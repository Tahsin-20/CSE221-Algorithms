import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Practice6 {
    static StringBuilder sb=new StringBuilder();
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int[]arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        building(arr, 0, n-1);
        pw.println(sb);
        pw.flush();
    }
    public static void building(int[]arr, int l, int r){
        if(l>r) return;

        int mid=(l+r)/2;
        sb.append(arr[mid]).append(" ");

        building(arr, l, mid-1);
        building(arr, mid+1, r);
    }
}
