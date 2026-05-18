import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskE {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edg=Integer.parseInt(st.nextToken());
        int[]u=new int[edg];
        int[]v=new int[edg];
        int[]indeg=new int[ver+1];
        int[]outdeg=new int[ver+1];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<edg; i++){
            u[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<edg; i++){
            v[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<edg; i++){
            if(u[i]==v[i]){
                outdeg[u[i]]++;
                indeg[u[i]]++;
            }
            else{
                outdeg[u[i]]++;
                indeg[v[i]]++;
            }
        }
        for(int i=1; i<=ver; i++){
            pw.print(indeg[i]-outdeg[i]+" ");
        }
        pw.flush();
    }
}
