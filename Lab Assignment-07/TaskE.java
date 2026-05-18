import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TaskE {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edge=Integer.parseInt(st.nextToken());
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
        int[][]dist=new int[ver+1][2];
        boolean[][]visited=new boolean[ver+1][2];
        for(int i=1; i<=ver; i++){
            dist[i][0]=Integer.MAX_VALUE;
            dist[i][1]=Integer.MAX_VALUE;
        }
        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        dist[1][0]=0;
        dist[1][1]=0;

        pq.add(new int[]{1,0,0});  //{node, distance, parity}
        pq.add(new int[]{1,0,1});

        while(!pq.isEmpty()){
            int[]curr=pq.remove();
            int node=curr[0];  //vertex
            int distance=curr[1]; //distance
            int parity=curr[2]; //parity

            if(visited[node][parity]) continue;
            visited[node][parity]=true;

            ArrayList<int[]>neigh=adj.get(node);
            for(int i=0; i<neigh.size(); i++){
                int[]a=neigh.get(i);
                int next=a[0];
                int weight=a[1];

                int newParity=weight%2;
                int newDist=distance+weight;
                if(newParity==parity) continue;

                if(dist[next][newParity]>newDist){
                    dist[next][newParity]=newDist;
                    pq.add(new int[]{next, dist[next][newParity], newParity});
                }
            }
        }
        int ans=Math.min(dist[ver][0], dist[ver][1]);
        if(ans==Integer.MAX_VALUE){
            pw.println(-1);
        }
        else{
            pw.println(ans);
        }
        pw.flush();
    }
}
