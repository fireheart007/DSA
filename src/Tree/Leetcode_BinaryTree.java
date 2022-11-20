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

    //PathSum-II  O(n) Time complexity
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

    //PathSum-III 0(n^2) Time complexity , can be done in O(n) using Hashmap
    //https://leetcode.com/problems/path-sum-iii/description/
    int count=0;
    public int pathSum(TreeNode root, int targetSum) { //the logic of the below code is like word search problem
        if(root==null)
            return 0;
        pathSum3(root,targetSum); //root se start kro or target sum find kro
        pathSum(root.left,targetSum); //left subtree se start kro or target sum dhoondo
        pathSum(root.right,targetSum); //right subtree se start kro or target sum dhoondo
        return count;
    }
//    root=[1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000]
// In case of int type, for the testcases like above the targetsum will be out of bound  because value of targetsum will become more than 10^10
// so, we are taking targetsum as 'long' in pathsum3
    public void pathSum3(TreeNode n,long targetSum){
        if(n==null)
            return;
        targetSum=targetSum-n.val;
        if(targetSum==0) //agar targetsum 0 ho gya to count++ kr do
            count++;
        pathSum3(n.left,targetSum); //left subtree me targetsum find kro
        pathSum3(n.right,targetSum); //right subtree me targetsum find kro
    }

}
