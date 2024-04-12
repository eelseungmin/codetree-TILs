import java.util.*;

public class Main {
    static int n, m;
    static boolean[] vis;
    static List<Integer>[] graph;
    static int ans;

    public static void main(String[] args) {
        // 여기에 코드를 작성해주세요.
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        vis = new boolean[n + 1];
        graph = new ArrayList[n + 1];
        ans = 0;
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        vis[1] = true;
        dfs(1);

        System.out.print(ans);
    }

    static void dfs(int vertex) {
        for (int i = 0; i < graph[vertex].size(); i++) {
            int cur = graph[vertex].get(i);
            
            if (!vis[cur]) {
                vis[cur] = true;
                ans++;
                dfs(cur);
            }
        }
    }
}