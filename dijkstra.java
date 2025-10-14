import java.util.*;
public class dijkstra {
    public static class edge{
        int to;
        int w;
        edge(int to, int w){
            this.to = to;
            this.w = w;
        }
    }

    static void dijkstra(int n, List<List<edge>> g, int src){
        int[] dist =new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a->a[1]));
        pq.add(new int[]{src,0});
        while(!pq.isEmpty()){
            int[] cur =pq.poll();
            int u=cur[0],d=cur[1];
            if(d>dist[u]) continue;
            for(edge e:g.get(u)){
                if(dist[u]+e.w<dist[e.to]){
                    dist[e.to]=dist[u]+e.w;
                    
                    pq.add(new int[]{e.to,dist[e.to]});
                }
            }
        }
        for(int i=0;i<n;i++){
            System.out.println("Distance from source to node "+i+" is "+dist[i]);
        }

    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n=s.nextInt(),m=s.nextInt();
        List<List<edge>> g = new ArrayList<>();
        for(int i=0;i<n;i++) g.add(new ArrayList<>());
        //edge input
        for(int i=0;i<m;i++){
            int u=s.nextInt(), v=s.nextInt(), w=s.nextInt();
            g.get(u).add(new edge(v,w));
            //for undirected graph
        }
        int src=s.nextInt();
        dijkstra(n,g,src);
        
    }
    
}

// 5 7
// 0 1 10
// 0 4 5
// 1 2 1
// 4 1 3
// 4 2 9
// 4 3 2
// 3 2 4
// 0

// Distance from 0 to 0 = 0
// Distance from 0 to 1 = 8
// Distance from 0 to 2 = 9
// Distance from 0 to 3 = 7
// Distance from 0 to 4 = 5

