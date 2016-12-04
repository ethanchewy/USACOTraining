/*
ID: 17chiue1
LANG: JAVA
TASK: numtri
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.PrintWriter;

import static java.lang.Math.max;
import static java.lang.Math.min;

class numtri {
  public static void main (String[] args) throws IOException{
    Scanner sc = new Scanner(new File("numtri.in"));
    PrintWriter pw = new PrintWriter(new File("numtri.out"));
    
    int rows = sc.nextInt();
    int[][] numtri = new int[rows][rows];
    for(int i = 0; i<rows;i++){
      for(int k = 0; k<=i;k++){
        numtri[i][k]=sc.nextInt();
      }
    }
    //System.out.println(Arrays.deepToString(numtri));
    sc.close();
    for(int i=rows-2;i>=0;i--){
      for(int j=0;j<=i;j++){
        numtri[i][j] += Math.max(numtri[i + 1][j], numtri[i + 1][j + 1]);
      }
    }
    pw.println(numtri[0][0]);
    pw.close();
  }
  
  
}
