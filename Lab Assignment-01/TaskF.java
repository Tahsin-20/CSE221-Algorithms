import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class An_Ancient_Sorting_Algo {
    public static void main(String[]args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int n=Integer.parseInt(br.readLine());
        int[]arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());
        boolean flag=true;

        for(int i=0; i<arr.length; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        while(flag){
            flag=false;
            for(int i=0; i<arr.length-1; i++){
                if((arr[i]%2==arr[i+1]%2)&&arr[i]>arr[i+1]){
                    int temp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=temp;
                    flag=true;
                }            
            }
        }
        for(int i=0; i<arr.length; i++){
            pw.print(arr[i]+" ");
        }
        pw.close();
    }
}
