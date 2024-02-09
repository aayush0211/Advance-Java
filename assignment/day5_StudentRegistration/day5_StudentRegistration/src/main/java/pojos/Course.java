package pojos;

public enum Course {
	DAC(80),DBDA(75),IOT(70),AI(85),DITISS(65);

	private double MIN_MARKS;
	Course(double i) {
		// TODO Auto-generated constructor stub
		MIN_MARKS=i;
	}
	public double getMIN_MARKS() {
		return MIN_MARKS;
	}
	
	
}
