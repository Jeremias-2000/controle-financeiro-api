package com.test.service;

import com.test.exception.DespesaNotFoundException;
import com.test.model.Despesa;
import com.test.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DespesaService {


    @Autowired
    private DespesaRepository despesaRepository;

    public List<Despesa> findDespesas(){
        return despesaRepository.findAll();
    }

    public Despesa findDespesaById(String id){
        return despesaRepository.findById(id)
                .orElseThrow(() -> new DespesaNotFoundException(id));
    }

    public void createDespesaData(Despesa despesa){
        despesaRepository.save(despesa);
    }

}
