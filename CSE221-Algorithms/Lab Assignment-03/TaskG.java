import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _220_trees {
    static int[]preorder, inorder;
    static int preIndx=0;
    static Map<Integer, Integer>map=new HashMap<>();
    static StringBuilder sb=new StringBuilder();

    public static void building(int inSt, int inEn){

        if(inSt>inEn) return;

        int root=preorder[preIndx++];
        int mid=map.get(root);

        building(inSt, mid-1);
        building(mid+1, inEn);

        sb.append(root).append(" ");
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        preorder=new int[n];
        inorder=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            inorder[i]=Integer.parseInt(st.nextToken());
        }

        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            preorder[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<n; i++){
            map.put(inorder[i],i);
        }
        
        building(0, n-1);
        pw.println(sb);
        pw.flush();
    }
}
