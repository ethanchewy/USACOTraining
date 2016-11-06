/*
ID: 17chiue1
LANG: JAVA
TASK: palsquare
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
class palsquare {
  
  /* ADD YOUR CODE HERE */
  public static void main(String args[]) throws IOException{
    BufferedReader sc = new BufferedReader(new FileReader("palsquare.in"));
    PrintWriter pw = new PrintWriter(new File("palsquare.out"));
    
    int base = Integer.parseInt(sc.readLine());
    
    for(int i = 1; i <=300; i++){
      String csquared = convert(i*i, base);
      if (palindrome(csquared)){
        pw.println(convert(i,base) + " " + csquared);
      }
    }
    pw.close();
  }
  
  public static String convert(int given, int base){
    String str = Integer.toString(given, base).toUpperCase();
    return str;
  }
  
  public static boolean palindrome(String original){
    for(int i = 0; i<original.length();i++){
      if (original.charAt(i) != original.charAt(original.length()-i-1)) return false;
    }
    return true;
  }
  
}
