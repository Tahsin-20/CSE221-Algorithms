import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A_Beautiful_Sorted_List {
    public static void main(String[]args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out,true);

        int n=Integer.parseInt(br.readLine());
        int[]arr1=new int[n];
        StringTokenizer st=new StringTokenizer(br.readLine());

        for(int i=0; i<n; i++){
            arr1[i]=Integer.parseInt(st.nextToken());
        }

        int m=Integer.parseInt(br.readLine());
        int[]arr2=new int[m];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++){
            arr2[i]=Integer.parseInt(st.nextToken());
        }
        int[]result=new int[n+m];

        int i=0, j=0, k=0;

        while(i<arr1.length && j<arr2.length){

            if(arr1[i]>arr2[j]){
                result[k]=arr2[j];
                k++;
                j++;
            }
            else{
                result[k]=arr1[i];
                k++;
                i++;
            }
        }
        if(i<arr1.length){
            while(i<arr1.length){
                result[k]=arr1[i];
                k++;
                i++;
            }
        }
        else if(j<arr2.length){
            while(j<arr2.length){
                result[k]=arr2[j];
                k++;
                j++;
            }
        }
        for(int l=0; l<result.length; l++){
            pw.print(result[l]+" ");
        }
        pw.flush();
    }
}
