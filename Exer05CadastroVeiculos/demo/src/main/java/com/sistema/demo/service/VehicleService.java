package com.sistema.demo.service;

import com.sistema.demo.exeption.VehicleException;
import com.sistema.demo.model.Vehicle;
import com.sistema.demo.repository.VehicleRepository;
import com.sistema.demo.service.DTO.VehicleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.util.ReflectionUtils;

import javax.transaction.Transactional;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    public List<Vehicle> findAllVehicles() throws VehicleException{
        List<Vehicle> all = vehicleRepository.findAll();
        if (all.isEmpty()){
            throw new VehicleException("Não há nenhum dado em nossos registros!");
        }
        return vehicleRepository.findAll();
    }


    public List<Vehicle> findVehicle(String marca, Integer ano, String cor) throws VehicleException {
        List<Vehicle> veiculos = vehicleRepository.findAllByMarcaAndAnoAndCor(marca, ano, cor);
        if (veiculos.isEmpty()) {
            throw new VehicleException("Nenhum veiculo cadastrado!");
        }
        return veiculos;
    }


    public Vehicle findVehicleById(Long id) throws VehicleException {
        Optional<Vehicle> findVehicleByID = vehicleRepository.findById(id);
        if(!findVehicleByID.isPresent()){
            throw new VehicleException("Nenhum veiculo encontrado.");
        }
        return findVehicleByID.get();
    }


    public Vehicle addVehicle(VehicleDTO vehicleDTO){
        Vehicle newVehicle = new Vehicle();
        newVehicle.setVeiculo(vehicleDTO.getVeiculo());
        newVehicle.setMarca(vehicleDTO.getMarca());
        newVehicle.setDescricao(vehicleDTO.getDescricao());
        newVehicle.setAno(vehicleDTO.getAno());
        newVehicle.setCor(vehicleDTO.getCor());
        newVehicle.setVendido(vehicleDTO.isVendido());
        newVehicle.setCreated(formatDate());
        newVehicle.setUpdated(formatDate());

        return vehicleRepository.save(newVehicle);
    }

    private LocalDateTime formatDate() {
        LocalDateTime agora = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String agoraFormatado = agora.format(formatter);
        return LocalDateTime.parse(agoraFormatado, formatter);

    }

    public Vehicle updateVehicle(Vehicle vehicle) throws VehicleException{
        Optional<Vehicle> findID = vehicleRepository.findById(vehicle.getId());
        if (findID.isEmpty()){
            throw new VehicleException("Veiculo não disponivel para edição!");
        }
        vehicle.setUpdated(formatDate());
        return vehicleRepository.save(vehicle);
    }


    public Vehicle updateHalf(Long id, Map<Object, Object> objectMap) throws VehicleException {
        Vehicle veiculo = vehicleRepository.findById(id).orElseThrow(() -> new VehicleException("Veículo não Cadastrado!"));
        objectMap.forEach((key, value) -> {
            Field field = org.springframework.util.ReflectionUtils.findField(Vehicle.class, (String) key);
            veiculo.setUpdated(formatDate());
            assert field != null;
            ReflectionUtils.setField(field, veiculo, value);
        });
        return vehicleRepository.save(veiculo);
    }

    public void deleteById(Long id) throws VehicleException{
        Optional <Vehicle> delByid = vehicleRepository.findById(id);
        if (!delByid.isPresent()){
            throw new VehicleException("Veiculo não disponivel!");
        }
        vehicleRepository.deleteById(delByid.get().getId());
    }
}
