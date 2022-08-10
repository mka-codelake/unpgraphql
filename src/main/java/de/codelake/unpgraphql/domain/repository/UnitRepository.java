package de.codelake.unpgraphql.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import de.codelake.unpgraphql.domain.model.Unit;

public interface UnitRepository extends JpaRepository<Unit, Long> {

}
