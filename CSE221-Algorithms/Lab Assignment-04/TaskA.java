import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskA {
    public static void main(String[]args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int v=Integer.parseInt(st.nextToken());
        int e=Integer.parseInt(st.nextToken());
        int[][]mat=new int[v][v];

        for(int i=0; i<e; i++){
            st=new StringTokenizer(br.readLine());
            int ui=Integer.parseInt(st.nextToken());
            int vi=Integer.parseInt(st.nextToken());
            int wi=Integer.parseInt(st.nextToken());
            mat[ui-1][vi-1]=wi;
        }

        for(int i=0; i<v; i++){
            for(int j=0; j<v; j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        pw.flush();
    }
    
}
