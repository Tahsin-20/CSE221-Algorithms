import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class TaskB {

    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw= new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int vertices=Integer.parseInt(st.nextToken());
        int edges=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int[]u=new int[edges];
        for(int i=0; i<edges; i++){
            u[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        int[]v=new int[edges];
        for(int i=0; i<edges; i++){
            v[i]=Integer.parseInt(st.nextToken());
        }

        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0; i<=vertices; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges; i++){
            adj.get(u[i]).add(v[i]);
            adj.get(v[i]).add(u[i]);
        }
        boolean[]visited=new boolean[vertices+1];
        Stack<Integer>stack=new Stack<>();
        stack.push(1);

        while(!stack.isEmpty()){
            int node=stack.pop();

            if(visited[node]==true){
                continue;
            }

            visited[node]=true;
            pw.print(node+" ");

            ArrayList<Integer>neighbours=adj.get(node);

            for(int i=0; i<neighbours.size(); i++){
                if(visited[neighbours.get(i)]==false){
                    stack.push(neighbours.get(i));
                }
            }
        }
        pw.flush();
    }
}