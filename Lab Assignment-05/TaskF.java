import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class TaskF {
    static ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
    static int[]subtree;
    static boolean[]visited;
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int nodes=Integer.parseInt(st.nextToken());
        int root=Integer.parseInt(st.nextToken());

        for(int i=0; i<=nodes; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<nodes-1; i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        subtree = new int[nodes+1];
        visited = new boolean[nodes+1];
        computeSubtree(root);
        int q=Integer.parseInt(br.readLine());

        while(q-->0){
            int x=Integer.parseInt(br.readLine());
            pw.println(subtree[x]);
        }
        pw.flush();
    }
    public static void computeSubtree(int root){
        Stack<Integer>stack=new Stack<>();
        Stack<Integer>tree=new Stack<>();
        stack.push(root);
        visited[root]=true;

        while(!stack.isEmpty()){
            int node=stack.pop();
            tree.push(node);

            ArrayList<Integer>nei=adj.get(node);

            for(int i=0; i<nei.size(); i++){
                int a=nei.get(i);
                if(visited[a]==false){
                    visited[a]=true;
                    stack.push(a);
                }
            }
        }
        while(!tree.isEmpty()){
            int n=tree.pop();
            subtree[n]=1;

            ArrayList<Integer>next=adj.get(n);
            for(int i=0; i<next.size(); i++){
                int b=next.get(i);
                if(subtree[b]>0){
                    subtree[n]+=subtree[b];
                }
            }
        }
    }
}
