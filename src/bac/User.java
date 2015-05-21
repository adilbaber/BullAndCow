package bac;

public class User {

	private String firstName;
	private String lastName;
	private String initials;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getInitials() {
		return initials;
	}
	public void setInitials(String initials) {
		this.initials = initials;
	}
	public User(String firstName, String lastName, String initials) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.initials = initials;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "{\"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName
				+ "\", \"initials\": \"" + initials + "\"}";
	}
	
}
