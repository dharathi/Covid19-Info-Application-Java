import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class sample 
{
	private final String url="jdbc:postgresql://localhost/covid";
	private final String user="postgres";
	private final String password="dharathi";
	
	private void connect() throws IOException
	{
		try(Connection connection=DriverManager.getConnection(url, user, password);)
		{
			if(connection!=null)
				System.out.println("Connected!");
			else
				System.out.println("Failed connection");
			
			Statement s=connection.createStatement();
			ResultSet rs = s.executeQuery("SELECT * FROM users");
			while(rs.next())
			{
				System.out.println(rs.getString("phno")+"   "+rs.getString("passwd"));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException 
	{
		sample sqlConnect = new sample();
		sqlConnect.connect();
		
	}

}
