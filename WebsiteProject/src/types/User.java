package types;

import java.util.UUID;

public class User
{
	private Object userId;
	private Object firstName;
	private Object lastName;
	private Object password;
	private Object role;
	private static int num = 3916000;

	public User()
	{
		//random id generation:
//		byte[] rand = {0,1,2};
//		this.setUserId(UUID.nameUUIDFromBytes(rand).toString());
		
		//incremental id generation
//		num = num + 1;
		
		this.setUserId(++num);
		this.setFirstName(null);
		this.setLastName(null);
		this.setPassword(null);
		this.setRole(1);
		
	}
	
	public User(String firstName, String lastName, String password){
		this(); 
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPassword(password);
	}

	public Object getUserId()
	{
		return userId;
	}

	public void setUserId(Object userId)
	{
		this.userId = userId;
	}

	public Object getFirstName()
	{
		return firstName;
	}

	public void setFirstName(Object firstName)
	{
		this.firstName = firstName;
	}

	public Object getLastName()
	{
		return lastName;
	}

	public void setLastName(Object lastName)
	{
		this.lastName = lastName;
	}

	public Object getPassword()
	{
		return password;
	}

	public void setPassword(Object password)
	{
		this.password = password;
	}

	public Object getRole()
	{
		return role;
	}

	public void setRole(Object role)
	{
		this.role = role;
	}
}
