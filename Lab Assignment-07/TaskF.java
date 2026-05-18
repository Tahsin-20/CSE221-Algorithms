import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TaskF {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edge=Integer.parseInt(st.nextToken());
        int source=Integer.parseInt(st.nextToken());
        int dest=Integer.parseInt(st.nextToken());
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
        int[]distL=new int[ver+1];
        int[]distS=new int[ver+1];
        Arrays.fill(distL, Integer.MAX_VALUE);
        Arrays.fill(distS, Integer.MAX_VALUE);

        PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        distS[source]=0;
        pq.add(new int[]{source,distS[source]});

        while(!pq.isEmpty()){
            int[]curr=pq.remove();
            int node=curr[0];
            int distance=curr[1];
            if(distance>distL[node]) continue;

            ArrayList<int[]>neigh=adj.get(node);
            for(int i=0; i<neigh.size(); i++){
                int[]a=neigh.get(i);
                int next=a[0];
                int wei=a[1];

                int newDist=distance+wei;

                if(distS[next]>newDist){
                    distL[next]=distS[next];
                    distS[next]=newDist;
                    pq.add(new int[]{next,newDist});
                }
                else if(newDist>distS[next] && newDist<distL[next]){
                    distL[next]=newDist;
                    pq.add(new int[]{next, newDist});
                }
            }
        }
        if(distL[dest]==Integer.MAX_VALUE) pw.println(-1);
        else pw.println(distL[dest]);
        pw.flush();

    }
}
