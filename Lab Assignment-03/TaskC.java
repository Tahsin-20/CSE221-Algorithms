import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Fast_power_drift {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out, true);
        StringTokenizer st=new StringTokenizer(br.readLine());
        long a=Long.parseLong(st.nextToken());
        long b=Long.parseLong(st.nextToken());

        long ans=1;
        a%=107;
        while(b>0){
            if(b%2==1){
                ans=(ans*a)%107;
            }
            a=(a*a)%107;
            b=b/2;
        }
        pw.println(ans);
    }
}
