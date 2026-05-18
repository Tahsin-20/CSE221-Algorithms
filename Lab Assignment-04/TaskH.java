import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TaskH {

    public static int gcd(int a, int b){
        while(a%b!=0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        return b;
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int q=Integer.parseInt(st.nextToken());

        ArrayList<Integer>[]adj=new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            adj[i]=new ArrayList<>();
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i!=j && gcd(i,j)==1){
                    adj[i].add(j);
                }
            }
        }
        while(q-->0){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int k=Integer.parseInt(st.nextToken());

            if(k<=adj[x].size()){
                pw.println(adj[x].get(k-1));
            }
            else{
                pw.println(-1);
            }
        }
        pw.flush();
    }
}
