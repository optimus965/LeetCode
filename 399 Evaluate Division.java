class Solution {
    double value1 = 0;
    boolean visited = false;
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        Map<String,Integer> map =new HashMap<>();
        int count = 0;
        for(int i =0;i < equations.size();i++) {
            List<String> list1 = equations.get(i);
            if(!map.containsKey(list1.get(0))) {
                map.put(list1.get(0),count++);
            }
            if(!map.containsKey(list1.get(1))) {
                map.put(list1.get(1),count++);
            }
        }
        List<List<Pair>> list = new ArrayList<>();
        for(int i =0;i < count;i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0;i < equations.size();i++) {
            List<String> list1 = equations.get(i);
            int index1 = map.get(list1.get(0));
            int index2 = map.get(list1.get(1));
            list.get(index1).add(new Pair(index2,values[i]));
            list.get(index2).add(new Pair(index1,1/values[i]));
        }
        double[] values1 = new double[queries.size()];
        for(int i =0;i < queries.size();i++) {
            List<String> lst = queries.get(i);
            String val1 = lst.get(0);
            String val2 = lst.get(1);
            if(!map.containsKey(val1) || !map.containsKey(val2)) {
                values1[i] = -1;
                continue;
            }
            int index1 = map.get(lst.get(0));
            int index2 = map.get(lst.get(1));
            boolean[] visited1 = new boolean[count];
            visited = false;
            letscall(list,-1,index1,index2,1.0,visited1);
            if(visited) {
                values1[i] = value1;
            }
            else {
                values1[i] = -1;
            }
        }
        return values1;
    }
    public void letscall(List<List<Pair>> list,int parent,int start,int destination,double value,boolean[] visited1) {
        if(start == destination) {
            value1 = value;
            visited  = true;
            return;
        }
        List<Pair> list1 = list.get(start);
        visited1[start] = true;
        for(Pair c:list1) {
            if(!visited1[c.destination]) {
                letscall(list,start,c.destination,destination,value*c.value,visited1);
            }
        }
    }
}
class Pair {
    int destination;
    double value;
    public Pair(int destination,double value) {
        this.destination = destination;
        this.value = value;
    }
}
