package br.com.ithiago.repository;

import br.com.ithiago.domain.Simulation;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Spring Data MongoDB repository for the Simulation entity.
 */
@SuppressWarnings("unused")
public interface SimulationRepository extends MongoRepository<Simulation,String> {

}
