import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Practice11 {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        int[]arr=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        int count=mergeSort(arr, 0, n-1);
        pw.println(count);
        pw.flush();
    }
    public static int mergeSort(int[]arr, int l, int r){
        if(l>=r) return 0;

        int mid=(l+r)/2;
        int count=0;
        count+=mergeSort(arr, l, mid);
        count+=mergeSort(arr, mid+1, r);
        count+=merge(arr, l, mid, r);
        return count;
    }
    public static int merge(int[]arr, int l, int mid, int r){
        if(l>=r) return 0;

        int n1=mid-l+1;
        int n2=r-mid;
        int count=0;

        int[]left=new int[n1];
        int[]right=new int[n2];

        for(int i=0; i<n1; i++){
            left[i]=arr[l+i];
        }
        for(int i=0; i<n2; i++){
            right[i]=arr[mid+1+i];
        }

        for(int j=0; j<n2; j++){
            int tar=2*right[j];
            int low=0, high=n1-1;

            while(low<=high){
                int mid1=(low+high)/2;
                if(left[mid1]>tar) high=mid1-1;
                else low=mid1+1;
            }
            count+=n1-low;
        }
        int i=0;
        int j=0;
        int k=l;

        while(i<n1 && j<n2){
            if(left[i]<=right[j]){
                arr[k++]=left[i++];
            }
            else{
                arr[k++]=right[j++];
            }
        }
        while(i<n1){
            arr[k++]=left[i++];
        }
        while(j<n2){
            arr[k++]=right[j++];
        }
        return count;
    }
}
