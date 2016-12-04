/*
ID: 17chiue1
LANG: JAVA
TASK: pprime
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;
class pprime {
  public static Scanner sc;
  public static PrintWriter pw;
    
  public static void main (String[] args) throws IOException{
    sc = new Scanner(new File("pprime.in"));
    pw = new PrintWriter(new File("pprime.out"));
    
    int min = sc.nextInt();
    int max = sc.nextInt();
    int minLen = (int)(Math.log10(min)+1);
    int maxLen = (int)(Math.log10(max)+1);
    sc.close();
    if (minLen <= 1 && maxLen >= 1)
      generate1digits(min, max);
    if (minLen <= 2 && maxLen >= 2)
      generate2digits(min, max);
    if (minLen <= 3 && maxLen >= 3)
      generate3digits(min, max);
    if (minLen <= 5 && maxLen >= 5)
      generate5digits(min, max);
    if (minLen <= 7 && maxLen >= 7)
      generate7digits(min, max);
    pw.close();
  }
  public static void generate1digits(int A, int B) throws IOException {
    for (int i = 2; i <= 7; i++) {
      if (i >= A && i <= B && isPrime(i))
        pw.println(i);
    }
  }
  public static void generate2digits(int A, int B) throws IOException {
    if (A <= 11 && B >= 11) pw.println("11");
  }
  public static void generate3digits(int A, int B) throws IOException { 
    for (int d1 = 1; d1 <= 9; d1 += 2) { 
      for (int d2 = 0; d2 <= 9; d2++) { 
        String s = ""; 
        s += d1; 
        s += d2; 
        s += d1; 
        int num = Integer.parseInt(s); 
        if (num >= A && num <= B && isPrime(num)) { 
          pw.println(num);  
        } 
      } 
    } 
  }
  public static  void  generate5digits(int A, int B) throws IOException { 
    for (int d1 = 1; d1 <= 9; d1 += 2) { 
      /* only odd => evens are never prime*/ 
      for (int d2 = 0; d2 <= 9; d2++) { 
        for (int d3 = 0; d3 <= 9; d3++) { 
          String s = ""; 
          s += d1; 
          s += d2; 
          s += d3; 
          s += d2; 
          s += d1; 
          int num = Integer.parseInt(s); 
          if (num >= A && num <= B && isPrime(num)) { 
            pw.println(num); 
          } 
        } 
      } 
    } 
  }
  public static  void generate7digits(int A, int B) throws IOException { 
    for (int d1 = 1; d1 <= 9; d1 += 2) { 
      /* evens aren't prime */ 
      for (int d2 = 0; d2 <= 9; d2++) { 
        for (int d3 = 0; d3 <= 9; d3++) { 
          for (int d4 = 0; d4 <= 9; d4++) { 
            String s = ""; s += d1; s += d2; 
            s += d3; 
            s += d4; 
            s += d3; 
            s += d2; 
            s += d1; 
            int num = Integer.parseInt(s); 
            if (num >= A && num <= B && isPrime(num)) { 
              pw.println(num); 
            } 
          } 
        } 
      } 
    }
  }

  public static boolean isPrime(int n){
    if (n%2==0) 
      return false;
    for(int i=3;i*i<=n;i+=2) {
        if(n%i==0)
            return false;
    }
    return true;
  }
  
}
