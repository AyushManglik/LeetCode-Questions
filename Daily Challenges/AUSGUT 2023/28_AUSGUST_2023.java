class MyStack {
    Queue<Integer> q1;
    Queue<Integer> q2;
    int top ;
    int del;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        top = 0;
    }
    
    public void push(int x) {
        top = x;
        q1.add(x);
    }
    
    public int pop() {
        while(!q1.isEmpty()){
            del = q1.remove();
            if(!q1.isEmpty())    q2.add(del);
        }
        while(!q2.isEmpty()){
            top= q2.remove();
            q1.add(top);
        }
        return del;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
