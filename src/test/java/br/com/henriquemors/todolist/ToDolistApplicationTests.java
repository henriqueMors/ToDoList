package br.com.henriquemors.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.henriquemors.todolist.entity.ToDo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ToDolistApplicationTests {
@Autowired
private WebTestClient webTestClient;

	@Test
	void testCreateToDoSuccess() {
		var todo = new ToDo("ToDo 1", "desc ToDo 1", false, 1);
		
		webTestClient
			.post()
			.uri("/ToDos")
			.bodyValue(todo)
			.exchange()
			.expectStatus().isOk()
			.expectBody()
			.jsonPath("$").isArray()
			.jsonPath("$.length()").isEqualTo(1)
			.jsonPath("$.[0].nome").isEqualTo(todo.getNome())
			.jsonPath("$.[0].descricao").isEqualTo(todo.getDescricao())
			.jsonPath("$.[0].realizado").isEqualTo(todo.isRealizado())
			.jsonPath("$.[0].prioridade").isEqualTo(todo.getPrioridade());
	}

	@Test
	void testCreateToDoFailure() {
		
	}

}
