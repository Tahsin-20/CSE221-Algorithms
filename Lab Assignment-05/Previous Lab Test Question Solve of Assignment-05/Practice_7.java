import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class Practice_7 {
    static int row, col, k;
    static int[][]mat;
    static boolean[][]visited;
    static int[][]parentX, parentY;
    static int[]dx={1, -1, 0, 0};
    static int[]dy={0, 0, -1, 1};
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        row=Integer.parseInt(st.nextToken());
        col=Integer.parseInt(st.nextToken());
        k=Integer.parseInt(st.nextToken());
        mat=new int[row][col];
        visited=new boolean[row][col];
        parentX=new int[row][col];
        parentY=new int[row][col];
        for(int i=0; i<row; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++){
                mat[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0);

        if(visited[row-1][col-1]==false){
            pw.println(0);
            pw.flush();
            return;
        }
        ArrayList<String>path=new ArrayList<>();
        int x=row-1, y=col-1;

        while(x!=0 || y!=0){
            path.add("("+(x+1)+","+(y+1)+")");
            int px=parentX[x][y];
            int py=parentY[x][y];
            x=px;
            y=py;
        }
        path.add("(1,1)");
        Collections.reverse(path);
        for(int d=0; d<path.size(); d++){
            pw.print(path.get(d));
        }
        pw.flush();
    }
    public static void dfs(int x, int y){
        Stack<int[]>stack=new Stack<>();
        visited[x][y]=true;
        stack.push(new int[]{x,y});

        while(!stack.isEmpty()){
            int[]temp=stack.pop();
            int row_i=temp[0];
            int col_i=temp[1];

            for(int m=0; m<4; m++){
                int r=row_i+dx[m];
                int c=col_i+dy[m];
                if(r>=0 && r<row && c>=0 && c<col){
                    if(visited[r][c]==false && (Math.abs(mat[row_i][col_i]-mat[r][c]))<=k){
                        visited[r][c]=true;
                        parentX[r][c]=row_i;
                        parentY[r][c]=col_i;
                        stack.push(new int[]{r,c});
                    }
                }
            }
        }
    }
}
