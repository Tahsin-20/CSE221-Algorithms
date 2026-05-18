import java.io.*;
import java.util.*;

public class Practice_2 {
    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static boolean[] visited = new boolean[26];
    static boolean[] path = new boolean[26];
    static Stack<Integer> stack = new Stack<>();
    static boolean cycle = false;

    public static void dfs(int node) {
        visited[node] = true;
        path[node] = true;

        for (int nei : adj.get(node)) {
            if (!visited[nei]) {
                dfs(nei);
            } else if (path[nei]) {
                cycle = true;
                return;
            }
        }

        path[node] = false;
        stack.push(node);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine());
        String[] words = new String[n];

        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
        }

        // Initialize graph
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int i = 0; i < n - 1; i++) {
            String w1 = words[i];
            String w2 = words[i + 1];

            int len = Math.min(w1.length(), w2.length());
            boolean found = false;

            for (int j = 0; j < len; j++) {
                if (w1.charAt(j) != w2.charAt(j)) {
                    int u = w1.charAt(j) - 'a';
                    int v = w2.charAt(j) - 'a';
                    adj.get(u).add(v);
                    found = true;
                    break;
                }
            }

            // Invalid case: prefix issue
            if (!found && w1.length() > w2.length()) {
                out.println("Impossible");
                out.flush();
                return;
            }
        }

        // Topological Sort
        for (int i = 0; i < 26; i++) {
            if (!visited[i]) {
                dfs(i);
            }
        }

        if (cycle) {
            out.println("Impossible");
        } else {
            while (!stack.isEmpty()) {
                char c = (char)(stack.pop() + 'a');
                out.print(c + " ");
            }
        }

        out.flush();
    }
}