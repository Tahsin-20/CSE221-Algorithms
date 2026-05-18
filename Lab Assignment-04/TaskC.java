import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskC {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        int[][]mat=new int[n][n];

        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int c=Integer.parseInt(st.nextToken());
            for(int j=0; j<c; j++){
                mat[i][Integer.parseInt(st.nextToken())]=1;
            }
        }
         for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        pw.flush();
    }
    
}
