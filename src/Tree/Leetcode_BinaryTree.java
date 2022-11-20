package Tree;
import java.util.*;
public class Leetcode_BinaryTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    TreeNode root;

    //LeetCode PathSum-II
    //https://leetcode.com/problems/path-sum-ii/description/
    public void pathSum2(TreeNode root, int target, List<Integer> al, List<List<Integer>> ans){
        if(root==null)
            return;

        al.add(root.val);
        if(root.left==null && root.right==null && target-root.val==0 ){ //checking if the current node is leaf node
//      and if the diff. b/w the current node value and the target is 0 then add this path to ans
            ans.add(new ArrayList<>(al));
            al.remove(al.size()-1); //explicit backtracking
            return;
        }
        pathSum2(root.left,target-root.val,al,ans); //left
        pathSum2(root.right,target-root.val,al,ans); //right
        al.remove(al.size()-1); //explicit backtracking
    }
    public List<List<Integer>> pathSum2(TreeNode root,int targetSum) {
        List<List<Integer>> ans=new ArrayList<>();
        pathSum2(root,targetSum,new ArrayList<>(),ans);
        return ans;
    }

}
