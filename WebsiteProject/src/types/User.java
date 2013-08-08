package types;

import java.util.UUID;

public class User
{
	private int userId;
	private String firstName;
	private String lastName;
	private String password;
	private short role;
//	private static int num = 3916000;

	public User()
	{
		//random id generation:
//		byte[] rand = {0,1,2};
//		this.setUserId(UUID.nameUUIDFromBytes(rand).toString());
		
		//incremental id generation
//		num++;
//		
		
		this.setUserId(0);
		this.setFirstName(null);
		this.setLastName(null);
		this.setPassword(null);
		this.setRole((short)0);
		
	}
	
	public User(int userId, String firstName, String lastName, String password, short role){
		this(); 
		this.setUserId(userId);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPassword(password);
		this.setRole(role);
	}

//	public int getUserId()
//	{
//		return userId;
//	}
//
//	public void setUserId(int userId)
//	{
//		this.userId = userId;
//	}

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

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public short getRole()
	{
		return role;
	}

	public void setRole(short role)
	{
		this.role = role;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}
}
