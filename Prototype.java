import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
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
		
		//Scene 1
		Label scene1Label = new Label("Which SunDevil Pizza would you like to order?");
		scene1Label.setWrapText(true);
		scene1Label.setMinWidth(50);
		scene1Label.setMinHeight(50);
		scene1Label.setFont(new Font("Ariel", 24));
		Button scene1CheeseButton = new Button("Cheese");
		Button scene1PepButton = new Button("Pepperoni");
		Button scene1VegButton = new Button("Vegetable");
		scene1CheeseButton.setOnAction(e -> primaryStage.setScene(scene2));
		scene1PepButton.setOnAction(e -> primaryStage.setScene(scene2));
		scene1VegButton.setOnAction(e -> primaryStage.setScene(scene2));
		
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(scene1Label, scene1CheeseButton, scene1PepButton, scene1VegButton);
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
		nextButton2.setOnAction(e -> primaryStage.setScene(scene3));
		
		VBox layout2 = new VBox(20);
		layout2.getChildren().addAll(scene2Label, topping1, topping2, topping3, topping4, nextButton2);
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
		
		VBox layout3 = new VBox(20);
		layout3.getChildren().addAll(scene3Label, time, nextButton3);
		scene3 = new Scene(layout3, 700, 450);
		
		//Scene 4
		Label scene4LabelTitle = new Label("Check out");
		scene4LabelTitle.setMinWidth(50);
		scene4LabelTitle.setMinHeight(50);
		scene4LabelTitle.setFont(new Font("Ariel", 24));
		TextArea results = new TextArea("ORDER INFORMATION GOES HERE");
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
