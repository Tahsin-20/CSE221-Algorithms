import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TaskE {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        ArrayList<int[]>schedule=new ArrayList<>();

        for(int i=0; i<n; i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int start=Integer.parseInt(st.nextToken());
            int end=Integer.parseInt(st.nextToken());

            schedule.add(new int[]{start,end});
        }
        Collections.sort(schedule, Comparator.comparingInt((int[]a)->a[1]).thenComparingInt(a->a[0]));
        ArrayList<int[]>result=new ArrayList<>();
        int last=-1;

        for(int i=0; i<schedule.size(); i++){
            int[]curr=schedule.get(i);

            if(curr[0]>last){
            result.add(curr);
            last=curr[1];
            }
        }
        pw.println(result.size());

        for(int i=0; i<result.size(); i++){
            int[]a=result.get(i);
            pw.println(a[0]+" "+a[1]);
        }
        pw.flush();
    }
}
