class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        solution sol = new solution();
        return sol.networkDelayTime(times,n,k);
    }
}

class Pair {
    int parent;
    int distance;
    public Pair(int parent,int distance) {
        this.parent = parent;
        this.distance = distance;
    }
}
class Edge {
    int destination;
    int weight;
    public Edge(int destination,int weight) {
        this.destination = destination;
        this.weight = weight;
    }
}
class solution {
    public int networkDelayTime(int[][] times,int n,int k) {
        List<List<Edge>> list = new ArrayList<>();
        for(int i =0;i < n;i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0;i < times.length;i++) {
            list.get(times[i][0] - 1).add(new Edge(times[i][1] - 1,times[i][2]));
        }
        PriorityQueue<Pair> que = new PriorityQueue<>((p1,p2)->Integer.compare(p1.distance,p2.distance));
        que.add(new Pair(k - 1,0));
        boolean[] visited = new boolean[n];
        int[] distance1 = new int[n];
        Arrays.fill(distance1,Integer.MAX_VALUE);
        distance1[k - 1] =0;
        while(que.size() > 0) {
            int parent = que.peek().parent;
            int distance = que.peek().distance;
            que.poll();
            if(!visited[parent]) {
                visited[parent] = true;
                for(Edge e:list.get(parent)) {
                    if(!visited[e.destination]) {
                    if(distance + e.weight < distance1[e.destination]) {
                        distance1[e.destination] = distance + e.weight;
                        que.add(new Pair(e.destination,distance + e.weight));
                    }
                    }
                }
            }
            
        }
        for(int i =0;i < visited.length;i++) {
                if(!visited[i]) {
                    return -1;
                }
        }
        int max = 0;
        for(int i =0;i < distance1.length;i++) {
            max = Math.max(max,distance1[i]);
        }
        return max;
    }
}
