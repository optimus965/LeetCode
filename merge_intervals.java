import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class solution {
    public int[][] sol(int[][] intervals, int[] newInterval) {
        int x = newInterval[0];
        int y = newInterval[1];
        List<Integer> list =new ArrayList<>();
        for(int i = 0 ; i< intervals.length;i++) {
            if(intervals[i][0] >= x && intervals[i][1] <= y) {
                list.add(i);
            }
            else if((x >= intervals[i][0] && x <= intervals[i][1]) || (y >= intervals[i][0] && y <= intervals[i][1])) {
                list.add(i);
            }
        }
        int[] arra = new int[list.size()];
        int max = newInterval[1];
        int min = newInterval[0];
        for(int i = 0; i< list.size();i++) {
            if (intervals[list.get(i)][0] < min) {
                min = intervals[list.get(i)][0];
            }
            if (intervals[list.get(i)][1] > max) {
                max = intervals[list.get(i)][1];
            }

        }
        List<int[]> list1 = new ArrayList<>();
        for(int i =0 ; i< intervals.length;i++) {
            if(!list.contains(i)) {
                list1.add(new int[] {intervals[i][0],intervals[i][1]});
            }
        }
        list1.add(new int[]{min, max});
        intervals = new int[list1.size()][2];
        for(int i =0 ; i< list1.size();i++) {
            intervals[i][0] = list1.get(i)[0];
            intervals[i][1] = list1.get(i)[1];
        }
        Arrays.sort(intervals,(a,b) -> (a[0] - b[0]));
        return intervals;
    }

}