package pojos;
//sid        | int         | NO   | PRI | NULL    | auto_increment |
//| first_name | varchar(20) | YES  |     | NULL    |                |
//| last_name  | varchar(20) | YES  |     | NULL    |                |
//| test_score | double      | YES  |     | NULL
public class Student {

	private int sid;
	private String fname;
	private String lname;
	private double marks;
	public Student() {
		super();
	}
	public Student(int sid, String fname, String lname, double marks) {
		super();
		this.sid = sid;
		this.fname = fname;
		this.lname = lname;
		this.marks = marks;
	}
	public Student(String fname, String lname, double marks) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", fname=" + fname + ", lname=" + lname + ", marks=" + marks + "]";
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	
	
	
}
