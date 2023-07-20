// // We need a Data Structure Stack or Queue because we need to manipulate the data.

// class Solution {
//     public int[] asteroidCollision(int[] asteroids) {
//         if (asteroids.length <= 1){
//             return asteroids;
//         }
//         Stack<Integer> stack = new Stack<>();
//         for (int asteroid : asteroids){
//             if (asteroid > 0){  //pushing all positive asteroids.
//                 stack.push(asteroid);
//             }
//             else{
//                 while (!stack.isEmpty() && stack.peek()> 0 && Math.abs(stack.peek()) < Math.abs(asteroid)){
//                     stack.pop();
//                 }
//                 if (stack.peek() < 0 || stack.isEmpty()){
//                     stack.push(asteroid);
//                 }
//                 else if (stack.peek() == Math.abs(asteroid)){
//                     stack.pop();
//                 }
//             }
//         }
//         int[] output = new int[stack.size()];
//         for (int i = output.length -1; i>=0; i--){
//             output[i] = stack.pop();
//         }
//         return output;
//     }
// }

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int[] stack = new int[asteroids.length];
        int p = 0;

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0 || p == 0) {
                stack[p++] = asteroids[i];
            } else {
                boolean add = true;
                while (p > 0 && stack[p-1] > 0) {
                    if (stack[p-1] == Math.abs(asteroids[i])) {
                        p--;
                        add = false;
                        break;
                    }
                    if (stack[p-1] > Math.abs(asteroids[i])) {
                        add = false;
                        break;
                    }

                    p--;
                }
                if (add) {
                    stack[p++] = asteroids[i];
                }
            }
        }

        return Arrays.copyOfRange(stack, 0, p);
    }
}
