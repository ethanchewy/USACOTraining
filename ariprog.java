/*
ID: 17chiue1
LANG: JAVA
TASK: ariprog
 */
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.util.Comparator;
import java.io.BufferedReader;

public class ariprog {
 
 public static void main(String[] args) throws IOException {
  
  Scanner in = new Scanner(new File("ariprog.in"));
  PrintWriter pw = new PrintWriter(new File("ariprog.out"));
  
  int prog = in.nextInt();
  int bound = in.nextInt();
  
  int max = bound*bound*2+10;
  
  ArrayList<Integer> all = new ArrayList<Integer>();
  boolean[] bisquares = new boolean[max];
  
  for(int i = 0; i <= bound;i++)
  {
   for(int j = 0; j <=bound;j++)
   {
    if(bisquares[i*i+j*j]) continue;
    bisquares[i*i+j*j] = true;
    all.add(i*i+j*j);
   }
  }

  Collections.sort(all);

  ArrayList<Long> ans = new ArrayList<Long>();
  
  for(int i = 0; i < bisquares.length;i++)
  {
   if(bisquares[i] == false) continue;
   for(int diff = 1; diff < 5000;diff++)
   {
    int at = i;
    int count = 0;
    for(count = 0; count < prog && at < bisquares.length && bisquares[at]; count++)
    {
     at += diff;
    }
    if(count >= prog)
     ans.add(((long)diff << 32) | i);    
   }
  }

  Collections.sort(ans);
  for(long a:ans)
  {
   pw.println((a&0xFFFFFFFFL) +" "+(a >>>32));
  }
  if(ans.size()== 0) pw.println("NONE");

  pw.close();

                                  
  
  
 }
}