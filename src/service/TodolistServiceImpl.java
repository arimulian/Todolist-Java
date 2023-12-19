package service;

import entity.Todolist;
import repository.TodolistRepository;

public class TodolistServiceImpl implements TodolistService {

	private final TodolistRepository todolistRepository;

	public TodolistServiceImpl(TodolistRepository todolistRepository) {
		this.todolistRepository = todolistRepository;
	}

	@Override
	public void showTodolist() {
		Todolist[] todolists = todolistRepository.getAll();
		System.out.println("Todolist");
		for (int i = 0; i < todolists.length; i++) {
			var todo = todolists[i];
			var no = i + 1;
			if (todo != null) {
				System.out.println(no + ". " + todo.getTodo());
			}
		}

	}

	@Override
	public void addTodolist(String todo) {
		Todolist todolist = new Todolist(todo);
		todolistRepository.add(todolist);
		System.out.println("Successfully added : " + todo);
	}

	@Override
	public void removeTodolist(Integer number) {
		boolean success = todolistRepository.remove(number);
		if (success) {
			System.out.println("Successfully removed todo : " + number);
		} else {
			System.out.println("Failed to remove todo : " + number);
		}
	}
}
