import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class TaskH {
    public static void main(String[]args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);
        int n=Integer.parseInt(br.readLine());
        String[]words=new String[n];
        int[]indeg=new int[26];
        boolean[]present=new boolean[26];

        for(int i=0; i<n; i++){
            String a=br.readLine();
            words[i]=a;
        }

        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();

        for(int i=0; i<26; i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<n; i++){
            String curr_word=words[i];

            for(int j=0; j<curr_word.length(); j++){
                char curr_char=curr_word.charAt(j);
                int ind=curr_char-'a';
                present[ind]=true;
            }
        }
        for(int i=0; i<n-1; i++){
            String w1=words[i];
            String w2=words[i+1];

            int minL=Math.min(w1.length(), w2.length());

            boolean diff=false;

            for(int j=0; j<minL; j++){
                char c1=w1.charAt(j);
                char c2=w2.charAt(j);

                if(c1!=c2){
                    int u=c1-'a';
                    int v=c2-'a';

                    adj.get(u).add(v);
                    indeg[v]+=1;

                    diff=true;

                    break;
                }
            }
            if(diff==false && w1.length()>w2.length()){
                pw.println(-1);
                pw.flush();
                return;
            }
        }
        PriorityQueue<Integer>qp=new PriorityQueue<>();

        for(int i=0; i<26; i++){
            if(present[i]==true && indeg[i]==0){
                qp.add(i);
            }
        }
        StringBuilder sb=new StringBuilder();

        while(!qp.isEmpty()){
            int node=qp.remove();

            char c=(char)(node+'a');
            sb.append(c);
            ArrayList<Integer>neigh=adj.get(node);

            for(int i=0; i<neigh.size(); i++){
                int a=neigh.get(i);
                    indeg[a]--;
                
                if(indeg[a]==0){
                    qp.add(a);
                }
            }
        }

        for(int i=0; i<26; i++){
            if(present[i]==true && indeg[i]>0){
                pw.println(-1);
                pw.flush();
                return;
            }
        }
        pw.println(sb);
        pw.flush();
    }
}
