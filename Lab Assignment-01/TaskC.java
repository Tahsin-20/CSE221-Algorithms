import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class fast_Sum {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out,true);

        int n=Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            long num=Long.parseLong(br.readLine());
            long sum=(num*(num+1))/2;
            pw.println(sum);
        }
    }
}
