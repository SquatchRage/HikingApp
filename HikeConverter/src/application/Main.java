package application;
	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.prefs.Preferences;
import java.beans.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class Main extends Application{
	
	private Stage window;
	private Scene scene;
	private TextField milesInput, hoursInput, minutesInput;
	private Button addButton;
	private HBox topBox, middleBox, bottomBox, labelPanel;
	private VBox master;
	private Label calculatedHours, calculatedMinutes, calculatedMiles, calculatedDays, calculatedMonths, calculatedYears, infoLabel;
	private Label milesLabel, yearLabel, monthLabel, dayLabel, hourLabel, minuteLabel;
	private Separator separator;
	private  String getMiles;
	private  String getHours;
	private  String getMinutes;
	static int totalMinutesHiked;
	static int totalHoursHiked;
	static int totalDaysHiked;
	static int totalMonthsHiked;
	static int totalYearsHiked;
	private int minutesHiked, hoursHiked;
	private double milesHiked = 0;
	static double totalMilesHiked;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void start(Stage primaryStage) {
		
		window = primaryStage;
		
		

//-- TOP HBOX AREA		
		
		milesInput = new TextField();
		milesInput.setAlignment(Pos.CENTER);
		milesInput.setPromptText("Miles Hiked");
		inputCheck(milesInput); // limits input to number/decimals
		
		Tooltip tp = new Tooltip();
		tp.setText("Insert your miles hiked.");
		milesInput.setTooltip(tp);
		
		hoursInput = new TextField();
		hoursInput.setAlignment(Pos.CENTER);
		hoursInput.setPromptText("Hours Hiked");
		inputCheck(hoursInput);// limits input to number/decimals
		
		Tooltip tp1 = new Tooltip();
		tp1.setText("Insert your hours hiked.\nIf they are unknown insert 0.");
		hoursInput.setTooltip(tp1);
		
		minutesInput = new TextField();
		minutesInput.setAlignment(Pos.CENTER);
		minutesInput.setPromptText("Minutes Hiked");
		inputCheck(minutesInput);// limits input to number/decimals
		
		Tooltip tp2 = new Tooltip();
		tp2.setText("Insert your minutes hiked.\nIf they are uknown enter 0"  );
		minutesInput.setTooltip(tp2);


		addButton = new Button("Add");
		//disables button until all fields have input
		addButton.disableProperty().bind(
         	    Bindings.isEmpty(milesInput.textProperty())
         	    .or(Bindings.isEmpty(hoursInput.textProperty()))
         	    .or(Bindings.isEmpty(minutesInput.textProperty()))
         	);

		topBox = new HBox();
		topBox.setAlignment(Pos.CENTER);
		topBox.setPadding(new Insets(35,10,10,10));
		topBox.setSpacing(50);

		topBox.getChildren().addAll(milesInput, hoursInput, minutesInput, addButton);
		
		separator = new Separator();
		separator.setMaxWidth(800);
		infoLabel = new Label(" ** If you do not know the the hours/minutes insert miles hiked and click 'Add'");
		labelPanel = new HBox();
		labelPanel.getChildren().add(infoLabel);
		
//-- MID HBOX AREA
		
		calculatedMiles = new Label("00");
		calculatedYears = new Label("00");
		calculatedMonths = new Label("00");
		calculatedDays = new Label("00");
		calculatedHours = new Label("00");
		calculatedMinutes = new Label("00");

		middleBox = new HBox();
		//middleBox.setStyle("-fx-background-color: white");
		middleBox.setAlignment(Pos.CENTER);
		middleBox.setPadding(new Insets(90,10,10,10));
		middleBox.setSpacing(100);
		middleBox.getChildren().addAll(calculatedMiles, calculatedYears, calculatedMonths, calculatedDays, calculatedHours, calculatedMinutes);

//-- BOTTOM HBOX AREA		
		
		milesLabel = new Label("Miles");
		yearLabel = new Label("Years");
		monthLabel = new Label("Months");
		dayLabel = new Label("Days");
		hourLabel = new Label("Hours");
		minuteLabel = new Label("Minutes");
		
		bottomBox = new HBox();
		bottomBox.setAlignment(Pos.CENTER);
		bottomBox.setPadding(new Insets(10,10,10,10));
		bottomBox.setSpacing(77);
		bottomBox.getChildren().addAll(milesLabel, yearLabel, monthLabel, dayLabel, hourLabel, minuteLabel);

	  //-- 	Show saved Data on initial load
	    IO.readData();
	    displayStats();
		

//-- Add button click		
		addButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

               	//Gets input from txtfields and pulls it into variables and adds them up.     
            
               getMiles = milesInput.getText().trim();
               getMinutes = minutesInput.getText().trim();
               getHours = hoursInput.getText().trim();
       
               milesHiked = Double.parseDouble(getMiles);   
               totalMilesHiked = totalMilesHiked + milesHiked;
       
               minutesHiked = Integer.parseInt(getMinutes);
               totalMinutesHiked = totalMinutesHiked + minutesHiked;
               
               hoursHiked = Integer.parseInt(getHours);
               totalHoursHiked = totalHoursHiked + hoursHiked;
               
               //-- This if statement checks if the hours/minutes fields have input.  if not a method is called to populate options. 
               if(hoursHiked  <= 0 && minutesHiked <= 0) {
            	               	 
            	 Alerts.nullFields(milesHiked);

               }
               // if total minutes are higher than given mod, add to hours, loop until minutes are lower than mod. 
              int mod = 60;
              if( totalMinutesHiked >= mod) {

             	   while(totalMinutesHiked >= mod) {
             		   
             		 totalMinutesHiked =  totalMinutesHiked - mod;
             		 totalHoursHiked++;}
              }	   
               // if total hours are higher than given mod, add to days, loop until hours are lower than mod. 	   									     
               mod = 24;
               if( totalHoursHiked >= mod) {

            	   while(totalHoursHiked >= mod) {
            		   
            		 totalHoursHiked =  totalHoursHiked - mod;
            		 totalDaysHiked++;}
            		   
               }
               // if total days are higher than given mod, add to months, loop until days are lower than mod. 
               mod = 31;
               if( totalDaysHiked >= mod) {

            	   while(totalDaysHiked >= mod) {
            		   
            		   totalDaysHiked =  totalDaysHiked - mod;
            		   totalMonthsHiked++;}
               }
               // if total months are higher than given mod, add to years, loop until months are lower than mod. 
               mod = 12;
               if( totalMonthsHiked >= mod) {

                   while(totalMonthsHiked >= mod) {
                		   
                	   totalMonthsHiked =  totalMonthsHiked - mod;
                		totalYearsHiked++;}
                   }


        
          	   // clearing textfields after button click
          	   milesInput.clear();
          	   minutesInput.clear();
          	   hoursInput.clear();
          	       
          	//-- Save the data, then call the new total
          	//-- call the new data 2 screen
          	//-- call method to display stats
           	IO.writeData( totalMilesHiked, totalMinutesHiked, totalHoursHiked, totalDaysHiked, totalMonthsHiked, totalYearsHiked);
    	    IO.readData();
           	displayStats();
               

            }
        });

		master = new VBox();
		master.setStyle("-fx-background-color: slategrey");
		master.getChildren().addAll(topBox, separator, labelPanel,  middleBox, bottomBox);
		scene = new Scene(master, 800,500);
		window.setScene(scene);
		window.setTitle("Hike Calculator");
		window.show();
	
	}

	 public void displayStats() {

		    calculatedMiles.setText(Double.toString(totalMilesHiked)); 
           	calculatedMinutes.setText(Integer.toString(totalMinutesHiked));
           	calculatedHours.setText(Integer.toString(totalHoursHiked));
           	calculatedDays.setText(Integer.toString(totalDaysHiked));
           	calculatedMonths.setText(Integer.toString(totalMonthsHiked));
           	calculatedYears.setText(Integer.toString(totalYearsHiked));

	 }

	 //-- Only allows user to enter a number or decimal into input
	 public void inputCheck(TextField tf) {

		tf.textProperty().addListener(new ChangeListener<String>() {
			    @Override
			    public void changed(ObservableValue<? extends String> observable, String oldValue, 
			        String newValue) {
			        if (!newValue.matches("\\d\\.\\d")) {
			            tf.setText(newValue.replaceAll("[^\\d\\.\\d]", ""));
			        }
			    }

			}); 
	 }	 
}//EOC


