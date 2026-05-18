import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TaskF {
    public static String next(String s, int p, int d){
        char[]arr=s.toCharArray();
        int digit=arr[p]-'0';
        digit=(digit+d+10)%10;
        arr[p]=(char)(digit+'0');
        return new String(arr);

    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        String strt=st.nextToken();
        String tar=st.nextToken();

        int n_forb=Integer.parseInt(br.readLine());

        HashSet<String>forbidden=new HashSet<>();
        for(int i=0; i<n_forb; i++){
            String a=br.readLine();
            forbidden.add(a);
        }
        Queue<String>q=new LinkedList<>();
        HashMap<String, Integer>distance=new HashMap<>();
        q.add(strt);
        distance.put(strt, 0);

        while(!q.isEmpty()){
            String node=q.remove();

            if(node.equals(tar)){
                pw.println(distance.get(node));
                pw.flush();
                return;
            }
            for(int i=0; i<4; i++){
                String up_increase=next(node, i, 1);
                String down_decrease=next(node, i, -1);

                if(!forbidden.contains(up_increase) && !distance.containsKey(up_increase)){
                    distance.put(up_increase, distance.get(node)+1);
                    q.add(up_increase);
                }
                if(!forbidden.contains(down_decrease) && !distance.containsKey(down_decrease)){
                    distance.put(down_decrease, distance.get(node)+1);
                    q.add(down_decrease);
                }
            }
        }
        pw.println(-1);
        pw.flush();

    }
}
