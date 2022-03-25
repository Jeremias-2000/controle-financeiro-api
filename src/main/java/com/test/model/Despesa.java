package com.test.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank
    private String descricao;

    private BigDecimal valor;

    @NotNull
    @NotBlank
    @JsonFormat(pattern = "MM/dd/yyyy")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate   data;

    @NotNull
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
