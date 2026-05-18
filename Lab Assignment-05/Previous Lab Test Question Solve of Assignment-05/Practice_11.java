import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice_11 {
    static boolean[]visited;
    static String[]color;
    static ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edge=Integer.parseInt(st.nextToken());
        int[]u=new int[edge];
        int[]v=new int[edge];
        visited=new boolean[ver+1];
        color=new String[ver+1];
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
        for(int i=1; i<=ver; i++){
            if(visited[i]==false){
                Queue<Integer>q=new LinkedList<>();
                visited[i]=true;
                color[i]="A";
                q.add(i);
                while(!q.isEmpty()){
                    int node=q.remove();
                    ArrayList<Integer>neigh=adj.get(node);
                    for(int j=0; j<neigh.size(); j++){       // listt[u].add(new ArrayDequueu())
                        int a=neigh.get(j);
                        if(visited[a]==false){
                            visited[a]=true;
                            if(color[node].equals("A")){
                                color[a]="B";
                            }
                            else{
                                color[a]="A";
                            }
                            q.add(a);
                        }
                        else if(color[node].equals(color[a])){
                            pw.println("X");
                            pw.flush();
                            return;
                        }
                    }
                }
            }
        }
        for(int n=1; n<=ver; n++){
            pw.print(color[n]+" ");
        }
        pw.flush();
    }
}
