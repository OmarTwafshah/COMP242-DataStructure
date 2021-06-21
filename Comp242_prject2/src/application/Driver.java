package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Driver extends Application {
	queueClass quClass = new queueClass();
	stackClass stClass = new stackClass();

	@Override
	public void start(Stage primaryStage) {

		BorderPane root = new BorderPane();

		// --------------------------------------------------------------------------------------------------------------//

		javafx.scene.control.Label selction = new javafx.scene.control.Label("Please select of this ");
		RadioButton queue = new RadioButton("Sell Old Shares First");
		RadioButton stack = new RadioButton("Sell New Shares First");
		ToggleGroup firstSelction = new ToggleGroup();
		stack.setSelected(true);
		stack.setToggleGroup(firstSelction);
		queue.setToggleGroup(firstSelction);

		// -----------------------------------------------------------------------------------------------------------------//

		VBox allTop = new VBox(15);
		allTop.getChildren().addAll(selction, queue, stack);
		allTop.setAlignment(Pos.TOP_CENTER);
		root.setTop(allTop);

		// -----------------------------------------------------------------------------------------------------------------//

		javafx.scene.control.Label Buy = new javafx.scene.control.Label(
				"if you want to Buy Shares cleck this Button :  ");
		javafx.scene.control.Button BuyNow = new javafx.scene.control.Button("   Buy Now   ");
		HBox BuySelction = new HBox(15);
		BuySelction.getChildren().addAll(Buy, BuyNow);

		// -----------------------------------------------------------------------------------------------------------------//

		javafx.scene.control.Label Sell = new javafx.scene.control.Label(
				"if you want to Sell Shares cleck this Button :  ");
		javafx.scene.control.Button SellNow = new javafx.scene.control.Button("   Sell Now   ");
		HBox SellSelction = new HBox(15);
		SellSelction.getChildren().addAll(Sell, SellNow);

		// -----------------------------------------------------------------------------------------------------------------//

		javafx.scene.control.Label printTotal = new javafx.scene.control.Label(
				"if you want to Print Total gain and lost  cleck this Button :  ");
		javafx.scene.control.Button PrintTotalButton = new javafx.scene.control.Button("   Print it   ");
		HBox Print = new HBox(15);
		Print.getChildren().addAll(printTotal, PrintTotalButton);

		// -----------------------------------------------------------------------------------------------------------------//

		VBox AllOperation = new VBox(15);
		AllOperation.getChildren().addAll(BuySelction, SellSelction, Print);
		AllOperation.setAlignment(Pos.CENTER_LEFT);
		root.setLeft(AllOperation);

		// -----------------------------------------------------------------------------------------------------------------//

		javafx.scene.control.Button close = new javafx.scene.control.Button(" Close ");
		javafx.scene.control.Button save = new javafx.scene.control.Button(" Save ");
		HBox AllBotton = new HBox(15);
		AllBotton.getChildren().addAll(close, save);
		AllBotton.setAlignment(Pos.BOTTOM_CENTER);
		root.setBottom(AllBotton);

		// -----------------------------------------------------------------------------------------------------------------//

		quClass.readData();
		stClass.readData();
		BuyNow.setOnAction(e -> {

			javafx.scene.control.Label NumberShares = new javafx.scene.control.Label(
					"         Enter Number Of Shares : ");
			javafx.scene.control.TextField FieldNumberShares = new javafx.scene.control.TextField();
			HBox HNumberShares = new HBox(15);
			HNumberShares.getChildren().addAll(NumberShares, FieldNumberShares);

			// -----------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label NameShares = new javafx.scene.control.Label("         Enter Name Of Shares : ");
			javafx.scene.control.TextField FieldNameShares = new javafx.scene.control.TextField();
			HBox HNameShares = new HBox(15);
			HNameShares.getChildren().addAll(NameShares, FieldNameShares);

			// -----------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Button BuyButton = new javafx.scene.control.Button(" Buy ");
			javafx.scene.control.Button closeButton = new javafx.scene.control.Button(" close ");
			javafx.scene.control.Button agianBuy = new javafx.scene.control.Button(" Agian Buy ");
			HBox AllButton = new HBox(15);
			AllButton.getChildren().addAll(BuyButton, closeButton, agianBuy);

			// -----------------------------------------------------------------------------------------------------------------//

			VBox AllBuy = new VBox(20);
			AllBuy.getChildren().addAll(HNumberShares, HNameShares, AllButton);

			// -----------------------------------------------------------------------------------------------------------------//

			Scene secondScene = new Scene(AllBuy, 500, 150);
			Stage newWindow = new Stage();
			newWindow.setTitle("  Buy: ");
			newWindow.setScene(secondScene);
			newWindow.show();

			// -----------------------------------------------------------------------------------------------------------------//

			closeButton.setOnAction(e1 -> {
				newWindow.close();
			});

			// -----------------------------------------------------------------------------------------------------------------//

			agianBuy.setOnAction(e2 -> {
				FieldNumberShares.clear();
				FieldNameShares.clear();
			});

			// -----------------------------------------------------------------------------------------------------------------//

			BuyButton.setOnAction(e3 -> {
				boolean result = false;

				if (FieldNumberShares.getText().isEmpty() || FieldNameShares.getText().isEmpty()
						|| !isStringInt(FieldNumberShares.getText())) {
					BorderPane error = new BorderPane();
					javafx.scene.control.Label errorlabel = new javafx.scene.control.Label(
							"The Text Filed is Empty Please Try again ");
					javafx.scene.control.Button errorButton = new javafx.scene.control.Button(" Close ");
					VBox verror = new VBox(60);
					verror.getChildren().addAll(errorlabel, errorButton);
					verror.setAlignment(Pos.CENTER);
					error.setCenter(verror);
					Scene errorScene = new Scene(error, 500, 210);
					Stage errorStage = new Stage();
					errorStage.setTitle("  Error: ");
					errorStage.setScene(errorScene);
					errorStage.show();
					errorButton.setOnAction(e4 -> {
						errorStage.close();
					});
				} else {
					if (queue.isSelected()) {
						result = quClass.Buyshares(Integer.parseInt(FieldNumberShares.getText()),
								FieldNameShares.getText());
					} else if (stack.isSelected()) {
						result = stClass.Buyshares(Integer.parseInt(FieldNumberShares.getText()),
								FieldNameShares.getText());
					}
					if (result == true) {
						BorderPane done = new BorderPane();
						javafx.scene.control.Label Donelabel = new javafx.scene.control.Label("The buy is Done  ");
						javafx.scene.control.Button doneClose = new javafx.scene.control.Button(" Close ");
						VBox verror = new VBox(60);
						verror.getChildren().addAll(Donelabel, doneClose);
						verror.setAlignment(Pos.CENTER);
						done.setCenter(verror);
						Scene doneScene = new Scene(done, 500, 210);
						Stage DoneStage = new Stage();
						DoneStage.setTitle("  Done buy : ");
						DoneStage.setScene(doneScene);
						DoneStage.show();
						doneClose.setOnAction(e4 -> {
							DoneStage.close();
						});
					} else {
						BorderPane done = new BorderPane();
						javafx.scene.control.Label Wronglabel = new javafx.scene.control.Label(
								"Wrong The name is Not found ");
						javafx.scene.control.Button wrongClose = new javafx.scene.control.Button(" Close ");
						VBox verror = new VBox(60);
						verror.getChildren().addAll(Wronglabel, wrongClose);
						verror.setAlignment(Pos.CENTER);
						done.setCenter(verror);
						Scene doneScene = new Scene(done, 500, 210);
						Stage DoneStage = new Stage();
						DoneStage.setTitle("  Done buy : ");
						DoneStage.setScene(doneScene);
						DoneStage.show();
						wrongClose.setOnAction(e4 -> {
							DoneStage.close();
						});
					}
				}

			});
		});

		// -----------------------------------------------------------------------------------------------------------------//

		SellNow.setOnAction(e -> {

			// -----------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label NumberShares = new javafx.scene.control.Label("Enter Number Of Shares : ");
			javafx.scene.control.TextField FieldNumberShares = new javafx.scene.control.TextField();
			HBox HNumberShares = new HBox(15);
			HNumberShares.getChildren().addAll(NumberShares, FieldNumberShares);

			// -----------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Label NameShares = new javafx.scene.control.Label(
					"Enter Name Of Shares (Just x Or y Or z) : ");
			javafx.scene.control.TextField FieldNameShares = new javafx.scene.control.TextField();
			HBox HNameShares = new HBox(15);
			HNameShares.getChildren().addAll(NameShares, FieldNameShares);

			// -----------------------------------------------------------------------------------------------------------------//

			javafx.scene.control.Button sellButton = new javafx.scene.control.Button(" Sell ");
			javafx.scene.control.Button closeButton = new javafx.scene.control.Button(" close ");
			javafx.scene.control.Button agianSell = new javafx.scene.control.Button(" Agian Sell ");
			HBox AllButton = new HBox(15);
			AllButton.getChildren().addAll(sellButton, closeButton, agianSell);

			// -----------------------------------------------------------------------------------------------------------------//

			VBox AllBuy = new VBox(20);
			AllBuy.getChildren().addAll(HNumberShares, HNameShares, AllButton);

			// -----------------------------------------------------------------------------------------------------------------//

			Scene secondScene = new Scene(AllBuy, 500, 150);
			Stage newWindow = new Stage();
			newWindow.setTitle(" Sell : ");
			newWindow.setScene(secondScene);
			newWindow.show();

			// -----------------------------------------------------------------------------------------------------------------//

			closeButton.setOnAction(e1 -> {
				newWindow.close();
			});

			// -----------------------------------------------------------------------------------------------------------------//

			agianSell.setOnAction(e2 -> {
				FieldNumberShares.clear();
				FieldNameShares.clear();
			});

			// -----------------------------------------------------------------------------------------------------------------//

			sellButton.setOnAction(e3 -> {
				double Result = 0;

				if ((FieldNumberShares.getText().isEmpty() || FieldNameShares.getText().isEmpty())
						|| !isStringInt(FieldNumberShares.getText())) {
					BorderPane error = new BorderPane();
					javafx.scene.control.Label errorlabel = new javafx.scene.control.Label(
							"The Text Filed is Error Please Try again ");
					javafx.scene.control.Button errorButton = new javafx.scene.control.Button(" Close ");
					VBox verror = new VBox(60);
					verror.getChildren().addAll(errorlabel, errorButton);
					verror.setAlignment(Pos.CENTER);
					error.setCenter(verror);
					Scene errorScene = new Scene(error, 500, 210);
					Stage errorStage = new Stage();
					errorStage.setTitle("  Error: ");
					errorStage.setScene(errorScene);
					errorStage.show();
					errorButton.setOnAction(e4 -> {
						errorStage.close();
					});
				} else {
					if (queue.isSelected()) {
						Result = quClass.sellShares(Integer.parseInt(FieldNumberShares.getText()),
								FieldNameShares.getText());
					} else if (stack.isSelected()) {
						Result = stClass.sellShares(Integer.parseInt(FieldNumberShares.getText()),
								FieldNameShares.getText());
					}

					BorderPane error = new BorderPane();
					javafx.scene.control.Label doneLabel = new javafx.scene.control.Label("The Sell Is Done ");
					javafx.scene.control.Label errorlabel = new javafx.scene.control.Label(
							"The Lost money is " + Result);
					javafx.scene.control.Button errorButton = new javafx.scene.control.Button(" Close ");
					VBox verror = new VBox(60);
					verror.getChildren().addAll(doneLabel, errorlabel, errorButton);
					verror.setAlignment(Pos.CENTER);
					error.setCenter(verror);
					Scene errorScene = new Scene(error, 500, 210);
					Stage errorStage = new Stage();
					errorStage.setTitle("  Final Result  ");
					errorStage.setScene(errorScene);
					errorStage.show();
					errorButton.setOnAction(e4 -> {
						errorStage.close();
					});
				}
			});
		});

		PrintTotalButton.setOnAction(e -> {
			if (queue.isSelected()) {
				BorderPane totalRe = new BorderPane();
				javafx.scene.control.Button totalbut = new javafx.scene.control.Button(" Close ");
				javafx.scene.control.Label total = new javafx.scene.control.Label(
						" The Total gian and lost is " + quClass.totalgainLost());
				VBox verror = new VBox(60);
				verror.getChildren().addAll(total, totalbut);
				verror.setAlignment(Pos.CENTER);
				totalRe.setCenter(verror);
				Scene errorScene = new Scene(totalRe, 500, 210);
				Stage errorStage = new Stage();
				errorStage.setTitle("  Final Result  ");
				errorStage.setScene(errorScene);
				errorStage.show();
				totalbut.setOnAction(e4 -> {
					errorStage.close();
				});
			} else if (stack.isSelected()) {
				BorderPane totalRe = new BorderPane();
				javafx.scene.control.Button totalbut = new javafx.scene.control.Button(" Close ");
				javafx.scene.control.Label total = new javafx.scene.control.Label(
						" The Total gian and lost is " + stClass.totalgainLost());
				VBox verror = new VBox(60);
				verror.getChildren().addAll(total, totalbut);
				verror.setAlignment(Pos.CENTER);
				totalRe.setCenter(verror);
				Scene errorScene = new Scene(totalRe, 500, 210);
				Stage errorStage = new Stage();
				errorStage.setTitle("  Final Result  ");
				errorStage.setScene(errorScene);
				errorStage.show();
				totalbut.setOnAction(e4 -> {
					errorStage.close();
				});
			}

		});
		// -----------------------------------------------------------------------------------------------------------------//

		close.setOnAction(e -> {
			primaryStage.close();
		});

		// -----------------------------------------------------------------------------------------------------------------//

		save.setOnAction(e -> {
			File file = new File("shares.txt");

			if (queue.isSelected()) {
				String conFile = "";
				while (quClass.front != null) {
					Node temp = quClass.deQueue();
					conFile += temp.toString();
				}
				writeFile(file, conFile);
			} else if (stack.isSelected()) {
				String conFile = "";
				while (stClass.header != null) {
					Node temp = stClass.pop();
					stClass.push(temp);
				}
				while (stClass.newHeader != null) {
					Node temp = stClass.pop(0);
					conFile += temp.toString();
				}
				writeFile(file, conFile);
			}

			BorderPane finalre = new BorderPane();
			javafx.scene.control.Button finalbutton = new javafx.scene.control.Button(" Close ");
			javafx.scene.control.Label finallabel = new javafx.scene.control.Label(
					" The List Save In File Thank And is Empty Now  ");
			VBox verror = new VBox(60);
			verror.getChildren().addAll(finallabel, finalbutton);
			verror.setAlignment(Pos.CENTER);
			finalre.setCenter(verror);
			Scene finalScene = new Scene(finalre, 500, 210);
			Stage finalStage = new Stage();
			finalStage.setTitle("  Final Result  ");
			finalStage.setScene(finalScene);
			finalStage.show();
			finalbutton.setOnAction(e4 -> {
				finalStage.close();
			});
		});

		// -----------------------------------------------------------------------------------------------------------------//

		Scene scene = new Scene(root, 500, 400);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	// -----------------------------------------------------------------------------------------------------------------//

	public static void main(String[] args) {
		launch(args);
	}

	// -----------------------------------------------------------------------------------------------------------------//

	public boolean isStringInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	// -----------------------------------------------------------------------------------------------------------------//

	public void writeFile(File file, String contentFile) {

		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(file);

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		PrintWriter pw = new PrintWriter(fos);
		pw.write(contentFile);
		pw.close();

		try {
			fos.close();

		} catch (IOException e2) {
			e2.printStackTrace();

		}
	}

}
