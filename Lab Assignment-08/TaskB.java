import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TaskB {
    static int[]parent;

    public static int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    public static boolean union (int a, int b){
        int root1=find(a);
        int root2=find(b);

        if(root1==root2) return false;

        parent[root2]=root1;
        return true;
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());

        int ver=Integer.parseInt(st.nextToken());
        int edge=Integer.parseInt(st.nextToken());

        ArrayList<int[]>edges=new ArrayList<>();
        for(int i=0; i<edge; i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            edges.add(new int[]{u,v,w});
            
        }
        Collections.sort(edges, Comparator.comparingInt(a->a[2]));
        parent=new int[ver+1];
        for(int i=1; i<=ver; i++){
            parent[i]=i;
        }
        long cost=0;
        int used=0;

        for(int i=0; i<edges.size(); i++){
            int[]b=edges.get(i);
            int u=b[0], v=b[1], w=b[2];

            if(union(u, v)){
                cost+=w;
                used++;
                if(used==ver-1){
                    pw.println(cost);
                    pw.flush();
                    return;
                }
            }
        }
    }
}
