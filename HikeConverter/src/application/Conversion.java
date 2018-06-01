package application;

public class Conversion {
	
	
	public  void convertMinutes(int minutes, int mod, int remainder) {
		
		
	if( minutes >= mod) {	
		
  	   while(minutes >= mod){
  		   
     	   //-- This variable collects the remainder and eventually adds it to toalMinutesHiked
     	   
     	  remainder = minutes % mod; // gets remainder of hours after 24 and leave it in total minutes
     	 minutes = minutes - mod; 
     	  
     	  Main.totalHoursHiked++; // adds 1 hour to totalDays because minutes went over 24
  	   		}
        }
  	 Main.totalMinutesHiked =  Main.totalMinutesHiked + remainder; //-- adds remaining hours to the total
        
  	   if(Main.totalMinutesHiked >= mod) {
  		   
   	   while(Main.totalMinutesHiked >= mod){
   		   System.out.println("In here because total is 2 high in hours");
   		  
   		   
      	   //-- This variable collects the remainder and eventually adds it to totalHoursHiked
      	   
      	 remainder =  Main.totalMinutesHiked % mod; // gets remainder of minutes after 24 and leave it in total hours
      	 Main.totalMinutesHiked =  Main.totalMinutesHiked - mod; 
      	  
      	 Main.totalHoursHiked++; // adds 1 day to totalDays because minutes went over 24
      	   
         }
   	 Main.totalMinutesHiked = Main.totalMinutesHiked + remainder; //-- adds remaining minutes to the total
	}
	else {Main.totalMinutesHiked = Main.totalMinutesHiked + minutes;}
         
	}
        
		
	
	
	
       // -----------------------------------------------------------------------------------------------------------------------------
	public  void convertHours(int hours, int mod, int remainder) {
		
		
	if( hours >= mod) {	
		
  	   while(hours >= mod){
  		   
     	   //-- This variable collects the remainder and eventually adds it to toalMinutesHiked
     	   
     	  remainder = hours % mod; // gets remainder of hours after 24 and leave it in total minutes
     	  hours = hours - mod; 
     	  
     	  Main.totalDaysHiked++; // adds 1 hour to totalDays because minutes went over 24
  	   		}
        }
  	 Main.totalHoursHiked =  Main.totalHoursHiked + remainder; //-- adds remaining hours to the total
        
  	   if(Main.totalHoursHiked >= mod) {
  		   
   	   while(Main.totalHoursHiked >= mod){
   		   System.out.println("In here because total is 2 high in hours");
   		  
   		   
      	   //-- This variable collects the remainder and eventually adds it to totalHoursHiked
      	   
      	 remainder =  Main.totalHoursHiked % mod; // gets remainder of minutes after 24 and leave it in total hours
      	 Main.totalHoursHiked =  (int) (Main.totalHoursHiked - mod); 
      	  
      	 Main.totalDaysHiked++; // adds 1 day to totalDays because minutes went over 24
      	   
         }
   	 Main.totalHoursHiked = Main.totalHoursHiked + remainder; //-- adds remaining minutes to the total
	}
	else {Main.totalHoursHiked = Main.totalHoursHiked + hours;}
         
	}
        
     // -----------------------------------------------------------------------------------------------------------------------------
	
	public  void convertDays(int days, int mod, int remainder) {
		
		
	if( days >= mod) {	
  	   while(days >= mod){
  		   
     	   //-- This variable collects the remainder and eventually adds it to toalMinutesHiked
     	   
     	  remainder = days % mod; // gets remainder of hours after 24 and leave it in total minutes
     	 days = days - mod; 
     	  
     	  Main.totalMonthsHiked++; // adds 1 hour to totalDays because minutes went over 24
     	   
        }
  	 Main.totalDaysHiked =  Main.totalDaysHiked + remainder; //-- adds remaining hours to the total
        

   	   while(Main.totalDaysHiked >= mod){
   		   System.out.println("In here because total is 2 high in hours");
   		  
   		   
      	   //-- This variable collects the remainder and eventually adds it to totalHoursHiked
      	   
      	 remainder =  Main.totalDaysHiked % mod; // gets remainder of minutes after 24 and leave it in total hours
      	 Main.totalDaysHiked =  (int) (Main.totalDaysHiked - mod); 
      	  
      	 Main.totalMonthsHiked++; // adds 1 day to totalDays because minutes went over 24
      	   
         }
   	 Main.totalDaysHiked = Main.totalDaysHiked + remainder; //-- adds remaining minutes to the total
	}
	else {Main.totalDaysHiked = Main.totalDaysHiked + days;}
         
	}
        
     // -----------------------------------------------------------------------------------------------------------------------------

	public  void convertMonths(int monthsHiked, int mod, int remainder) {
		
	  	   while(monthsHiked >= mod){
	  		   
	     	   //-- This variable collects the remainder and eventually adds it to toalMinutesHiked
	     	   
	     	  remainder = monthsHiked % mod; // gets remainder of minutes after 60 and leave it in total minutes
	     	 monthsHiked = monthsHiked - mod; 
	     	  
	     	  Main.totalYearsHiked++; // adds 1 hour to totalHours because minutes went over 60
	     	   
	        }
	  	 Main.totalMonthsHiked =  Main.totalMonthsHiked + remainder; //-- adds remaining minutes to the total
	        

	   	   while(Main.totalMonthsHiked >= mod){
	   		   
	      	   //-- This variable collects the remainder and eventually adds it to toalMinutesHiked
	      	
	      	   
	      	 remainder =  Main.totalMonthsHiked % mod; // gets remainder of minutes after 60 and leave it in total minutes
	      	 Main.totalMonthsHiked =  Main.totalMonthsHiked - mod; 
	      	  
	      	 Main.totalYearsHiked++; // adds 1 hour to totalHours because minutes went over 60
	      	   
	         }
	   	 Main.totalMonthsHiked =  Main.totalMonthsHiked + remainder; //-- adds remaining minutes to the total
	         
	         
		}
  // -----------------------------------------------------------------------------------------------------------------------------
	      
	
}
