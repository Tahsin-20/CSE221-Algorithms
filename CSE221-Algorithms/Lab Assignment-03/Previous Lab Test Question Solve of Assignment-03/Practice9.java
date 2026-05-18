import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Practice9 {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        int[]arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int[]result=(maxsum(arr, 0, n-1));
        pw.println((result[1]+1)+" "+(result[2]+1));
        pw.flush();
    }
    public static int[]maxsum(int[]arr, int l, int r){

        if(l==r) return new int[]{arr[l],l,l};

        int mid=(l+r)/2;
        int[]left=maxsum(arr, l, mid);
        int[]right=maxsum(arr, mid+1, r);
        int[]cross=crosssum(arr, l, mid, r);

        if(left[0] >= right[0] && left[0] >= cross[0]) return left;
        else if(right[0] >= left[0] && right[0] >= cross[0]) return right;
        else return cross;
    }
    public static int[]crosssum(int[]arr, int l, int mid, int r){
        
        int leftsum=0;
        int leftmax=Integer.MIN_VALUE;
        int leftind=-1;

        for(int i=mid; i>=l; i--){
            leftsum+=arr[i];
            if(leftsum>leftmax){
                leftmax=leftsum;
                leftind=i;
            }
        }

        int rightsum=0;
        int rightmax=Integer.MIN_VALUE;
        int rightind=-1;

        for(int i=mid+1; i<=r; i++){
            rightsum+=arr[i];
            if(rightsum>rightmax){
                rightmax=rightsum;
                rightind=i;
            }
        }

        return new int[]{leftmax+rightmax, leftind, rightind};
    }
}
