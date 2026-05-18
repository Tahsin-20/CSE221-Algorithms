import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TaskG {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        String source=st.nextToken();
        String dest=st.nextToken();

        String[]words=new String[n];
        for(int i=0; i<n; i++){
            String a=br.readLine();
            words[i]=a;
        }
        HashMap<Character, ArrayList<String>>map=new HashMap<>();

        for(int i=0; i<n; i++){
            String w=words[i];
            char firstC=w.charAt(0);

            if(!map.containsKey(firstC)){
                map.put(firstC, new ArrayList<>());
            }
            map.get(firstC).add(w);
        }
        Queue<String>q=new LinkedList<>();
        HashSet<String>visited=new HashSet<>();
        q.add(source);
        visited.add(source);

        while(!q.isEmpty()){
            String curr_word=q.remove();

            if(curr_word.equals(dest)){
                pw.println("YES");
                pw.flush();
                return;
            }

            char lastC=curr_word.charAt(curr_word.length()-1);

            if(map.containsKey(lastC)){
                ArrayList<String>next=map.get(lastC);

                for(int i=0; i<next.size(); i++){
                    String nextword=next.get(i);

                    if(visited.contains(nextword)==false){
                        visited.add(nextword);
                        q.add(nextword);
                    }
                }
                map.remove(lastC);
            }
        }
        pw.println("NO");
        pw.flush();
    }
}
