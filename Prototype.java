import javafx.application.Application;			//import necessary javafx utilities
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Prototype extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}
	
	Scene scene1, scene2, scene3, scene4, scene5;
	
	
	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("SunDevil Pizza");
		
		TextArea results = new TextArea();
		
		//Scene 1
		Label scene1Label = new Label("Which SunDevil Pizza would you like to order?");
		scene1Label.setWrapText(true);
		scene1Label.setMinWidth(50);
		scene1Label.setMinHeight(50);
		scene1Label.setFont(new Font("Ariel", 24));
		Button scene1CheeseButton = new Button("Cheese");		
		Button scene1PepButton = new Button("Pepperoni");
		Button scene1VegButton = new Button("Vegetable");
		scene1CheeseButton.setOnAction(e -> {
			results.appendText("Cheese Pizza $...\n");
			primaryStage.setScene(scene2);
		});
		scene1PepButton.setOnAction(e -> {
			results.appendText("Pepperoni Pizza $...\n");
			primaryStage.setScene(scene2);
		});
		scene1VegButton.setOnAction(e -> {
			results.appendText("Vegetable Pizza $...\n");
			primaryStage.setScene(scene2);
		});
		
		VBox layout1 = new VBox(20);
		HBox layout1h = new HBox(20);
		layout1.setPadding(new Insets(15));						// Centered text on scene 1 and made it look nicer overall
		layout1.getChildren().addAll(scene1Label);
		scene1CheeseButton.setPrefSize(200, 200);
		scene1PepButton.setPrefSize(200, 200);
		scene1VegButton.setPrefSize(200, 200);
		layout1h.getChildren().addAll(scene1CheeseButton, scene1PepButton, scene1VegButton); 
		layout1.setAlignment(Pos.TOP_CENTER);
		layout1.setPadding(new Insets(50,0,0,0));
		layout1h.setAlignment(Pos.CENTER);
		layout1.getChildren().addAll(layout1h);
		scene1 = new Scene(layout1, 700, 450);
		
		//Scene 2
		Label scene2Label = new Label("Which topping(s) would you like to add?");
		scene2Label.setWrapText(true);
		scene2Label.setMinWidth(50);
		scene2Label.setMinHeight(50);
		scene2Label.setFont(new Font("Ariel", 24));
		CheckBox topping1 = new CheckBox("Mushroom");
		CheckBox topping2 = new CheckBox("Onions");
		CheckBox topping3 = new CheckBox("Olives");
		CheckBox topping4 = new CheckBox("Extra Cheese");
		Button nextButton2 = new Button("Next >");
		nextButton2.setOnAction(e -> {
			if(topping1.isSelected()) {
				results.appendText("\t+ Mushrooms $...\n");
			}
			if(topping2.isSelected()) {
				results.appendText("\t+ Onions $...\n");
			}
			if(topping3.isSelected()) {
				results.appendText("\t+ Olives $...\n");
			}
			if(topping4.isSelected()) {
				results.appendText("\t+ Extra Cheese $...\n");
			}
			
			results.appendText("\nTax: $...\n\n\nTotal: $...");
			primaryStage.setScene(scene3);
		});
		
		VBox layout2 = new VBox(20);
		HBox layout2h = new HBox(20);
		layout2.setPadding(new Insets(15));						// Scene 2 text centered, check boxes centered, next button in bottom left
		layout2.getChildren().addAll(scene2Label);				// made it look overall more professional
		topping1.setPrefSize(100, 100);
		topping2.setPrefSize(100, 100);
		topping3.setPrefSize(100, 100);
		topping4.setPrefSize(100, 100);
		layout2h.setAlignment(Pos.CENTER);
		
		layout2h.getChildren().addAll(topping1, topping2, topping3, topping4);
		layout2.setAlignment(Pos.TOP_CENTER);
		layout2.setPadding(new Insets(50,0,0,0));
		VBox nb2Box = new VBox(20);
		nb2Box.setAlignment(Pos.BOTTOM_RIGHT);
		nextButton2.setPadding(new Insets(15));
		nb2Box.setPadding(new Insets(125,50,0,0));
		nb2Box.getChildren().addAll(nextButton2);
		layout2.getChildren().addAll(layout2h, nb2Box);

		scene2 = new Scene(layout2, 700, 450);
		
		//Scene 3
		Label scene3Label = new Label("What time would you like to pick up your order?");
		scene3Label.setWrapText(true);
		scene3Label.setMinWidth(50);
		scene3Label.setMinHeight(50);
		scene3Label.setFont(new Font("Ariel", 24));
		TextField time = new TextField("Enter time here");
		Button nextButton3 = new Button("Next >");
		nextButton3.setOnAction(e -> primaryStage.setScene(scene4));
		
		VBox layout3 = new VBox(20);						// Similar formatting changes to first 2 layouts
		layout3.getChildren().addAll(scene3Label, time, nextButton3);
		layout3.setAlignment(Pos.TOP_CENTER);
		scene3 = new Scene(layout3, 700, 450);
		
		//Scene 4
		Label scene4LabelTitle = new Label("Check out");
		scene4LabelTitle.setMinWidth(50);
		scene4LabelTitle.setMinHeight(50);
		scene4LabelTitle.setFont(new Font("Ariel", 24));
		//Results Text Area
		results.setEditable(false);
		Label scene4Request = new Label("Enter your ASURITE ID");
		TextField asurite = new TextField();
		Button nextButton4 = new Button("Next >");
		nextButton4.setOnAction(e -> primaryStage.setScene(scene5));
		
		VBox layout4 = new VBox(20);
		layout4.getChildren().addAll(scene4LabelTitle, results, scene4Request, asurite, nextButton4);
		scene4 = new Scene(layout4, 700, 450);
		
		//Scene 5
		Label scene5LabelTitle = new Label("Your order has been recieved and a confirmation email has been sent to [ASURITEID]@asu.edu");
		scene5LabelTitle.setWrapText(true);
		scene5LabelTitle.setMinWidth(50);
		scene5LabelTitle.setMinHeight(50);
		scene5LabelTitle.setFont(new Font("Ariel", 24));
		Label scene5Label2 = new Label("Order Status: ");
		Label orderStatus = new Label("READY");
		orderStatus.setMinWidth(30);
		orderStatus.setMinHeight(30);
		orderStatus.setFont(new Font("Ariel", 20));
		
		VBox layout5 = new VBox(20);
		layout5.getChildren().addAll(scene5LabelTitle, scene5Label2, orderStatus);
		scene5 = new Scene(layout5, 700, 450);
		
		primaryStage.setScene(scene1);
		primaryStage.show();
	}
	
}
