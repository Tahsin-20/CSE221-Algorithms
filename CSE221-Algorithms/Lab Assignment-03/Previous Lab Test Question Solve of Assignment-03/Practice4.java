import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Practice4 {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        int[]arr=new int[n];
        
        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int b=BS(arr, n);
        int odd=b;
        int even=n-b;
        pw.println(odd+" "+even);
        pw.flush();
    }
    public static int BS(int[]arr, int n){
        int l=0, r=n-1;
        int ans=n;

        while(l<=r){

            int mid=(l+r)/2;

            if(arr[mid]%2==0){
                ans=mid;
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}
