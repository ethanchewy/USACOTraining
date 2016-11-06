/*
ID: 17chiue1
LANG: JAVA
TASK: ride
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class ride {
  
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new File("ride.in"));
    PrintWriter pw = new PrintWriter(new File("ride.out"));
    if (convert_value(sc.nextLine())%47 == convert_value(sc.nextLine())%47){
      pw.println("GO");
    } else{
      pw.println("STAY");
    }
    pw.close();
  }
    
    public static int convert_value(String a){
      int total_value=1;
      for (int i = 0; i < a.length(); i++){
        int char_value = a.charAt(i) - 'A' + 1;
        total_value *= char_value;
      }
      return total_value;    
    }
  
}
