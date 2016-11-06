/*
ID: 17chiue1
LANG: JAVA
TASK: barn1
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.BufferedReader;
class barn1 {
  
  public static void main(String args[]) throws IOException{
    Scanner sc = new Scanner(new File("barn1.in"));
    PrintWriter pw = new PrintWriter(new File("barn1.out"));
    
    int maximum = sc.nextInt();
    int total = sc.nextInt();
    int occupied = sc.nextInt();
    
    int[] stalls = new int[occupied];
    ArrayList<Integer> gaps = new ArrayList<Integer>();

    for(int i = 0; i<occupied; i++){
      stalls[i] = sc.nextInt();
      
    }
    Arrays.sort(stalls);
    /* differences */
    for(int i = 1;i<occupied;i++){
      if(stalls[i] - stalls[i - 1] > 1){
        gaps.add(stalls[i]-stalls[i-1]);
      }
    }
    Collections.sort(gaps);
    
    int boards = gaps.size()+1;
    System.out.println("boards "+boards);
    int a;
    while(boards > maximum){
      a = gaps.remove(0);
      System.out.println("boards "+boards);
      System.out.println("a "+a);
      occupied=occupied + a -1;
      System.out.println("occupied "+occupied);
      boards--;
    }
    
    pw.println(occupied);
    pw.close();
  }
  
}
