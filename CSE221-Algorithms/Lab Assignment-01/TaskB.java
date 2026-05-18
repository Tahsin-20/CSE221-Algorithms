import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Can_you_solve_arithmatic_expressions {
    public static void main (String[]args) throws Exception{

        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out,true);

        int n=Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){

            StringTokenizer st= new StringTokenizer(br.readLine());

            st.nextToken();

            double a=Double.parseDouble(st.nextToken());
            String op=st.nextToken();
            double b=Double.parseDouble(st.nextToken());
            double result=0;

            if(op.equals("+")){
                result=a+b;
            }
            else if(op.equals("-")){
                result=a-b;
            }
            else if(op.equals("*")){
                result=a*b;
            }
            else if(op.equals("/")){
                result=a/b;
            }
            pw.println(result);
        }
    }
}
