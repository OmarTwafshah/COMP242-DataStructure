package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Project extends Application {

	static int students_total_numGazaSc = 0;
	static int students_total_numGazaLi = 0;
	static int students_total_numWestBankSc = 0;
	static int students_total_numWestBankLi = 0;
	Node headerLiteraryGaza = new Node();
	Node headerScienceGaza = new Node();
	Node headerLiteraryWestBank = new Node();
	Node headerScienceWEstBank = new Node();

	@Override
	public void start(Stage primaryStage) {
		try {

			// -------------//
			/*
			 * Read file and sorted it and save it in List Sorted All data split data if it
			 * Literary or Science Read Gaza file And West bank
			 */
			String row;
			BufferedReader csvReader = null;
			try {
				csvReader = new BufferedReader(new FileReader("Gaza_2019.csv"));

			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
			try {
				while ((row = csvReader.readLine()) != null) {
					String[] data = row.split(",");
					if (data[1].trim().equalsIgnoreCase("Literary")) {
						sorted_insert(headerLiteraryGaza, Double.parseDouble(data[2]), Integer.parseInt(data[0]),
								data[1]);
						students_total_numGazaLi++;
					} else if (data[1].trim().equalsIgnoreCase("Scientific")) {
						sorted_insert(headerScienceGaza, Double.parseDouble(data[2]), Integer.parseInt(data[0]),
								data[1]);
						students_total_numGazaSc++;
					}
				}
			} catch (NumberFormatException | IOException e1) {
				e1.printStackTrace();
			}
			csvReader.close();

			// ---------------------------------------------------------------------//

			String row2;
			BufferedReader csvReader2 = null;
			try {
				csvReader2 = new BufferedReader(new FileReader("WestBank_2019.csv"));
			} catch (FileNotFoundException e2) {
				e2.printStackTrace();
			}
			try {
				while ((row2 = csvReader2.readLine()) != null) {
					String[] data = row2.split(",");
					if (data[1].trim().equalsIgnoreCase("Literary")) {
						sorted_insert(headerLiteraryWestBank, Double.parseDouble(data[2]), Integer.parseInt(data[0]),
								data[1]);
						students_total_numWestBankLi++;
					} else if (data[1].trim().equalsIgnoreCase("Scientific")) {
						sorted_insert(headerScienceWEstBank, Double.parseDouble(data[2]), Integer.parseInt(data[0]),
								data[1]);
						students_total_numWestBankSc++;
					}

				}
			} catch (NumberFormatException | IOException e1) {
				e1.printStackTrace();
			}
			csvReader2.close();

			// ----------------------------------------------------------------------------------------------------//

			// First Step in java fx
			/*
			 * Add All RadioButton and Create you scene in javafx Create HBox And VBox to
			 * relate with RadioButton and TextFiled and Label text set all VBox And HBox in
			 * Pos in scene set all action for all RadioButton
			 * 
			 */

			// ----------------------------------------------------------------------------------------------------//

			BorderPane root = new BorderPane();

			// ----------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label region = new javafx.scene.control.Label(
					"Please select a region. The program will not work without selecting a region ");
			RadioButton gaza = new RadioButton("Gaza");
			RadioButton westBank = new RadioButton("West Bank");
			ToggleGroup first1 = new ToggleGroup();
			gaza.setSelected(true);
			gaza.setToggleGroup(first1);
			westBank.setToggleGroup(first1);
			VBox menu1 = new VBox(20);
			menu1.getChildren().addAll(region, gaza, westBank);
			root.setLeft(menu1);

			// ----------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label Branch = new javafx.scene.control.Label(
					"Please select a Branch. The program will not work without selecting a Branch ");
			RadioButton literary = new RadioButton("Literary");
			RadioButton science = new RadioButton("Science");
			ToggleGroup second2 = new ToggleGroup();
			literary.setSelected(true);
			literary.setToggleGroup(second2);
			science.setToggleGroup(second2);
			VBox menu2 = new VBox(20);
			menu2.getChildren().addAll(Branch, literary, science);
			root.setRight(menu2);

			// ----------------------------------------------------------------------------------------------------//

			HBox allMenu = new HBox(200);
			allMenu.getChildren().addAll(menu1, menu2);
			allMenu.setAlignment(Pos.TOP_CENTER);
			root.setTop(allMenu);

			// ----------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label selection = new javafx.scene.control.Label(
					"Please select a selection. The program will not work without selecting a selection ");
			RadioButton selection1 = new RadioButton(
					"Sorted All Data And insert Node If you want add node add seat number and branh and Gpa");
			RadioButton selection2 = new RadioButton("Delete A Tawjihi Record From The List Using The Seat Number");
			RadioButton selection3 = new RadioButton("Search For A Specific Tawjihi Record Using A Seat Number");
			RadioButton selection4 = new RadioButton("Display The Top 10 Students According To The Grade");
			RadioButton selection5 = new RadioButton("Calculate And Display The Mean (Average)");
			RadioButton selection6 = new RadioButton("Calculate And Display The Mode");
			RadioButton selection7 = new RadioButton("Calculate And Display The Variance And Standard Deviation");
			RadioButton selection8 = new RadioButton("Calculate And Display The Median");
			RadioButton selection9 = new RadioButton(
					"Return The Number And Percentage Of Students Whom Grade Above Or Equal A Specific Grade");
			RadioButton selection10 = new RadioButton(
					"Export The Above-Calculated Items (From 4 To 9) Into A File As A Report");
			VBox allSelection = new VBox(20);
			allSelection.getChildren().addAll(selection, selection1, selection2, selection3, selection4, selection5,
					selection6, selection7, selection8, selection9, selection10);
			ToggleGroup selectionGroup = new ToggleGroup();
			selection1.setToggleGroup(selectionGroup);
			selection2.setToggleGroup(selectionGroup);
			selection3.setToggleGroup(selectionGroup);
			selection4.setToggleGroup(selectionGroup);
			selection5.setToggleGroup(selectionGroup);
			selection6.setToggleGroup(selectionGroup);
			selection7.setToggleGroup(selectionGroup);
			selection8.setToggleGroup(selectionGroup);
			selection9.setToggleGroup(selectionGroup);
			selection10.setToggleGroup(selectionGroup);
			allSelection.setAlignment(Pos.BASELINE_LEFT);
			root.setLeft(allSelection);

			// ----------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label TextSeatNumber = new javafx.scene.control.Label(
					"The Seat Number To add it  :  ");
			javafx.scene.control.TextField FieldSeatNumber = new javafx.scene.control.TextField();
			FieldSeatNumber.setText("13245678");
			javafx.scene.control.Label TextBranch = new javafx.scene.control.Label("The Branch To add it  :  ");
			javafx.scene.control.TextField FieldBranch = new javafx.scene.control.TextField();
			FieldBranch.setText("Literary");
			javafx.scene.control.Label TextGpa = new javafx.scene.control.Label("The Gpa To add it  :  ");
			javafx.scene.control.TextField FieldGpa = new javafx.scene.control.TextField();
			FieldGpa.setText("70");
			javafx.scene.control.Label firstText = new javafx.scene.control.Label(
					"Enter A Value If There Is A Reason ");
			javafx.scene.control.TextField textField = new javafx.scene.control.TextField();
			textField.setText("70");
			HBox input1 = new HBox(15);
			input1.getChildren().addAll(firstText, textField);
			HBox input2 = new HBox(15);
			input2.getChildren().addAll(TextSeatNumber, FieldSeatNumber);
			HBox input3 = new HBox(15);
			input3.getChildren().addAll(TextBranch, FieldBranch);
			HBox input4 = new HBox(15);
			input4.getChildren().addAll(TextGpa, FieldGpa);
			VBox input = new VBox(15);
			input.getChildren().addAll(input2, input3, input4, input1);
			input.setAlignment(Pos.BOTTOM_LEFT);
			root.setBottom(input);

			// ----------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label result1 = new javafx.scene.control.Label("The Final Result Is :  ");
			javafx.scene.control.Label reuslt2 = new javafx.scene.control.Label();
			HBox finalresult = new HBox(15);
			finalresult.getChildren().addAll(result1, reuslt2);
			finalresult.setAlignment(Pos.CENTER);
			finalresult.setSpacing(50);
			root.setCenter(finalresult);

			// ----------------------------------------------------------------------------------------------------//

			gaza.setOnAction(e -> {

			});

			// ----------------------------------------------------------------------------------------------------//

			westBank.setOnAction(e -> {

			});

			// ----------------------------------------------------------------------------------------------------//

			literary.setOnAction(e -> {

			});

			// ----------------------------------------------------------------------------------------------------//

			science.setOnAction(e -> {

			});

			// ----------------------------------------------------------------------------------------------------//

			selection1.setOnAction(e -> {
				try {

					if (gaza.isSelected() && science.isSelected()) {
						sorted_insert(headerScienceGaza, Double.parseDouble(FieldSeatNumber.getText()),
								Integer.parseInt(FieldSeatNumber.getText()), String.valueOf(FieldBranch));
						FileWriter list;
						try {
							list = new FileWriter(new File("List.txt"));
							Node curr = headerScienceGaza;
							while (curr != null) {
								list.write(curr.toString() + "\n");
								curr = curr.next;
							}
							list.close();
						} catch (IOException ex) {
							System.out.println(ex.getMessage() + "\n");
						}

						reuslt2.setText("The Sort is Done And The List Save In List.txt File  ");

					} else if (gaza.isSelected() && literary.isSelected()) {
						sorted_insert(headerLiteraryGaza, Double.parseDouble(FieldSeatNumber.getText()),
								Integer.parseInt(FieldSeatNumber.getText()), String.valueOf(FieldBranch));
						FileWriter list;
						try {
							list = new FileWriter(new File("List.txt"));
							Node curr = headerLiteraryGaza;
							while (curr != null) {
								list.write(curr.toString() + "\n");
								curr = curr.next;
							}
							list.close();
						} catch (IOException ex) {
							System.out.println(ex.getMessage() + "\n");
						}

						reuslt2.setText("The Sort is Done And The List Save In List.txt File  ");

					} else if (westBank.isSelected() && science.isSelected()) {
						sorted_insert(headerScienceWEstBank, Double.parseDouble(FieldSeatNumber.getText()),
								Integer.parseInt(FieldSeatNumber.getText()), String.valueOf(FieldBranch));
						FileWriter list;
						try {
							list = new FileWriter(new File("List.txt"));
							Node curr = headerScienceWEstBank;
							while (curr != null) {
								list.write(curr.toString() + "\n");
								curr = curr.next;
							}
							list.close();
						} catch (IOException ex) {
							System.out.println(ex.getMessage() + "\n");
						}

						reuslt2.setText("The Sort is Done And The List Save In List.txt File  ");

					} else if (westBank.isSelected() && literary.isSelected()) {
						sorted_insert(headerLiteraryWestBank, Double.parseDouble(FieldSeatNumber.getText()),
								Integer.parseInt(FieldSeatNumber.getText()), String.valueOf(FieldBranch));
						FileWriter list;
						try {
							list = new FileWriter(new File("List.txt"));
							Node curr = headerLiteraryWestBank;
							while (curr != null) {
								list.write(curr.toString() + "\n");
								curr = curr.next;
							}
							list.close();
						} catch (IOException ex) {
							System.out.println(ex.getMessage() + "\n");
						}

						reuslt2.setText("The Sort is Done And The List Save In List.txt File  ");

					}
				} catch (Exception e1) {
					reuslt2.setText(e1.getMessage());
				}
			});

			// ----------------------------------------------------------------------------------------------------//

			selection2.setOnAction(e -> {
				try {
					if (gaza.isSelected() && science.isSelected()) {
						reuslt2.setText("The Result of Delete is "
								+ delete_node(headerScienceGaza, Integer.parseInt(textField.getText())));

					} else if (gaza.isSelected() && literary.isSelected()) {
						reuslt2.setText("The Result of Delete is "
								+ delete_node(headerLiteraryGaza, Integer.parseInt(textField.getText())));

					} else if (westBank.isSelected() && science.isSelected()) {
						reuslt2.setText("The Result of Delete is "
								+ delete_node(headerScienceWEstBank, Integer.parseInt(textField.getText())));

					} else if (westBank.isSelected() && literary.isSelected()) {
						reuslt2.setText("The Result of Delete is "
								+ delete_node(headerLiteraryWestBank, Integer.parseInt(textField.getText())));

					}
				} catch (Exception e2) {
					reuslt2.setText(e2.getMessage());
				}
			});

			// ----------------------------------------------------------------------------------------------------//

			selection3.setOnAction(e -> {
				try {
					if (gaza.isSelected() && science.isSelected()) {
						reuslt2.setText("The Result of Search is "
								+ search_list(headerScienceGaza, Integer.parseInt(textField.getText())));
					} else if (gaza.isSelected() && literary.isSelected()) {
						reuslt2.setText("The Result of Search is "
								+ search_list(headerLiteraryGaza, Integer.parseInt(textField.getText())));

					} else if (westBank.isSelected() && science.isSelected()) {
						reuslt2.setText("The Result of Search is "
								+ search_list(headerScienceWEstBank, Integer.parseInt(textField.getText())));

					} else if (westBank.isSelected() && literary.isSelected()) {

						reuslt2.setText("The Result of Search is "
								+ search_list(headerLiteraryWestBank, Integer.parseInt(textField.getText())));

					}
				} catch (Exception e2) {
					reuslt2.setText(e2.getMessage());
				}

			});

			// ----------------------------------------------------------------------------------------------------//

			selection4.setOnAction(e -> {

				if (gaza.isSelected() && science.isSelected()) {
					reuslt2.setText("The Result is " + print_first_ten(headerScienceGaza));

				} else if (gaza.isSelected() && literary.isSelected()) {
					reuslt2.setText("The Result is " + print_first_ten(headerLiteraryGaza));

				} else if (westBank.isSelected() && science.isSelected()) {
					reuslt2.setText("The Result is " + print_first_ten(headerScienceWEstBank));

				} else if (westBank.isSelected() && literary.isSelected()) {
					reuslt2.setText("The Result is " + print_first_ten(headerLiteraryWestBank));

				}

			});

			// ----------------------------------------------------------------------------------------------------//

			selection5.setOnAction(e -> {

				if (gaza.isSelected() && science.isSelected()) {
					reuslt2.setText("The Result is " + calc_mean(headerScienceGaza, students_total_numGazaSc));

				} else if (gaza.isSelected() && literary.isSelected()) {
					reuslt2.setText("The Result is " + calc_mean(headerLiteraryGaza, students_total_numGazaLi));

				} else if (westBank.isSelected() && science.isSelected()) {
					reuslt2.setText("The Result is " + calc_mean(headerScienceWEstBank, students_total_numWestBankSc));

				} else if (westBank.isSelected() && literary.isSelected()) {
					reuslt2.setText("The Result is " + calc_mean(headerLiteraryWestBank, students_total_numWestBankLi));

				}

			});

			// ----------------------------------------------------------------------------------------------------//

			selection6.setOnAction(e -> {

				if (gaza.isSelected() && science.isSelected()) {
					reuslt2.setText("The Result Of Mode is " + get_mod(headerScienceGaza));

				} else if (gaza.isSelected() && literary.isSelected()) {
					reuslt2.setText("The Result Of Mode is " + get_mod(headerLiteraryGaza));

				} else if (westBank.isSelected() && science.isSelected()) {
					reuslt2.setText("The Result Of Mode is " + get_mod(headerScienceWEstBank));

				} else if (westBank.isSelected() && literary.isSelected()) {
					reuslt2.setText("The Result Of Mode is " + get_mod(headerLiteraryWestBank));

				}

			});

			// ----------------------------------------------------------------------------------------------------//

			selection7.setOnAction(e -> {

				if (gaza.isSelected() && science.isSelected()) {
					reuslt2.setText(
							"The Result Of Variance is " + calc_variance(headerScienceGaza, students_total_numGazaSc)
									+ "And The Result Of Standard Deviation Is "
									+ calc_standard_div(headerScienceGaza, students_total_numGazaSc));

				} else if (gaza.isSelected() && literary.isSelected()) {
					reuslt2.setText(
							"The Result Of Variance is " + calc_variance(headerLiteraryGaza, students_total_numGazaLi)
									+ "And The Result Of Standard Deviation Is "
									+ calc_standard_div(headerLiteraryGaza, students_total_numGazaLi));

				} else if (westBank.isSelected() && science.isSelected()) {
					reuslt2.setText("The Result Of Variance is "
							+ calc_variance(headerScienceWEstBank, students_total_numWestBankSc)
							+ "And The Result Of Standard Deviation Is "
							+ calc_standard_div(headerScienceWEstBank, students_total_numWestBankSc));
				} else if (westBank.isSelected() && literary.isSelected()) {
					reuslt2.setText("The Result Of Variance is "
							+ calc_variance(headerLiteraryWestBank, students_total_numWestBankLi)
							+ "And The Result Of Standard Deviation Is "
							+ calc_standard_div(headerLiteraryWestBank, students_total_numWestBankLi));
				}

			});

			// ----------------------------------------------------------------------------------------------------//

			selection8.setOnAction(e -> {

				if (gaza.isSelected() && science.isSelected()) {

					reuslt2.setText("The Result Of median is " + get_median(headerScienceGaza));

				} else if (gaza.isSelected() && literary.isSelected()) {

					reuslt2.setText("The Result Of median is " + get_median(headerLiteraryGaza));

				} else if (westBank.isSelected() && science.isSelected()) {

					reuslt2.setText("The Result Of median is " + get_median(headerScienceWEstBank));

				} else if (westBank.isSelected() && literary.isSelected()) {

					reuslt2.setText("The Result Of median is " + get_median(headerLiteraryWestBank));
				}

			});

			// ----------------------------------------------------------------------------------------------------//

			selection9.setOnAction(e -> {
				try {

					if (gaza.isSelected() && science.isSelected()) {
						reuslt2.setText(
								"The Result Of  percentage of students whom grade above or equal a specific grade is "
										+ get_number_precentage(headerScienceGaza,
												Double.parseDouble(textField.getText()), students_total_numGazaSc));

					} else if (gaza.isSelected() && literary.isSelected()) {
						reuslt2.setText(
								"The Result Of  percentage of students whom grade above or equal a specific grade is "
										+ get_number_precentage(headerLiteraryGaza,
												Double.parseDouble(textField.getText()), students_total_numGazaLi));

					} else if (westBank.isSelected() && science.isSelected()) {
						reuslt2.setText(
								"The Result Of  percentage of students whom grade above or equal a specific grade is "
										+ get_number_precentage(headerScienceWEstBank,
												Double.parseDouble(textField.getText()), students_total_numWestBankSc));
					} else if (westBank.isSelected() && literary.isSelected()) {
						reuslt2.setText(
								"The Result Of  percentage of students whom grade above or equal a specific grade is "
										+ get_number_precentage(headerLiteraryWestBank,
												Double.parseDouble(textField.getText()), students_total_numWestBankLi));
					}
				} catch (Exception e2) {
					reuslt2.setText(e2.getMessage());
				}

			});

			// ----------------------------------------------------------------------------------------------------//

			selection10.setOnAction(e -> {
				try {

					if (gaza.isSelected() && science.isSelected()) {
						printAllRuseltInFile(headerScienceGaza, Double.parseDouble(textField.getText()),
								students_total_numGazaSc);
						reuslt2.setText("The Result Of Data 4-9 Is Save In File :) ");

					} else if (gaza.isSelected() && literary.isSelected()) {
						printAllRuseltInFile(headerLiteraryGaza, Double.parseDouble(textField.getText()),
								students_total_numGazaLi);
						reuslt2.setText("The Result Of Data 4-9 Is Save In File :) ");

					} else if (westBank.isSelected() && science.isSelected()) {
						printAllRuseltInFile(headerScienceWEstBank, Double.parseDouble(textField.getText()),
								students_total_numWestBankSc);
						reuslt2.setText("The Result Of Data 4-9 Is Save In File :) ");

					} else if (westBank.isSelected() && literary.isSelected()) {
						printAllRuseltInFile(headerLiteraryWestBank, Double.parseDouble(textField.getText()),
								students_total_numWestBankLi);
						reuslt2.setText("The Result Of Data 4-9 Is Save In File :) ");

					}
				} catch (Exception e2) {
					reuslt2.setText(e2.getMessage());
				}

			});

			// ----------------------------------------------------------------------------------------------------//

			Scene scene = new Scene(root, 1100, 900);
			primaryStage.setTitle("First Project");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ----------------------------------------------------------------------------------------------------//

	public static void main(String[] args) {
		launch(args);

	}

	// ----------------------------------------------------------------------------------------------------//

	// Method That check if Student Existing or not And return Boolean val .
	public static boolean search_list(Node list, int seat_number) {
		Node temp = list;
		while (temp != null) {
			if (temp.getSeat_number() == seat_number)
				return true;
			temp = temp.next;
		}
		return false;
	}

	// ----------------------------------------------------------------------------------------------------//

	// Method That Calculate The Mean For List User Set It
	public static double calc_mean(Node header, int students_total_num) {
		double sum = 0;
		Node temp = header;
		while (temp != null) {
			sum += temp.getGpa();
			temp = temp.next;
		}
		return sum / students_total_num;
	}

	// ----------------------------------------------------------------------------------------------------//

	// Method That Calculate The variance For List User Set It
	public static double calc_variance(Node header, int students_total_num) {
		double mean = calc_mean(header, students_total_num);
		Node temp = header.next;
		double sum_squared = 0;
		while (temp != null) {
			sum_squared += Math.pow((temp.getGpa() - mean), 2);
			temp = temp.next;
		}
		return sum_squared / students_total_num;
	}

	// ----------------------------------------------------------------------------------------------------//

	// Method That Calculate The standard deviation For List User Set It

	public static double calc_standard_div(Node header, int students_total_num) {
		return Math.sqrt(calc_variance(header, students_total_num));
	}

	// ----------------------------------------------------------------------------------------------------//

	// Method That get Header of user and Student seat and Branch and gpa
	// this method check if the student Literary or Not
	// compare Of Node Gpa and set the biggest at first
	// After That check it is null and add first Node
	// After that Add Node for current

	public static void sorted_insert(Node head, double gpa, int seat_number, String branch) {
		Node new_node = new Node(gpa, seat_number, branch);
		Node current;
		if (head.next == null || head.next.getGpa() <= new_node.getGpa()) {
			new_node.next = head.next;
			head.next = new_node;
		} else {
			current = head.next;
			while (current.next != null && current.next.getGpa() > new_node.getGpa()) {
				current = current.next;
			}
			new_node.next = current.next;
			current.next = new_node;
		}

	}

	// ----------------------------------------------------------------------------------------------------//

	// Method That check if Student Existing or not And Delete it if Existing and
	// return Boolean val .

	public static boolean delete_node(Node head, int seat_number) {
		Node temp = head.next, prev = head;
		if (temp == null || temp.getSeat_number() == seat_number) {
			head.next = temp;
			return true;
		}

		while (temp != null && temp.getSeat_number() != seat_number) {
			prev = temp;
			temp = temp.next;
		}

		if (temp == null)
			return false;

		prev.next = temp.next;
		return true;
	}

	// ----------------------------------------------------------------------------------------------------//

	// Print Top 10 Student Gpa
	public static String print_first_ten(Node header) {
		int count = 0;
		String tenStudent = "";
		Node temp = header.next;
		while (temp != null && temp.next != null && count < 10) {
			tenStudent += temp.toString() + "\n";
			if (temp.getGpa() != temp.next.getGpa())
				count++;
			temp = temp.next;
		}
		return tenStudent;
	}

	// ----------------------------------------------------------------------------------------------------//

	// Calculate Mode
	// works for sorted list
	public static String get_mod(Node header) {
		if (header.next == null)
			return null;
		Node temp = header.next;
		double prev_gpa = temp.getGpa();
		double mod_number = temp.getGpa();
		temp = temp.next;
		int count = 1, max_count = 0;

		while (temp != null) {
			if (temp.getGpa() == prev_gpa) {
				count++;
			} else {
				if (count > max_count) {
					max_count = count;
					mod_number = prev_gpa;
				}
				count = 0;
			}
			prev_gpa = temp.getGpa();
			temp = temp.next;
		}
		String mod = mod_number + " ِ repeat " + max_count;
		return mod;
	}

	// ----------------------------------------------------------------------------------------------------//

	public static String get_median(Node header) {
		if (header.next == null)
			return null;
		Node slow = header.next;
		Node fast = header.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		String median = "The Student Gpa is " + slow.getGpa() + " And The Seat Number is " + slow.getSeat_number();
		return median;
	}

	// ----------------------------------------------------------------------------------------------------//

	public static String get_number_precentage(Node header, double gpa, int students_total_num) {
		int count = 0;
		Node temp = header.next;
		while (temp != null) {
			if (temp.getGpa() >= gpa)
				count++;
			temp = temp.next;
		}
		String precentage_Of_Student = "The Number Of Student is " + count
				+ " And The Percentage of Students Whom Grade Above Or Equal A Specific Grade is"
				+ ((count * 1.0) / students_total_num);
		return precentage_Of_Student;

	}

	// ----------------------------------------------------------------------------------------------------//

	public static void printAllRuseltInFile(Node header, double gpa, int students_total_num) {
		FileWriter outfile;
		try {
			outfile = new FileWriter(new File("allMethodResult.txt"));

			outfile.write("The Top ten Student is : " + print_first_ten(header) + "\n");

			outfile.write("The mean is : " + calc_mean(header, students_total_num) + "\n");

			outfile.write("The Mode is " + get_mod(header) + "\n");

			outfile.write("The variance is " + calc_variance(header, students_total_num) + "\n");

			outfile.write("The standard deviation is " + calc_standard_div(header, students_total_num) + "\n");

			outfile.write(get_median(header) + "\n");

			outfile.write(get_number_precentage(header, gpa, students_total_num) + "\n");

			outfile.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage() + "\n");
		}
	}

}