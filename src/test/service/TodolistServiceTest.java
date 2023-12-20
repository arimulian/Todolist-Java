package test.service;

import entity.Todolist;
import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;

public class TodolistServiceTest {

	public static void main(String[] args) {
		testRemoveTodolist();
	}

	public static void testShowTodolist() {
		TodolistRepositoryImpl repository = new TodolistRepositoryImpl();
		repository.data[0] = new Todolist("todo 1");
		repository.data[1] = new Todolist("todo 2");
		repository.data[2] = new Todolist("todo 3");

		TodolistService service = new TodolistServiceImpl(repository);
		service.showTodolist();

	}

	public static void testAddTodolist() {
		TodolistRepository repository = new TodolistRepositoryImpl();
		TodolistService service = new TodolistServiceImpl(repository);
		service.addTodolist("todo ke-I");
		service.addTodolist("todo ke-II");
		service.addTodolist("todo ke-III");
		service.showTodolist();

	}

	public static void testRemoveTodolist() {
		TodolistRepository repository = new TodolistRepositoryImpl();
		TodolistService service = new TodolistServiceImpl(repository);
		service.addTodolist("todo ke-I");
		service.addTodolist("todo ke-II");
		service.addTodolist("todo ke-III");

		service.removeTodolist(5);
		service.removeTodolist(2);
		service.showTodolist();
		service.removeTodolist(11);

	}


}
