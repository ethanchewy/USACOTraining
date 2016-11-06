/*
ID: 17chiue1
LANG: JAVA
TASK: dualpal
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
class dualpal {
  
  public static void main(String[] args) throws IOException{
    BufferedReader sc = new BufferedReader(new FileReader("dualpal.in"));
    PrintWriter pw = new PrintWriter(new File("dualpal.out"));
    String line = sc.readLine();
    String[] strs = line.trim().split("\\s+");
    
    int number = Integer.parseInt(strs[0]);
    
    int greater = Integer.parseInt(strs[1])+1;
    int counter2 = 0;
    int counter = 0;
    boolean done = false;
    while(counter2<number){
      for(int b=2;b<=10;b++){
        String converted = convert(greater,b);
        System.out.println(converted+"test "+b);
        if(palindrome(converted)){
          counter++;
        };
      }
      if(counter>=2){
          
          counter2++;
          pw.println(greater);
     }
     counter=0;
     greater++;
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
