package com.test.repository;

import com.test.model.Despesa;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaRepository extends MongoRepository<Despesa,String> {
}
