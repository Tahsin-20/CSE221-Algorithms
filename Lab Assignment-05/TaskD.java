import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class TaskD {

    public static void bfs(int st, boolean[]visited, ArrayList<ArrayList<Integer>>adj, int[] parent, int[]dist ){
        Queue<Integer>q=new LinkedList<>();
        visited[st]=true;
        q.add(st);
        dist[st]=0;
        parent[st]=-1;

        while(!q.isEmpty()){
            int node=q.remove();
            ArrayList<Integer>neighbours=adj.get(node);

            for(int i=0; i<neighbours.size(); i++){
                int n=neighbours.get(i);
                if(visited[n]==false){
                    visited[n]=true;
                    dist[n]=dist[node]+1;
                    parent[n]=node;
                    q.add(n);
                }
            }
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int vertices=Integer.parseInt(st.nextToken());
        int edges=Integer.parseInt(st.nextToken());
        int source=Integer.parseInt(st.nextToken());
        int dest=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0; i<=vertices; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges; i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
        }
        boolean[]visitedS=new boolean[vertices+1];
        int[]parentS=new int[vertices+1];
        int[]distanceS=new int[vertices+1];
        
        bfs(source, visitedS, adj, parentS, distanceS);

        boolean[]visitedK=new boolean[vertices+1];
        int[] parentK=new int[vertices+1];
        int[] distanceK=new int[vertices+1];

        bfs(k, visitedK, adj, parentK, distanceK);

        if(visitedS[k]==false || visitedK[dest]==false){
            pw.println(-1);
            pw.flush();
            return;
        }
        List<Integer>path1=new ArrayList<>();
        int curr=k;
        while(curr!=-1){
            path1.add(curr);
            curr=parentS[curr];
        }
        Collections.reverse(path1);

        List<Integer>path2=new ArrayList<>();
        curr=dest;
        while(curr!=-1){
            path2.add(curr);
            curr=parentK[curr];
        }
        Collections.reverse(path2);

        path2.remove(0);
        pw.println((path1.size()+path2.size())-1);
        for (int i = 0; i < path1.size(); i++) {
            pw.print(path1.get(i) + " ");
        }

        for (int i = 0; i < path2.size(); i++) {
            pw.print(path2.get(i) + " ");
        }

        pw.flush();
        
    }  
}
