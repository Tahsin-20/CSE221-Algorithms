import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TaskB {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
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
            adj.get(v).add(u);
        }
        boolean[]visited=new boolean[ver+1];
        char[]color=new char[ver+1];
        int ans=0;

        for(int i=1; i<=ver; i++){
            if(visited[i]==false){
                Queue<Integer>q=new LinkedList<>();
                q.add(i);
                visited[i]=true;
                color[i]='B';
                int cB=1, cG=0;

                while(!q.isEmpty()){
                    int node=q.remove();
                    ArrayList<Integer>neigh=adj.get(node);

                    for(int j=0; j<neigh.size(); j++){
                        int a=neigh.get(j);
                        if(visited[a]==false){
                            visited[a]=true;

                            if(color[node]=='B'){
                                color[a]='G';
                                cG++;
                            }
                            else{
                                color[a]='B';
                                cB++;
                            }
                            q.add(a);
                        }
                    }
                }
                ans+=Math.max(cG, cB);
            }
        }
        pw.println(ans);
        pw.flush();
    }
}
