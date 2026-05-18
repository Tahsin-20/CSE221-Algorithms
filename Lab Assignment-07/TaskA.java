import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TaskA {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edge=Integer.parseInt(st.nextToken());
        int source=Integer.parseInt(st.nextToken());
        int dest=Integer.parseInt(st.nextToken());
        int[]u=new int[edge];
        int[]v=new int[edge];
        int[]w=new int[edge];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<edge; i++){
            u[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<edge; i++){
            v[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<edge; i++){
            w[i]=Integer.parseInt(st.nextToken());
        }
        ArrayList<ArrayList<int[]>>adj=new ArrayList<>();
        for(int i=0; i<=ver; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edge; i++){
            adj.get(u[i]).add(new int[]{v[i],w[i]});
        }
        int[]dist=new int[ver+1];
        boolean[]visited=new boolean[ver+1];
        int[]parent=new int[ver+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        dist[source]=0;
        parent[source]=-1;
        pq.add(new int[]{source,dist[source]});

        while(!pq.isEmpty()){
            int[]curr=pq.remove();
            int a=curr[0];

            if(visited[a]==true) continue;
            visited[a]=true;

            ArrayList<int[]>neigh=adj.get(a);

            for(int i=0; i<neigh.size(); i++){
                int[]b=neigh.get(i);
                int v_i=b[0];
                int w_i=b[1];

                if(dist[v_i]>dist[a]+w_i){
                    dist[v_i]=dist[a]+w_i;
                    parent[v_i]=a;
                    pq.add(new int[]{v_i,dist[v_i]});
                }
            }
        }
        if(visited[dest]==false){
            pw.println(-1);
        }
        else{
            pw.println(dist[dest]);
            ArrayList<Integer>path=new ArrayList<>();
            int curr=dest;

            while(curr!=-1){
                path.add(curr);
                curr=parent[curr];
            }
            Collections.reverse(path);

            for(int i=0; i<path.size(); i++){
                pw.print(path.get(i)+" ");
            }
        }
        pw.flush();
    }
}
