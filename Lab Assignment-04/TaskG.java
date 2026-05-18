import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class TaskG {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int row=Integer.parseInt(st.nextToken());
        int col=Integer.parseInt(st.nextToken());
        int number=Integer.parseInt(st.nextToken());
        int[]x=new int[number];
        int[]y=new int[number];
        Set<String>set=new HashSet<>();

        for(int i=0; i<number; i++){
            st=new StringTokenizer(br.readLine());
            x[i]=Integer.parseInt(st.nextToken());
            y[i]=Integer.parseInt(st.nextToken());
            set.add(x[i]+" "+y[i]);
        }
        int[]dx={-2,-2,2,2,-1,-1,1,1};
        int[]dy={-1,1,-1,1,-2,2,-2,2};

        for(int i=0; i<number; i++){
            for(int j=0; j<8; j++){
                int nx=x[i]+dx[j];
                int ny=y[i]+dy[j];

                if(set.contains(nx+" "+ny)){
                    pw.println("YES");
                    pw.flush();
                    return;
                }
            }
        }
        pw.println("NO");
        pw.flush();
    }
}
