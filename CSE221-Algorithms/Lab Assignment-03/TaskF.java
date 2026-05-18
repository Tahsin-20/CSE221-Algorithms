import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Ordering_binary_tree {

    static StringBuilder sb=new StringBuilder();

    public static void building(long[]arr, int l, int r){
        if(l>r) return;

        int mid=(l+r)/2;

        sb.append(arr[mid]).append(" ");

        building(arr, l, mid-1);
        building(arr, mid+1, r);
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int len=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        long[]arr=new long[len];

        for(int i=0; i<len; i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        building(arr, 0, len-1);
        pw.println(sb);
        pw.flush();
    }
}
