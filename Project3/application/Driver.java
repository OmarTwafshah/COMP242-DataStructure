package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class Driver extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// --------------------------------------------------------------------------------------------------------------//

			Tree myTree = new Tree();

			// --------------------------------------------------------------------------------------------------------------//

			BorderPane root = new BorderPane();

			// --------------------------------------------------------------------------------------------------------------//
			image(root);
			// --------------------------------------------------------------------------------------------------------------//
			javafx.scene.control.Label AddLabel = new javafx.scene.control.Label("Click To Button To Add File : ");
			javafx.scene.control.Button AddButton = new javafx.scene.control.Button("Add File");
			javafx.scene.control.Label yearLabel = new javafx.scene.control.Label("   Add Year : ");
			TextField TextFieldYear = new TextField();
			AddLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			AddLabel.setTextFill(Color.WHITE);
			yearLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			yearLabel.setTextFill(Color.WHITE);
			AddButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			AddButton.setTextFill(Color.BLACK);
			HBox add = new HBox(10);
			add.getChildren().addAll(AddLabel, AddButton, yearLabel, TextFieldYear);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label SearchLabel = new javafx.scene.control.Label(
					"Click To Button To Search By Name : ");
			javafx.scene.control.Button SearchButton = new javafx.scene.control.Button(" Search ");
			SearchLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			SearchLabel.setTextFill(Color.WHITE);
			SearchButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			SearchButton.setTextFill(Color.BLACK);
			HBox Search = new HBox(10);
			Search.getChildren().addAll(SearchLabel, SearchButton);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label AverageLabel = new javafx.scene.control.Label(
					"Click To Button To Find Average Frequencies of a Name : ");
			javafx.scene.control.Button AverageButton = new javafx.scene.control.Button(" Average ");
			AverageLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			AverageLabel.setTextFill(Color.WHITE);
			AverageButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			AverageButton.setTextFill(Color.BLACK);
			HBox Average = new HBox(10);
			Average.getChildren().addAll(AverageLabel, AverageButton);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label NameLabel = new javafx.scene.control.Label(
					"Click To Button To Find Name with max frequency : ");
			javafx.scene.control.Button NameButton = new javafx.scene.control.Button(" Name ");
			NameLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			NameLabel.setTextFill(Color.WHITE);
			NameButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			NameButton.setTextFill(Color.BLACK);
			HBox Name = new HBox(10);
			Name.getChildren().addAll(NameLabel, NameButton);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label TotalLabel = new javafx.scene.control.Label(
					"Click To Button To Find Total number of babies in a selected year : ");
			javafx.scene.control.Button TotalButton = new javafx.scene.control.Button(" Total ");
			TotalLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			TotalLabel.setTextFill(Color.WHITE);
			TotalButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			TotalButton.setTextFill(Color.BLACK);
			HBox Total = new HBox(10);
			Total.getChildren().addAll(TotalLabel, TotalButton);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label ExportLabel = new javafx.scene.control.Label(
					"Click To Button To Export the AVL tree data to a file : ");
			javafx.scene.control.Button ExportButton = new javafx.scene.control.Button(" Export ");
			ExportLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			ExportLabel.setTextFill(Color.WHITE);
			ExportButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			ExportButton.setTextFill(Color.BLACK);
			HBox Export = new HBox(10);
			Export.getChildren().addAll(ExportLabel, ExportButton);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Button Close = new javafx.scene.control.Button(" Close ");
			Close.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			Close.setTextFill(Color.BLACK);

			// --------------------------------------------------------------------------------------------------------------//

			VBox allClick = new VBox(12);
			allClick.getChildren().addAll(add, Search, Average, Name, Total, Export, Close);
			allClick.setAlignment(Pos.CENTER);
			root.setCenter(allClick);

			// --------------------------------------------------------------------------------------------------------------//

			AddButton.setOnAction(e -> {
				if (TextFieldYear.getText() == "") {

					BorderPane error = new BorderPane();
					image(error);
					Label errorlabel = new Label("Error : Please Enter Year");
					Button errorClose = new Button("Close");
					errorlabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
					errorlabel.setTextFill(Color.WHITE);
					errorClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
					errorClose.setTextFill(Color.BLACK);
					VBox errorV = new VBox(25);
					errorV.getChildren().addAll(errorlabel, errorClose);
					errorV.setAlignment(Pos.CENTER);
					error.setCenter(errorV);

					Scene newScene = new Scene(error, 500, 150);
					Stage newWindow2 = new Stage();
					newWindow2.setTitle("  Done Read Data ");
					newWindow2.setScene(newScene);
					newWindow2.show();
					errorClose.setOnAction(e4 -> {
						newWindow2.close();
					});
					return;
				}
				int year = Integer.parseInt(TextFieldYear.getText());
				FileChooser fc = new FileChooser();
				fc.setInitialDirectory(new File("C:\\Users\\Redmi\\Desktop\\file"));
				fc.getExtensionFilters().addAll(new ExtensionFilter("Text Document", "*.txt"));
				File ChoisenFile = fc.showOpenDialog(null);
				if (ChoisenFile == null) {
					BorderPane error = new BorderPane();
					image(error);
					Label errorlabel = new Label("Please Enter File ");
					Button errorClose = new Button("Close");
					errorlabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
					errorlabel.setTextFill(Color.WHITE);
					errorClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
					errorClose.setTextFill(Color.BLACK);
					VBox errorV = new VBox(25);
					errorV.getChildren().addAll(errorlabel, errorClose);
					errorV.setAlignment(Pos.CENTER);
					error.setCenter(errorV);

					Scene newScene = new Scene(error, 500, 150);
					Stage newWindow2 = new Stage();
					newWindow2.setTitle("  Done Read Data ");
					newWindow2.setScene(newScene);
					newWindow2.show();
					errorClose.setOnAction(e4 -> {
						newWindow2.close();
					});
					return;
				} else if (ChoisenFile != null) {
					String row;
					try {
						Scanner scanner = new Scanner(ChoisenFile);
						while (scanner.hasNextLine()) {
							row = scanner.nextLine();
							String[] data = row.split(",");
							myTree.insert(data[0].trim(), data[1].trim(), Integer.parseInt(data[2]), year);
						}
						scanner.close();
						TextFieldYear.setText("");
						BorderPane done = new BorderPane();

						image(done);

						javafx.scene.control.Label doneLabel = new javafx.scene.control.Label(
								"The Read File Is Done And Save It In AVL ");

						javafx.scene.control.Button closeDone = new javafx.scene.control.Button(" close ");

						doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						doneLabel.setTextFill(Color.WHITE);
						closeDone.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						closeDone.setTextFill(Color.BLACK);

						VBox DoneV = new VBox(15);
						DoneV.getChildren().addAll(doneLabel, closeDone);
						DoneV.setAlignment(Pos.CENTER);
						done.setCenter(DoneV);

						Scene secondScene = new Scene(done, 500, 150);
						Stage newWindow = new Stage();
						newWindow.setTitle("  Done Read Data ");
						newWindow.setScene(secondScene);
						newWindow.show();

						closeDone.setOnAction(c -> {
							newWindow.close();
						});
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			});

			// --------------------------------------------------------------------------------------------------------------//

			SearchButton.setOnAction(e -> {

				BorderPane searchScene = new BorderPane();
				image(searchScene);

				Label LabelSearch = new Label("Enter The Name To Search it ");
				TextField TextFieldSearch = new TextField();

				LabelSearch.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				LabelSearch.setTextFill(Color.WHITE);

				HBox SearchBox = new HBox(15);
				SearchBox.getChildren().addAll(LabelSearch, TextFieldSearch);

				Label LabelGender = new Label("Selected The Gender :  ");
				RadioButton male = new RadioButton("Male");
				RadioButton female = new RadioButton("Female");
				LabelGender.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				LabelGender.setTextFill(Color.WHITE);
				male.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				male.setTextFill(Color.WHITE);
				female.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				female.setTextFill(Color.WHITE);
				ToggleGroup toggle = new ToggleGroup();
				male.setToggleGroup(toggle);
				female.setToggleGroup(toggle);

				HBox gender = new HBox(10);
				gender.getChildren().addAll(male, female);

				HBox Allgender = new HBox(15);
				Allgender.getChildren().addAll(LabelGender, gender);

				Button find = new Button("find");
				Button close = new Button("Close");

				find.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				find.setTextFill(Color.BLACK);
				close.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				close.setTextFill(Color.BLACK);

				HBox ButtonBox = new HBox(15);
				ButtonBox.getChildren().addAll(find, close);

				VBox SearchAll = new VBox(15);
				SearchAll.getChildren().addAll(SearchBox, Allgender, ButtonBox);
				SearchAll.setAlignment(Pos.CENTER);
				searchScene.setCenter(SearchAll);

				Scene secondScene = new Scene(searchScene, 500, 150);
				Stage newWindow = new Stage();
				newWindow.setTitle("  Done Read Data ");
				newWindow.setScene(secondScene);
				newWindow.show();

				find.setOnAction(e2 -> {
					if (!male.isSelected() && !female.isSelected()) {

						BorderPane error = new BorderPane();
						image(error);
						Label errorlabel = new Label("Error : Selected By Female or Male");
						Button errorClose = new Button("Close");
						errorlabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						errorlabel.setTextFill(Color.WHITE);
						errorClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						errorClose.setTextFill(Color.BLACK);
						VBox errorV = new VBox(25);
						errorV.getChildren().addAll(errorlabel, errorClose);
						errorV.setAlignment(Pos.CENTER);
						error.setCenter(errorV);

						Scene newScene = new Scene(error, 500, 150);
						Stage newWindow2 = new Stage();
						newWindow2.setTitle("  Done Read Data ");
						newWindow2.setScene(newScene);
						newWindow2.show();
						errorClose.setOnAction(e4 -> {
							newWindow2.close();
						});
						return;

					}

					if (TextFieldSearch.getText() == "") {
						BorderPane error = new BorderPane();
						image(error);
						Label errorlabel = new Label(" Error : Enter Name");
						Button errorClose = new Button("Close");
						errorlabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						errorlabel.setTextFill(Color.WHITE);
						errorClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						errorClose.setTextFill(Color.BLACK);
						VBox errorV = new VBox(25);
						errorV.getChildren().addAll(errorlabel, errorClose);
						errorV.setAlignment(Pos.CENTER);
						error.setCenter(errorV);

						Scene newScene = new Scene(error, 500, 150);
						Stage newWindow2 = new Stage();
						newWindow2.setTitle(" ");
						newWindow2.setScene(newScene);
						newWindow2.show();

						errorClose.setOnAction(e4 -> {
							newWindow2.close();
						});
						return;

					}

					if (male.isSelected()) {
						BorderPane done = new BorderPane();
						image(done);

						BST_Node temp = myTree.SearchName(TextFieldSearch.getText(), "M");
						Label doneLabel = null;
						if (temp == null) {
							doneLabel = new Label("The Name or Gender is Wrong");
						} else if (temp != null) {
							doneLabel = new Label("The Final Result is " + temp.toString());
						}

						Button doneClose = new Button("Close");

						doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						doneLabel.setTextFill(Color.WHITE);
						doneClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						doneClose.setTextFill(Color.BLACK);

						VBox doneV = new VBox(25);
						doneV.getChildren().addAll(doneLabel, doneClose);
						doneV.setAlignment(Pos.CENTER);
						done.setCenter(doneV);

						Scene newScene = new Scene(done, 800, 150);
						Stage newWindow2 = new Stage();
						newWindow2.setTitle(" ");
						newWindow2.setScene(newScene);
						newWindow2.show();

						doneClose.setOnAction(e1 -> {
							newWindow2.close();
						});
					} else if (female.isSelected()) {
						BorderPane done = new BorderPane();
						image(done);

						BST_Node temp = myTree.SearchName(TextFieldSearch.getText(), "F");
						Label doneLabel = null;
						if (temp == null) {
							doneLabel = new Label("The Name or Gender is Wrong");
						} else if (temp != null) {
							doneLabel = new Label("The Final Result is " + temp.toString());
						}
						Button doneClose = new Button("Close");

						doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						doneLabel.setTextFill(Color.WHITE);
						doneClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						doneClose.setTextFill(Color.BLACK);

						VBox doneV = new VBox(25);
						doneV.getChildren().addAll(doneLabel, doneClose);
						doneV.setAlignment(Pos.CENTER);
						done.setCenter(doneV);

						Scene newScene = new Scene(done, 800, 150);
						Stage newWindow2 = new Stage();
						newWindow2.setTitle(" ");
						newWindow2.setScene(newScene);
						newWindow2.show();

						doneClose.setOnAction(e1 -> {
							newWindow2.close();
						});
					}

				});

				close.setOnAction(e1 -> {
					newWindow.close();
				});
			});

			// --------------------------------------------------------------------------------------------------------------//

			AverageButton.setOnAction(e -> {

				BorderPane searchScene = new BorderPane();
				image(searchScene);

				Label LabelSearch = new Label("Enter The Name To Find AVG Frequencies it ");
				TextField TextFieldSearch = new TextField();

				LabelSearch.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				LabelSearch.setTextFill(Color.WHITE);

				HBox SearchBox = new HBox(15);
				SearchBox.getChildren().addAll(LabelSearch, TextFieldSearch);

				Label LabelGender = new Label("Selected The Gender :  ");
				RadioButton male = new RadioButton("Male");
				RadioButton female = new RadioButton("Female");
				LabelGender.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				LabelGender.setTextFill(Color.WHITE);
				male.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				male.setTextFill(Color.WHITE);
				female.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				female.setTextFill(Color.WHITE);
				ToggleGroup toggle = new ToggleGroup();
				male.setToggleGroup(toggle);
				female.setToggleGroup(toggle);

				HBox gender = new HBox(10);
				gender.getChildren().addAll(male, female);

				HBox Allgender = new HBox(15);
				Allgender.getChildren().addAll(LabelGender, gender);

				Button find = new Button("find");
				Button close = new Button("Close");

				find.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				find.setTextFill(Color.BLACK);
				close.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				close.setTextFill(Color.BLACK);

				HBox ButtonBox = new HBox(15);
				ButtonBox.getChildren().addAll(find, close);

				VBox SearchAll = new VBox(15);
				SearchAll.getChildren().addAll(SearchBox, Allgender, ButtonBox);
				SearchAll.setAlignment(Pos.CENTER);
				searchScene.setCenter(SearchAll);

				Scene secondScene = new Scene(searchScene, 550, 170);
				Stage newWindow = new Stage();
				newWindow.setTitle("  ");
				newWindow.setScene(secondScene);
				newWindow.show();

				find.setOnAction(e2 -> {
					if (!male.isSelected() && !female.isSelected()) {

						BorderPane error = new BorderPane();
						image(error);
						Label errorlabel = new Label("Error : Selected By Female or Male");
						Button errorClose = new Button("Close");

						errorlabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						errorlabel.setTextFill(Color.WHITE);
						errorClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						errorClose.setTextFill(Color.BLACK);

						VBox errorV = new VBox(25);
						errorV.getChildren().addAll(errorlabel, errorClose);
						errorV.setAlignment(Pos.CENTER);
						error.setCenter(errorV);

						Scene newScene = new Scene(error, 500, 150);
						Stage newWindow2 = new Stage();
						newWindow2.setTitle("  Done Read Data ");
						newWindow2.setScene(newScene);
						newWindow2.show();
						errorClose.setOnAction(e4 -> {
							newWindow2.close();
						});
						return;

					}

					if (TextFieldSearch.getText() == "") {
						BorderPane error = new BorderPane();
						image(error);

						Label errorlabel = new Label(" Error : Enter Name");
						Button errorClose = new Button("Close");

						errorlabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						errorlabel.setTextFill(Color.WHITE);
						errorClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						errorClose.setTextFill(Color.BLACK);

						VBox errorV = new VBox(25);
						errorV.getChildren().addAll(errorlabel, errorClose);
						errorV.setAlignment(Pos.CENTER);
						error.setCenter(errorV);

						Scene newScene = new Scene(error, 500, 150);
						Stage newWindow2 = new Stage();
						newWindow2.setTitle(" ");
						newWindow2.setScene(newScene);
						newWindow2.show();

						errorClose.setOnAction(e4 -> {
							newWindow2.close();
						});
						return;
					}

					if (male.isSelected()) {
						BorderPane done = new BorderPane();
						image(done);

						double result = myTree.AverageFrequenciesName(TextFieldSearch.getText(), "M");
						Label doneLabel = null;

						if (result == 0) {
							doneLabel = new Label("The Name or Gender is Wrong");
						} else {
							doneLabel = new Label("The Final Result is " + result);
						}

						Button doneClose = new Button("Close");

						doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						doneLabel.setTextFill(Color.WHITE);
						doneClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						doneClose.setTextFill(Color.BLACK);

						VBox doneV = new VBox(25);
						doneV.getChildren().addAll(doneLabel, doneClose);
						doneV.setAlignment(Pos.CENTER);
						done.setCenter(doneV);

						Scene newScene = new Scene(done, 800, 150);
						Stage newWindow2 = new Stage();
						newWindow2.setTitle(" ");
						newWindow2.setScene(newScene);
						newWindow2.show();

						doneClose.setOnAction(e1 -> {
							newWindow2.close();
						});

					} else if (female.isSelected()) {
						BorderPane done = new BorderPane();
						image(done);

						double result = myTree.AverageFrequenciesName(TextFieldSearch.getText(), "F");
						Label doneLabel = null;

						if (result == 0) {
							doneLabel = new Label("The Name or Gender is Wrong");
						} else {
							doneLabel = new Label("The Final Result is " + result);
						}
						Button doneClose = new Button("Close");

						doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						doneLabel.setTextFill(Color.WHITE);
						doneClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						doneClose.setTextFill(Color.BLACK);

						VBox doneV = new VBox(25);
						doneV.getChildren().addAll(doneLabel, doneClose);
						doneV.setAlignment(Pos.CENTER);
						done.setCenter(doneV);

						Scene newScene = new Scene(done, 800, 150);
						Stage newWindow2 = new Stage();
						newWindow2.setTitle(" ");
						newWindow2.setScene(newScene);
						newWindow2.show();

						doneClose.setOnAction(e1 -> {
							newWindow2.close();
						});
					}

				});

				close.setOnAction(e1 -> {
					newWindow.close();
				});
			});

			// --------------------------------------------------------------------------------------------------------------//

			NameButton.setOnAction(e -> {
				BorderPane done = new BorderPane();
				image(done);
				BST_Node temp = myTree.max_frequency();

				BST.max = 0;
				BST.Maxtemp = null;
				Label doneLabel = null;

				if (temp == null) {
					doneLabel = new Label("Error : Add File First");
				} else if (temp != null) {
					doneLabel = new Label("The Final Result is " + temp.toString());

				}

				Button doneClose = new Button("Close");

				doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				doneLabel.setTextFill(Color.WHITE);
				doneClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				doneClose.setTextFill(Color.BLACK);

				VBox doneV = new VBox(25);
				doneV.getChildren().addAll(doneLabel, doneClose);
				doneV.setAlignment(Pos.CENTER);
				done.setCenter(doneV);

				Scene newScene = new Scene(done, 800, 150);
				Stage newWindow2 = new Stage();
				newWindow2.setTitle(" ");
				newWindow2.setScene(newScene);
				newWindow2.show();

				doneClose.setOnAction(e1 -> {
					newWindow2.close();
				});
			});

			// --------------------------------------------------------------------------------------------------------------//

			TotalButton.setOnAction(e -> {
				BorderPane searchScene = new BorderPane();
				image(searchScene);

				Label LabelTotal = new Label("Enter The Year To Find All Frequencies it ");
				TextField TextFieldTotal = new TextField();

				LabelTotal.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				LabelTotal.setTextFill(Color.WHITE);

				HBox SearchBox = new HBox(15);
				SearchBox.getChildren().addAll(LabelTotal, TextFieldTotal);

				Button find = new Button("find");
				Button close = new Button("Close");

				find.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				find.setTextFill(Color.BLACK);
				close.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				close.setTextFill(Color.BLACK);

				HBox ButtonBox = new HBox(15);
				ButtonBox.getChildren().addAll(find, close);

				VBox SearchAll = new VBox(15);
				SearchAll.getChildren().addAll(SearchBox, ButtonBox);
				SearchAll.setAlignment(Pos.CENTER);
				searchScene.setCenter(SearchAll);

				Scene secondScene = new Scene(searchScene, 550, 170);
				Stage newWindow = new Stage();
				newWindow.setTitle("  Done Read Data ");
				newWindow.setScene(secondScene);
				newWindow.show();

				find.setOnAction(e3 -> {
					if (TextFieldTotal.getText() == "") {
						BorderPane error = new BorderPane();
						image(error);
						Label errorlabel = new Label(" Error : Enter Year ");
						Button errorClose = new Button("Close");

						errorlabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						errorlabel.setTextFill(Color.WHITE);
						errorClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						errorClose.setTextFill(Color.BLACK);

						VBox errorV = new VBox(25);
						errorV.getChildren().addAll(errorlabel, errorClose);
						errorV.setAlignment(Pos.CENTER);
						error.setCenter(errorV);

						Scene newScene = new Scene(error, 500, 150);
						Stage newWindow2 = new Stage();
						newWindow2.setTitle(" ");
						newWindow2.setScene(newScene);
						newWindow2.show();

						errorClose.setOnAction(e4 -> {
							newWindow2.close();
						});
						return;
					}

					BorderPane done = new BorderPane();
					image(done);
					int newYear = Integer.parseInt(TextFieldTotal.getText());
					int total = myTree.Total_babies(newYear);

					BST.sum = 0;

					Label doneLabel = null;
					if (total == 0) {
						doneLabel = new Label("The Year is Not Found ");
					} else if (total != 0) {
						doneLabel = new Label("The Final Result is " + total);
					}

					Button doneClose = new Button("Close");

					doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
					doneLabel.setTextFill(Color.WHITE);
					doneClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
					doneClose.setTextFill(Color.BLACK);

					VBox doneV = new VBox(25);
					doneV.getChildren().addAll(doneLabel, doneClose);
					doneV.setAlignment(Pos.CENTER);
					done.setCenter(doneV);

					Scene newScene = new Scene(done, 800, 150);
					Stage newWindow2 = new Stage();
					newWindow2.setTitle(" ");
					newWindow2.setScene(newScene);
					newWindow2.show();

					doneClose.setOnAction(e1 -> {
						newWindow2.close();
					});

				});

				close.setOnAction(e1 -> {
					newWindow.close();
				});

			});

			// --------------------------------------------------------------------------------------------------------------//

			ExportButton.setOnAction(e -> {
				BorderPane done = new BorderPane();
				image(done);

				try {
					myTree.Export_AVL();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Label doneLabel = new Label("The AVL Tree is Save output file ");

				Button doneClose = new Button("Close");

				doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				doneLabel.setTextFill(Color.WHITE);
				doneClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				doneClose.setTextFill(Color.BLACK);

				VBox doneV = new VBox(25);
				doneV.getChildren().addAll(doneLabel, doneClose);
				doneV.setAlignment(Pos.CENTER);
				done.setCenter(doneV);

				Scene newScene = new Scene(done, 800, 150);
				Stage newWindow = new Stage();
				newWindow.setTitle(" ");
				newWindow.setScene(newScene);
				newWindow.show();

				doneClose.setOnAction(e1 -> {
					newWindow.close();
				});

			});

			// --------------------------------------------------------------------------------------------------------------//

			Close.setOnAction(e -> {

				primaryStage.close();
			});

			// --------------------------------------------------------------------------------------------------------------//

			Scene scene = new Scene(root, 650, 350);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static void image(BorderPane root) {
		Image back = new Image("file:photo.png");
		ImageView imgV = new ImageView(back);
		imgV.setFitHeight(600);
		imgV.setFitWidth(1200);
		root.getChildren().add(imgV);
	}

}
