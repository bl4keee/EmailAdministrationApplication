package emailapp;
import java.util.Scanner;

public class Email {

	// variables are set to private not the let people access them directly (encapsulation will be used)
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private String alternateEmail;
	private String companySuffix = "Techcompany.com";
	private int mailboxCapacity = 500;
	private int defaultPasswordLength = 10;
	
	// Constructor to receive the first and the last name
	public Email(String firstName, String lastName) {
		this.firstName = firstName; //this = class level variable; firstName (after equals) refers to the local variable passed as parameter in the constructor
		this.lastName = lastName;
		
		// Call a method asking for the department - return the department
		this.department = setDepartment();
		
		// Call a method that returns the random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is: " + this.password);
		
		// Combine elements to generate email
		email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
	}
	
	// Ask for department
	private String setDepartment() {
		System.out.println("New worker: " + firstName + ". Department Codes:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
		Scanner scanner = new Scanner(System.in);
		int depChoice = scanner.nextInt();
		scanner.close();
		if (depChoice == 1) { return "sales"; }
		else if (depChoice == 2) { return "dev"; }
		else if (depChoice == 3) { return "acct"; }
		else {return ""; }
	}
	
	// Generate a random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUWXYZ123456789!@#$%";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String (password);
	}
	
	// Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxCapacity = capacity;
	}
	
	// Set the alternate email
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	// Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	// Get the mailbox capacity
	public int getMailboxCapacity() {
		return mailboxCapacity;
	}
	
	// Get the alternate email
	public String getAlternateEmail() {
		return alternateEmail;
	}
	
	// Get the password
	public String getPassword() { 
		return password;
	}
	
	//  Method to display name, email and mailbox capacity
	public String showInfo() { 
		return "DISPLAY NAME: " + firstName + " " + lastName +
				"\nCOMPANY EMAIL: " + email +
				"\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
	}
}
