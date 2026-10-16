package com.github.stefanyomori.registro_stefany_558792_m1.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@Entity
@Table(name = "tb_registro")
public class  Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome da estação é obrigatório")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    @Column(nullable = false, length = 100)
    private String estacaoNome;

    @NotNull(message = "A data do registro é obrigatória")
    @PastOrPresent(message = "A data não pode ser futura")
    @Column(nullable = false)
    private LocalDate dataRegistro;

    @NotNull(message = "A temperatura é obrigatória")
    @Column(nullable = false)
    private BigDecimal temperatura;

    @NotNull(message = "A umidade é obrigatória")
    @Size(min = 0, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    @Column(nullable = false, length = 16)
    private BigDecimal percentualUmidade;

    @NotNull(message = "A precipitação é obrigatória")
    @Size(min = 0, message = "O nome deve ter entre 3 e 100 caracteres")
    @Column(nullable = false, length = 16)
    private BigDecimal precipitacao;

    @NotBlank(message = "A condição climática é obrigatória")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CondicaoClimatica condicaoClimatica;
}
