package com.test.controller;

import com.test.model.Despesa;
import com.test.service.DespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/controle")
public class DespesaController {

    @Autowired
    private DespesaService despesaService;

    @GetMapping("/")
    @Cacheable("despesas")
    @ResponseStatus(HttpStatus.OK)
    public List<Despesa> returnDespesas(){
        return despesaService.findDespesas();
    }

    @GetMapping("/{id}")
    @Cacheable(value = "despesa",key = "#id")
    @ResponseStatus(HttpStatus.OK)
    public Despesa findDespesaById(@PathVariable("id") String id){
        return despesaService.findDespesaById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createDespesa(@RequestBody Despesa despesa){
        despesaService.createDespesaData(despesa);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDespesaBYId(@PathVariable("id") String id){
        despesaService.deleteDespesaData(id);
    }


}
