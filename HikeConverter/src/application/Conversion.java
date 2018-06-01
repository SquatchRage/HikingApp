package application;

public class Conversion {
	
	IO io = new IO();
	
	public  void convertMinutes(int minutes, int mod, int remainder) {
		
		
        if(minutes >= mod) {

            while (minutes >= mod){
      	   
      	   //-- This variable collects the remainder and eventually adds it to toalMinutesHiked
      	   
            	remainder = minutes % mod; // gets remainder of minutes after 60 and leave it in total minutes
      	 minutes = minutes - mod; 
      	  
      	   Main.totalHoursHiked++; // adds 1 hour to totalHours because minutes went over 60
      	   
         }
            Main.totalMinutesHiked =  Main.totalMinutesHiked + remainder; //-- adds remaining minutes to the total

         }
         else if( Main.totalMinutesHiked >= mod) {
      	   
      	   while( Main.totalMinutesHiked >= mod) {
      		   
      		 remainder =  Main.totalMinutesHiked % mod;
      		 Main.totalMinutesHiked =  Main.totalMinutesHiked - mod;
      		 Main.totalHoursHiked++;
      		   
      	   }
      	   
      	 Main.totalMinutesHiked =  Main.totalMinutesHiked + remainder;
         }
         
         else {
        	 Main.totalMinutesHiked =  Main.totalMinutesHiked + minutes;
         	}
      	           
        
         }
         
        
		
	
	
	
       // -----------------------------------------------------------------------------------------------------------------------------
public  void convertHours(int hours, int mod, int remainder) {
		
        if(hours >= mod) {

            while (hours >= mod){
      	   
      	   //-- This variable collects the remainder and eventually adds it to toalMinutesHiked
      	   
            	remainder = hours % mod; // gets remainder of minutes after 60 and leave it in total minutes
            	hours = hours - mod; 
      	  
      	   Main.totalDaysHiked++; // adds 1 hour to totalHours because minutes went over 60
      	   
         }
            Main.totalHoursHiked =  Main.totalHoursHiked + remainder; //-- adds remaining minutes to the total

         }
         else if( Main.totalHoursHiked >= mod) {
      	   
      	   while( Main.totalHoursHiked >= mod) {
      		   
      		 remainder =  Main.totalHoursHiked % mod;
      		 Main.totalHoursHiked =  Main.totalHoursHiked - mod;
      		 Main.totalDaysHiked++;
      		   
      	   }
      	   
      	 Main.totalHoursHiked =  Main.totalHoursHiked + remainder;
         }
         
         else {
        	 Main.totalHoursHiked =  Main.totalHoursHiked + hours;
         	  }
      	   
         }
         
        
     // -----------------------------------------------------------------------------------------------------------------------------
	
	public  void convertDays(int days, int mod, int remainder) {
		
		
	       if(days >= mod) {

	            while (days >= mod){
	      	   
	      	   //-- This variable collects the remainder and eventually adds it to toalMinutesHiked
	      	   
	            	remainder = days % mod; // gets remainder of minutes after 60 and leave it in total minutes
	            	days = days - mod; 
	      	  
	      	   Main.totalMonthsHiked++; // adds 1 hour to totalHours because minutes went over 60
	      	   
	         }
	            Main.totalDaysHiked =  Main.totalDaysHiked + remainder; //-- adds remaining minutes to the total

	         }
	         else if( Main.totalDaysHiked >= mod) {
	      	   
	      	   while( Main.totalDaysHiked >= mod) {
	      		   
	      		 remainder =  Main.totalDaysHiked % mod;
	      		 Main.totalDaysHiked =  Main.totalDaysHiked - mod;
	      		 Main.totalMonthsHiked++;
	      		   
	      	   }
	      	   
	      	 Main.totalDaysHiked =  Main.totalDaysHiked + remainder;
	         }
	         
	         else {
	        	 Main.totalDaysHiked =  Main.totalDaysHiked + days;
	         	  }
	      	   
	         }
	         
        
     // -----------------------------------------------------------------------------------------------------------------------------

	public  void convertMonths(int months, int mod, int remainder) {
		
	       if(months >= mod) {

	            while (months >= mod){
	      	   
	      	   //-- This variable collects the remainder and eventually adds it to toalMinutesHiked
	      	   
	            	remainder = months % mod; // gets remainder of minutes after 60 and leave it in total minutes
	            	months = months - mod; 
	      	  
	      	   Main.totalYearsHiked++; // adds 1 hour to totalHours because minutes went over 60
	      	   
	         }
	            Main.totalMonthsHiked =  Main.totalMonthsHiked + remainder; //-- adds remaining minutes to the total

	         }
	         else if( Main.totalMonthsHiked >= mod) {
	      	   
	      	   while( Main.totalMonthsHiked >= mod) {
	      		   
	      		 remainder =  Main.totalMonthsHiked % mod;
	      		 Main.totalMonthsHiked =  Main.totalMonthsHiked - mod;
	      		 Main.totalYearsHiked++;
	      		   
	      	   }
	      	   
	      	 Main.totalMonthsHiked =  Main.totalMonthsHiked + remainder;
	         }
	         
	         else {
	        	 Main.totalMonthsHiked =  Main.totalMonthsHiked + months;
	         	  }
	      	   
	         }
	         
	      
	
}
