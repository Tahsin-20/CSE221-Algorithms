import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Longest_K_Distinct_Subarray {
    public static void main(String[]args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out, true);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int len=Integer.parseInt(st.nextToken());
        int distinct=Integer.parseInt(st.nextToken());
        int[]arr=new int[len];
        
        st=new StringTokenizer(br.readLine());

        for(int i=0; i<len; i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }

        HashMap<Integer, Integer> map=new HashMap<>();
        int j=0;
        int max=0;

        for(int i=0; i<len; i++){

            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }
            else{
                map.put(arr[i], 1);
            }
            while(map.size()>distinct){
                int repeat=map.get(arr[j])-1;

                if(repeat==0){
                    map.remove(arr[j]);
                }
                else{
                    map.put(arr[j], repeat);
                }
                j++;
            }
            max=Math.max(max, i-j+1);
        }
        pw.println(max);
    }
}
