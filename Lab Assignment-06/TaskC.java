import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TaskC {
    static int[]dx={-2, -2, -1, -1, 1, 1, 2, 2};
    static int[]dy={-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int row=Integer.parseInt(br.readLine());

        StringTokenizer st=new StringTokenizer(br.readLine());
        int x1=Integer.parseInt(st.nextToken())-1;
        int y1=Integer.parseInt(st.nextToken())-1;
        int x2=Integer.parseInt(st.nextToken())-1;
        int y2=Integer.parseInt(st.nextToken())-1;

        boolean[][]visited=new boolean[row][row];
        Queue<int[]>q=new LinkedList<>();

        q.add(new int[]{x1, y1, 0});
        visited[x1][y1]=true;

        while(!q.isEmpty()){
            int[]curr=q.remove();
            int x=curr[0], y=curr[1], steps=curr[2];

            if(x==x2 && y==y2){
                pw.println(steps);
                pw.flush(); 
                return;
            }

            for(int i=0; i<8; i++){
                int x_i=x+dx[i];
                int y_i=y+dy[i];

                if(x_i>=0 && x_i<row && y_i>=0 && y_i<row && visited[x_i][y_i]==false){
                    visited[x_i][y_i]=true;
                    q.add(new int[]{x_i, y_i, steps+1});
                }
            }
        }
        pw.println(-1);
        pw.flush();

    }

}
