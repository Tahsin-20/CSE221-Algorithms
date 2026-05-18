import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Practice2 {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        String[]arr=new String[n];
        for(int i=0; i<n; i++){
            arr[i]=st.nextToken();
        }
        
        pw.println(occurence(arr, 0, n-1));
        pw.flush();
    }

    public static String occurence(String[]arr, int l, int r){
        if(l==r) return arr[l];

        int mid=(l+r)/2;
        String left=occurence(arr, l, mid);
        String right=occurence(arr, mid+1, r);

        if(left.equals(right)){
            return left;
        }

        int leftcount=count(arr, l, r, left);
        int rightcount=count(arr, l, r, right);

        if(leftcount>rightcount){
            return left;
        }
        else{
            return right;
        }
    }
    public static int count(String[]arr, int l, int r, String tar){
        int c=0;
        for(int i=l; i<=r; i++){
            if(arr[i].equals(tar)){
                c++;
            }
        }
        return c;
    }
}
