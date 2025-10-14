import java.util.*;

class DistanceVectorRouting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        int[][] cost = new int[n][n];
        System.out.println("Enter cost matrix (999 for no direct link):");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                cost[i][j] = sc.nextInt();

        int[][] dist = new int[n][n];
        int[][] nextHop = new int[n][n];

        // Initialize distance and next hop tables
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = cost[i][j];
                if (i == j)
                    nextHop[i][j] = i;
                else if (cost[i][j] != 999)
                    nextHop[i][j] = j;
                else
                    nextHop[i][j] = -1;
            }
        }

        // Distance Vector update until no change
        boolean changed;
        do {
            changed = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (dist[i][k] + cost[k][j] < dist[i][j]) {
                            dist[i][j] = dist[i][k] + cost[k][j];
                            nextHop[i][j] = nextHop[i][k];
                            changed = true;
                        }
                    }
                }
            }
        } while (changed);

        // Print routing tables
        for (int i = 0; i < n; i++) {
            System.out.println("\nRouting table for Node " + i + ":");
            System.out.println("Destination\tNext Hop\tDistance");
            for (int j = 0; j < n; j++) {
                System.out.println(j + "\t\t" + nextHop[i][j] + "\t\t" + dist[i][j]);
            }
        }

        sc.close();
    }
}

// 4
// 0 1 3 999
// 1 0 1 4
// 3 1 0 2
// 999 4 2 0

// Routing table for Node 0:
// Destination	Next Hop	Distance
// 0		0		0
// 1		1		1
// 2		1		2
// 3		1		4

// Routing table for Node 1:
// Destination	Next Hop	Distance
// 0		0		1
// 1		1		0
// 2		2		1
// 3		2		3

// Routing table for Node 2:
// Destination	Next Hop	Distance
// 0		1		2
// 1		1		1
// 2		2		0
// 3		3		2

// Routing table for Node 3:
// Destination	Next Hop	Distance
// 0		2		4
// 1		2		3
// 2		2		2
// 3		3		0

