import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Searching_Is_Fun {
    public static void main(String[]args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out, true);

        int n=Integer.parseInt(br.readLine());

        while(n-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            long k=Long.parseLong(st.nextToken());
            long x=Long.parseLong(st.nextToken());

            long ans=k+(k-1)/(x-1);
            pw.println(ans);
        }
    }
}
