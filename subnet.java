import java.util.*;

class subnet{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of hosts and links: ");
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] cost = new int[n][n];
        for (int[] row : cost) Arrays.fill(row, 9999);
        System.out.println("Enter links (u v cost):");
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            cost[u][v] = w;
            cost[v][u] = w;
        }
        int[] vis = new int[n];
        vis[0] = 1;
        int total = 0;

        System.out.println("\nBroadcast Tree:");
        for (int e = 0; e < n - 1; e++) {
            int min = 9999, a = -1, b = -1;
            for (int i = 0; i < n; i++) {
                if (vis[i] == 1) {
                    for (int j = 0; j < n; j++) {
                        if (cost[i][j] < min && vis[j] == 0) {
                            min = cost[i][j];
                            a = i; b = j;
                        }
                    }
                }
            }
            vis[b] = 1;
            total += min;
            System.out.println("Host " + a + " → Host " + b + " (cost " + min + ")");
        }

        System.out.println("Total cost: " + total);
        sc.close();
    }
}
// 5 7
// 0 1 2
// 0 3 6
// 1 2 3
// 1 3 8
// 1 4 5
// 2 4 7
// 3 4 9

// Broadcast Tree:
// Host 0 → Host 1 (cost 2)
// Host 1 → Host 2 (cost 3)
// Host 1 → Host 4 (cost 5)
// Host 0 → Host 3 (cost 6)
// Total cost: 16


