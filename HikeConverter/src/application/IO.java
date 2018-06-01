package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IO {

	public static  void writeData(double miles, int minutes, int hours, int days, int months, int years){
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
			   System.out.println("in alert");
		   
		   }	
		   
		   System.out.println(miles);
		   System.out.println(minutes);
		   System.out.println(hours);

		
			}
	
	 public static  void readData(){

		   try{
	            FileReader fr = new FileReader("hikingData.txt");
	            BufferedReader br = new BufferedReader(fr);

	           Scanner scan = new Scanner(fr);

	            while(scan.hasNext()){

	            	Main.totalMilesHiked = scan.nextDouble();
	            	Main.totalMinutesHiked = scan.nextInt();
	            	Main.totalHoursHiked = scan.nextInt();
	            	Main.totalDaysHiked = scan.nextInt();
	            	Main.totalMonthsHiked = scan.nextInt();
	            	Main.totalYearsHiked = scan.nextInt();

	            }
	            

	            br.close();
	            scan.close();
	            fr.close();
	            
	        } catch(IOException e){

				   new Alerts("Error", "There was an error reading the data from file!");
	        }
		 
	   		System.out.println("readData\n" + "Total Miles"  + Main.totalMilesHiked + "\ntotal minutes " + Main.totalMinutesHiked + "\ntotal hours " + Main.totalHoursHiked + "\n");

	 }
}
