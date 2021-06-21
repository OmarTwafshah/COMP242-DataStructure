package application;

public class HeapNode {
	private int year;
	private int frequencies;

	public HeapNode(int year, int frequencies) {
		super();
		this.year = year;
		this.frequencies = frequencies;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getFrequencies() {
		return frequencies;
	}

	public void setFrequencies(int frequencies) {
		this.frequencies = frequencies;
	}

	@Override
	public String toString() {
		return "The frequencie is = " + frequencies + " , and year is = " + year;
	}

}
