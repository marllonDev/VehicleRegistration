package com.sistema.demo.controller;

import com.sistema.demo.exeption.VehicleException;
import com.sistema.demo.model.Vehicle;
import com.sistema.demo.service.DTO.VehicleDTO;
import com.sistema.demo.service.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value= "/veiculos")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VehicleController {

    private final VehicleService vehicleService;


//    @ResponseStatus(value = HttpStatus.OK)
//    @GetMapping
//    public List<Vehicle> findAllVehicle() throws VehicleException{
//        return vehicleService.findAllVehicles();
//    }

    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping
    public List<Vehicle> findVehicle(@RequestParam(value = "marca", required = false) String marca,
                                     @RequestParam(value = "ano",required = false) Integer ano,
                                     @RequestParam(value = "cor", required = false) String cor) throws VehicleException {
        return vehicleService.findVehicle(marca, ano, cor);
    }


    @ResponseStatus(value = HttpStatus.OK)
    @GetMapping("/{id}")
    public Vehicle findById(@PathVariable Long id) throws VehicleException{
        return vehicleService.findVehicleById(id);
    }


    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping
    @ResponseBody
    private Vehicle addNewCustomer(@RequestBody VehicleDTO vehicleDTO) {
        return vehicleService.addVehicle(vehicleDTO);
    }


    @ResponseStatus(value = HttpStatus.OK)
    @PutMapping("/{id}")
    @ResponseBody
    public Vehicle updateVehicle(@RequestBody Vehicle vehicle) throws VehicleException{
        return vehicleService.updateVehicle(vehicle);
    }


    @ResponseStatus(value = HttpStatus.ACCEPTED)
    @PatchMapping("/{id}")
    public Vehicle updateHalfVehicle(@PathVariable Long id, @RequestBody Map<Object, Object> objectMap) throws VehicleException {
        return vehicleService.updateHalf(id, objectMap);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id)throws VehicleException{
        vehicleService.deleteById(id);

    }








}
