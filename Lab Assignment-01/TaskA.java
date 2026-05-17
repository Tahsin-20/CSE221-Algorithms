import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TaskA {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out, true);

        int n=Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            int no=Integer.parseInt(br.readLine());

            if(no%2==0){
                pw.println(no+" is an Even number.");
            }
            else{
                pw.println(no+" is an Odd number.");
            }
        }
    }
}
