/*
ID: 17chiue1
LANG: JAVA
TASK: combo
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

class combo {
  
  public static void main(String args[]) throws IOException{
    Scanner sc = new Scanner(new File("combo.in"));
    PrintWriter pw = new PrintWriter(new File("combo.out"));
    
    int number = sc.nextInt();
    int[] john = new int[3];
    int[] master = new int[3];
    for(int i = 0;i<3;i++){
      john[i] = sc.nextInt();
    }
    for(int i = 0;i<3;i++){
      master[i] = sc.nextInt();
    }
    int counter = 0;
    
    int a = master[0];
    int b = master[1];
    int c = master[2];
    
    int x = john[0];
    int y = john[1];
    int z = john[2];
    for(int i=1;i<=number;i++)
        for(int j=1;j<=number;j++)
            for(int k=1;k<=number;k++)
                if(check2(i,j,k,a,b,c,number)||check2(i,j,k,x,y,z,number))
                    counter++;
    pw.println(counter);
    pw.close();
    
    
    
  }
  
  public static boolean check1(int a, int b, int n){
    if(Math.abs(a-b)<=2) return true;
    if(Math.abs(a-b)>=n-2) return true;
    return false;
  }
  
  public static boolean check2 (int a, int b, int c, int d, int e, int f,int n){
    return (check1(a,d,n)&& check1(b,e,n) && check1(c,f,n));
  }
  
}
