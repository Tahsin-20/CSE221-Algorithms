import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Reverse_Sorting {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out,true);
        int n=Integer.parseInt(br.readLine());
        int count=0;
        List<String>store=new ArrayList<>();
        boolean flag=true;

        int[]arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());

        if(n==1){
            pw.println("YES");
            pw.println(0);
            return;
        }
        else if(n==2){
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());

            if(x<=y){
                pw.println("YES");
                pw.println(0);
            }
            else{
                pw.println("NO");
            }
            return;
        }

        for(int i=0; i<arr.length; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<arr.length-1; i++){
            for(int j=1; j<arr.length-1; j++){
                if(arr[j-1]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j-1];
                    arr[j-1]=temp;
                    count++;
                    store.add(j+" "+(j+2));
                }
            }
        }
        for(int i=1; i<arr.length; i++){
            if(arr[i]<arr[i-1]){
                pw.println("NO");
                flag=false;
                return;
            }
        }
        if(flag==true){
            pw.println("YES");
            pw.println(count);

            for(int i=0; i<store.size(); i++){
                pw.println(store.get(i));
            }
        }
    }
}
