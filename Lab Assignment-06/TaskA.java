import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class TaskA {

    public static boolean dfs(boolean[]path, boolean[]visited, Stack<Integer>stack, ArrayList<ArrayList<Integer>>adj, int start){
        visited[start]=true;
        path[start]=true;
        ArrayList<Integer>neigh=adj.get(start);
        for(int j=0; j<neigh.size(); j++){
            int curr=neigh.get(j);
            if(visited[curr]==false){
                if(dfs(path, visited, stack, adj, curr)==true) return true;
            }
            else if(path[curr]==true) return true;
        }
        path[start]=false;
        stack.push(start);
        return false;
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int test=Integer.parseInt(br.readLine());

        while(test-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int ver=Integer.parseInt(st.nextToken());
            int edge=Integer.parseInt(st.nextToken());
            ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
            for(int i=0; i<=ver; i++){
                adj.add(new ArrayList<>());
            }

            for(int i=0; i<edge; i++){
                st=new StringTokenizer(br.readLine());
                int u=Integer.parseInt(st.nextToken());
                int v=Integer.parseInt(st.nextToken());

                adj.get(u).add(v);
            }
            boolean[]visited=new boolean[ver+1];
            boolean[]path=new boolean[ver+1];
            Stack<Integer>stack=new Stack<>();
            boolean hasCycle=false;
            for(int i=1; i<=ver; i++){
                if(visited[i]==false){
                    if(dfs(path, visited, stack, adj, i)==true){
                        hasCycle=true;
                        break;
                    }
                }
            }
            if(hasCycle==true){
                pw.println(-1);
            }
            else{
                while(!stack.isEmpty()){
                    pw.print(stack.pop()+" ");
                }
            }
        }
        pw.flush();
    }
}
