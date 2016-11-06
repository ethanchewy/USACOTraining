/*
ID: 17chiue1
LANG: JAVA
TASK: skidesign
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
import java.io.BufferedReader;

public class skidesign {
 
 public static void main(String[] args) throws IOException {
  
  Scanner in = new Scanner(new File("skidesign.in"));
  PrintWriter pw = new PrintWriter(new File("skidesign.out"));
  
  int num = in.nextInt();
  int[] hills = new int[num];
  
  for(int i=0;i<num;i++){
    hills[i] = in.nextInt();
  }
  
  Arrays.sort(hills);
  System.out.println(Arrays.toString(hills));
  
  int difference = hills[num-1]-hills[0];
  int diff0 = difference - 17;
  
  //How much to raise
  int split1 = diff0/2;
  System.out.println(split1 + "split1");
  
  //How much to lower
  int split2 = diff0/2 + diff0%2;
  System.out.println(split2 + "split2");
  
  int diffnext1 = hills[1]-hills[0];
  int diffnext2 = hills[num-1]-hills[num-2];
  
  int cost = 0;
  int sum = Integer.MAX_VALUE;
        for (int min = 0; min <= 100; min++) {
            int tmpSum = 0;
            for (int i = 0; i < num; i++) {
                int tmp = hills[i] - min;
                if (tmp > 17) {
                    tmp -= 17;
                    tmpSum += tmp * tmp;
                } else if (tmp < 0) {
                    tmpSum += tmp * tmp;
                }
            }
            sum = Math.min(sum, tmpSum);
        }
  
  pw.println(sum);
  pw.close();
 }
}