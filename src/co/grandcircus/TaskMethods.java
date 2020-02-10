package co.grandcircus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskMethods {

	// Add task
	public Task addTask(Scanner scnr) {
		Task task = new Task();
		// Get and set name
		System.out.println("Add Task\nTeam Member Name:");
		String getName = scnr.nextLine();
		task.setMemberName(getName);

		// Get and set description
		System.out.println("Task Description:");
		String getDescription = scnr.nextLine();
		task.setDescription(getDescription);

		// Get and set date
		System.out.println("Due Date:");
		task.setDueDate(scnr);
		System.out.println("Task successfully entered.");
		return task;
	}

	// Display menu
	public void displayMenu() {
		// Create menu
		ArrayList<String> menu = new ArrayList<>();
		menu.add("1. List Tasks");
		menu.add("2. Add Task");
		menu.add("3. Delete Task");
		menu.add("4. Mark Task Complete");
		menu.add("5. Edit Task");
		menu.add("6. Quit");

		// Display
		System.out.println("+---------------------------------------------------------------------------------------------+");
		for (String item : menu) {
			System.out.printf("%5s%s\n", "", item);
		}
		System.out.println("+---------------------------------------------------------------------------------------------+");
		System.out.println("Enter Selection:");
	}

	// List all tasks
	public void listTask(ArrayList<Task> taskList) {
		int i = 1;
		System.out.println("+---------------------------------------------------------------------------------------------+");
		for (Task item : taskList) {
			System.out.printf("%5s%-1d: %-1s\n", "", i++, item);
		}
		System.out.println("+---------------------------------------------------------------------------------------------+");

	}

	// Display by name
	public void displayByName(String chooseName, ArrayList<Task> taskList) {
		System.out.println("+---------------------------------------------------------------------------------------------+");
		int i = 1;
		for (Task item : taskList) {
			if (item.getMemberName().equalsIgnoreCase(chooseName)) {
				System.out.printf("%5s%-1d: %-1s\n", "", i++, item);
			}
		}
		System.out.println("+---------------------------------------------------------------------------------------------+");
	}

	// Display by date
	public void displayByDate(LocalDate chooseDate, ArrayList<Task> taskList) {
		System.out.println("+---------------------------------------------------------------------------------------------+");
		int i = 1;
		for (Task item : taskList) {
			boolean valid = item.getDueDate().compareTo(chooseDate) <= 0;
			if (valid) {
				System.out.printf("%5s%-1d: %-1s\n", "", i++, item);
			}
		}
	System.out.println("+---------------------------------------------------------------------------------------------+");
		
	}

	// Edit task
	public void editTask(Task taskToEdit, Scanner scnr) {
		// Get user input
		System.out.println("What would you like to edit? [1] Name, [2] Description, or [3] Date.");
		int userChoice = Validator.getInt(scnr, 1, 3);

		// Switch to choose edit mode
		switch (userChoice) {
		case 1:
			System.out.println("Enter a Name:");
			String setMemberName = scnr.nextLine();
			taskToEdit.setMemberName(setMemberName);
			break;
		case 2:
			System.out.println("Enter a Description:");
			String setDescription = scnr.nextLine();
			taskToEdit.setDescription(setDescription);
			break;
		default:
			taskToEdit.setDueDate(scnr);
		}
	}

	// Validate yes or no
	public boolean yesOrNo(Scanner scnr) {
		do {
			String userInput = scnr.nextLine();
			if (userInput.toUpperCase().startsWith("Y")) {
				return true;
			} else if (userInput.toUpperCase().startsWith("N")) {
				return false;
			} else {
				System.out.println("Please enter Y or N.");
			}
		} while (true);
	}

}
