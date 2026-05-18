import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Two_Sum_Revisited {
    public static void main (String[]args) throws Exception{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out,true);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        Long sum=Long.parseLong(st.nextToken());

        Long[]arr1=new Long[a];
        Long[]arr2=new Long[b];

        StringTokenizer st1=new StringTokenizer(br.readLine());

        for(int i=0; i<a; i++){
            arr1[i]=Long.parseLong(st1.nextToken());
        }

        StringTokenizer st2=new StringTokenizer(br.readLine());

        for(int i=0; i<b; i++){
            arr2[i]=Long.parseLong(st2.nextToken());
        }

        int i=0, j=b-1;

        long bestd=Long.MAX_VALUE;
        int bi=0, bj=0;

        while(i<a && j>=0){
            long bestsum=arr1[i]+arr2[j];
            long diff=Math.abs(bestsum-sum);

            if(diff<bestd){
                bestd=diff;
                bi=i;
                bj=j;
            }
            if(arr1[i]+arr2[j]<sum){
                i++;
            }
            else if(arr1[i]+arr2[j]>sum){
                j--;
            }
            else{
                break;
            }
        }
        pw.println((bi+1)+" "+(bj+1));
    }
}
