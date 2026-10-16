package com.github.stefanyomori.registro_stefany_558792_m1.dto;

import com.github.stefanyomori.registro_stefany_558792_m1.entities.CondicaoClimatica;
import com.github.stefanyomori.registro_stefany_558792_m1.entities.Registro;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class RegistroOutput {
    Long registroId;
    String estacaoNome;
    LocalDate dataRegistro;
    BigDecimal temperatura;
    BigDecimal percentualUmidade;
    BigDecimal precipitacao;
    CondicaoClimatica condicaoClimatica;

    public RegistroOutput(Registro entity){
        registroId = entity.getId();
        estacaoNome = entity.getEstacaoNome();
        dataRegistro = entity.getDataRegistro();
        temperatura = entity.getTemperatura();
        percentualUmidade = entity.getPercentualUmidade();
        precipitacao = entity.getPrecipitacao();
        condicaoClimatica = entity.getCondicaoClimatica();
    }
}

