package fi.haagahelia.course.domain;

import org.springframework.data.repository.CrudRepository;

import fi.haagahelia.course.domain.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}