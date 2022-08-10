package de.codelake.unpgraphql.api;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import de.codelake.unpgraphql.domain.model.Person;
import de.codelake.unpgraphql.domain.repository.PersonRepository;

@Controller
public class PersonController {

	private final PersonRepository repo;

	public PersonController(final PersonRepository repo) {
		this.repo = repo;
	}

	@SchemaMapping(typeName = "Query", value = "findAllPersons")
	public List<Person> findAllPersons() {
		return repo.findAll();
	}

	@QueryMapping
	public Person findPerson(@Argument final Long id) {
		return repo.findById(id).get();
	}

	@MutationMapping
	public Person createPerson() {
		return repo.save(new Person());
	}

	@MutationMapping
	public Person changePersonName(@Argument final Long id, @Argument final String name) {
		final Person person = repo.findById(id).get();
		person.setName(name);
		repo.save(person);
		return person;
	}
}
