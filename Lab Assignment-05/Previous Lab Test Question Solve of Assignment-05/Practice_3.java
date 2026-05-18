import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Practice_3 {
    static int row, col;
    static boolean[][]visited;
    static char[][]mat;
    static int[]rowwise={1, -1, 0, 0};
    static int[]colwise={0, 0, 1, -1};
    static int player1=0;
    static int player2=0;
    
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        row=Integer.parseInt(st.nextToken());
        col=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int row_1=Integer.parseInt(st.nextToken());
        int col_1=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        int row_2=Integer.parseInt(st.nextToken());
        int col_2=Integer.parseInt(st.nextToken());
        visited=new boolean[row][col];
        mat=new char[row][col];

        for(int i=0; i<row; i++){
            mat[i]=br.readLine().toCharArray();
        }
        player1=bfs(row_1, col_1, 0);
        visited=new boolean[row][col];
        player2=bfs(row_2, col_2, 0);

        if(player1 == -1 && player2 == -1){
            pw.println("Tie");
}
else if(player1 == -1){
    pw.println("Player 2");
}
else if(player2 == -1){
    pw.println("Player 1");
}
else if(player1 < player2){
    pw.println("Player 1");
}
else if(player2 < player1){
    pw.println("Player 2");
}
else{
    pw.println("Tie");
}
        pw.flush();
    }
    public static int bfs(int i, int j, int edge){
        int[][]dist=new int[row][col];
        Queue<int[]>q=new LinkedList<>();
        q.add(new int[]{i, j});
        visited[i][j]=true;
        dist[i][j]=0;

        while(!q.isEmpty()){
            int[]node=q.remove();
            
            int r_i=node[0];
            int c_i=node[1];
            if(mat[r_i][c_i]=='D') return dist[r_i][c_i];
            for(int m=0; m<4; m++){
                int row_i=r_i+rowwise[m];
                int col_i=c_i+colwise[m];

                if(row_i>=0 && row_i<row && col_i>=0 && col_i<col){
                    if(visited[row_i][col_i]==false && mat[row_i][col_i]!='W'){
                        visited[row_i][col_i]=true;
                        dist[row_i][col_i]=dist[r_i][c_i]+1;
                        q.add(new int[]{row_i, col_i});
                    }
                }
            }
        }
        return -1;
    }
}
