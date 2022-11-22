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

    //Pathsum  O(n) Time complexity
    //https://leetcode.com/problems/path-sum/description/
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null) //this condition will be written first
            return false;
        if(root.left==null && root.right==null && targetSum-root.val==0) //leaf node condition
            return true;
        boolean l=hasPathSum(root.left,targetSum-root.val);
        boolean r=hasPathSum(root.right,targetSum-root.val);
        return l||r; //agar kisi ek se bhi path find ho rha hai to true return kr do
    }

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

    //PathSum-III O(n^2) Time complexity , can be done in O(n) using Hashmap
    //https://leetcode.com/problems/path-sum-iii/description/
    int count=0;
    public int pathSum(TreeNode root, int targetSum) { //the logic of the below code is like word search problem
        if(root==null)
            return 0;
        pathSum3(root,targetSum); //target sum find kro
        pathSum(root.left,targetSum); //tree ke left node se start kro
        pathSum(root.right,targetSum); //tree ke right node se start kro
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

    // Sum Root to Leaf Numbers - O(n) tc
    //https://leetcode.com/problems/sum-root-to-leaf-numbers/description/
    public int sumNumbers(TreeNode root) {
        return sum(root,0);
    }
    public int sum(TreeNode n,int sol){
        if(n==null)
            return 0;
        if(n.left==null && n.right==null) //leaf node condition
            return sol*10+n.val;
        int l=sum(n.left,sol*10+n.val); //left subtree ka sum
        int r=sum(n.right,sol*10+n.val); //right subtree ka sum
        return l+r; //poore tree ka sum
    }

    //Diameter of Binary Tree
    //https://leetcode.com/problems/diameter-of-binary-tree/description/
    public int diameterOfBinaryTree(TreeNode root) { //O(n^2) tc
        if(root==null)
            return 0;
        int sd=ht(root.left)+ht(root.right)+2;
        int ld=diameterOfBinaryTree(root.left);
        int rd=diameterOfBinaryTree(root.right);
        return Math.max(sd,Math.max(ld,rd));
    }
    public int ht(TreeNode n){
        if(n==null)
            return -1;
        int l=ht(n.left);
        int r=ht(n.right);
        return Math.max(l,r)+1;
    }
    //O(n) tc
    class DiaHtPair{
        int dia=0;
        int ht=-1;
    }
    public DiaHtPair dia(TreeNode n){ //O(n) tc
        if(n==null)
            return new DiaHtPair();
        DiaHtPair L=dia(n.left);
        DiaHtPair R=dia(n.right);
        int sd=L.ht + R.ht +2;
        DiaHtPair ans=new DiaHtPair();
        ans.dia=Math.max(sd,Math.max(L.dia,R.dia));
        ans.ht=Math.max(L.ht,R.ht) +1;
        return ans;
    }
    public int diameterOfBT(TreeNode root){
        return dia(root).dia;
    }

    //Binary Tree Maximum Path Sum - O(n) tc
    //https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
    int res=Integer.MIN_VALUE; //declaring global variable
    public int maxPathSum(TreeNode root) {
        maxpath(root);
        return res;
    }
    public int maxpath(TreeNode n){
        if(n==null)
            return 0;
        int l=maxpath(n.left);
        int r=maxpath(n.right);

        //Case 1 :- Current node is lying in b/w the path of maxpath
        int max_straight=Math.max(Math.max(l,r)+n.val,n.val); //return the max b/w the max left or right path and the current node
        //Case 2:- Current node is acting as the root of maxpath i.e. self dia
        int max_path=Math.max(l+r+n.val,max_straight);//return max b/w self dia and max straight path , Case 2&1 compared

        res=Math.max(max_path,res); //return tha max b/w the current max path and previous max path

        //here we will not return res because it is not the straight path, so we can't use it otherwise l and r will not store the straight path which will be wrong
        return max_straight;
    }

    //Balanced Binary Tree - O(n) tc can be implemented using class logic
    //https://leetcode.com/problems/balanced-binary-tree/description/
    public boolean balanced(TreeNode n){ //O(n^2) tc
        if(n==null)
            return true;
        if(Math.abs(ht(n.left)-ht(n.right))<=1){
            boolean l= balanced(n.left);
            boolean r= balanced(n.right);
            return l&&r;
        }
        return false;
    }
}
