class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] element : intervals){
            if (list.isEmpty() || list.getLast()[1] < element[0]){
                list.add(element);
            }
            else{
                if (list.getLast()[1] < element[1]){
                    list.getLast()[1] = element[1];
                }
            }
        }
        return list.toArray(new int[0][]);
    }
}
