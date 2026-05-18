import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class _220_trees_reassessed {
    static int[] inorder, postorder;
    static Map<Integer, Integer>map=new HashMap<>();
    static StringBuilder sb=new StringBuilder();

    public static void building(int inSt, int inEn, int postSt, int postEn){

        if(inSt>inEn) return;
        int root=postorder[postEn];

        sb.append(root).append(" ");
        int mid=map.get(root);
        int left=mid-inSt;

        building(inSt, mid-1, postSt, postSt+left-1);
        building(mid+1, inEn, postSt+left, postEn-1);
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int n=Integer.parseInt(br.readLine());
        inorder=new int[n];
        postorder=new int[n];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            inorder[i]=Integer.parseInt(st.nextToken());
        }
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            postorder[i]=Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++){
            map.put(inorder[i], i);
        }

        building(0, n-1, 0, n-1);
        pw.println(sb);
        pw.flush();
    }
}
