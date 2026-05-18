import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Count_the_inversion {
    static long count=0;
    public static void main(String[]args) throws Exception{

        
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out, true);
        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        int [] arr=new int[n];

        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        mergeSrt(arr, 0, n-1);
        pw.println(count);
        for(int i=0; i<arr.length; i++){
            pw.print(arr[i]+" ");
        }
        pw.flush();
    }
    public static void mergeSrt(int[]arr, int l, int r){
        if(l<r){
            int mid=(l+r)/2;
            mergeSrt(arr, l, mid);
            mergeSrt(arr, mid+1, r);
            merge(arr, l, mid, r);
        }
    }
    public static void merge(int[]arr, int l, int mid, int r){
        int n1=mid-l+1;
        int n2=r-mid;

        int[]left=new int[n1];
        int[]right=new int[n2];

        for(int i=0; i<n1; i++){
            left[i]=arr[l+i];
        }
        for(int i=0; i<n2; i++){
            right[i]=arr[mid+1+i];
        }
        int i=0; 
        int j=0; 
        int k=l;
        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k]=left[i];
                k++;
                i++;
            }
            else{
                arr[k]=right[j];
                k++;
                j++;
                count+=(n1-i);
            }
        }
        while(i<n1){
            arr[k]=left[i];
            k++;
            i++;
        }
        while(j<n2){
            arr[k]=right[j];
            k++;
            j++;
        }
    }
}
