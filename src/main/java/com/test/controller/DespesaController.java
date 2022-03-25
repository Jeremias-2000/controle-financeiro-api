package com.test.controller;

import com.test.model.Despesa;
import com.test.service.DespesaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = {"Controle"})
@RequestMapping("/api/v1/controle")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Retorna as despesas cadastradas")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "requisição executada com sucesso") ,
            @ApiResponse(code = 400,message = "nenhuma despesa foi encontrada")
        }
    )
    public List<Despesa> returnDespesas(){
        return despesaService.findDespesas();
    }

    @GetMapping("/{id}")
    @Cacheable(value = "despesa",key = "#id")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Retorna uma despesa especifica")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "requisição executada com sucesso") ,
            @ApiResponse(code = 404,message = "nenhuma despesa foi encontrada com esse id")
    })
    public Despesa findDespesaById(@PathVariable("id") String id){
        return despesaService.findDespesaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 201,message = "Despesa cadastrada com sucesso !",response = Despesa.class) ,
            @ApiResponse(code = 400,message = "Foi encontrado um erro no json")
    })
    public void createDespesa( @RequestBody  Despesa despesa){
        despesaService.createDespesaData(despesa);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Retorna uma despesa especifica")
    @ApiResponses(value = {
            @ApiResponse(code = 200,message = "requisição executada com sucesso") ,
            @ApiResponse(code = 404,message = "nenhuma despesa foi encontrada com esse id")
    })
    public void deleteDespesaBYId(@PathVariable("id") String id){
        despesaService.deleteDespesaData(id);
    }


}
