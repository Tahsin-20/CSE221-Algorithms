import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Trains {
    static class Train{
        String name;
        String line;
        int time;
        int indx;

        Train(String name, String line, int time, int indx){
            this.name=name;
            this.line=line;
            this.time=time;
            this.indx=indx;
        }
    }
    static int compare_name(String s1, String s2){

            int len=Math.min(s1.length(), s2.length());

            for(int i=0; i<len; i++){
                char c1=s1.charAt(i);
                char c2=s2.charAt(i);
                int rank1;
                if(Character.isLowerCase(c1)){
                    rank1=c1-'a';
                }
                else{
                    rank1=c1-'A'+26;
                }
                int rank2;
                if(Character.isLowerCase(c2)){
                    rank2=c2-'a';
                }
                else{
                    rank2=c2-'A'+26;
                }

                if(rank1!=rank2){
                    return rank1-rank2;
                }
            }
            return s1.length()-s2.length();
        }
    public static void main(String[]args) throws Exception{

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out, true);

        int n=Integer.parseInt(br.readLine());
        ArrayList<Train>trains=new ArrayList<>();

        for(int i=0; i<n; i++){
            String ln=br.readLine();
            StringTokenizer st=new StringTokenizer(ln);
            String name=st.nextToken();
            String time="";
            while(st.hasMoreTokens()){
                time=st.nextToken();
            }
            String[]hm=time.split(":");
            int totaltime=Integer.parseInt(hm[0])*60+Integer.parseInt(hm[1]);
            trains.add(new Train(name, ln, totaltime, i));
        }
        Collections.sort(trains, new Comparator<Train>() {
            public int compare(Train t1, Train t2){
                int train_name=compare_name(t1.name, t2.name);

                if(train_name<0) return -1;
                if(train_name>0) return 1;

                if(t1.time>t2.time) return -1;
                if(t1.time<t2.time) return 1;

                if(t1.indx<t2.indx) return -1;
                if(t1.indx>t2.indx) return 1;

                return 0;
            }
        });

        for(int i=0; i<trains.size(); i++){
            Train t=trains.get(i);
            pw.println(t.line);
        }
    }
}
