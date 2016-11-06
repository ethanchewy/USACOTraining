/*
ID: 17chiue1
LANG: JAVA
TASK: gift1
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class gift1 {
  
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(new File("gift1.in"));
    PrintWriter pw = new PrintWriter(new File("gift1.out"));
    
    int num_ppl = sc.nextInt();
    
    Map<String, Integer> received = new HashMap<String, Integer>();
    List<String> people = new ArrayList<String>();
    for (int i = 0; i < num_ppl;i++){
      String current = sc.next();
      people.add(current);
      received.put(current, 0);
    }
    
    Map<String, Integer> initial = new HashMap<String, Integer>();
    
    for (int i = 0; i < num_ppl; i++){
      String giver = sc.next();
      int amount = sc.nextInt();
      int recipients = sc.nextInt();
      
      initial.put(giver, amount);
      
      int giftAmount = 0;
      
      if (recipients > 0) {
        giftAmount = amount/recipients;
        received.put(giver, received.get(giver) + amount % recipients);
      }
      
      for (int j = 0; j <recipients; j++){
        String recipient = sc.next();
        received.put(recipient, received.get(recipient) + giftAmount);
      }
      
      
    }
    for (String person: people){
      pw.println(person +" " + (received.get(person)-initial.get(person)));
    }
    pw.close();
  }
  
}
