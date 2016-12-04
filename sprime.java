/*
ID: 17chiue1
LANG: JAVA
TASK: sprime
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
class sprime {
  
  public static Scanner sc;
  public static PrintWriter pw;
  static int length;
    
  public static void main (String[] args) throws IOException{
    sc = new Scanner(new File("sprime.in"));
    pw = new PrintWriter(new File("sprime.out"));
    
    length = sc.nextInt();
    solve(pw);
    pw.close();
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
  public static void solve(PrintWriter pw){ 
    solve(2,1,pw); 
    solve(3,1,pw); 
    solve(5,1,pw); 
    solve(7,1,pw); 
  } 
  public static void solve(int pre, int len, PrintWriter out){
    if(len == length) { 
      out.println(pre); 
      return; 
    } for(int i = 1; i<= 9 ; i +=2){ 
      int value = pre * 10 + i; 
      if(isPrime(value)){
        solve(value, len +1, out); 
      } 
    } 
  }
  
}
