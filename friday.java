/*
ID: 17chiue1
LANG: JAVA
TASK: friday
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class friday {
  
  /* ADD YOUR CODE HERE */
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(new File("friday.in"));
    PrintWriter pw = new PrintWriter(new File("friday.out"));
    
    int years = sc.nextInt();
    //Starting Sat, Sun, etc.
    

    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[] count = {0,0,0,0,0,0,0};
    int day=2;
    for(int i=1900; i<1900+years;i++){
      //4 months have 30 days, 7 months have 31, and Feb has 28 except...
      
      for(int month = 0; month < 12; month++){
        int daysMonth = days[month];
        
        if(month == 1 && leapyear(i)){
          daysMonth++;
        }
        for(int d = 1; d <= daysMonth; d++){
          if(d==13){
            count[day]++;
          }
          day = (day +1)%7;
        }
      }
    }
    for(int i=0; i<count.length;i++){
      if(i==count.length-1){
        pw.print(count[i]+"\n");
      } else{
        pw.print(count[i]+" ");
      }
    }
    pw.close();
    
  }
  
  public static boolean leapyear(int year){
    if(year % 100 !=0 && year % 4 == 0){
      return true;
    } else if(year % 100 == 0 && year % 400 == 0){
      return true;
    } else {
      return false;
    }
  }
}
