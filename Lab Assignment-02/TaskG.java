import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Count_the_numbers {

    public static int lowerbound(int[]arr, int low){
        int i=0, j=arr.length;

        while(i<j){
            int mid=(i+j)/2;

            if(arr[mid]<low){
                i=mid+1;
            }
            else{
                j=mid;
            }
        }
        return i;
    }

    public static int upperbound(int[]arr, int up){
        int i=0, j=arr.length;

        while(i<j){
            int mid=(i+j)/2;

            if(arr[mid]<=up){
                i=mid+1;
            }
            else{
                j=mid;
            }
        }
        return j;
    }
    public static void main(String[]args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out, true);

        StringTokenizer st=new StringTokenizer(br.readLine());
        int len=Integer.parseInt(st.nextToken());
        int query=Integer.parseInt(st.nextToken());
        int[]arr=new int[len];
        st=new StringTokenizer(br.readLine());

        for(int i=0; i<len; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        while(query-->0){
            st=new StringTokenizer(br.readLine());
            int low=Integer.parseInt(st.nextToken());
            int up=Integer.parseInt(st.nextToken());

            int lower_i=lowerbound(arr, low);
            int upper_i=upperbound(arr, up);

            pw.println(upper_i-lower_i);
        }
    }
}
