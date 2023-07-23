class Solution {
    static final int MAX_N = 20;
    static TreeNode[][] trees = new TreeNode[MAX_N + 1][];
    public List<TreeNode> allPossibleFBT(int n) {
        if (trees[1] == null) {
            trees[0] = new TreeNode[0];
            for (int i = 0; i <= MAX_N; i += 2)  trees[i] = trees[0];
            trees[1] = new TreeNode[1];
            trees[1][0] = new TreeNode();
            trees[3] = new TreeNode[1];
            trees[3][0] = new TreeNode();
            trees[3][0].left = trees[3][0].right = trees[1][0];
            for (int m = 5; m <= MAX_N; m += 2) {
                int configCount = 0;
                for (int i = 1; i < m; i++)
                    configCount += trees[i].length * trees[m - i - 1].length;
                TreeNode[] configs = trees[m] = new TreeNode[configCount];
                int configsIdx = 0;
                for (int i = 1; i < m; i++) {
                    for (TreeNode left : trees[i]) {
                        for (TreeNode right : trees[m - i - 1]) {
                            configs[configsIdx] = new TreeNode();
                            configs[configsIdx].left = left;
                            configs[configsIdx++].right = right;
                        }
                    }
                }
            }
        }
        return Arrays.asList(trees[n]);
    }
}
