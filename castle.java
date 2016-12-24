/*
ID: 17chiue1
LANG: JAVA
TASK: castle
 */

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class castle {
 // castle's dimensions n x m
 static int [][] castle; 
 static boolean [][] visited;
 
 //Input given
 static int N;
 static int M;
 
 
 static int [] roomsize;
 
 // largest room created by removing one wall
 static int maxRoom; 
 
 static int [][] id;
 static int x_max;
 static int y_max;
 static char largest_dir;

 /*
  * Floodfill
  */
 
 public static void main(String[] args) throws IOException {
  Scanner in = new Scanner(new File("castle.in"));
  // Scanner in = new Scanner("5 5 3 2 6 3 6 1 8 4 1 4 13 7 13 9 4 3 0 2 6 5 9 8 8 12 13 ");
  PrintWriter pw = new PrintWriter(new File("castle.out"));
  M = in.nextInt();
  N = in.nextInt();
  castle = new int[N][M];
  id = new int[N][M];
  visited = new boolean[N][M];
  roomsize = new int[2501];
  for(int i = 0; i < N; i++) {
   for(int j = 0; j < M; j++) {
    castle[i][j] = in.nextInt();
   }
  }
  
  // for(boolean [] row : visited) printRow(row);
  in.close();
  
  int cnt = 0;
  int maxsize1 = 0;
  for(int i = 0; i < N; i++) {
   for(int j = 0; j < M; j++) {
    if(! visited[i][j]) {
     visit(i, j, cnt);
     maxsize1 = Math.max(maxsize1, roomsize[cnt]);
     cnt++;
    }
   }
  }
  // for(boolean [] row : visited) printRow(row);
  pw.println(cnt);
  pw.println(maxsize1);
  
  for(int c = 0; c < M; c++) {
   for(int r = N - 1; r >= 0; r--) {
    // check for removing north wall
    if(genWalls(castle[r][c]).contains("N") && r > 0 && id[r][c] != id[r - 1][c]) {
     if(roomsize[id[r][c]] + roomsize[id[r - 1][c]] > maxRoom) {
      maxRoom = roomsize[id[r][c]] + roomsize[id[r - 1][c]];
      x_max = r + 1;
      y_max = c + 1;
      largest_dir = 'N';
      // System.out.println(x_max + " " + y_max + " " + largest_dir);
     }
    }
    
    // check for removing east wall
    if(genWalls(castle[r][c]).contains("E") && c < M - 1 && id[r][c] != id[r][c + 1]) {
     if(roomsize[id[r][c]] + roomsize[id[r][c + 1]] > maxRoom) {
      maxRoom = roomsize[id[r][c]] + roomsize[id[r][c + 1]];
      x_max = r + 1;
      y_max = c + 1;
      largest_dir = 'E';
      // System.out.println(x_max + " " + y_max + " " + largest_dir);
     }
    }
    
   }
  }
  /* for(String [] arr : optWalls) {
   for(String s : arr) System.out.print(s + " ");
   System.out.println();
  } */
  
  pw.println(maxRoom);
  pw.println(x_max + " " + y_max + " " + largest_dir);
  pw.close();
 }
 
 public static boolean valid(int x, int y) {
  return x >= 0 && x < N && y >= 0 && y < M;
 }
 
 /*
  * recurse until !valid or options all contained in genWalls
  */
 
 public static void visit(int x, int y, int ind) {
  id[x][y] = ind;
  if(visited[x][y]) return;
  visited[x][y] = true;
  roomsize[ind]++;
  if(valid(x + 1, y) && ! genWalls(castle[x][y]).contains("S")) visit(x + 1, y, ind);
  if(valid(x - 1, y) && ! genWalls(castle[x][y]).contains("N")) visit(x - 1, y, ind);
  if(valid(x, y - 1) && ! genWalls(castle[x][y]).contains("W")) visit(x, y - 1, ind);
  if(valid(x, y + 1) && ! genWalls(castle[x][y]).contains("E")) visit(x, y + 1, ind);
 }
 
 /*
  * Based on the number at the module, figure out which walls are present
  */
 public static HashSet<String> genWalls(int N) {
  HashSet <String> walls = new HashSet <String> ();
  if(N >= 8) {
   walls.add("S");
   N -= 8;
  }
  
  if(N >= 4) {
   walls.add("E");
   N -= 4;
  }
  
  if(N >= 2) {
   walls.add("N");
   N -= 2;
  }
  
  if(N >= 1) {
   walls.add("W");
   N--;
  }
  return walls;
 }

}