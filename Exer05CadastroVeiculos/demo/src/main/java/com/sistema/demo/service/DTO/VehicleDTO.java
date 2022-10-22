package com.sistema.demo.service.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {

    private String veiculo;

    private String marca;

    private Integer ano;

    private String descricao;

    private String cor;

    private boolean vendido;

    private LocalDateTime created;

    private LocalDateTime updated;
}
