import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TaskA {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int vertices=Integer.parseInt(st.nextToken());
        int edges=Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0; i<=vertices; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges; i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[]visited=new boolean[vertices+1];
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        visited[1]=true;

        while(!q.isEmpty()){
            int node=q.remove();
            pw.print(node+" ");

            ArrayList<Integer>neighbours=adj.get(node);
            for(int i=0; i<neighbours.size(); i++){
                int a=neighbours.get(i);
                if(visited[a]==false){
                    visited[a]=true;
                    q.add(a);
                }
            }
        }
        pw.flush();
    }
}
