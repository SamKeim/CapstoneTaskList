package co.grandcircus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Task {
	public String memberName;
	public String description;
	public LocalDate dueDate;
	public boolean isComplete;
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDueDateString() {
		// Returns as string for readability
		String date = getDueDate().format(DateTimeFormatter.ofPattern("M/d/yy"));
		return date;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	public void setDueDate(Scanner scnr) {
		// Declare variables
		boolean exit = false;
		String dueDate = "";
	
		// While loop, loops until valid entry is made
		do{
			try{
				dueDate = scnr.next(); // Gets Date
				scnr.nextLine(); // Clears Scanner
				
				// Translates to Local Date, if valid
				DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
				LocalDate setDueDate = LocalDate.parse(dueDate, format);
				
				// FIXME allow user to enter today's date
				// Date must be in the future, if not, throws IllegalArgumentException
				if (setDueDate.compareTo(LocalDate.now()) >= 0) {
					// Enters block if date is in the future and of an acceptable format
					this.dueDate = setDueDate;
					exit = true;
				} else {
					throw new IllegalArgumentException("Date must be after today.\nEnter date:");
				}
			} catch (DateTimeParseException dtpe) {
				// Catches invalid date format exceptions
				System.out.println("Please enter a valid date (M/D/YY).");
			} catch (IllegalArgumentException iae) {
				// Catches thrown exception if date entered has already past
				System.out.println(iae.getMessage());
			}
		} while (!exit);
	}
	
	public String getIsComplete() {
		// Returns as string for easy reading
		String isCompleteString = "";
		if (isComplete) {
			isCompleteString = "Complete";
		} else {
			isCompleteString = "Incomplete";
		}
		return isCompleteString;
	}
	
	public void setComplete(boolean isComplete) {
		this.isComplete = isComplete;
	}
	
	public Task() {
		super();
	}
	
	public Task(String memberName, String description, String dueDate) {
		// Overloaded constructor, used for JUnit testing
		this.memberName = memberName;
		this.description = description;
		this.isComplete = false;
		DateTimeFormatter format = DateTimeFormatter.ofPattern("M/d/yy");
		LocalDate validDate = LocalDate.parse(dueDate, format);
		this.dueDate = validDate;
	}
	
	@Override
	public String toString() {
		return String.format("%-15s%-10s%-15s%-50s", getIsComplete(), getDueDateString(), memberName, description);
	}

}
