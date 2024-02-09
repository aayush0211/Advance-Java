package dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//jdbc:mysql://localhost:3306/studentadmission?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true","root","root");
//	return cn;
public class DbUtil {

private static Connection cn;
	
	public static Connection openConnection(String dburl,String user_name,String pass) throws SQLException
	{
		cn=DriverManager.getConnection(dburl,user_name,pass);
	return cn;
	}
	public static void closeConnection() throws SQLException
	{	if(cn!=null)
		cn.close();
	}
	public static Connection getCn() {
		return cn;
	}
}
