import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskA {
    static int[]parent,size;

    public static int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }

    public static void union (int a, int b){
        int root1=find(a);
        int root2=find(b);

        if(root1!=root2){
            parent[root2]=root1;
            size[root1]+=size[root2];
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int people=Integer.parseInt(st.nextToken());
        int frndship=Integer.parseInt(st.nextToken());
        parent=new int[people+1];
        size=new int[people+1];

        for(int i=1; i<=people; i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0; i<frndship; i++){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());

            union(a,b);

            pw.println(size[find(b)]);
        }
        pw.flush();

    }
}
