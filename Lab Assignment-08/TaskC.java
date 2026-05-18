import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
 
public class TaskC {
 
    static class Edge {
        int u, v, w;
        boolean used;
 
        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
 
    static class DSU {
 
        int[] parent, size;
 
        DSU(int n) {
 
            parent = new int[n + 1];
            size = new int[n + 1];
 
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
 
        int find(int x) {
 
            if (parent[x] == x) {
                return x;
            }
 
            return parent[x] = find(parent[x]);
        }
 
        boolean union(int a, int b) {
 
            a = find(a);
            b = find(b);
 
            if (a == b) {
                return false;
            }
 
            if (size[a] < size[b]) {
 
                int temp = a;
                a = b;
                b = temp;
            }
 
            parent[b] = a;
            size[a] += size[b];
 
            return true;
        }
    }
 
    static ArrayList<ArrayList<int[]>> adj;
    static boolean[] vis;
 
    static int bestRemove;
 
    static boolean dfs(int u, int target, int limit, int currentBest) {
 
        if (u == target) {
            bestRemove = currentBest;
            return true;
        }
 
        vis[u] = true;
 
        for (int[] e : adj.get(u)) {
 
            int v = e[0];
            int w = e[1];
 
            if (!vis[v]) {
 
                int nextBest = currentBest;
 
                
                if (w < limit) {
                    nextBest = Math.max(nextBest, w);
                }
 
                if (dfs(v, target, limit, nextBest)) {
                    return true;
                }
            }
        }
 
        return false;
    }
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
 
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
 
        ArrayList<Edge> edges = new ArrayList<>();
 
        for (int i = 0; i < m; i++) {
 
            st = new StringTokenizer(br.readLine());
 
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
 
            edges.add(new Edge(u, v, w));
        }
 
        Collections.sort(edges, Comparator.comparingInt(a -> a.w));
 
        DSU dsu = new DSU(n);
 
        adj = new ArrayList<>();
 
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
 
        long mstCost = 0;
        int cnt = 0;
 
        
        for (Edge e : edges) {
 
            if (dsu.union(e.u, e.v)) {
 
                e.used = true;
 
                mstCost += e.w;
                cnt++;
 
                adj.get(e.u).add(new int[]{e.v, e.w});
                adj.get(e.v).add(new int[]{e.u, e.w});
            }
        }
 
        
        if (cnt != n - 1) {
            pw.println(-1);
            pw.close();
            return;
        }
 
        long ans = Long.MAX_VALUE;
 
        
        for (Edge e : edges) {
 
            if (e.used) {
                continue;
            }
 
            vis = new boolean[n + 1];
            bestRemove = -1;
 
            dfs(e.u, e.v, e.w, -1);
 
 
            if (bestRemove == -1) {
                continue;
            }
 
            long newCost = mstCost + e.w - bestRemove;
 
            ans = Math.min(ans, newCost);
        }
 
        if (ans == Long.MAX_VALUE) {
            pw.println(-1);
        }
        else {
            pw.println(ans);
        }
 
        pw.close();
    }
}