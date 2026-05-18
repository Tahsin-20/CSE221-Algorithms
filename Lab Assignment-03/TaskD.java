import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskD {
    static final long m=(long)Math.pow(10, 9)+7;
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int t=Integer.parseInt(br.readLine());

        while(t-->0){
            long[][]result={{1,0},
                            {0,1}};
            StringTokenizer st=new StringTokenizer(br.readLine());
            long[][]mat=new long[2][2];
            mat[0][0]=Long.parseLong(st.nextToken());
            mat[0][1]=Long.parseLong(st.nextToken());
            mat[1][0]=Long.parseLong(st.nextToken());
            mat[1][1]=Long.parseLong(st.nextToken());
            long x=Integer.parseInt(br.readLine());

             while(x>0){
                if(x%2==1){
                    result=multiply(result,mat);
                }
                mat=multiply(mat,mat);
                x/=2;
             }
             pw.println(result[0][0]+" "+result[0][1]);
             pw.println(result[1][0]+" "+result[1][1]);
        }
        pw.flush();
    }
    public static long[][] multiply(long[][]a, long[][]b){
        long[][]c=new long[2][2];
        c[0][0]=(a[0][0]*b[0][0] + a[0][1]*b[1][0])%m;
        c[0][1]=(a[0][0]*b[0][1] + a[0][1]*b[1][1])%m;
        c[1][0]=(a[1][0]*b[0][0] + a[1][1]*b[1][0])%m;
        c[1][1]=(a[1][0]*b[0][1] + a[1][1]*b[1][1])%m;
    
        return c;
    }
}
