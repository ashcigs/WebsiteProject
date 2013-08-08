package dao;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

import types.User;

public class UsersDAO
{
	private static final String TABLE_NAME = "users";
	
	public static void checkTable(DataSource ds) throws SQLException{

		if(!existsTable(ds)){
			CreateTable(ds);
		}
		
	}
	
	private static void CreateTable(DataSource ds) throws SQLException{
		Connection connection = null;
		
		try
		{
			System.out.println("trying to create table");
			connection = ds.getConnection();

			String sql = "create table "+TABLE_NAME+" ("
					+ "userId int NOT NULL AUTO_INCREMENT,"
					+ "firstName varchar(30) NOT NULL, "
					+ "lastName varchar(30) NOT NULL, "
					+ "password varchar(30) NOT NULL, "
					+ "role TINYINT NOT NULL,"
					+ "PRIMARY KEY (`userId`))";
			
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.executeUpdate();
			System.out.println("table created");
		}finally {
			if (connection != null) {
				connection.close();
			}
		}
		
	}

	private static boolean existsTable(DataSource ds) throws SQLException
	{
		Connection connection = null;
		
		try
		{
			System.out.println("checking if table exists");
			connection = ds.getConnection();
			DatabaseMetaData metadata = connection.getMetaData();
			ResultSet resultSet = metadata.getTables("websiteproject", null, TABLE_NAME, null);
			if(resultSet.next()){
				System.out.println("table exists");
				return true;
			}
			System.out.println("table does not exist");
			return false;
		}
		finally
		{
			if (connection != null)
			{
				connection.close();
			}
		}
		
	}
	
//	public static void insertUser(DataSource ds, User usr) throws SQLException{
//		Connection connection = null;
//		
//		try
//		{
//			System.out.println("trying to insert user");
//			connection = ds.getConnection();
//			String sql = "insert into websiteproject."+TABLE_NAME+" (firstName, lastName, password, role)"
//					+ "values(?, ?, ?, ?)";
//			PreparedStatement stmt = connection.prepareStatement(sql);
//
//			stmt.setString(1, (String) usr.getFirstName());
//			stmt.setString(2, (String) usr.getLastName());
//			stmt.setString(3, (String) usr.getPassword());
//			stmt.setShort(4, (short) usr.getRole());
//			
//			stmt.executeUpdate();
//			System.out.println("user inserted");
//			
//		}
//		finally
//		{
//			if (connection != null)
//			{
//				connection.close();
//			}
//		}
//		
//	}
	
	public static void insertUser(DataSource ds, String firstName, String lastName, String password) throws SQLException{
		Connection connection = null;
		
		try
		{
			System.out.println("trying to insert user");
			connection = ds.getConnection();
			String sql = "insert into websiteproject."+TABLE_NAME+" (firstName, lastName, password, role)"
					+ "values(?, ?, ?, ?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, firstName);
			stmt.setString(2, lastName);
			stmt.setString(3, password);
			stmt.setShort(4, (short) 1);
			
			stmt.executeUpdate();
			System.out.println("user inserted");
			
		}
		finally
		{
			if (connection != null)
			{
				connection.close();
			}
		}
		
	}
	
	public static User selectUserById(DataSource ds, int userId) throws SQLException{
		Connection connection = null;
		
		try
		{
			connection = ds.getConnection();
			String sql = "SELECT * FROM "+TABLE_NAME+" WHERE userId="+userId;
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			User usr = new User();
			while (rs.next()){
				usr.setUserId(rs.getInt(1));
				usr.setFirstName(rs.getString(2));
				usr.setLastName(rs.getString(3));
				usr.setPassword(rs.getString(4));
				usr.setRole(rs.getShort(5));
			}
			return usr;
		}
		finally
		{
			if (connection != null)
			{
				connection.close();
			}
		}
	}
	
	public static ArrayList<User> selectAllUsers(DataSource ds) throws SQLException
	{
		Connection connection = null;

		try
		{
			connection = ds.getConnection();
			String sql = "SELECT * FROM "+TABLE_NAME;
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<User> result = new ArrayList<>();

			while (rs.next())
			{
				User usr = new User();
				usr.setUserId(rs.getInt(1));
				usr.setFirstName(rs.getString(2));
				usr.setLastName(rs.getString(3));
				usr.setPassword(rs.getString(4));
				usr.setRole(rs.getShort(5));
				result.add(usr);
			}

			return result;

		}
		finally
		{
			if (connection != null)
			{
				connection.close();
			}
		}
	}

	public static void printAllSchemas(DataSource ds) throws SQLException
	{
		Connection connection = null;

		try
		{
			connection = ds.getConnection();
			ResultSet rs = connection.getMetaData().getCatalogs();

			while (rs.next()) {
			    System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT") );
			}


		}
		finally
		{
			if (connection != null)
			{
				connection.close();
			}
		}
	}
	
}
