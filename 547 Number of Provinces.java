class Solution {
    int provisions = 0;
    public int find(int[] parent,int index) {
        if(parent[index] == index) {
            return index;
        }
        parent[index] = find(parent,parent[index]);
        return parent[index];
    }
    public void union(int[] parent,int index1,int index2,int[] size) {
        int parent1 = find(parent,index1);
        int parent2 = find(parent,index2);
        if(parent1 == parent2) {
            return;
        }
        provisions--;
        if(size[parent1] >= size[parent2]) {
            size[parent1] += size[parent2];
            parent[parent2] = parent1;
            // parent[parent2] = parent[parent1];
        }
        else {
            size[parent2] += size[parent1];
            parent[parent1] = parent2;
            // parent[parent1] = parent[parent2];
        }

    }
    public int findCircleNum(int[][] isConnected) {
        provisions = isConnected.length;
        int[] parent = new int[isConnected.length];
        int[] size = new int[parent.length];
        for(int i =0;i < provisions;i++) {
            parent[i] = i;
            size[i] = 1;
        }
        for(int i = 0;i  < parent.length;i++) {
            for(int j = 0;j < parent.length;j++) {
                if(isConnected[i][j] == 1) {
                    union(parent,i,j,size);
                }
            }
        }
        return provisions;
    }
}
