import java.util.Scanner;

public class Todolist {

	public static String[] model = new String[10];
	public static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		viewShowTodolist();
	}

	/**
	 * Menampilkan data Todo list
	 */

	public static void showTodolist() {
		System.out.println("Todolist");

			for (int i = 0; i < model.length; i++) {
				var todo = model[i];
				var no = i + 1;
				if (todo != null) {
					System.out.println(no + ". " + todo);
				}
			}
		}


	public static void testShowTodolist() {
		showTodolist();
	}

	/**
	 * Menambahkan data Todo ke List
	 */
	public static void addTodolist(String todo) {
		// Cek apakah data model penuh
		var isFull = true;
		for (int i = 0; i < model.length; i++) {
			if (model[i] == null) {
				isFull = false;
				break;
			}
		}

		//jika penh, resize ukurannya menjadi 2x lipat
		if (isFull) {
			var temp = model;
			model = new String[model.length * 2];
			for (int i = 0; i < temp.length; i++) {
				model[i] = temp[i];
			}
		}

		// tambahkan ke posisi yang data array nya NULL
		for (var i = 0; i < model.length; i++) {
			if (model[i] == null) {
				model[i] = todo;
				break;
			}
		}
	}

	public static void testAddTodolist() {
		for (int i = 0; i < 25; i++) {
			addTodolist("todolist ke - " + i);
		}
		showTodolist();
	}

	/**
	 * Menghapus data Todo dari list
	 */
	public static boolean deleteTodolist(Integer number) {
		//Cek apakah number lebih besar dari panjang datanya
		if ((number - 1) > model.length) {
			return false;
			//Cek apakah data null
		} else if (model[number - 1] == null) {
			return false;
		} else {
			model[number - 1] = null;
			// Menggeser data array
			for (int i = (number - 1); i < model.length; i++) {
				//cek apakah number tersebut array terakhir
				if (i == (model.length - 1)) {
					model[i] = null;
				} else {
					model[i] = model[i + 1];
				}
			}
			return true;
		}
	}

	public static void testDeleteTodolist() {

		addTodolist("todo - 1");
		addTodolist("todo - 2");
		addTodolist("todo - 3");
		addTodolist("todo - 4");
		addTodolist("todo - 5");

		var result = deleteTodolist(15);
		System.out.println(result);

		result = deleteTodolist(6);
		System.out.println(result);

		result = deleteTodolist(2);
		System.out.println(result);

		showTodolist();
	}

	/**
	 * Input user
	 *
	 * @param info
	 * @return
	 */
	public static String input(String info) {
		System.out.print(info + ": ");
		var data = scanner.nextLine();
		return data;
	}

	public static void testInput() {
		var name = input("nama");
		System.out.println("Hi " + name);
	}

	/**
	 * Menampilkan View data todo list
	 */
	public static void viewShowTodolist() {
		while (true) {
			showTodolist();
			System.out.println("Menu");
			System.out.println("1. Tambah");
			System.out.println("2. Hapus");
			System.out.println("x. Keluar");

			var input = input("pilih");

			if (input.equals("1")) {
				viewAddTodolist();
			} else if (input.equals("2")) {
				viewDeleteTodolist();
			} else if (input.equals("x")) {
				break;
			} else {
				System.out.println("perintah tidak dimengerti");
			}
		}
	}

	public static void testViewShowTodolist() {
		addTodolist("todolist ke - 1");
		addTodolist("todolist ke - 2");
		addTodolist("todolist ke - 3");
		viewShowTodolist();
	}

	/**
	 * Menampilkan view tambah data todo list
	 */
	public static void viewAddTodolist() {
		System.out.println("Menambahkan Todo");
		var todo = input("todo (x maka batal)");
		if (todo.equals("x")){
			//batal
		}else {
		addTodolist(todo);
		}
	}

	public static void testViewAddTodolist() {
		viewAddTodolist();
		showTodolist();
	}


	/**
	 * Menampilkan view hapus data todo list
	 */
	public static void viewDeleteTodolist() {
		showTodolist();
		System.out.println("Menghapus Todolist");
		var number = input("Nomor yang dihapus (x maka batal)");

		if (number.equals("x")){
			//batal
		}else {
			boolean success = deleteTodolist(Integer.valueOf(number));
			if (!success) {
				System.out.println("Gagal menghapus todolist " + number);
			}
		}

	}

	public static void testViewDeleteTodolist(){
		addTodolist("todolist ke - 1");
		addTodolist("todolist ke - 2");
		addTodolist("todolist ke - 3");
		viewDeleteTodolist();
		showTodolist();
	}


}
