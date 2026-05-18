import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Practice5 {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader( new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int m=107;
        int a=Integer.parseInt(st.nextToken());
        long n=Long.parseLong(st.nextToken());

        long ans=a;
        while(n>0){
            if(n%2==0){
                ans=(ans*a)%m;
            }
            a=(a*a)%m;
            n=n/2;
        }
        pw.println(ans);
        pw.flush();
    }
}
