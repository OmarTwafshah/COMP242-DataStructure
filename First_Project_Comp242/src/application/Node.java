package application;

public class Node {
	private double gpa;
	private int seat_number;
	private String branch; // Literary or Science
	public Node next;

	// Constructor
	public Node(double gpa, int seat_number, String branch) {
		this.gpa = gpa;
		this.seat_number = seat_number;
		this.branch = branch;
		this.next = null;
	}

	public Node() {

	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public int getSeat_number() {
		return seat_number;
	}

	public void setSeat_number(int seat_number) {
		this.seat_number = seat_number;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "Student GPA Is = " + gpa + " , And Seat Number Is = " + seat_number + ", And The Branch Is = " + branch;
	}

}
