class Solution {
    public String simplifyPath(String path) {
        Stack <String> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        String[] p = path.split("/");

        for (int i=0; i<p.length; i++){
            if (!stack.isEmpty() && p[i].equals(".."))
                stack.pop();
            else if(!p[i].equals("") && !p[i].equals(".") && !p[i].equals(".."))
                stack.push(p[i]);
        }
        if (stack.isEmpty())
            return "/";
        while (!stack.isEmpty()){
            res.insert(0,stack.pop()).insert(0,"/");
        }
        return res.toString();
    }
}
