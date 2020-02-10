package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TaskTests {

	@Test
	void displayByUser() {
		ArrayList<Task> taskList = new ArrayList<>();
		taskList.add(new Task("Sam", "Get a job", "3/21/20"));
		taskList.add(new Task("Rana", "Throw a party", "2/12/20"));
		taskList.add(new Task("Rana", "Learn Java", "3/21/20"));
		taskList.add(new Task("Amanda", "Learn to cook", "2/15/20"));
		taskList.add(new Task("Jeannie", "Teach yoga", "2/10/20"));
		taskList.add(new Task("Sean", "Play pong", "2/25/20"));
		taskList.add(new Task("Kyle", "Eat lunch", "3/22/20"));
		TaskMethods tm = new TaskMethods();
//		System.out.println("Displaying 2 tasks for Rana, throw a party and learn java");
//		tm.displayByName("Rana", taskList);
	}
	
	@Test
	void displayByDate() {
		ArrayList<Task> taskList = new ArrayList<>();
		taskList.add(new Task("Sam", "Get a job", "3/21/20"));
		taskList.add(new Task("Rana", "Throw a party", "2/12/20"));
		taskList.add(new Task("Rana", "Learn Java", "3/21/20"));
		taskList.add(new Task("Amanda", "Learn to cook", "2/15/20"));
		taskList.add(new Task("Jeannie", "Teach yoga", "2/10/20"));
		taskList.add(new Task("Sean", "Play pong", "2/29/20"));
		taskList.add(new Task("Kyle", "Eat lunch", "3/1/20"));
		TaskMethods tm = new TaskMethods();
//		System.out.println("Displaying 4 tasks before end of Feb");
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
//		LocalDate validDate = LocalDate.parse("2/29/20", format);
//		tm.displayByDate(validDate, taskList);
	}
	
	
}
