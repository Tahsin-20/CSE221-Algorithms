import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Practice10 {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        String binary=br.readLine();

        int count=countOnes(binary, 0, binary.length()-1);
        pw.println(count);
        pw.flush();

    }

    public static int countOnes(String binary, int l, int r){
        if(l==r){
            if(binary.charAt(l)=='1') return 1;
            else return 0;
        }

        int mid=(l+r)/2;
        int leftcount=countOnes(binary, l, mid);
        int rightcount=countOnes(binary, mid+1, r);

        return leftcount+rightcount;
    }
}
