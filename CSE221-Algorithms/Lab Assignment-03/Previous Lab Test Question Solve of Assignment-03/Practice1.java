import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Practice1 {
    static int m=107;
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        long n=Long.parseLong(st.nextToken());

        if(a==1){
            pw.println((n+1)%m);
        }
        else{
            long[]result=geometricSum(a,n);
            pw.println((result[1]+1)%m);
        }
        pw.flush();
    }

    public static long[] geometricSum(int a, long n){

        if(n==1) return new long[]{a%m, a%m};

        if(n%2==0){
            long[]half=geometricSum(a, n/2);
            long pow_half=half[0];
            long sum_half=half[1];

            long full_pow=(pow_half*pow_half)%m;
            long full_sum=(sum_half+(pow_half*sum_half)%m)%m;

            return new long[]{full_pow,full_sum};

        }
        else{
            long[]prev=geometricSum(a,n-1);
            long pow=(prev[0]*a)%m;
            long sum=(prev[1]+pow)%m;

            return new long[]{pow,sum};
        }
    }
}
