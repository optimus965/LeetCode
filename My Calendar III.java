class MyCalendarThree {
    TreeMap<Integer,Integer> map = new TreeMap<>();
    int max = 0;
    public MyCalendarThree() {
        
    }
    
    public int book(int startTime, int endTime) {
        if(map.containsKey(startTime)) {
            int value = map.get(startTime);
            map.put(startTime,value + 1);
        }
        else {
            map.put(startTime,1);
        }
        if(map.containsKey(endTime)) {
            int value = map.get(endTime);
            map.put(endTime,value - 1);
        }
        else {
            map.put(endTime,-1);
        }
        int count =0;
        for(Integer c:map.values()) {
            count = count + c;
            max = Math.max(max,count);
        }
        return max;
    }
}
