/*
ID: 17chiue1
LANG: JAVA
TASK: frac1
 */

import java.io.*;
import java.util.*;

public class frac1 {
  public static ArrayList<String> possibilities = new ArrayList<String>();
  public static void main (String[] args) throws IOException{
    Scanner in = new Scanner(new File("frac1.in"));
    PrintWriter pw = new PrintWriter(new File("frac1.out"));
    
    int n = in.nextInt();
    int solutions[][]= new int[1000][2];
    
    ArrayList<frac> ans = new ArrayList<frac>();
    ans.add(new frac(0,1));
    ans.add(new frac(1,1));
    for(int denom = 1; denom <= n;denom++){
      for(int numer = 1; numer < denom;numer++){
        if(gcd(denom,numer) == 1) 
          ans.add(new frac(numer,denom));
      }
    }
    Collections.sort(ans);
    for(frac f: ans){
      pw.println(f.numerator+"/"+f.denominator);
    }
    pw.close();

  }
  public static int gcd(int big, int small){
    //base case when the remainder is equal to 0
    if(small==0)
      return big;
    //Continually takes mod of big until small 
    return gcd(small, big%small);
  }
  public static class frac implements Comparable<frac>{
    int numerator,denominator;
    public frac(int n,int d){
      numerator = n; denominator = d;
    }
    
    public int compareTo(frac f){
      if(((double)numerator)/denominator > ((double)f.numerator)/f.denominator) 
        return 1; 
      if(((double)numerator)/denominator < ((double)f.numerator)/f.denominator) 
        return -1; 
      else return 0;
    }
    
  }
  
}