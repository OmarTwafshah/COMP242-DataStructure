package application;

public class Node {
	private int numberShares;
	private double priceShares;
	private String nameShares;
	private String dateShares;
	public Node next;

	public Node() {

	}

	public Node(int numberShares, double priceShares, String nameShares, String dateShares) {
		this.numberShares = numberShares;
		this.priceShares = priceShares;
		this.nameShares = nameShares;
		this.dateShares = dateShares;
		this.next = null;
	}

	public int getNumberShares() {
		return numberShares;
	}

	public void setNumberShares(int numberShares) {
		this.numberShares = numberShares;
	}

	public double getPriceShares() {
		return priceShares;
	}

	public void setPriceShares(double priceShares) {
		this.priceShares = priceShares;
	}

	public String getNameShares() {
		return nameShares;
	}

	public void setNameShares(String nameShares) {
		this.nameShares = nameShares;
	}

	public String getDateShares() {
		return dateShares;
	}

	public void setDateShares(String dateShares) {
		this.dateShares = dateShares;
	}

	@Override
	public String toString() {
		return numberShares + ", " + priceShares + ", " + nameShares + ", " + dateShares + "\n";
	}

}
