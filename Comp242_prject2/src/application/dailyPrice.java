package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class dailyPrice {

	String companyName;
	double dailyPrice;

	public static ArrayList<dailyPrice> ar = new ArrayList<>();

	public dailyPrice(String companyName, double dailyPrice) {
		this.companyName = companyName;
		this.dailyPrice = dailyPrice;
	}

	public static void readData() {
		String row;
		BufferedReader csvReader = null;
		try {
			csvReader = new BufferedReader(new FileReader("dailyPrice.txt"));

		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		try {
			while ((row = csvReader.readLine()) != null) {
				String[] data = row.split(",");
				ar.add(new dailyPrice(data[0].trim(), Double.parseDouble(data[1].trim())));

			}
		} catch (NumberFormatException | IOException e1) {
			e1.printStackTrace();
		}
		try {
			csvReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
