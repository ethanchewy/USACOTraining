/*
ID: 17chiue1
LANG: JAVA
TASK: milk2
 */
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class milk2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("milk2.in"));
        PrintWriter pw = new PrintWriter(new File("milk2.out"));

        // Read and sort data
        int numTimess = sc.nextInt();
        Times[] intervals = new Times[numTimess];
        for(int i=0; i<numTimess; i++) {
            intervals[i] = new Times(sc.nextInt(), sc.nextInt());
        }
        Arrays.sort(intervals, new Comparator<Times>() {
            @Override
            public int compare(Times o1, Times o2) {
                return o1.getLow()-o2.getLow();
            }
        });

        // Single pass scan
        int low = intervals[0].getLow();
        int high = intervals[0].getHigh();
        int maxTimes = high-low;
        int maxGap = 0;
        for(int i=1; i<intervals.length; i++) {
            Times a = intervals[i];
            if (a.getLow() <= high) {
                high = Math.max(a.getHigh(), high);
            } else {
                maxTimes = Math.max(maxTimes, high-low);
                maxGap = Math.max(maxGap, a.getLow()-high);
                low = a.getLow();
                high = a.getHigh();
            }
        }

        pw.println(maxTimes + " " + maxGap);
        pw.close();
    }

    private static class Times {
        private final int low;
        private final int high;

        public Times(int low, int high) {
            this.low = low;
            this.high = high;
        }

        public int getLow() {
            return this.low;
        }

        public int getHigh() {
            return this.high;
        }
    }
}
