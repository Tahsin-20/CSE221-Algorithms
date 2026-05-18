import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TaskD {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edge=Integer.parseInt(st.nextToken());
        int source=Integer.parseInt(st.nextToken());
        int dest=Integer.parseInt(st.nextToken());
        int[]w=new int[ver+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=ver; i++){
            w[i]=Integer.parseInt(st.nextToken());
        }
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0; i<=ver; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edge; i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
        }
        boolean[]visited=new boolean[ver+1];
        int[]dist=new int[ver+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        dist[source]=w[source];
        pq.add(new int[]{source, dist[source]});

        while(!pq.isEmpty()){
            int[]curr=pq.remove();
            int node=curr[0];
            int d=curr[1];

            if(visited[node]) continue;
            visited[node]=true;
            ArrayList<Integer>neigh=adj.get(node);
            for(int i=0; i<neigh.size(); i++){
                int a=neigh.get(i);
                int newCost=d+w[a];
                if(newCost<dist[a]){
                    dist[a]=newCost;
                    pq.add(new int[]{a, dist[a]});
                }
            }
        }
        if(dist[dest]==Integer.MAX_VALUE) pw.println(-1);
        else{
            pw.println(dist[dest]);
        }
        pw.flush();
    }
}
