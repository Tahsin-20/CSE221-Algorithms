import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TaskB {
    static ArrayList<ArrayList<int[]>>adj=new ArrayList<>();

    public static int[] dijkstra(int st, int ver){
        int[]dist=new int[ver+1];
        boolean[]visited=new boolean[ver+1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparing(a->a[1]));
        dist[st]=0;
        pq.add(new int[]{st,dist[st]});

        while(!pq.isEmpty()){
            int[]curr=pq.remove();
            int node=curr[0];

            if(visited[node]) continue;
            visited[node]=true;
            ArrayList<int[]>neigh=adj.get(node);
            for(int i=0; i<neigh.size(); i++){
                int[]a=neigh.get(i);
                int nextv=a[0];
                int w=a[1];

                if(dist[nextv]>dist[node]+w){
                    dist[nextv]=dist[node]+w;
                    pq.add(new int[]{nextv, dist[nextv]});
                }
            }
        }
        return dist;
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edge=Integer.parseInt(st.nextToken());
        int sA=Integer.parseInt(st.nextToken());
        int sB=Integer.parseInt(st.nextToken());

        for(int i=0; i<=ver; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edge; i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());

            adj.get(u).add(new int[]{v,w});
        }
        int[]distA=dijkstra(sA, ver);
        int[]distB=dijkstra(sB, ver);
        int bestT=Integer.MAX_VALUE;
        int bestN=-1;

        for(int i=1; i<=ver; i++){
            if(distA[i]==Integer.MAX_VALUE || distB[i]==Integer.MAX_VALUE) continue;

            int time=Math.max(distA[i], distB[i]);

            if(time<bestT || (time==bestT && i<bestN)){
                bestT=time;
                bestN=i;
            }
        }
        if(bestN==-1){
            pw.println(-1);
        }
        else{
            pw.println(bestT+" "+bestN);
        }
        pw.flush();
    }
}
