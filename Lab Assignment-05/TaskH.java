import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class TaskH {
    static int row, col;
    static boolean[][]visited;
    static char[][]mat;

    static int[]row_wise={-1, 1, 0, 0};
    static int[]col_wise={0, 0, -1, 1};

    public static int dfs(int x, int y){
        Stack<int[]>stack=new Stack<>();
        stack.push(new int[]{x,y});
        visited[x][y]=true;
        int D=0;

        while(!stack.isEmpty()){
            int[]temp=stack.pop();
            int i=temp[0];
            int j=temp[1];

            if(mat[i][j]=='D') D++;

            for(int m=0; m<4; m++){
                int row_i=i+row_wise[m];
                int col_i=j+col_wise[m];

                if(row_i>=0 && row_i<row && col_i>=0 && col_i<col){
                    if(visited[row_i][col_i]==false && mat[row_i][col_i]!='#'){
                        visited[row_i][col_i]=true;
                        stack.push(new int[]{row_i, col_i});
                    }
                }
            }
        }
        return D;
    }

    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        row=Integer.parseInt(st.nextToken());
        col=Integer.parseInt(st.nextToken());
        visited=new boolean[row][col];
        mat=new char[row][col];

        for(int i=0; i<row; i++){
            mat[i]=br.readLine().toCharArray();
        }
        int mD=0;

        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(visited[i][i]!=true && mat[i][j]!='#'){
                    int no_of_D=dfs(i,j);
                    mD=Math.max(mD, no_of_D);
                }
            }
        }
        pw.println(mD);
        pw.flush();
    }
}
