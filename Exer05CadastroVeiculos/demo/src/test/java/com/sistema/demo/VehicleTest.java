package com.sistema.demo;

import com.sistema.demo.exeption.VehicleException;
import com.sistema.demo.model.Vehicle;
import com.sistema.demo.service.DTO.VehicleDTO;
import com.sistema.demo.service.VehicleService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class VehicleTest {
    @Autowired
    VehicleService vehicleService;

    @BeforeAll
    void setUp() {
        VehicleDTO veiculo = new VehicleDTO();
        veiculo.setVeiculo("Ranger");
        veiculo.setMarca("Ford");
        veiculo.setDescricao("Movido a Diesel");
        veiculo.setCor("Cinza");
        veiculo.setAno(2022);
        veiculo.setVendido(false);
        veiculo.setCreated(LocalDateTime.now());
        veiculo.setUpdated(LocalDateTime.now());

        vehicleService.addVehicle(veiculo);
    }

    @Order(1)
    @Test
    void addVeiculo() throws VehicleException {
        VehicleDTO veiculo = new VehicleDTO();
        veiculo.setVeiculo("Ranger");
        veiculo.setMarca("Ford");
        veiculo.setDescricao("Movido a Diesel");
        veiculo.setCor("Cinza");
        veiculo.setAno(2022);
        veiculo.setVendido(false);
        veiculo.setCreated(LocalDateTime.now());
        veiculo.setUpdated(LocalDateTime.now());

        vehicleService.addVehicle(veiculo);

        Vehicle confirmCreated = vehicleService.findVehicleById(1L);

        Assertions.assertEquals("Movido a Diesel", confirmCreated.getDescricao());
    }

    @Order(2)
    @Test
    void updateVehicle() throws VehicleException {
        Vehicle veiculo = new Vehicle();
        veiculo.setId(1L);
        veiculo.setVeiculo("Ranger");
        veiculo.setMarca("Ford");
        veiculo.setDescricao("Movido a Diesel");
        veiculo.setCor("Amarela");
        veiculo.setAno(2018);
        veiculo.setVendido(false);
        veiculo.setCreated(LocalDateTime.now());
        veiculo.setUpdated(LocalDateTime.now());
        vehicleService.updateVehicle(veiculo);

        Vehicle confirmUpdated = vehicleService.findVehicleById(1L);

        Assertions.assertEquals("Amarela", confirmUpdated.getCor());
    }

//    @Order(3)
//    @Test
//    void findVeiculoById() throws VehicleException {
//        Assertions.assertTrue(vehicleService.findVehicleById(2L));
//    }

    @Order(4)
    @Test
    void findCarsWithoutParam() throws VehicleException {
        Assertions.assertTrue(vehicleService.findVehicle(null, null, null).size() == 2);
    }

    @Order(5)
    @Test
    void findCarsWithParam() throws VehicleException {
        Assertions.assertTrue(vehicleService.findVehicle("Fiat", 2018, "Verde").size() == 1);
    }

    @Order(6)
    @Test
    void updateParcialVeiculo() throws VehicleException {
        Map<Object, Object> obj = new HashMap<Object, Object>();
        obj.put("cor", "Verde");
        long id = 2;

        vehicleService.updateHalf(id, obj);
        Vehicle parcialUpdate = vehicleService.findVehicleById(2L);
        Assertions.assertEquals("Verde", parcialUpdate.getCor());
    }

    @Order(6)
    @Test
    void deleteVeiculo() throws VehicleException {
        vehicleService.deleteById(1L);
        Assertions.assertTrue(vehicleService.findVehicle(null, null, null).size() == 1);
    }
}
