import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Practice_4 {
    static int[]gold;
    static boolean[]visited;
    static ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
    static int maxGold=0;
    static int bestNode=-1;
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edge=Integer.parseInt(st.nextToken());
        gold=new int[ver+1];
        visited=new boolean[ver+1];
        st=new StringTokenizer(br.readLine());
        for(int i=1; i<=ver; i++){
            gold[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<=ver; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edge; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        dfs(1, 0);
        pw.println(maxGold);
        pw.flush();
    }
    public static void dfs(int node, int currSum){
        Stack<int[]>stack=new Stack<>();
        stack.push(new int[]{node, gold[node]});
        visited[node]=true;
        
        while(!stack.isEmpty()){
            int[]n=stack.pop();
            int nod=n[0];
            int g=n[1];
            if(g>maxGold){
                maxGold=g;
                bestNode=nod;
            }
            ArrayList<Integer>neigh=adj.get(nod);
            for(int i=0; i<neigh.size(); i++){
                int a=neigh.get(i);
                if(visited[a]!=true){
                    visited[a]=true;
                    stack.push(new int[]{a, g+gold[a]});
                }
            }
        }
    }
}
