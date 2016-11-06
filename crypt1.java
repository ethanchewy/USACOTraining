/*
ID: 17chiue1
LANG: JAVA
TASK: crypt1
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

class crypt1 {
  
  /* ADD YOUR CODE HERE */
  public static void main(String args[]) throws IOException{
    Scanner sc = new Scanner(new File("crypt1.in"));
    PrintWriter pw = new PrintWriter(new File("crypt1.out"));
    
    int total = sc.nextInt();
    int[] numbers = new int[total];
    for (int i = 0; i<total; i++){
      numbers[i] = sc.nextInt();
    }
    int count = 0;

    for (int a:numbers){
      for (int b:numbers){
        for (int c:numbers){
          for (int d:numbers){
            for (int e:numbers){
              int abc = 100*a+10*b+c;
              int de = 10*d + e;
              
              int product1 = e * abc;
              int product2 = d *10 * abc;
              int product3 = product1 + product2;
              if(product2%10==0){
                product2/=10;
              }
              //System.out.println(product3);
              //System.out.println(Integer.toString(product3));
              if(val(product1,numbers)&&val(product2,numbers)&&val(product3,numbers)&&Integer.toString(product3).length()==4&&Integer.toString(product1).length()==3
                   &&Integer.toString(product2).length()==3){
                count++;
              }
            }
          }
        }
      }
    }
    pw.println(count);
    pw.close();
    
    
  }
  public static boolean val(int a, int[] b){
    String str = Integer.toString(a);
    int counter = 0;
    for(int i = 0;i<str.length();i++){
      for(int c:b){
        //System.out.println(str.charAt(i));
        //System.out.println(c);
        if(Character.getNumericValue(str.charAt(i))==c){
          counter++;
          //System.out.println(counter);
          break;
        }
      }
    }
    if(counter==str.length()){
      return true;
    }
    return false;
  }
  
}
