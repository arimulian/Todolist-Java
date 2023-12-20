package test.view;

import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import view.TodolistView;

public class ViewTodolistTest {
	public static void main(String[] args) {
		testRemoveTodolist();
	}

	public static void testShowTodolist() {
		TodolistRepository todolistRepository = new TodolistRepositoryImpl();
		TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
		TodolistView todolistView = new TodolistView(todolistService);

		todolistView.showTodolist();
	}

	public static void testAddTodolist() {
		TodolistRepository todolistRepository = new TodolistRepositoryImpl();
		TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
		TodolistView todolistView = new TodolistView(todolistService);

		todolistView.addTodolist();
		todolistView.showTodolist();
	}

	public static void testRemoveTodolist() {
		TodolistRepository todolistRepository = new TodolistRepositoryImpl();
		TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
		TodolistView todolistView = new TodolistView(todolistService);

		todolistView.addTodolist();
		todolistView.showTodolist();
		todolistView.removeTodolist();
		todolistView.showTodolist();
	}
}
