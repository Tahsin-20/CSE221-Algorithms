import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Practice_10 {
    static int nodecount;
    static int edgecount;
    static boolean[]visited;
    static ArrayList<ArrayList<Integer>>adj=new  ArrayList<>();
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edge=Integer.parseInt(st.nextToken());
        int[]u=new int[edge];
        int[]v=new int[edge];
        visited=new boolean[ver+1];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<edge; i++){
            u[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<edge; i++){
            v[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<=ver; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edge; i++){
            adj.get(u[i]).add(v[i]);
            adj.get(v[i]).add(u[i]);
        }
        Stack<Integer>stack=new Stack<>();
        visited[ver]=true;
        stack.push(ver);
        while(!stack.isEmpty()){
            int node=stack.pop();
            nodecount++;

            ArrayList<Integer>neigh=adj.get(node);
            for(int i=0; i<neigh.size(); i++){
                int a=neigh.get(i);
                edgecount++;
                if(visited[a]==false){
                    visited[a]=true;
                    stack.push(a);
                }
            }
        }
        pw.println(nodecount+" "+(edgecount/2));
        pw.flush();
    }
}
