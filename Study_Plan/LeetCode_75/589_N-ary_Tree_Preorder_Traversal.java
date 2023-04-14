class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root==null)return list;
        list.add(root.val);
        for(Node i: root.children) preorder(i);
        return list;
    }
}
