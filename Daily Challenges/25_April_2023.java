class SmallestInfiniteSet {
    boolean[] arr;
    int index = 0;
    public SmallestInfiniteSet() {
        arr = new boolean[1000];
    }
    
    public int popSmallest() {
        while(arr[index]){
            index++;
        }
        arr[index] = true;
        index++;
        return index;
    }
    
    public void addBack(int num) {
        arr[num - 1] = false;
        index = Integer.min(index, num - 1);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */

