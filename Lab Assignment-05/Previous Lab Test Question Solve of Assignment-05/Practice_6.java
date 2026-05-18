import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Practice_6 {
    static boolean[]visited;
    static boolean[]path;
    static int[]parent;
    static int start, end;
    static ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

    public static boolean dfs(int i){
        visited[i]=true;
        path[i]=true;

        ArrayList<Integer>neigh=adj.get(i);
        for(int j=0; j<neigh.size(); j++){
            int curr=neigh.get(j);
            if(visited[curr]==false){
                parent[curr]=i;
                if(dfs(curr)==true) return true;
            }
            else if(path[curr]==true){
                start=curr;
                end=i;
                return true;
            }
        }
        path[i]=false;
        return false;

    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edg=Integer.parseInt(st.nextToken());
        visited=new boolean[ver+1];
        path=new boolean[ver+1];
        parent=new int[ver+1];

        for(int i=0; i<=ver; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edg; i++){
            st=new StringTokenizer(br.readLine());
            int u=Integer.parseInt(st.nextToken());
            int v=Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
        }
        for(int i=1; i<=ver; i++){
            if(visited[i]==false){
                if(dfs(i)==true){
                    ArrayList<Integer>cycle=new ArrayList<>();
                    cycle.add(start);
                    int curr=end;
                    while(curr!=start){
                        cycle.add(curr);
                        curr=parent[curr];
                    }
                    cycle.add(start);
                    Collections.reverse(cycle);
                    for(int n=0; n<cycle.size(); n++){
                        pw.print(cycle.get(n));
                        if(n<cycle.size()-1) pw.print("->");
                    }
                    pw.flush();
                    return;
                }
            }
        }
        pw.println(0);
        pw.flush();

    }
}

