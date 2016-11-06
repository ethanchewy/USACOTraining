/*
ID: 17chiue1
LANG: JAVA
TASK: milk
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.io.BufferedReader;
class milk {
  
  public static void main(String args[]) throws IOException{
    Scanner sc = new Scanner(new File("milk.in"));
    PrintWriter pw = new PrintWriter(new File("milk.out"));
    
    int amount = sc.nextInt();
    int farmers = sc.nextInt();
    int[][] collection = new int[farmers][2];
    
    for (int i = 0; i<farmers;i++){
      collection[i][0] = sc.nextInt();
      collection[i][1] = sc.nextInt();
    }
    
    java.util.Arrays.sort(collection, new java.util.Comparator<int[]>() {
    public int compare(int[] a, int[] b) {
        return a[0] - b[0];
    }
    });
    if(collection.length==0){
      pw.println(0);
    } else{
      int b = 0;
      int counter = 0;
      int counter2 = 0;
      int total = 0;
      int number = collection[b][0];
      int number2 = collection[b][1];
      boolean done = false;
      while(!done){
        if(counter2 < number2){
          total+= number;
          counter++;
          counter2++;
        } else{
          b++;
          number = collection[b][0];
          number2 = collection[b][1];
          counter2 = 0;
        }
        if(counter==amount){
          done = true;
        }
      }
      pw.println(total);
    }
    pw.close();
    
    
  }
  
}
