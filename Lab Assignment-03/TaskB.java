import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Count_the_inversions_revisited {
    public static void main(String[]args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        int n=Integer.parseInt(br.readLine());
        StringTokenizer st=new StringTokenizer(br.readLine());
        long[]arr=new long[n];

        for(int i=0; i<n; i++){
            arr[i]=Long.parseLong(st.nextToken());
        }
        long result=mergeSort(arr, 0, n-1);
        pw.print(result);
        pw.flush();
    }
    public static long mergeSort(long[]arr, int l, int r){
        if(l>=r) return 0;
         else{
            int mid=(l+r)/2;
            int count=0;
            count+=mergeSort(arr, l, mid);
            count+=mergeSort(arr, mid+1, r);
            count+=merge(arr, l, mid, r);
            return count;
         }
    }
    public static long merge(long[]arr, int l, int mid, int r){
        if(l>=r) return 0;

        int n1=mid-l+1;
        int n2=r-mid;
        int count=0;

        long[]arr1=new long[n1];
        long[]arr2=new long[n2];

        for(int i=0; i<n1; i++){
            arr1[i]=arr[l+i];
        }
        for(int i=0; i<n2; i++){
            arr2[i]=arr[mid+1+i];
        }

        for(int j=0; j<n2; j++){
            long tar=(long)arr2[j]*arr2[j];
            int low=0, high=n1-1;
            while(low<=high){
                int mid1=(low+high)/2;
                if(arr1[mid1]>tar) high=mid1-1;
                else low=mid1+1;
            }
            count+=n1-low;
        }
        int i=0; 
        int j=0; 
        int k=l;
        while(i<n1 && j<n2){
            if(arr1[i]<=arr2[j]){
                arr[k]=arr1[i];
                k++;
                i++;
            }
            else{
                arr[k]=arr2[j];
                k++;
                j++;
            }
        }
        while(i<n1){
            arr[k]=arr1[i];
            k++;
            i++;
        }
        while(j<n2){
            arr[k]=arr2[j];
            k++;
            j++;
        }
        return count;
    }
}
