package application;
	
import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application {
	Label lb1, lb2, lb3;
	TextField tf1, tf2, tf3;
	
	@Override
	public void start(Stage primaryStage) {
		GridPane pane = new GridPane();
		
		lb1 = new Label("Dollar: ");
		tf1 = new TextField();
		dollarConversion dConv = new dollarConversion();
		tf1.setOnAction(dConv);
		
		lb2 = new Label("Euro: ");
		tf2 = new TextField();
		euroConversion euConv = new euroConversion();
		tf2.setOnAction(euConv);
		
		lb3 = new Label("Yuan: ");
		tf3 = new TextField();
		yuanConversion yuConv = new yuanConversion();
		tf3.setOnAction(yuConv);
		
		pane.setAlignment(Pos.CENTER);
		pane.setHgap(30);
		pane.setVgap(20);
		
		pane.add(lb1, 0, 0);
		pane.add(tf1, 1, 0);
		pane.add(lb2, 0, 1);
		pane.add(tf2, 1, 1);
		pane.add(lb3, 0, 2);
		pane.add(tf3, 1, 2);
		
		Scene scene = new Scene(pane, 500, 500);
		primaryStage.setTitle("Currency Converter");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	class dollarConversion implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			double dollar = Double.parseDouble(tf1.getText());
			double euro = dollar*0.92;
			double euroRounded = Math.round(euro * 100.0)/100.0;
			double yuan = dollar*7.07;
			double yuanRounded = Math.round(yuan * 100.0)/100.0;
			tf2.setText(Double.toString(euroRounded));
			tf3.setText(Double.toString(yuanRounded));
		}
	}
	
	class euroConversion implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			double euro = Double.parseDouble(tf2.getText());
			double dollar = euro/0.92;
			double dollarRounded = Math.round(dollar * 100.0)/100.0;
			double yuan = euro*7.69;
			double yuanRounded = Math.round(yuan * 100.0)/100.0;
			tf1.setText(Double.toString(dollarRounded));
			tf3.setText(Double.toString(yuanRounded));
		}
	}
	
	class yuanConversion implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			double yuan = Double.parseDouble(tf3.getText());
			double dollar = yuan/7.07;
			double dollarRounded = Math.round(dollar * 100.0)/100.0;
			double euro = yuan/7.69;
			double euroRounded = Math.round(euro * 100.0)/100.0;
			tf1.setText(Double.toString(dollarRounded));
			tf2.setText(Double.toString(euroRounded));
		}
	}
}
