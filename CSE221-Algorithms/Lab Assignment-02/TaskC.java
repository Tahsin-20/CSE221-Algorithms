import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Triple_The_Trouble {

    static class Pair{
        long value;
        int indx;

        Pair(long value, int indx){
            this.value=value;
            this.indx=indx;
        }
    }
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out, true);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        long target=Long.parseLong(st.nextToken());

        Pair[]arr=new Pair[n];
        st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            long value=Long.parseLong(st.nextToken());
            arr[i]=new Pair(value, i+1);
        }

        for(int i=0; i<n-1; i++){
            boolean flag=false;
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j].value>arr[j+1].value){
                    Pair temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            if(flag==false){
                break;
            }
        }
        for(int i=0; i<n-2; i++){
            int left=i+1;
            int right=n-1;

            while(left<right){
                long sum=arr[i].value+arr[left].value+arr[right].value;

                if(sum<target){
                    left++;
                }
                else if(sum>target){
                    right--;
                }
                else{
                    pw.println(arr[i].indx+" "+arr[left].indx+" "+arr[right].indx);
                    return;
                }
            }
        }
        pw.println(-1);
    }
}
