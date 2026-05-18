import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class TaskC {
   public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int vertices=Integer.parseInt(st.nextToken());
        int edges=Integer.parseInt(st.nextToken());
        int source=Integer.parseInt(st.nextToken());
        int dest=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());
        int[]u=new int[edges];
        for(int i=0; i<edges; i++){
            u[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        int[]v=new int[edges];
        for(int i=0; i<edges; i++){
            v[i]=Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0; i<=vertices; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges; i++){
            adj.get(u[i]).add(v[i]);
            adj.get(v[i]).add(u[i]);
        }
        for(int i=1; i<=vertices; i++){
            Collections.sort(adj.get(i));
        }
        boolean[]visited=new boolean[vertices+1];
        Integer[]parent=new Integer[vertices+1];
        int[]distance=new int[vertices+1];
        Queue<Integer>q=new LinkedList<>();
        q.add(source);
        visited[source]=true;
        parent[source]=-1;
        distance[source]=0;

        while(!q.isEmpty()){
            int node=q.remove();
            ArrayList<Integer>neighbours=adj.get(node);

            for(int i=0; i<neighbours.size(); i++){
                int n=neighbours.get(i);
                if(visited[n]==false){
                    visited[n]=true;
                    parent[n]=node;
                    distance[n]=distance[node]+1;
                    q.add(n);
                }
            }
        }
        if(visited[dest]==false){
            pw.println(-1);
            pw.flush();
            return;
        }
        else{
            pw.println(distance[dest]);
        }
        List<Integer>path=new ArrayList<>();
        int curr=dest;
        while(curr!=-1){
            path.add(curr);
            curr=parent[curr];
        }
        Collections.reverse(path);

        for(int i=0; i<path.size(); i++){
            pw.print(path.get(i)+" ");
        }
        pw.flush();
    } 
}
