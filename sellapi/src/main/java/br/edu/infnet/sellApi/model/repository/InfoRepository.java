package br.edu.infnet.sellApi.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infnet.sellApi.model.domain.Info;

@Repository
public interface InfoRepository extends CrudRepository<Info, Integer> {

}