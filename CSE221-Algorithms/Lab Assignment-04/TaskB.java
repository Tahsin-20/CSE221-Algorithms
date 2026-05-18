import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TaskB{
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        int[]u=new int[m];
        int[]v=new int[m];
        int[]w=new int[m];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            u[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            v[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            w[i]=Integer.parseInt(st.nextToken());
        }
        ArrayList<ArrayList<int[]>>adj=new ArrayList<>();

        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            adj.get(u[i]).add(new int[]{v[i],w[i]});
        }

        for(int i=1; i<=n; i++){
            System.out.print(i+":");

            for(int j=0; j<adj.get(i).size(); j++){
                int[]edge=adj.get(i).get(j);

                System.out.print(" ("+edge[0]+","+edge[1]+")");
            }
            System.out.println();
        }
        pw.flush();

    }
}
