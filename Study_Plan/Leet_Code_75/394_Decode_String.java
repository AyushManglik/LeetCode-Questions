/*
class Solution {
    public String decodeString(String s) {
        Stack<Integer> is = new Stack<>();
        Stack<StringBuilder> ss = new Stack<>();

        int n = s.length(), num = 0;
        StringBuilder str = new StringBuilder();

        for(char ch : s.toCharArray()) {
            // There will be 4 types of characters --> number, [ , ], character

            if(ch >= '0' && ch <= '9') {
                num = (num * 10) + ch - '0';
            } else if(ch == '[') {
                ss.push(str);
                str = new StringBuilder();

                is.push(num);
                num = 0;
            } else if(ch == ']') {
                StringBuilder temp = str;
                str = ss.pop();
                int count = is.pop();

                while(count-- > 0) {
                    str.append(temp);
                }
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
}
*/

class Solution {
    public String decodeString(String s) {
        Deque<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) queue.offer(c);
        return helper(queue);
    }
    
    public String helper(Deque<Character> queue) {
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while (!queue.isEmpty()) {
            char c= queue.poll();
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            } else if (c == '[') {
                String sub = helper(queue);
                for (int i = 0; i < num; i++) sb.append(sub);   
                num = 0;
            } else if (c == ']') {
                break;
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
