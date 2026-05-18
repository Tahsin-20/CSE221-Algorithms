import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class TaskF {
    public static void main(String[]args) throws Exception{
        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int row=Integer.parseInt(st.nextToken());
        int col=Integer.parseInt(st.nextToken());
        int count=0;
        ArrayList<String>list=new ArrayList<>();

        if(row-1!=0 && col-1!=0){
            count++;
            list.add((row-1)+" "+(col-1));
        }
        if(row-1!=0){
            count++;
            list.add((row-1)+" "+(col));
        }
        if(row-1!=0 && col+1<=n){
            count++;
            list.add((row-1)+" "+(col+1));
        }
        if(col-1!=0){
            count++;
            list.add((row)+" "+(col-1));
        }
        if(col+1<=n){
            count++;
            list.add((row)+" "+(col+1));
        }
        if(row+1<=n && col-1!=0){
            count++;
            list.add((row+1)+" "+(col-1));
        }
        if(row+1<=n){
            count++;
            list.add((row+1)+" "+(col));
        }
        if(row+1<=n && col+1<=n){
            count++;
            list.add((row+1)+" "+(col+1));
        }
        pw.println(count);
        for(int i=0; i<list.size(); i++){
            pw.println(list.get(i));
        }
        pw.flush();
    }
}
