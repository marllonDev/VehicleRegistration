package com.sistema.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Vehicle {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String veiculo;

    private String marca;

    private Integer ano;

    private String descricao;

    private String cor;

    private boolean vendido;

    private LocalDateTime created;

    private LocalDateTime updated;
}
