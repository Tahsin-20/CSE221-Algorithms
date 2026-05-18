import java.io.*;
import java.util.StringTokenizer;

public class Fast_series_sum {

    static long mod;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            mod = Long.parseLong(st.nextToken());

            if (a == 1) {
                pw.println(n % mod);
            } else {
                long[] ans = solve(a, n);
                pw.println(ans[1]);   // sum
            }
        }
        pw.flush();
    }

    // returns {a^n % mod, sum(1..n) % mod}
    static long[] solve(long a, long n) {

        if (n == 1) {
            return new long[]{a % mod, a % mod};
        }

        if (n % 2 == 0) {
            long[] half = solve(a, n / 2);

            long powHalf = half[0];   // a^(n/2)
            long sumHalf = half[1];   // S(n/2)

            long powN = (powHalf * powHalf) % mod;

            long sumN = (sumHalf * (1 + powHalf) % mod) % mod;

            return new long[]{powN, sumN};
        } else {
            long[] prev = solve(a, n - 1);

            long powN = (prev[0] * a) % mod;
            long sumN = (prev[1] + powN) % mod;

            return new long[]{powN, sumN};
        }
    }
}
