import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class TaskE {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edge=Integer.parseInt(st.nextToken());
        int s=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        StringBuilder sb=new StringBuilder();

        for(int i=0; i<=ver; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edge; i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[]visited=new boolean[ver+1];
        int[]distance=new int[ver+1];
        Arrays.fill(distance, -1);
        Queue<Integer>q=new ArrayDeque<>();
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<s; i++){
            int a=Integer.parseInt(st.nextToken());
            q.add(a);
            distance[a]=0;
            visited[a]=true;
        }
        while(!q.isEmpty()){
            int node=q.remove();
            ArrayList<Integer>neigh=adj.get(node);
            for(int i=0; i<neigh.size(); i++){
                int a=neigh.get(i);
                if(visited[a]==false){
                    visited[a]=true;
                    distance[a]=distance[node]+1;
                    q.add(a);
                }
            }
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<d; i++){
            int a=Integer.parseInt(st.nextToken());
            sb.append(distance[a]+" ");
        }
        pw.println(sb);
        pw.flush();
    }
}
