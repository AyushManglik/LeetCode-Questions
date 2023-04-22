class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones)
            pq.add(i);

        int p1;
        int p2;

        while(pq.size()>1){

             p1=pq.poll();
             p2=pq.poll();

            if(p1>p2)
                pq.add(p1-p2);

            }
            
        return pq.isEmpty()?0:pq.poll();
    }
}
