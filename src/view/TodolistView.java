package view;


import service.TodolistService;
import util.InputUtil;


public class TodolistView {

	private TodolistService service;

	public TodolistView(TodolistService service) {
		this.service = service;
	}

	public void showTodolist() {

		while (true) {
			service.showTodolist();
			System.out.println("Menu");
			System.out.println("1. Tambah");
			System.out.println("2. Hapus");
			System.out.println("x. Keluar");

			var input = InputUtil.input("Pilih");

			if (input.equals("1")) {
				addTodolist();
			} else if (input.equals("2")) {
				removeTodolist();
			} else if (input.equals("x")) {
				break;
			} else {
				System.out.println("input tidak di mengerti");
			}
		}

	}

	public void addTodolist() {
		System.out.println("Menambah Todolist");
		var todo = InputUtil.input("todo (jika x maka batal)");
		if (todo.equals("x")) {
			//batal
		} else {
			service.addTodolist(todo);
		}
	}

	public void removeTodolist() {
		System.out.println("Menghapus Todolist");
		var todo = InputUtil.input("Nomor Todolist (jika x maka batal)");
		if (todo.equals("x")) {
			//batal
		} else {
			service.removeTodolist(Integer.valueOf(todo));
		}
	}
}
