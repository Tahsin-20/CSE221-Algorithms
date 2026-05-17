import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Is_sorted {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out, true);

        int n=Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++){
            boolean bool=true;
            int len=Integer.parseInt(br.readLine());
            int[]arr=new int[len];

            StringTokenizer st=new StringTokenizer(br.readLine());

            for(int j=0; j<arr.length; j++){
                arr[j]=Integer.parseInt(st.nextToken());
            }
            for(int l=0; l<arr.length-1; l++){
                if(arr[l]>arr[l+1]){
                    bool=false;
                    break;
                }
            }
            if(bool==true){
                pw.println("YES");
            }
            else{
                pw.println("NO");
            }

        }
    }
}
