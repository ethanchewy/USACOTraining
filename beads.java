/*
ID: 17chiue1
LANG: JAVA
TASK: beads
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class beads {
  
  public static void main(String ars[]) throws IOException{
    Scanner sc = new Scanner(new File("beads.in"));
    PrintWriter pw = new PrintWriter(new File("beads.out"));
    
    int size = sc.nextInt()*2;
    String necklace_1 = sc.next();
    necklace_1 = necklace_1.concat(necklace_1);
    char[] necklace = necklace_1.toCharArray();
    int maximum = 0;
    int sum1 = 0;
    int sum2 = 0;
    int i;
    int together = 0; 
    int walk = 0; 
    
    boolean set_yet = false;
    boolean not_done = true;
    
    char compar = 'w';
    
    for (i = 0; i < size; i++){
      if(necklace[i] == 'r' || necklace[i] == 'b'){
        sum2 = 1;
        i++;
        break;
      }
      sum2 = size/2;
    }
    for(; i < size; i++){
      if(necklace[i] == 'w'){
        together =1;
        walk = 1;
        sum2++;
        necklace[i] = necklace[i-1];
      } else if(necklace[i]==necklace[i-1]){
        sum2++;
      } else{
        if((sum1+sum2) > maximum)
          maximum = sum1+sum2;
        sum1 = sum2;
        sum2 = 1;
        if(walk==1){
          sum2 += together;
          sum1 -= together;
        }
        walk = 0; 
        together = 0;

      }
    }
    if((sum1+sum2) > maximum) 
        maximum = sum1+sum2; 
    if(maximum > (size/2)) 
        maximum = size/2; 
    pw.println(maximum);
    pw.close();
  }
  
}
