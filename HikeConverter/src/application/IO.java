package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IO {

	public static void writeData(double miles, int minutes, int hours, int days, int months, int years){
		   try{
		
		       FileWriter fw = new FileWriter ("hikingData.txt");
		       PrintWriter pw = new PrintWriter(fw);
		
		       pw.println(miles);
		       pw.println(minutes);
		       pw.println(hours);
		       pw.println(days);
		       pw.println(months);
		       pw.println(years);
		
		       pw.close();
		   } catch (IOException e){
		
			   new Alerts("Error", "There was an error writing the data to file!");
		   
		   }	
		
			}
	
	 public static void readData(double miles, int min, int hour, int day, int month, int year){

		   try{
	            FileReader fr = new FileReader("hikingData.txt");
	            BufferedReader br = new BufferedReader(fr);

	           Scanner scan = new Scanner(fr);

	            while(scan.hasNext()){

	            	miles = scan.nextDouble();
	            	min = scan.nextInt();
	            	hour = scan.nextInt();
	            	day = scan.nextInt();
	            	month = scan.nextInt();
	            	year = scan.nextInt();

	            }
	            

	            br.close();
	            scan.close();
	            fr.close();
	            
	        } catch(IOException e){

				   new Alerts("Error", "There was an error reading the data from file!");
	        }
		 
	   	//	System.out.println("readData\n" + "Total Miles"  + totalMilesHiked + "\ntotal minutes " + totalMinutesHiked + "\ntotal hours " + totalHoursHiked + "\n");

	 }
}
