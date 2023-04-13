//Using Stack
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length != popped.length){
            return false;
        }
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i: pushed){
            stack.push(i);
            while (!stack.isEmpty() && j < popped.length && stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return j == popped.length;
    }
}
