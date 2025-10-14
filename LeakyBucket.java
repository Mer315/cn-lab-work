import java.util.*;

class LeakyBucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter bucket size: ");
        int bucketSize = sc.nextInt();

        System.out.print("Enter output rate: ");
        int outputRate = sc.nextInt();

        System.out.print("Enter number of incoming packets: ");
        int n = sc.nextInt();

        int[] packets = new int[n];
        System.out.println("Enter packet sizes:");
        for (int i = 0; i < n; i++)
            packets[i] = sc.nextInt();

        int stored = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("\nIncoming packet size: " + packets[i]);

            if (packets[i] + stored > bucketSize) {
                int dropped = (packets[i] + stored) - bucketSize;
                System.out.println("Bucket overflow! Dropped " + dropped + " packets.");
                stored = bucketSize;
            } else {
                stored += packets[i];
            }

            System.out.println("Packets in bucket: " + stored);

            // send out packets at output rate
            stored -= outputRate;
            if (stored < 0) stored = 0;

            System.out.println("After sending, packets left: " + stored);
        }

        // empty remaining packets
        while (stored > 0) {
            System.out.println("\nSending remaining packets...");
            stored -= outputRate;
            if (stored < 0) stored = 0;
            System.out.println("Packets left: " + stored);
        }

        sc.close();
    }
}

// Enter bucket size: 10
// Enter output rate: 4
// Enter number of incoming packets: 5
// Enter packet sizes:
// 3 6 4 2 5

// Incoming packet size: 3
// Packets in bucket: 3
// After sending, packets left: 0

// Incoming packet size: 6
// Packets in bucket: 6
// After sending, packets left: 2

// Incoming packet size: 4
// Packets in bucket: 6
// After sending, packets left: 2

// Incoming packet size: 2
// Packets in bucket: 4
// After sending, packets left: 0

// Incoming packet size: 5
// Packets in bucket: 5
// After sending, packets left: 1

// Sending remaining packets...
// Packets left: 0
