package co.grandcircus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
	public static void main(String[] args) {

		// Declare variables
		TaskMethods tm = new TaskMethods();
		Scanner scnr = new Scanner(System.in);
		ArrayList<Task> taskList = new ArrayList<>();
		int userSelection;
		boolean userContinue = true;

		taskList.add(new Task("Sam", "Get a job", "3/21/20"));
		taskList.add(new Task("Rana", "Throw a party", "2/12/20"));
		taskList.add(new Task("Rana", "Learn Java", "3/21/20"));
		taskList.add(new Task("Amanda", "Learn to cook", "2/15/20"));
		taskList.add(new Task("Jeannie", "Teach yoga", "2/10/20"));
		taskList.add(new Task("Sean", "Play pong", "2/29/20"));
		taskList.add(new Task("Kyle", "Eat lunch", "3/1/20"));
		
		// Present menu
		System.out.println("Welcome to the Task Manager.");
		do {
			tm.displayMenu();
			int menuSelection = Validator.getInt(scnr, 1, 6);
	
			// Switch statement to call methods
			switch (menuSelection) {
			case 1:
				// List Tasks
				System.out.println("[1] Display All Tasks, [2] Display by Name, [3] Display by Date");
				int displaySelection = Validator.getInt(scnr, 1, 3);
				switch (displaySelection) {
				case 1:
					tm.listTask(taskList);
					break;
				case 2:
					System.out.println("Enter Name:");
					String chooseName = scnr.nextLine();
					tm.displayByName(chooseName, taskList);
					break;
				default:
					LocalDate chooseDate = Validator.getDate(scnr);
					tm.displayByDate(chooseDate, taskList);
					break;
				}
				break;
			case 2:
				// Add Task
				taskList.add(tm.addTask(scnr));
				break;
			case 3:
				// Delete Task
				tm.listTask(taskList);
				System.out.println("Select a task to delete.");
				int taskChoice = Validator.getInt(scnr, 1, taskList.size());
				taskList.get(taskChoice - 1);
				System.out.println("Confirm Delete (Y/N)");
				if (tm.yesOrNo(scnr)) {
					taskList.remove(taskChoice - 1);
				}
				break;
			case 4:
				// Mark Task Complete
				tm.listTask(taskList);
				System.out.println("Select a task to mark complete.");
				userSelection = Validator.getInt(scnr, 1, taskList.size());
				taskList.get(userSelection - 1);
				System.out.println("Confirm Complete (Y/N)");
				if (tm.yesOrNo(scnr)) {
					taskList.get(userSelection - 1).setComplete(true);
				}
				break;
			case 5:
				tm.listTask(taskList);
				System.out.println("Select a task to edit.");
				userSelection = Validator.getInt(scnr, 1, taskList.size());
				taskList.get(userSelection - 1);
				tm.editTask(taskList.get(userSelection - 1), scnr);
				break;
			default:
				// Quit
				userContinue = false;
				break;
			}
		} while (userContinue);
		System.out.println("Thank you, goodbye.");
	}
}
