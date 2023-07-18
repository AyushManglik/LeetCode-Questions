class RecentCounter {
    private LinkedList<Integer> q;
    private int count;

    public RecentCounter() {
        count = 0;
        q = new LinkedList<>();
    }
    
    public int ping(int t) {
        while(!q.isEmpty() && q.peek()+3000<t){
            q.pop();
            count--;
        }
        q.add(t);
        count++;
        return count;
    }
}
