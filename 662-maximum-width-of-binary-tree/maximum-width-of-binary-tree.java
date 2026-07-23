/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        while(!q.isEmpty()){
            int start = q.peek().getValue();
            for(int i = q.size(); i>0; i--){
                Pair<TreeNode , Integer> pair = q.poll();
                TreeNode node = pair.getKey();
                int num = pair.getValue() - start;

                res = Math.max(res, num + 1);
                if(node.left!=null){
                    q.offer(new Pair<>(node.left, 2*num));
                }
                if(node.right!=null){
                    q.offer(new Pair<>(node.right, 2*num+1));
                }
            }

        }
        return res;
    }
}