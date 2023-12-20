import repository.TodolistRepository;
import repository.TodolistRepositoryImpl;
import service.TodolistService;
import service.TodolistServiceImpl;
import view.TodolistView;

public class TodolistAppV2 {

	private static TodolistRepository todolistRepository = new TodolistRepositoryImpl();
	private static TodolistService todolistService = new TodolistServiceImpl(todolistRepository);
	private static TodolistView todolistView = new TodolistView(todolistService);

	public static void main(String[] args) {

		todolistView.showTodolist();
	}
}
