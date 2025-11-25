import java.util.*;

public class DijkstraSimple {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];
        System.out.println("Enter cost matrix (999 for no link):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = sc.nextInt();

        System.out.print("Enter source node: ");
        int src = sc.nextInt();

        int[] dist = new int[n];
        boolean[] vis = new boolean[n];

        Arrays.fill(dist, 999);
        dist[src] = 0;

        for (int c = 0; c < n - 1; c++) {

            int u = -1, min = 999;
            for (int i = 0; i < n; i++)
                if (!vis[i] && dist[i] < min) {
                    min = dist[i];
                    u = i;
                }

            vis[u] = true;

            for (int v = 0; v < n; v++) {
                if (!vis[v] && cost[u][v] != 999 &&
                    dist[u] + cost[u][v] < dist[v]) {
                    dist[v] = dist[u] + cost[u][v];
                }
            }
        }

        // output
        System.out.println("\nShortest distances from source " + src + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("To node " + i + " = " + dist[i]);
        }

        sc.close();
    }
}


// 5
// 0 10 999 999 5
// 999 0 1 999 3
// 999 999 0 4 9
// 999 999 999 0 2
// 999 999 999 999 0
// 0

// Shortest Distances from Source 0:
// To node 0 = 0
// To node 1 = 8
// To node 2 = 9
// To node 3 = 7
// To node 4 = 5

