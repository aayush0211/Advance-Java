package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import pojos.Student;
import static dbutils.DbUtil.*;
public class StudentDaoImpl implements StudentDao {

	private Connection cn;
	private PreparedStatement pst1,pst2;
	
	
	public StudentDaoImpl() throws SQLException {
		super();
		cn=getCn();
		pst1=cn.prepareStatement("insert into students vlaues(default,?,?,?)");
		pst2=cn.prepareStatement("insert into studentcourse values(?,?)");
	}


	@Override
	public String addStudent(Student newStudent,int cid) throws SQLException {
		// TODO Auto-generated method stub
		pst1.setString(1, newStudent.getFname());
		pst1.setString(2, newStudent.getLname());
		pst1.setDouble(3, newStudent.getMarks());
		pst2.setInt(1, newStudent.getSid());
		pst2.setInt(2, cid);
		
		int row1=pst1.executeUpdate();
		int row2=pst2.executeUpdate();
		
		if(row1==1&&row2==1)
			return "successfully register !!";
		return "Not register !!";
	}
	public void cleanUP() throws SQLException
	{
		if(pst1!=null)pst1.close();
		if(pst2!=null)pst2.close();
	}

}
