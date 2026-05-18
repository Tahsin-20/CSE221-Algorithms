import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class TaskF {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int test=Integer.parseInt(br.readLine());

        while(test-->0){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int activites=Integer.parseInt(st.nextToken());
            int people=Integer.parseInt(st.nextToken());

            ArrayList<int[]>arr=new ArrayList<>();

            for(int i=0; i<activites; i++){
                st=new StringTokenizer(br.readLine());

                int s=Integer.parseInt(st.nextToken());
                int e=Integer.parseInt(st.nextToken());

                arr.add(new int[]{s,e});
            }
            Collections.sort(arr, Comparator.comparingInt((int[]a)->a[1]).thenComparingInt(a->a[0]));
            TreeMap<Integer, Integer>map=new TreeMap<>();
            map.put(-1,people);
            int result=0;

            for(int i=0; i<arr.size(); i++){
                int[]a=arr.get(i);
                int s=a[0];
                int e=a[1];
                Integer t=map.lowerKey(s);

                if(t==null) continue;
                result++;

                int freq=map.get(t);

                if(freq==1) map.remove(t);
                else map.put(t, freq-1);

                map.put(e, map.getOrDefault(e, 0)+1);
            }
            pw.println(result);
        }
        pw.flush();
    }
}
