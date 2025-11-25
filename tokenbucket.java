import java.util.*;

class TokenBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter bucket size: ");
        int b = sc.nextInt();

        System.out.print("Enter token rate: ");
        int r = sc.nextInt();

        System.out.print("Enter number of incoming packets: ");
        int n = sc.nextInt();

        int[] pk = new int[n];
        System.out.println("Enter packet sizes:");
        for (int i = 0; i < n; i++)
            pk[i] = sc.nextInt();

        int t = 0;

        for (int i = 0; i < n; i++) {
            t = Math.min(b, t + r);

            System.out.println("\nIncoming packet size: " + pk[i]);
            System.out.println("Tokens available: " + t);

            if (pk[i] <= t) {
                t -= pk[i];
                System.out.println("Packet sent!");
            } else {
                System.out.println("Not enough tokens! Packet dropped.");
            }

            System.out.println("Tokens left: " + t);
        }

        sc.close();
    }
}

//input
// Enter bucket size: 10
// Enter token rate: 3
// Enter number of incoming packets: 5
// Enter packet sizes:
// 4 5 2 8 6

//output
// Enter bucket size: 10
// Enter token rate: 3
// Enter number of incoming packets: 5
// Enter packet sizes:
// 4 5 2 8 6

// Incoming packet size: 4
// Tokens available: 3
// Not enough tokens! Packet dropped.
// Tokens left: 3

// Incoming packet size: 5
// Tokens available: 6
// Packet sent!
// Tokens left: 1

// Incoming packet size: 2
// Tokens available: 4
// Packet sent!
// Tokens left: 2

// Incoming packet size: 8
// Tokens available: 5
// Not enough tokens! Packet dropped.
// Tokens left: 5

// Incoming packet size: 6
// Tokens available: 8
// Packet sent!
// Tokens left: 2






