package de.codelake.unpgraphql.api;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import de.codelake.unpgraphql.domain.model.Unit;
import de.codelake.unpgraphql.domain.repository.UnitRepository;

@Controller
public class UnitController {

	private final UnitRepository repo;

	public UnitController(final UnitRepository repo) {
		this.repo = repo;
	}

	@QueryMapping
	public List<Unit> findAllUnits() {
		return repo.findAll();
	}

	@QueryMapping
	public Unit findUnit(@Argument final Long id) {
		return repo.findById(id).get();
	}
}
