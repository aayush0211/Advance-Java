package dao;

import java.sql.SQLException;

import pojos.Student;

public interface StudentDao {

	String addStudent(Student newStudent,int cid)throws SQLException;
}
