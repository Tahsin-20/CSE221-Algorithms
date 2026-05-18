import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TaskG {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());

        long[][]arr=new long[n][2];

        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            arr[i][0]=Long.parseLong(st.nextToken());
            arr[i][1]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(arr, Comparator.comparingLong(a->a[0]));

        long t=0;
        long ans=0;

        for(int i=0; i<n; i++){
            t+=arr[i][0];
            ans+=arr[i][1]-t;
        }
        pw.println(ans);
        pw.flush();
    }
}
