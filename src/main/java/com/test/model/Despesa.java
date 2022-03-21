package com.test.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.yaml.snakeyaml.util.EnumUtils;

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
        SAIDA_INVESTIMENTO("saida"),
        SAIDA_GASTO_ADICIONAL("gasto_adicional");

        private  String descricao;




    }

}
