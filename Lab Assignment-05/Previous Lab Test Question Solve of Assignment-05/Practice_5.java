import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Practice_5 {
    static int row, col;
    static boolean[][]visited;
    static int[][]mat;
    static int[]dx={-1, -1, 1, 1};
    static int[]dy={-1, 1, -1, 1};
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int posr=Integer.parseInt(st.nextToken());
        int posc=Integer.parseInt(st.nextToken());
        int c=Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        row=Integer.parseInt(st.nextToken());
        col=Integer.parseInt(st.nextToken());
        visited=new boolean[row][col];
        mat=new int[row][col];
        for(int i=0; i<row; i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0; j<col; j++){
                mat[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        Stack<int[]>stack=new Stack<>();
        stack.push(new int[]{posr, posc});
        visited[posr][posc]=true;
        while(!stack.isEmpty()){
            int[]temp=stack.pop();
            int i=temp[0];
            int j=temp[1];
            if(mat[i][j]!=0){
                mat[i][j]=c;
            }
            for(int m=0; m<4; m++){
                int row_i=i+dx[m];
                int col_i=j+dy[m];

                if(row_i>=0 && row_i<col && col_i>=0 && col_i<col){
                    if(visited[row_i][col_i]==false){
                        visited[row_i][col_i]=true;
                        stack.push(new int[]{row_i, col_i});
                    }
                }
            }
        }
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                pw.print(mat[i][j]+" ");
            }
            pw.println();
        }
        pw.flush();
    }
}
