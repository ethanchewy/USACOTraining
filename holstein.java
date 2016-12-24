/*
ID: 17chiue1
LANG: JAVA
TASK: holstein
 */

import java.io.*;
import java.util.*;

public class holstein {
  static int[] requirements;
  static int num_vit;
  
  static int[][] feed;
  static int numf;
  
  static int min_best;
  static int[] min_best_set;
  
  static int[] current_set;
 
  
  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(new File("holstein.in"));
    PrintWriter pw = new PrintWriter(new File("holstein.out"));
    
    //Get Input
    //Types of Vitamins
    num_vit = sc.nextInt();
    
    //Min. Requirements
    requirements = new int[num_vit];
    
    for(int i = 0; i<num_vit;i++){
      requirements[i] = sc.nextInt();
    }
    
    numf = sc.nextInt();
    //All vitamins available
    feed = new int[numf][num_vit];
    
    for(int i = 0; i<numf;i++){
      for(int j = 0; j<num_vit;j++){
        feed[i][j] = sc.nextInt();
      }
    }
    
    current_set = new int[50000];
    min_best_set = new int[50000];
    sc.close();
    
    //Try all possible subsets (g!)
    //Try if there is only 1 scoop, 2 scoops, etc.
    //First, try each match. For example {a,b,c}, try {a,b}, {a,c}, {b,c}
    //Use bitmasks: http://codeforces.com/blog/entry/18169
    
    //int total = 0; // location in requirements
    min_best = numf+1;
    find_feed(0,0);
    
    pw.print(min_best+" ");
    for(int lvl=0; lvl<min_best;lvl++){
      //System.out.println(min_best_set[lvl]+1);
      if(lvl==min_best-1){
        pw.print(min_best_set[lvl]+1+"\n");
      } else{
        pw.print(min_best_set[lvl]+1+" ");
      }
     
    }
    pw.close();
    
  }
  
  public static void find_feed(int cnt, int id){
    //cnt => number of feeds in current mixture
    //id => identifier for the first feed that is being added
    
    int lvl;
    //System.out.println(min_best);
    //Check if requirements have been met
    for(lvl = 0; lvl<num_vit;lvl++){
      //System.out.println("hello1");
      if(requirements[lvl]>0){
        break;
      }
    }
    
    
    //System.out.println(lvl);
    //System.out.println(num_vit);
    //If met => base case
    if(lvl >=num_vit){
      //System.out.println("hello2");
      min_best = cnt;
      for(lvl=0;lvl<min_best;lvl++){
        
        min_best_set[lvl] = current_set[lvl];
        //System.out.println("hi"+min_best_set[lvl]);
      }
      return;
    }
    
    while(id<numf && cnt+1<min_best){
      //System.out.println("hello3");
      for(lvl=0; lvl<num_vit;lvl++){
        //System.out.println("lvl"+lvl);
        //System.out.println("id"+id);
        requirements[lvl] -=feed[id][lvl];
        //System.out.println("hi1");
      }
      current_set[cnt] = id;
      //System.out.println("hi2");
      
      find_feed(cnt+1,id+1);
      
      System.out.println("cnt"+cnt);
      System.out.println("id"+id);
      
      for(lvl = 0; lvl<num_vit;lvl++){
        requirements[lvl] += feed[id][lvl];
      }
      //System.out.println(id);
      id++;
      
    }
  }
  

}