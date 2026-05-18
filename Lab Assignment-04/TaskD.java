import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskD {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int ver=Integer.parseInt(st.nextToken());
        int edg=Integer.parseInt(st.nextToken());
        int[]u=new int[edg];
        int[]v=new int[edg];

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<edg; i++){
            u[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<edg; i++){
            v[i]=Integer.parseInt(st.nextToken());
        }
        int[]deg=new int[ver+1];
        for(int i=0; i<edg; i++){
            if(u[i]==v[i]){
                deg[u[i]]+=2;
            }
            else{
                deg[u[i]]++;
                deg[v[i]]++;
            }
        }
        int odd=0;
        for(int i=1; i<=ver; i++){
            if(deg[i]%2!=0){
                odd++;
            }
        }
        if(odd==0 || odd==2){
            pw.println("YES");
        }
        else{
            pw.println("NO");
        }
        pw.flush();

    }
}
