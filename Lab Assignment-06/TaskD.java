import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TaskD {
    static ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
    static int ver;

    public static int[] bfs(int start){
        boolean[]visited=new boolean[ver+1];
        int[]distance=new int[ver+1];

        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        distance[start]=0;
        visited[start]=true;
        int farNode=start;

        while(!q.isEmpty()){
            int node=q.remove();

            ArrayList<Integer>neigh=adj.get(node);

            for(int i=0; i<neigh.size(); i++){
                int a=neigh.get(i);
                if(visited[a]==false){
                    visited[a]=true;
                    distance[a]=distance[node]+1;
                    q.add(a);

                    if(distance[a]>distance[farNode]){
                        farNode=a;
                    }
                }
            }
        }
        return new int[]{farNode, distance[farNode]};
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        ver=Integer.parseInt(br.readLine());

        for(int i=0; i<=ver; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<ver-1; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[]first=bfs(1);
        int stNode=first[0];

        int[]second=bfs(stNode);
        int secNode=second[0];
        int dia=second[1];
        pw.println(dia);
        pw.println(stNode+" "+secNode);
        pw.flush();
    }
}
