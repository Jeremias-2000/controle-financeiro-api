package com.test.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Document("despesas")
@NoArgsConstructor
@AllArgsConstructor
public class Despesa {

    @Id
    private String id;
    private String descricao;
    private BigDecimal valor;
    private LocalDate   data;
    private Tipo tipo;


    @Getter
    @AllArgsConstructor
    public enum Tipo{
        ENTRADA("entrada"),
        SAIDA("saida");

        private String descricao;
    }

}
