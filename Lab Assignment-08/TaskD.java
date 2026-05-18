import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TaskD {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int test=Integer.parseInt(br.readLine());

        while(test-->0){
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
                adj.get(v[i]).add(new int[]{u[i],w[i]});
            }
            int[]best=new int[ver+1];

            PriorityQueue<int[]>pq=new PriorityQueue<>(Comparator.comparingInt((int[]a)->a[1]).reversed());
            best[source]=Integer.MAX_VALUE;
            pq.add(new int[]{source,Integer.MAX_VALUE});

            while(!pq.isEmpty()){
                int[]curr=pq.remove();
                int node=curr[0];
                int bn=curr[1];

                if(bn<best[node]) continue;
                ArrayList<int[]>neigh=adj.get(node);

                for(int i=0; i<neigh.size(); i++){
                    int[]a=neigh.get(i);
                    int next=a[0];
                    int nb=Math.min(bn, a[1]);

                    if(nb>best[next]){
                        best[next]=nb;
                        pq.add(new int[]{next, nb});
                    }
                }
            }
            pw.println(best[dest]);
        }
        pw.flush();

    }
}
