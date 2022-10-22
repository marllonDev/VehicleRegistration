package com.sistema.demo.repository;

import com.sistema.demo.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    @Query("SELECT v FROM Vehicle v WHERE (:marca is null or v.marca = :marca) and (:ano is null"
            + " or v.ano = :ano) and (:cor is null or v.cor = :cor)")
    List<Vehicle> findAllByMarcaAndAnoAndCor(@Param("marca") String marca, @Param("ano") Integer ano, @Param("cor") String cor);
}
