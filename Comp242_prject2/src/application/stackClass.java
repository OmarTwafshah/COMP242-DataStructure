package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class stackClass {
	public Node header = null;
	public Node newHeader = null;
	public double total = 0;

	public void readData() {
		String row;
		BufferedReader readShares = null;
		try {
			readShares = new BufferedReader(new FileReader("shares.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			while ((row = readShares.readLine()) != null) {
				String[] data = row.split(",");
				push(Integer.parseInt(data[0].trim()), Integer.parseInt(data[1].trim()), data[2].trim(), data[3]);

			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public void push(int numberShares, double priceShares, String nameShares, String date) {
		Node newNode = new Node(numberShares, priceShares, nameShares, date);
		if (header == null) {
			header = newNode;
			return;
		}

		newNode.next = header;
		header = newNode;
	}

	public Node pop() {
		Node temp = header;

		header = header.next;
		temp.next = null;
		return temp;

	}

	public void push(Node temp) {
		if (newHeader == null) {
			newHeader = temp;
			return;
		}

		temp.next = newHeader;
		newHeader = temp;
	}

	public Node pop(int num) {
		Node temp = newHeader;

		newHeader = newHeader.next;
		temp.next = null;
		return temp;

	}

	public boolean Buyshares(int numberShares, String nameShares) {
		dailyPrice.readData();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		int size = dailyPrice.ar.size();
		for (int i = 0; i < size; i++) {
			if (dailyPrice.ar.get(i).companyName.equalsIgnoreCase(nameShares)) {
				push(numberShares, dailyPrice.ar.get(i).dailyPrice, nameShares, date);
				return true;
			}
		}
		return false;
	}

	public double sellShares(int numberShares, String nameShares) {
		dailyPrice.readData();
		boolean flag = false;
		int size = dailyPrice.ar.size();
		double price = 0;
		for (int i = 0; i < size; i++) {
			if (dailyPrice.ar.get(i).companyName.equalsIgnoreCase(nameShares)) {
				price = dailyPrice.ar.get(i).dailyPrice;
				flag = true;
				break;
			}
		}
		if (!flag) {
			return -1;
		}
		double Result = 0;
		while (header != null) {
			Node temp = pop();
			if (temp.getNameShares().equalsIgnoreCase(nameShares.trim())) {
				if (numberShares - temp.getNumberShares() == 0) {
					Result = gainLost(Result + (price - temp.getPriceShares()) * numberShares);
					numberShares = 0;
				} else if (numberShares - temp.getNumberShares() > 0) {
					Result = gainLost(Result += (price - temp.getPriceShares()) * numberShares);
					numberShares = numberShares - temp.getNumberShares();
				} else if (numberShares - temp.getNumberShares() < 0) {
					temp.setNumberShares(temp.getNumberShares() - numberShares);
					Result = gainLost(Result + (price - temp.getPriceShares()) * numberShares);
					numberShares = 0;
					push(temp);
				} else if (numberShares == 0) {
					push(temp);
				}

			} else {
				push(temp);
			}
		}
		Sort();
		return Result;

	}

	public void Sort() {
		Node temp = null;
		while (newHeader != null) {
			temp = pop(0);
			if (temp != null)
				push(temp.getNumberShares(), temp.getPriceShares(), temp.getNameShares(), temp.getDateShares());

		}
	}

	public double gainLost(double number) {
		double result = 0;
		result += number;
		total += result;
		return result;
	}

	public double totalgainLost() {

		return total;
	}
}
