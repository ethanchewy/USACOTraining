/*
ID: 17chiue1
LANG: JAVA
TASK: sort3
 */

// Just need to count the number of swaps!
import java.io.*;
import java.util.*;


class sort3 {
  
  public static void main (String[] args) throws IOException{
    Scanner sc = new Scanner(new File("sort3.in"));
    PrintWriter pw = new PrintWriter(new File("sort3.out"));
    
    int num = sc.nextInt();
    //Original
    int[] set = new int[num];

    //Get how many of each 1,2,3s are in the original
    int[] values = {0,0,0,0};
    
    //Get counts for out of order locations in each
    int switch_12 = 0;
    int switch_21 = 0;
    int total = 0;
    
    for(int i =0; i<num;i++){
      set[i] = sc.nextInt();
      values[set[i]]++;
    }
    
    System.out.println(Arrays.toString(set));
    System.out.println(Arrays.toString(values));
    
    for(int i =0; i<num;i++){
      //If it isn't a one in the right locations
      if(i<values[1] && set[i] != 1){
        total++;
        if(set[i] == 2){
          switch_12++;
        }
      } else if (i>=values[1] && i<values[1] + values[2] && set[i]==3){
        total++;
      } else if (i>= values[1] && i<values[1] + values[2] && set[i] ==1){
        switch_21++;
      }
    }
    //See how many additional switches we need to make based on overlaps
    if(switch_21>switch_12){
      total += Math.abs(switch_12-switch_21);
    }
    System.out.println(total);
    pw.println(total);
    pw.close();
  }
  
}

