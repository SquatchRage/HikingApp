

package application;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.*;

public class Alerts {
	
	
	
	public Alerts(String title, String message){

		
		Stage window  = new Stage();
		
		// This piece of code forces you to take care of current open window; 
		window.initModality(Modality.APPLICATION_MODAL); 
		window.setTitle(title);
		window.setMinWidth(400);
		window.setHeight(300); 
		
		Label label = new Label();
		label.setText(message);
		Button b = new Button("Close window");
		b.setOnAction(e -> window.close());
		
		VBox layout = new VBox(10);  //Vertical box layout with seperation of 10 pixels
		layout.setStyle("-fx-background-color: CRIMSON");
		layout.getChildren().addAll(label, b); // adds objects created to the layout
		layout.setAlignment(Pos.CENTER); 		//sets alignment of everything to CENTER
		
		Scene s = new Scene(layout); // Puts the layout into the scene
		window.setScene(s);
		window.showAndWait();  // Displays window and needs to be closed before returning to previous window. 
		
		
	}
	
	public static void nullFields(double milesHiked) {
		 
		 double time, speed;
		 
			List<String> choices = new ArrayList<>();
			choices.add("0.5");
			choices.add("1.0");
			choices.add("1.5");
			choices.add("2.0");
			choices.add("2.5");
			choices.add("3.0");
			choices.add("3.5");

			ChoiceDialog<String> dialog = new ChoiceDialog<>("0.5", choices);
			dialog.setTitle("Hiked Miles Per Hour");
			dialog.setHeaderText("			  IF TIME HIKED IS UNKNOWN"
					+ "\n Choose an average Hiked Miles Per Hour (HMPH) below.");
			dialog.setContentText("Choose your HMPH:");

			// Traditional way to get the response value.
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()){
				
			    speed = Double.parseDouble(result.get()); // -- get selected input and convert to double
			    time =  milesHiked / speed; // -- time  = distance Hiked / average speed of hike * 10 % for elevation gain/breaks

			    if(time >= 1) {
			    	 Main.totalHoursHiked = (int) (Main.totalHoursHiked + time);
		
			    }
			    
			    else {
			    time = time * 60; // -- this gives us the representation of minutes (Ex: if .25 is left over, it converts it to 15 )
			    

			    Main.totalMinutesHiked = (int) (Main.totalMinutesHiked + time); 
			    	}

				}
		   
			}// end of nullcheck


}// EOC
