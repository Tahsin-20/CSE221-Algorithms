import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskE {
    static int[]parent;

    public static int find(int z){
        if(parent[z]!=z){
            parent[z]=find(parent[z]);
        }
        return parent[z];
    }
    public static void union(int m, int n){
        int a=find(m);
        int b=find(n);

        if(a!=b){
            parent[b]=a;
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edg=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());
        parent=new int[ver+1];

        for(int i=1; i<=ver; i++){
            parent[i]=i;
        }

        for(int i=0; i<edg; i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            union(u,v);
        }

        while(q-->0){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            if(find(x)==find(y)){
                pw.println("YES");
            }
            else{
                pw.println("NO");
            }
        }
        pw.flush();
    }
}
