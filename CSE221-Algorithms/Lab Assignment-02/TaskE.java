import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Longest_Subarray_Sum {
    public static void main(String[]args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw =new PrintWriter(System.out,true);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        long target=Long.parseLong(st.nextToken());
        st=new StringTokenizer(br.readLine());
        long[]arr=new long[n];

        for(int i=0; i<n; i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        int left=0;
        long sum=0;
        int maxl=0;
        for(int right=0; right<n; right++){
            sum+=arr[right];

            while(sum>target){
                sum-=arr[left];
                left++;
            }
            maxl=Math.max(maxl, right-left+1);
        }
        pw.println(maxl);
    }
}
