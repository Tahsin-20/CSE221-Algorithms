import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TaskC {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edge=Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>>adj=new ArrayList<>();
        for(int i=0; i<=ver; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edge; i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            int w=Integer.parseInt(st.nextToken());
            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});
        }
        boolean[]visited=new boolean[ver+1];
        int[]dist=new int[ver+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        dist[1]=0;
        pq.add(new int[]{1, dist[1]});

        while(!pq.isEmpty()){
            int[]curr=pq.remove();
            int node=curr[0];
            int danger=curr[1];

            if(visited[node]) continue;
            visited[node]=true;
            ArrayList<int[]>neigh=adj.get(node);
            for(int i=0; i<neigh.size(); i++){
                int[]a=neigh.get(i);
                int next=a[0];
                int w=a[1];

                int newDanger=Math.max(danger, w);

                if(newDanger<dist[next]){
                    dist[next]=newDanger;
                    pq.add(new int[]{next, newDanger});
                }
            }
        }
        for(int i=1; i<=ver; i++){
            if(dist[i]==Integer.MAX_VALUE){
                pw.print(-1+" ");
            }
            else{
                pw.print(dist[i]+" ");
            }
        }
        pw.flush();
    }
}
