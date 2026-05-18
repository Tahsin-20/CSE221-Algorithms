import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Sorting_Again {

    public static int selectionsort(int [] id, int[]marks, int count){
        for(int i=0; i<id.length-1; i++){
            int best=i;
            boolean flag=false;
            for(int j=i+1; j<id.length; j++){
                if(marks[j]>marks[best]|| (marks[j]==marks[best] && id[j]<id[best])){
                    best=j;
                    flag=true;
                }
            }
            if(flag==true){
            int temp1=marks[i];
            int temp2=id[i];
            marks[i]=marks[best];
            marks[best]=temp1;
            id[i]=id[best];
            id[best]=temp2;
            count++;
        }
    }
    return count;
}


    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out,true);

        int n=Integer.parseInt(br.readLine());

        while(n-->0){

            int T=Integer.parseInt(br.readLine());
            int[]id=new int[T];
            int[]marks=new int[T];
            StringTokenizer st=new StringTokenizer(br.readLine());

            for(int i=0; i<T; i++){
                id[i]=Integer.parseInt(st.nextToken());
            }

            st=new StringTokenizer(br.readLine());

            for(int i=0; i<T; i++){
                marks[i]=Integer.parseInt(st.nextToken());
            }
            int c=selectionsort(id, marks, 0);

            pw.println("Minimum swaps: "+c);
            for(int m=0; m<id.length; m++){
                pw.println("ID: "+id[m]+" "+"Mark: "+marks[m]);
            }
        }
    } 
}
