package codechef;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sarvesh
 * @since
 */
public class TLG {

    /*private static void solve(List<String> numbers) {
        int l = 0;
        int w = 0;
        for(String scores : numbers) {
            final String[] arr = scores.split(" ");
            final int s1 = Integer.parseInt(arr[0]);
            final int s2 = Integer.parseInt(arr[1]);
            final int lead = Math.abs(s1 - s2);
            if(lead > l) {
                l = lead;
                if(s1 > s2) {
                    w = 1;
                } else {
                    w = 2;
                }
            }
        }
        System.out.println(w + " " + l);
    }*/
    private static void solve(List<String> numbers) {
        int lead1 = 0, lead2 = 0;
        int m = 0, n = 0;
        int d1 = 0, d2 = 0;
        for(String scores : numbers) {
            final String[] arr = scores.split(" ");
            final int s1 = Integer.parseInt(arr[0]);
            final int s2 = Integer.parseInt(arr[1]);
            m = m + s1;
            n = n + s2;
            if(m >= n) {
                d1 = m - n;
            } else {
                d2 = n - m;
            }
            if(d1 > lead1) {
                lead1 = d1;
            }
            if(d2 > lead2){
                lead2 = d2;
            }
        }
        if(lead1 > lead2) {
            System.out.println(1 + " " + lead1);
        } else {
            System.out.println(2 + " " + lead2);
        }
    }

    public static void main(String[] args) throws Exception {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            while(t > 0) {
                lines.add(br.readLine());
                t--;
            }
        }
        solve(lines);
    }
}
