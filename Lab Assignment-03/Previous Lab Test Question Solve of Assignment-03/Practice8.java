import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Practice8 {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        int[]arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        pw.println(maxsum(arr, 0, n-1));
        pw.flush();
    }
    public static int maxsum(int[]arr, int l, int r){

        if(l==r) return arr[l];

        int mid=(l+r)/2;
        int left=maxsum(arr, l, mid);
        int right=maxsum(arr, mid+1, r);
        int cross=crosssum(arr, l, mid, r);

        return Math.max(cross, Math.max(right, left));
    }
    public static int crosssum(int[]arr, int l, int mid, int r){
        
        int leftsum=0;
        int leftmax=Integer.MIN_VALUE;

        for(int i=mid; i>=l; i--){
            leftsum+=arr[i];
            leftmax=Math.max(leftmax, leftsum);
        }

        int rightsum=0;
        int rightmax=Integer.MIN_VALUE;

        for(int i=mid+1; i<=r; i++){
            rightsum+=arr[i];
            rightmax=Math.max(rightmax, rightsum);
        }

        return leftmax+rightmax;
    }
}
