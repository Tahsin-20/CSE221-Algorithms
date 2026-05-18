import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Two_Sum_Trouble {
    public static void main(String[]args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out, true);

        StringTokenizer st1=new StringTokenizer(br.readLine());
        int len=Integer.parseInt(st1.nextToken());
        int[]arr=new int[len];
        int sum=Integer.parseInt(st1.nextToken());

        st1=new StringTokenizer(br.readLine());
        
        for(int i=0; i<len; i++){
            arr[i]=Integer.parseInt(st1.nextToken());
        }
        int i=0;
        int j=len-1;

        while(i<j){
            if(arr[i]+arr[j]<sum){
                i++;
            }
            else if(arr[i]+arr[j]>sum){
                j--;
            }
            else{
                pw.println((i+1)+" "+(j+1));
                return;
            }
        }
        pw.println(-1);
    }
}
