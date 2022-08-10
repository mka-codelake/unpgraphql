package de.codelake.unpgraphql.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.codelake.unpgraphql.domain.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
