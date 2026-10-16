package com.github.stefanyomori.registro_stefany_558792_m1.dto;

import com.github.stefanyomori.registro_stefany_558792_m1.entities.CondicaoClimatica;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegistroInput {
    //@NotEmpty
    //Long registroId;
    String estacaoNome;
    LocalDate dataRegistro;
    BigDecimal temperatura;
    BigDecimal percentualUmidade;
    BigDecimal precipitacao;
    CondicaoClimatica condicaoClimatica;
}
