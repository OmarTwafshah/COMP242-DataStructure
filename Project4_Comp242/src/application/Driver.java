package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
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
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

public class Driver extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// --------------------------------------------------------------------------------------------------------------//

			BorderPane root = new BorderPane();

			// --------------------------------------------------------------------------------------------------------------//
			Hash hash = new Hash(3);
			// --------------------------------------------------------------------------------------------------------------//
			image(root);
			// --------------------------------------------------------------------------------------------------------------//
			javafx.scene.control.Label AddLabel = new javafx.scene.control.Label(
					"Click To Button To Add Directory File : ");
			javafx.scene.control.Button AddButton = new javafx.scene.control.Button("Add File");
			AddLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			AddLabel.setTextFill(Color.WHITE);
			AddButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			AddButton.setTextFill(Color.BLACK);
			HBox add = new HBox(10);
			add.getChildren().addAll(AddLabel, AddButton);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label AddNameAndGenderLabel = new javafx.scene.control.Label(
					"Click To Button To Add Name And Gender : ");
			javafx.scene.control.Button AddNameAndGenderButton = new javafx.scene.control.Button(" Add ");
			AddNameAndGenderLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			AddNameAndGenderLabel.setTextFill(Color.WHITE);
			AddNameAndGenderButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			AddNameAndGenderButton.setTextFill(Color.BLACK);
			HBox AddNameAndGender = new HBox(10);
			AddNameAndGender.getChildren().addAll(AddNameAndGenderLabel, AddNameAndGenderButton);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label DeleteLabel = new javafx.scene.control.Label(
					"Click To Button To Delete record : ");
			javafx.scene.control.Button DeleteButton = new javafx.scene.control.Button(" Delete ");
			DeleteLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			DeleteLabel.setTextFill(Color.WHITE);
			DeleteButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			DeleteButton.setTextFill(Color.BLACK);
			HBox Delete = new HBox(10);
			Delete.getChildren().addAll(DeleteLabel, DeleteButton);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label AddfrequencieandYearLabel = new javafx.scene.control.Label(
					"Click To Button To ِAdd Frequencie And Year From Name You Enter It : ");
			javafx.scene.control.Button AddfrequencieandYearButton = new javafx.scene.control.Button(" Add ");
			AddfrequencieandYearLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			AddfrequencieandYearLabel.setTextFill(Color.WHITE);
			AddfrequencieandYearButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			AddfrequencieandYearButton.setTextFill(Color.BLACK);
			HBox AddfrequencieandYear = new HBox(10);
			AddfrequencieandYear.getChildren().addAll(AddfrequencieandYearLabel, AddfrequencieandYearButton);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label UpdateLAbel = new javafx.scene.control.Label(
					"Click To Button To Update Frequencie From Year You Enter It  : ");
			javafx.scene.control.Button UpdateButton = new javafx.scene.control.Button(" Update ");
			UpdateLAbel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			UpdateLAbel.setTextFill(Color.WHITE);
			UpdateButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			UpdateButton.setTextFill(Color.BLACK);
			HBox Update = new HBox(10);
			Update.getChildren().addAll(UpdateLAbel, UpdateButton);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label SearchLabel = new javafx.scene.control.Label(
					"Click To Button To Search In Your List : ");
			javafx.scene.control.Button SearchButton = new javafx.scene.control.Button(" Serach ");
			SearchLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			SearchLabel.setTextFill(Color.WHITE);
			SearchButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			SearchButton.setTextFill(Color.BLACK);
			HBox Search = new HBox(10);
			Search.getChildren().addAll(SearchLabel, SearchButton);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label MaxLabel = new javafx.scene.control.Label(
					"Click To Button To Find Max Frequancy in your List : ");
			javafx.scene.control.Button MaxButton = new javafx.scene.control.Button(" Max ");
			MaxLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			MaxLabel.setTextFill(Color.WHITE);
			MaxButton.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			MaxButton.setTextFill(Color.BLACK);
			HBox Max = new HBox(10);
			Max.getChildren().addAll(MaxLabel, MaxButton);

			// --------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Button Close = new javafx.scene.control.Button(" Close ");
			Close.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
			Close.setTextFill(Color.BLACK);

			// --------------------------------------------------------------------------------------------------------------//

			VBox allClick = new VBox(12);
			allClick.getChildren().addAll(add, AddNameAndGender, Delete, AddfrequencieandYear, Update, Search, Max,
					Close);
			allClick.setAlignment(Pos.CENTER);
			root.setCenter(allClick);

			// --------------------------------------------------------------------------------------------------------------//

			AddButton.setOnAction(e -> {
				DirectoryChooser fc = new DirectoryChooser();
				fc.setInitialDirectory(new File("C:\\Users\\Redmi\\Desktop"));
				File file = fc.showDialog(primaryStage);
				File[] files = file.listFiles();
				if (file != null) {
					String row;
					try {
						for (int i = 0; i < files.length; i++) {
							Scanner scanner = new Scanner(files[i]);
							int year = Integer.parseInt(files[i].getName().substring(7, 11));
							while (scanner.hasNextLine()) {
								row = scanner.nextLine();
								String[] data = row.split(",");
								hash.insert(data[0].trim(), data[1].trim(), year, Integer.parseInt(data[2]));
							}
							scanner.close();
						}
						BorderPane done = new BorderPane();
						for (int j = 0; j < hash.table.length; j++) {
							if (hash.table[j] != null) {
								System.out.println(hash.table[j].toString());
								System.out.println();
								System.out.println();
							}
						}

						image(done);

						javafx.scene.control.Label doneLabel = new javafx.scene.control.Label("The Read File Is Done");

						TextArea PrintFile = new TextArea();
						PrintFile.setMaxWidth(300);
						PrintFile.setMaxHeight(250);
						String PathFile = "";
						for (int i = 0; i < files.length; i++) {
							PathFile += "\n" + files[i].getPath();
						}

						PrintFile.setText(PathFile);

						javafx.scene.control.Button closeDone = new javafx.scene.control.Button(" close ");

						doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						doneLabel.setTextFill(Color.WHITE);
						closeDone.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						closeDone.setTextFill(Color.BLACK);

						VBox DoneV = new VBox(15);
						DoneV.getChildren().addAll(doneLabel, PrintFile, closeDone);
						DoneV.setAlignment(Pos.CENTER);
						done.setCenter(DoneV);

						Scene secondScene = new Scene(done, 450, 300);
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

			AddNameAndGenderButton.setOnAction(e -> {

				BorderPane AddNameAndGenderScene = new BorderPane();
				image(AddNameAndGenderScene);

				Label LabelName = new Label("Enter The Name To Add it ");
				TextField TextFieldName = new TextField();

				LabelName.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				LabelName.setTextFill(Color.WHITE);

				HBox SearchBox = new HBox(15);
				SearchBox.getChildren().addAll(LabelName, TextFieldName);

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

				Label SelectionUser = new Label(" if You Want Add Year And Frequencie Click yes");
				Button Yes = new Button("Yes");
				Button No = new Button("No");
				SelectionUser.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				SelectionUser.setTextFill(Color.WHITE);
				Yes.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				Yes.setTextFill(Color.BLACK);
				No.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				No.setTextFill(Color.BLACK);

				HBox SelectFreqAndYear = new HBox(10);
				SelectFreqAndYear.getChildren().addAll(SelectionUser, Yes, No);

				Label Freq = new Label("Frequencie is :  ");
				TextField freqFiled = new TextField();
				Label YearsAdd = new Label(" Year is :  ");
				TextField YearFiled = new TextField();
				Freq.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				Freq.setTextFill(Color.WHITE);
				YearsAdd.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				YearsAdd.setTextFill(Color.WHITE);

				HBox SelectFreqAndYear2 = new HBox(10);
				SelectFreqAndYear2.getChildren().addAll(Freq, freqFiled, YearsAdd, YearFiled);
				SelectFreqAndYear2.setVisible(false);

				HBox gender = new HBox(10);
				gender.getChildren().addAll(male, female);

				HBox Allgender = new HBox(15);
				Allgender.getChildren().addAll(LabelGender, gender);

				Button addNew = new Button("Add");
				Button close = new Button("Close");

				addNew.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				addNew.setTextFill(Color.BLACK);
				close.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				close.setTextFill(Color.BLACK);

				HBox ButtonBox = new HBox(15);
				ButtonBox.getChildren().addAll(addNew, close);

				VBox AddAll = new VBox(15);
				AddAll.getChildren().addAll(SearchBox, Allgender, SelectFreqAndYear, SelectFreqAndYear2, ButtonBox);
				AddAll.setAlignment(Pos.CENTER);
				AddNameAndGenderScene.setCenter(AddAll);

				Yes.setOnAction(e4 -> {
					SelectFreqAndYear2.setVisible(true);
				});

				No.setOnAction(e4 -> {
					SelectFreqAndYear2.setVisible(false);
				});

				Scene secondScene = new Scene(AddNameAndGenderScene, 790, 350);
				Stage newWindow = new Stage();
				newWindow.setTitle("  Done Read Data ");
				newWindow.setScene(secondScene);
				newWindow.show();

				addNew.setOnAction(e2 -> {
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

					if (TextFieldName.getText() == "") {
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

					if (SelectFreqAndYear2.isVisible() && freqFiled.getText() == "" && YearFiled.getText() == "") {
						BorderPane error = new BorderPane();
						image(error);
						Label errorlabel = new Label(" Error : Enter Year And Frequencie");
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
						if (SelectFreqAndYear2.isVisible()) {

							hash.insert(TextFieldName.getText(), "M", Integer.parseInt(YearFiled.getText()),
									Integer.parseInt(freqFiled.getText()));

						} else if (!SelectFreqAndYear2.isVisible()) {
							hash.insert(TextFieldName.getText(), "M");
						}

					} else if (female.isSelected()) {
						if (SelectFreqAndYear2.isVisible()) {

							hash.insert(TextFieldName.getText(), "F", Integer.parseInt(YearFiled.getText()),
									Integer.parseInt(freqFiled.getText()));

						} else if (!SelectFreqAndYear2.isVisible()) {
							hash.insert(TextFieldName.getText(), "F");
						}
					}

					BorderPane done = new BorderPane();
					image(done);

					Label doneLabel = new Label("The Add is Done ");
					Button doneClose = new Button("Close");

					doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
					doneLabel.setTextFill(Color.WHITE);
					doneClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
					doneClose.setTextFill(Color.BLACK);

					VBox doneV = new VBox(25);
					doneV.getChildren().addAll(doneLabel, doneClose);
					doneV.setAlignment(Pos.CENTER);
					done.setCenter(doneV);

					TextFieldName.setText("");
					male.setSelected(false);
					female.setSelected(false);
					freqFiled.setText("");
					YearFiled.setText("");
					SelectFreqAndYear2.setVisible(false);

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

			DeleteButton.setOnAction(e -> {

				BorderPane DeleteScene = new BorderPane();
				image(DeleteScene);

				Label LabelName = new Label("Enter The Name To Delete record :  ");
				TextField TextFieldName = new TextField();

				LabelName.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				LabelName.setTextFill(Color.WHITE);

				HBox NameBox = new HBox(15);
				NameBox.getChildren().addAll(LabelName, TextFieldName);

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

				Button DeleteNow = new Button("Delete");
				Button close = new Button("Close");

				DeleteNow.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				DeleteNow.setTextFill(Color.BLACK);
				close.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				close.setTextFill(Color.BLACK);

				HBox ButtonBox = new HBox(15);
				ButtonBox.getChildren().addAll(DeleteNow, close);

				VBox DeleteAll = new VBox(15);
				DeleteAll.getChildren().addAll(NameBox, Allgender, ButtonBox);
				DeleteAll.setAlignment(Pos.CENTER);
				DeleteScene.setCenter(DeleteAll);

				Scene secondScene = new Scene(DeleteScene, 550, 170);
				Stage newWindow = new Stage();
				newWindow.setTitle("  ");
				newWindow.setScene(secondScene);
				newWindow.show();

				DeleteNow.setOnAction(e2 -> {
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
						newWindow2.setTitle("  Delete Data ");
						newWindow2.setScene(newScene);
						newWindow2.show();
						errorClose.setOnAction(e4 -> {
							newWindow2.close();
						});
						return;

					}

					if (TextFieldName.getText() == "") {
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
						newWindow2.setTitle(" Delete Data ");
						newWindow2.setScene(newScene);
						newWindow2.show();

						errorClose.setOnAction(e4 -> {
							newWindow2.close();
						});
						return;
					}

					boolean result = false;

					if (male.isSelected()) {
						result = hash.remove(TextFieldName.getText(), "M");

					} else if (female.isSelected()) {
						result = hash.remove(TextFieldName.getText(), "F");
					}
					if (result == true) {

						BorderPane done = new BorderPane();
						image(done);

						Label doneLabel = new Label("The Delete is Done ");

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

					} else if (result == false) {
						BorderPane error = new BorderPane();
						image(error);
						Label errorlabel = new Label("Error : Name OR Gender Wrong");
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
						newWindow2.setTitle("  Delete Data ");
						newWindow2.setScene(newScene);
						newWindow2.show();
						errorClose.setOnAction(e4 -> {
							newWindow2.close();
						});
						return;
					}
				});

				close.setOnAction(e1 -> {
					newWindow.close();
				});
			});

			// --------------------------------------------------------------------------------------------------------------//

			AddfrequencieandYearButton.setOnAction(e -> {

				BorderPane AddfrequencieandYearScene = new BorderPane();
				image(AddfrequencieandYearScene);

				Label LabelName = new Label("Enter The Name : ");
				TextField TextFieldName = new TextField();

				LabelName.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				LabelName.setTextFill(Color.WHITE);

				HBox SearchBox = new HBox(15);
				SearchBox.getChildren().addAll(LabelName, TextFieldName);

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

				Label Freq = new Label(" Frequencie is :  ");
				TextField freqFiled = new TextField();
				Label YearsAdd = new Label(" Year is :  ");
				TextField YearFiled = new TextField();
				Freq.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				Freq.setTextFill(Color.WHITE);
				YearsAdd.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				YearsAdd.setTextFill(Color.WHITE);

				HBox SelectFreqAndYear2 = new HBox(10);
				SelectFreqAndYear2.getChildren().addAll(Freq, freqFiled, YearsAdd, YearFiled);

				HBox gender = new HBox(10);
				gender.getChildren().addAll(male, female);

				HBox Allgender = new HBox(15);
				Allgender.getChildren().addAll(LabelGender, gender);

				Button addNew = new Button("Add");
				Button close = new Button("Close");

				addNew.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				addNew.setTextFill(Color.BLACK);
				close.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				close.setTextFill(Color.BLACK);

				HBox ButtonBox = new HBox(15);
				ButtonBox.getChildren().addAll(addNew, close);

				VBox AddAll = new VBox(15);
				AddAll.getChildren().addAll(SearchBox, Allgender, SelectFreqAndYear2, ButtonBox);
				AddAll.setAlignment(Pos.CENTER);
				AddfrequencieandYearScene.setCenter(AddAll);

				Scene secondScene = new Scene(AddfrequencieandYearScene, 790, 350);
				Stage newWindow = new Stage();
				newWindow.setTitle("  Done Read Data ");
				newWindow.setScene(secondScene);
				newWindow.show();

				addNew.setOnAction(e2 -> {
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

					if (TextFieldName.getText() == "") {
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

					if (freqFiled.getText() == "" || YearFiled.getText() == "") {
						BorderPane error = new BorderPane();
						image(error);
						Label errorlabel = new Label(" Error : Enter Year And Frequencie");
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
						String newString = hash.find(TextFieldName.getText(), "M");
						if (newString == null) {
							BorderPane error = new BorderPane();
							image(error);
							Label errorlabel = new Label(" Error : Name OR Gender Wrong");
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
						} else {
							hash.insert(TextFieldName.getText(), "M", Integer.parseInt(YearFiled.getText()),
									Integer.parseInt(freqFiled.getText()));
						}
					} else if (female.isSelected()) {

						String newString = hash.find(TextFieldName.getText(), "F");
						if (newString == null) {
							BorderPane error = new BorderPane();
							image(error);
							Label errorlabel = new Label(" Error : Name OR Gender Wrong");
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
						} else {
							hash.insert(TextFieldName.getText(), "F", Integer.parseInt(YearFiled.getText()),
									Integer.parseInt(freqFiled.getText()));
						}
					}

					BorderPane done = new BorderPane();
					image(done);

					Label doneLabel = new Label("The Add is Done ");
					Button doneClose = new Button("Close");

					doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
					doneLabel.setTextFill(Color.WHITE);
					doneClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
					doneClose.setTextFill(Color.BLACK);

					VBox doneV = new VBox(25);
					doneV.getChildren().addAll(doneLabel, doneClose);
					doneV.setAlignment(Pos.CENTER);
					done.setCenter(doneV);

					TextFieldName.setText("");
					male.setSelected(false);
					female.setSelected(false);
					freqFiled.setText("");
					YearFiled.setText("");

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

			UpdateButton.setOnAction(e -> {
				BorderPane UpdateScene = new BorderPane();
				image(UpdateScene);

				Label LabelName = new Label("Enter The Name : ");
				TextField TextFieldName = new TextField();

				LabelName.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				LabelName.setTextFill(Color.WHITE);

				HBox SearchBox = new HBox(15);
				SearchBox.getChildren().addAll(LabelName, TextFieldName);

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

				Label Freq = new Label(" Frequencie is :  ");
				TextField freqFiled = new TextField();
				Label YearsAdd = new Label(" Year is :  ");
				TextField YearFiled = new TextField();
				Freq.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				Freq.setTextFill(Color.WHITE);
				YearsAdd.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				YearsAdd.setTextFill(Color.WHITE);

				HBox SelectFreqAndYear2 = new HBox(10);
				SelectFreqAndYear2.getChildren().addAll(Freq, freqFiled, YearsAdd, YearFiled);

				HBox gender = new HBox(10);
				gender.getChildren().addAll(male, female);

				HBox Allgender = new HBox(15);
				Allgender.getChildren().addAll(LabelGender, gender);

				Button addNew = new Button("Update");
				Button close = new Button("Close");

				addNew.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				addNew.setTextFill(Color.BLACK);
				close.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				close.setTextFill(Color.BLACK);

				HBox ButtonBox = new HBox(15);
				ButtonBox.getChildren().addAll(addNew, close);

				VBox AddAll = new VBox(15);
				AddAll.getChildren().addAll(SearchBox, Allgender, SelectFreqAndYear2, ButtonBox);
				AddAll.setAlignment(Pos.CENTER);
				UpdateScene.setCenter(AddAll);

				Scene secondScene = new Scene(UpdateScene, 790, 350);
				Stage newWindow = new Stage();
				newWindow.setTitle("  Done Read Data ");
				newWindow.setScene(secondScene);
				newWindow.show();

				addNew.setOnAction(e2 -> {
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

					if (TextFieldName.getText() == "") {
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

					if (freqFiled.getText() == "" || YearFiled.getText() == "") {
						BorderPane error = new BorderPane();
						image(error);
						Label errorlabel = new Label(" Error : Enter Year And Frequencie");
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
						String find = hash.find(TextFieldName.getText(), "M");

						if (find == null) {
							BorderPane error = new BorderPane();
							image(error);
							Label errorlabel = new Label(" Error : Name OR Gender Wrong");
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
						} else if (find != null) {
							int n = hash.currentIndex(TextFieldName.getText(), "M");
							HeapNode f = new HeapNode(Integer.parseInt(YearFiled.getText()),
									Integer.parseInt(freqFiled.getText()));
							boolean exit = hash.table[n].h.founded(f);
							if (exit == true) {
								hash.table[n].h.replace(Integer.parseInt(YearFiled.getText()),
										Integer.parseInt(freqFiled.getText()));

							} else {
								BorderPane error = new BorderPane();
								image(error);
								Label errorlabel = new Label(" Error To Update");
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
						}
					} else if (female.isSelected()) {

						String find = hash.find(TextFieldName.getText(), "F");

						if (find == null) {
							BorderPane error = new BorderPane();
							image(error);
							Label errorlabel = new Label(" Error : Name OR Gender Wrong");
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
						} else if (find != null) {
							int n = hash.currentIndex(TextFieldName.getText(), "F");
							HeapNode f = new HeapNode(Integer.parseInt(YearFiled.getText()),
									Integer.parseInt(freqFiled.getText()));
							boolean exit = hash.table[n].h.founded(f);
							if (exit == true) {
								hash.table[n].h.replace(Integer.parseInt(YearFiled.getText()),
										Integer.parseInt(freqFiled.getText()));

							} else {
								BorderPane error = new BorderPane();
								image(error);
								Label errorlabel = new Label(" Error To Update");
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
						}
					}

					BorderPane done = new BorderPane();
					image(done);

					Label doneLabel = new Label("The Update is Done ");
					Button doneClose = new Button("Close");

					doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
					doneLabel.setTextFill(Color.WHITE);
					doneClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
					doneClose.setTextFill(Color.BLACK);

					VBox doneV = new VBox(25);
					doneV.getChildren().addAll(doneLabel, doneClose);
					doneV.setAlignment(Pos.CENTER);
					done.setCenter(doneV);

					TextFieldName.setText("");
					male.setSelected(false);
					female.setSelected(false);
					freqFiled.setText("");
					YearFiled.setText("");

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

			SearchButton.setOnAction(e -> {
				BorderPane SearchScene = new BorderPane();
				image(SearchScene);

				Label LabelName = new Label("Enter The Name To Delete record :  ");
				TextField TextFieldName = new TextField();

				LabelName.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				LabelName.setTextFill(Color.WHITE);

				HBox NameBox = new HBox(15);
				NameBox.getChildren().addAll(LabelName, TextFieldName);

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

				Button SearchNow = new Button(" Search ");
				Button close = new Button("Close");

				SearchNow.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				SearchNow.setTextFill(Color.BLACK);
				close.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
				close.setTextFill(Color.BLACK);

				HBox ButtonBox = new HBox(15);
				ButtonBox.getChildren().addAll(SearchNow, close);

				VBox DeleteAll = new VBox(15);
				DeleteAll.getChildren().addAll(NameBox, Allgender, ButtonBox);
				DeleteAll.setAlignment(Pos.CENTER);
				SearchScene.setCenter(DeleteAll);

				Scene secondScene = new Scene(SearchScene, 550, 170);
				Stage newWindow = new Stage();
				newWindow.setTitle("  ");
				newWindow.setScene(secondScene);
				newWindow.show();

				SearchNow.setOnAction(e2 -> {
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
						newWindow2.setTitle("  Delete Data ");
						newWindow2.setScene(newScene);
						newWindow2.show();
						errorClose.setOnAction(e4 -> {
							newWindow2.close();
						});
						return;

					}

					if (TextFieldName.getText() == "") {
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
						newWindow2.setTitle(" Delete Data ");
						newWindow2.setScene(newScene);
						newWindow2.show();

						errorClose.setOnAction(e4 -> {
							newWindow2.close();
						});
						return;
					}

					String result = null;

					if (male.isSelected()) {

						result = hash.find(TextFieldName.getText(), "M");

					} else if (female.isSelected()) {

						result = hash.find(TextFieldName.getText(), "F");
					}
					if (result != null) {

						BorderPane done = new BorderPane();
						image(done);

						Label doneLabel = new Label(result);

						Button doneClose = new Button("Close");

						doneLabel.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						doneLabel.setTextFill(Color.WHITE);
						doneClose.setFont(Font.font("Bahnschrift SemiBold", FontWeight.BOLD, 17));
						doneClose.setTextFill(Color.BLACK);

						VBox doneV = new VBox(25);
						doneV.getChildren().addAll(doneLabel, doneClose);
						doneV.setAlignment(Pos.CENTER);
						done.setCenter(doneV);

						Scene newScene = new Scene(done, 800, 600);
						Stage newWindow2 = new Stage();
						newWindow2.setTitle(" ");
						newWindow2.setScene(newScene);
						newWindow2.show();

						TextFieldName.setText("");
						male.setSelected(false);
						female.setSelected(false);

						doneClose.setOnAction(e1 -> {
							newWindow2.close();
						});

					} else if (result == null) {
						BorderPane error = new BorderPane();
						image(error);
						Label errorlabel = new Label("Error : Name OR Gender Wrong");
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
						newWindow2.setTitle("  Search Data ");
						newWindow2.setScene(newScene);
						newWindow2.show();
						errorClose.setOnAction(e4 -> {
							newWindow2.close();
						});
						return;
					}
				});

				close.setOnAction(e1 -> {
					newWindow.close();
				});
			});

			// --------------------------------------------------------------------------------------------------------------//

			MaxButton.setOnAction(e -> {
				BorderPane done = new BorderPane();
				image(done);
				String info = hash.maxName();
				if (info == null) {

					BorderPane error = new BorderPane();
					image(error);
					Label errorlabel = new Label("Error To find Max");
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
					newWindow2.setTitle("  Delete Data ");
					newWindow2.setScene(newScene);
					newWindow2.show();
					errorClose.setOnAction(e4 -> {
						newWindow2.close();
					});
					return;
				}
				Label doneLabel = new Label(info);

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

			Scene scene = new Scene(root, 700, 400);
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
