/*
ID: 17chiue1
LANG: JAVA
TASK: gift1
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class oldgift1 {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new File("gift1.in"));
    PrintWriter pw = new PrintWriter(new File("gift1.out"));
    /* # of ppl */
    int ppl = sc.nextInt();
    /* Variables */
    String total[][] = new String[ppl][2];
    
    /* Fill first column of return data set */
    for (int i = 0; i < ppl; i++){
       String name = sc.nextLine();
       total[i][0]=name;
       total[i][1]=null;
    }
    
    for (int i = 0; i < ppl;i++){
      String giver = sc.nextLine();
      
      int a = sc.nextInt();
      int b = sc.nextInt();
      
      
      for (int g = 0; g < ppl; g++){
        if(total[g][0] == giver){
          int current_giver_val = Integer.parseInt(total[g][1]);
          int new_giver_val = current_giver_val - a;
          total[g][1] = Integer.toString(new_giver_val);
        }
      }
      
      int divided = a / b;
      
      for (int ii = 0; ii < b; ii++){
        String next_name = sc.nextLine();
        for (int iii =0; iii<ppl; iii++){
          if(total[iii][0]==next_name){
            int current_value = Integer.parseInt(total[iii][1]);
            int new_value = current_value + divided;
            String new_string = Integer.toString(new_value);
            total[iii][0] = new_string;
          }
        }
      }
      
    }
    pw.print(total);
    pw.close();
    
  }
}
