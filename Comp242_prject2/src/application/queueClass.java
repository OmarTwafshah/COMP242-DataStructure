package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class queueClass {
	public Node rear = null;
	public Node front = null;
	public Node newRear = null;
	public Node newFront = null;
	public double total = 0;

	// Queue q ;

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
				enQueue(Integer.parseInt(data[0].trim()), Integer.parseInt(data[1].trim()), data[2].trim(), data[3]);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void enQueue(int numberShares, double priceShares, String nameShares, String date) {
		Node newNode = new Node(numberShares, priceShares, nameShares, date);
		if (rear == null) {
			rear = front = newNode;
			rear.next = front;
			return;
		}
		rear.next = newNode;
		rear = rear.next;
		rear.next = front;
	}

	public void enQueue(Node temp) {
		if (newRear == null) {
			newRear = newFront = temp;
			newRear.next = newFront;
			return;
		}
		newRear.next = temp;
		newRear = newRear.next;
		newRear.next = newFront;
	}

	public Node deQueue() {
		Node temp = null;
		if (front == null) {
			System.out.println("The List Empty");
			return temp;
		} else {
			temp = front;
			if (front == rear) {
				front = rear = null;
			} else {
				front = front.next;
				rear.next = front;
			}
			temp.next = null;
		}
		return temp;
	}

	public Node deQueue(int num) {
		Node temp = null;
		if (newFront == null) {
			System.out.println("The List Empty");
			return temp;
		} else {
			temp = newFront;
			if (newFront == newRear) {
				newFront = newRear = null;
			} else {
				newFront = newFront.next;
				newRear.next = newFront;
			}
			temp.next = null;
		}
		return temp;
	}

	public boolean isEmpty() {
		if (front == null) {
			return true;
		}
		return false;
	}

	public boolean Buyshares(int numberShares, String nameShares) {
		dailyPrice.readData();
		String pattern = "dd-MM-yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		int size = dailyPrice.ar.size();
		for (int i = 0; i < size; i++) {
			if (dailyPrice.ar.get(i).companyName.equalsIgnoreCase(nameShares)) {
				enQueue(numberShares, dailyPrice.ar.get(i).dailyPrice, nameShares, date);
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

		while (front != null) {
			Node temp = deQueue();
			if (temp.getNameShares().equalsIgnoreCase(nameShares.trim()) && numberShares != 0) {
				if (numberShares - temp.getNumberShares() == 0) {
					Result = gainLost(Result + (price - temp.getPriceShares()) * numberShares);
					numberShares = 0;
				} else if (numberShares - temp.getNumberShares() > 0) {
					Result = gainLost(Result + (price - temp.getPriceShares()) * numberShares);
					numberShares = numberShares - temp.getNumberShares();
				} else if (numberShares - temp.getNumberShares() < 0) {
					temp.setNumberShares(temp.getNumberShares() - numberShares);
					Result = gainLost(Result + (price - temp.getPriceShares()) * numberShares);
					numberShares = 0;
					enQueue(temp);
				}
			} else {
				enQueue(temp);
			}
		}
		Sort();
		return Result;

	}

	public void Sort() {
		Node temp = null;
		while (newFront != null) {
			temp = deQueue(0);
			if (temp != null)
				enQueue(temp.getNumberShares(), temp.getPriceShares(), temp.getNameShares(), temp.getDateShares());

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