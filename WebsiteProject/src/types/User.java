package types;

public class User
{
	private String email;
	private String firstName;
	private String lastName;
	
	public User(){
		this.setEmail(null);
		this.setFirstName(null);
		this.setLastName(null);
	}
	
	public User(String email, String firstName, String lastName){
		this.setEmail(email);
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
}
