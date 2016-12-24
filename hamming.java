/*
ID: 17chiue1
LANG: JAVA
TASK: hamming
 */

import java.io.*;
import java.util.*;

public class hamming {
  //Declare globals
  //Number n codewords
  static int n;
  //length b
  static int b;
  //at least this hamming distance
  static int d;
  public static void main (String[] args) throws IOException{
    Scanner sc = new Scanner(new File("holstein.in"));
    PrintWriter pw = new PrintWriter(new File("holstein.out"));
    
    n = sc.nextInt();
    b = sc.nextInt();
    d = sc.nextInt();
  }
  
  //Calculate hamming distance
  public static int calculateHamming(int a, int b){
    String a_string = Integer.toBinaryString(a);
  }
}