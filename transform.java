/*
ID: 17chiue1
LANG: JAVA
TASK: transform
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
class transform {
  
  /* ADD YOUR CODE HERE */
  public static void main(String args[]) throws IOException{
    Scanner sc = new Scanner(new File("transform.in"));
    PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
    
    int rows = sc.nextInt();
    int combination = 0;
    boolean more = false;
    
    char[][] original = new char[rows][rows];
    char[][] output = new char[rows][rows];
    
    
    for(int i=0; i<rows;i++){
      String s = sc.next();
      for(int b=0; b<rows;b++){
        original[i][b] = s.charAt(b);
      }
    }
    print(original);
    for(int i=0; i<rows;i++){
      String s = sc.next();
      for(int b=0; b<rows;b++){
        output[i][b] = s.charAt(b);
      }
    }
    
    if(Arrays.deepEquals(rotate(original), output)){
      pw.println(1);
    } else if(Arrays.deepEquals(rotate(rotate(original)), output)){
      pw.println(2);
    } else if(Arrays.deepEquals(rotate(rotate(rotate(original))),output)){
      pw.println(3);
    } else if(Arrays.deepEquals(reflected(original), output)){
      pw.println(4);
    } else if(Arrays.deepEquals(rotate(reflected(original)), output)
             || Arrays.deepEquals(rotate(rotate(reflected(original))), output)
             || Arrays.deepEquals(rotate(rotate(rotate(reflected(original)))), output)
             ){
      pw.println(5);
    } else if (Arrays.deepEquals(original, output)){
      pw.println(6);
    } else{
      pw.println(7);
    }
    pw.close();
    
  }
  private static void print(char[][] input) {
        for(int i=0; i<input.length; i++) {
            for(int j=0; j<input.length; j++) {
                System.out.print(input[i][j]);
            }
            System.out.println();
        }
    }
  public static char[][] reflected (char[][] original){
    int rows = original.length;
    char[][] returned= new char[rows][rows];
    for(int i=0; i<rows;i++){
      for(int b=0; b<rows;b++){
        returned[i][b] = original[i][rows-b-1];
      }
    }
    return returned;
  }
  public static char[][] rotate (char[][] original){
    int rows = original.length;
    char[][] returned= new char[rows][rows];
    for(int i=0; i<rows;i++){
      for(int b=0; b<rows;b++){
        returned[b][rows-i-1]=original[i][b];
      }
    }
    return returned;
  }
  
}
