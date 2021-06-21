package application;

public class LLNode {
	private int year;
	private int frequencie;
	public LLNode next;

	public LLNode() {

	}

	public LLNode(int year, int frequencie) {
		this.year = year;
		this.frequencie = frequencie;
		this.next = null;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getFrequencie() {
		return frequencie;
	}

	public void setFrequencie(int frequencie) {
		this.frequencie = frequencie;
	}

	@Override
	public String toString() {
		return " , And year = " + year + " , And frequencie = " + frequencie + "\n ";
	}

}
