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

    //Balanced Binary Tree -     O(n) tc can be implemented using class logic
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

    // Lowest Common Ancestor of a Binary Tree - O(n) tc
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root==p || root==q) //agar current node hi p ya q hai to vo hi lca hai
            return root;
        TreeNode l=lowestCommonAncestor(root.left,p,q);
        TreeNode r=lowestCommonAncestor(root.right,p,q);

        if(l!=null && r!=null) // Case 1-agar p and q current node ke left and right child hai then current node is lca
            return root;
        else if(l!=null && r==null) //Case 2- agar p and q dono left subtree me hai then l will return lca of p and q in left subtree
            return l;
        else //Case 3-agar p and q dono right subree me hai then r will return lca of p and q in right subtree
            return r;

    }

    //LCA 2 - O(n) tc  --> here we are given that if either a or b not exist then return null
    //https://www.lintcode.com/problem/474/
    public TreeNode lowestCommonAncestorII(TreeNode root, TreeNode A, TreeNode B) {
        if(exist(root,A) && exist(root,B)) //if both the nodes a & b exist in the tree then only find the lca
            return lowestCommonAncestor(root,A,B);
        return null; //else return null
    }
    public boolean exist(TreeNode n,TreeNode ele){
        if(n==null)
            return false;
        if(n==ele)
            return true;
        boolean l=exist(n.left,ele);
        boolean r=exist(n.right,ele);
        return l||r;
    }

    //LCA 3 - The node structure of a binary tree is modified such that each node has the reference to its parent node.
    //You are given two nodes: 'N1' and 'N2' of the above binary tree. Your task is to return the lca of the given node
    //https://www.codingninjas.com/codestudio/problems/lowest-common-ancestor-of-a-binary-tree-iii_1280134

    class BinaryTreeNode {
        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;
        BinaryTreeNode parent;
        BinaryTreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
            parent = null;
        }
    } //for the code reference

    //Approach 1- O(n) tc and O(n) Space Complexity
    public static BinaryTreeNode lowestCommonAncestor(BinaryTreeNode n1, BinaryTreeNode n2) {

        HashSet<Integer> hashSet = new HashSet<>();

        // Storing all ancestors of n1 in a hashset
        while (n1 != null) {
            hashSet.add(n1.data);
            n1 = n1.parent;
        }
        //checking in hashset that which node is common in b/w ancestors of n1 and n2
        //The first node to be found in the hash set will be LCA of ‘n1’ and ‘n2’
        while (n2 != null) {
            if (hashSet.contains(n2.data)) { //this operation runs in O(1) tc
                return n2;
            }
            n2 = n2.parent;
        }
        return null; //if both n1 and n2 don't exist then return null
    }
    //Approach 2- O(n) tc and O(1) Space Complexity -> more efficient
    public static BinaryTreeNode lowestCommonAncestor3(BinaryTreeNode n1, BinaryTreeNode n2) {
        //making copy of both the nodes ,so we can iterate them without changing values of original nodes
        BinaryTreeNode copy1=n1;
        BinaryTreeNode copy2=n2;
        while(copy1!=copy2){ //while node 1 is not equal to node 2 we will run the loop
            if(copy1!=null) //if node 1 is not null
                copy1=copy1.parent; //go to its parent
            else
                copy1=n2; //if copy1 is null then make it equal to node 2
            if(copy2!=null) //if node 2 is not null
                copy2=copy2.parent; //go to its parent
            else
                copy2=n1; //if copy2 is null then make it equal to node 1
        }
        return copy1; //return either copy1 or copy2 because both will be equal now
    }
    //if node is null then make it equal to the other node --> this approach will help us to equalise the distance travelled from both the nodes so that we can
    //reach the common node on both the copy1 and copy2 at the same time

    //LCA 4 - given root of binary tree and an array of nodes, return lca of all the nodes - O(n) tc
    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode[] arr){
        HashSet<TreeNode>  hashSet=new HashSet<>();
        Collections.addAll(hashSet, arr); //copy the whole array to the hashset,so we can iterate through it in O(1) tc --> this operation will take O(n) tc
        return lca4(root,hashSet);
    }
    public TreeNode lca4(TreeNode root, HashSet<TreeNode> hashSet){ //tc-O(n)
        if(root==null)
            return null;
        if(hashSet.contains(root)) // O(1) tc --> agar current node hashset me hai to vo hi lca hai
            return root;
        TreeNode l=lca4(root.left,hashSet);
        TreeNode r=lca4(root.right,hashSet);

        if(l!=null && r!=null)
            return root;
        else if(l!=null && r==null)
            return l;
        else
            return r;
    }
    //total tc - o(n) + o(n) = o(2n)  -->o(n) for converting array to hashset and other o(n) for lca4 function

    //Given the root of a binary tree, determine if it is a valid BST-  O(n) tc
    //https://leetcode.com/problems/validate-binary-search-tree/description/
    public boolean isValidBST(TreeNode root) {
        return isBST2(root).isBST;
    }
    class isBSTpair{
        boolean isBST=true;
        //we have taken min , max long here due to given constraints in this ques. as max value of a node can be 2^31-1 which is Integer.MAX_VALUE
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
    }
    private isBSTpair isBST2(TreeNode n){
        if(n==null)
            return new isBSTpair();

        isBSTpair L=isBST2(n.left);
        isBSTpair R=isBST2(n.right);
        isBSTpair ans=new isBSTpair();
        ans.min=Math.min(n.val,Math.min(L.min,R.min));
        ans.max=Math.max(n.val,Math.max(L.max,R.max));

        if(L.max<n.val && R.min>n.val){
            ans.isBST= L.isBST && R.isBST;
        }
        else
            ans.isBST=false;

        return ans;
    }

    //Binary Tree Level Order Traversal - O(n) tc
    //https://leetcode.com/problems/binary-tree-level-order-traversal/description/
    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelNextLn(root);
    }
    public List<List<Integer>> levelNextLn(TreeNode root){
        List<List<Integer>> list=new ArrayList<>();
        if(root!=null){
            Queue<TreeNode> Q=new LinkedList<>();
            Q.add(root);
            while(true){
                int nodeCount=Q.size();
                List<Integer> al=new ArrayList<>();
                while(nodeCount>0){
                    TreeNode n=Q.poll();
                    al.add(n.val);
                    if(n.left!=null)
                        Q.add(n.left);
                    if(n.right!=null)
                        Q.add(n.right);
                    nodeCount--;
                }
                list.add(new ArrayList<>(al));
                if(Q.isEmpty())
                    break;
            }
        }
        return list;
    }

    //Flatten Binary Tree to Linked List --> The "linked list" should be in the same order as a pre-order traversal of the binary tree
    //https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
    //1st Approach -> TC- O(n), SC-O(n)
    TreeNode prev=null; //initially previous root is null
    public void flatten(TreeNode root) {//here we have to do -> "Right Left Root" for flattening the tree
        if(root==null)
            return;
        flatten(root.right); //pehle right subtree tree flat kro
        flatten(root.left); //uske baad left subtree flat kro
        root.right=prev; //current node ke right ko prev node bana do
        root.left=null; //or uska left null kr do
        prev=root; //uske baad prev node me current node ki value daal do
    }
    //2nd Approach -> TC- O(n), SC- O(1) --> Using morris traversal
    public void flattenMorris(TreeNode root) {
        while(root!=null){
            if(root.left!=null){ //agar left child exist krta hai to
                TreeNode pred=root.left; //curr node ka predecessor dhoondo
                while(pred.right!=null){
                    pred=pred.right;
                }
                pred.right=root.right; //or predcessor ke right ko curr node ke right pe point kr do
                root.right=root.left; //uske baas curr node ke right ko curr node ke left pe point kr do
                root.left=null; //or curr node ka left null kr do
            }
            root=root.right; //uske baad curr node ka right subtree visit kro
        }
    }

    //Boundary Traversal of binary tree
    //https://practice.geeksforgeeks.org/problems/boundary-traversal-of-binary-tree/1
    ArrayList <Integer> boundary(TreeNode node)
    {
        ArrayList <Integer> al=new ArrayList<>();
        al.add(node.val); //adding root node
        leftTraverse(node.left,al); //traversing left boundary nodes of the tree except the leaf nodes because they will be covered in leafTraversal

        //we have to travel leaf nodes for left and right tree separately otherwise for eg:- if tree has only single node then it will be added twice in al
        //first when the root is added and second when we will traverse the leaf nodes because it will also include root node
        leafTraverse(node.left,al); // Traversing Leaf nodes of left subtree
        leafTraverse(node.right,al);// Traversing Leaf nodes of right subtree

        rightTraverse(node.right,al); // Traversing Reverse right boundary nodes
        return al;
    }
    public void leftTraverse(TreeNode root,ArrayList<Integer> al){
        if((root==null)||(root.left==null && root.right==null)) //if node is null ,or it is boundary node then don't add to al and return
            return;
        al.add(root.val); //add the node to al
        if(root.left!=null) //if left child exist then go to left
            leftTraverse(root.left,al);
        else //otherwise go to right
            leftTraverse(root.right,al);
    }
    public void leafTraverse(TreeNode root,ArrayList<Integer> al){
        if(root==null)
            return;
        if(root.left==null && root.right==null){ //if the node is leaf node then add to al and return
            al.add(root.val);
            return;
        }
        leafTraverse(root.left,al); //traverse the leaf node of left subtree
        leafTraverse(root.right,al);//traverse the leaf node of right subtree
    }
    public void rightTraverse(TreeNode root,ArrayList<Integer> al){
        if((root==null)||(root.left==null && root.right==null)) //if node is null ,or it is boundary node then don't add to al and return
            return;
        if(root.right!=null)//if right child exist then go to right
            rightTraverse(root.right,al);
        else //otherwise go to left
            rightTraverse(root.left,al);
        al.add(root.val); //add the node to al during backtracking so that we will add the right boundary nodes in reverse order
    }

    //Vertical Traversal of Binary Tree -> TC-O(n)
    //https://practice.geeksforgeeks.org/problems/print-a-binary-tree-in-vertical-order/1
    static class pair{
        int hd;
        TreeNode node;
        public pair(int dist,TreeNode n){
            hd=dist;
            node=n;
        }
    }
    static ArrayList <Integer> verticalOrder(TreeNode root)
    {
        //We have used TreeMap here so that the values stored will be sorted according to the key
        Map<Integer,ArrayList<Integer>> map=new TreeMap<>(); //map banao jisme horizontal distance as key and al of nodes as values store hongi
        Queue<pair> q=new LinkedList<>(); //level order traversal ke liye queue banao joki horizontal distance and node store kregi
        q.add(new pair(0,root)); //root add kro queue me, or root ko hum origin consider kr rhe hai isliye uska horizontal distance '0' hoga
        while (!q.isEmpty()){
            pair curr=q.poll();
            if(map.containsKey(curr.hd))//agar horizontal distance exist krta hai map me,iska matlab al bani hui hai
                map.get(curr.hd).add(curr.node.val);//so uski al me bas curr node ki value add krdo

            else{ //agar horizontal distance ki key exist nhi krti
                ArrayList<Integer> al=new ArrayList<>(); //to nayi al banao
                al.add(curr.node.val); //or usme curr node ki valye daalo
                map.put(curr.hd,al); //ab curr key or uske corresponding banayi hui al ko map me daal do
            }

            // level order traversal logic
            if(curr.node.left!=null)
                q.add(new pair(curr.hd-1,curr.node.left)); //agar left node pe jayenge to horizontal distance me -1 ho jayega
            if(curr.node.right!=null)
                q.add(new pair(curr.hd+1,curr.node.right)); //agar right node pe jayenge to horizontal distance me +1 ho jayega
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for (ArrayList<Integer> al : map.values()){ //iterate through the value of map
            //add all the values of al in the ans arraylist
            ans.addAll(al);
        }
        return ans;
    }

    //Top View of Binary Tree -> TC,SC- O(n)
    //https://practice.geeksforgeeks.org/problems/top-view-of-binary-tree/1
    // Similar logic to vertical order traversal --> store the nodes in map wrt to its horizontal distance
    static ArrayList<Integer> topView(TreeNode root)
    {
        Map<Integer,Integer> map=new TreeMap<>(); //map banao jisme h.d. as key and sirf pehli node corresponding to that h.d. will be stored
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,root));
        while(!q.isEmpty()){
            pair curr=q.poll();
            if(!map.containsKey(curr.hd)) //agar map me horizontal distance ki key pehle se exist nhi krti
                map.put(curr.hd,curr.node.val); //to fir key or uske corresponding node dono map me daal do
            //agar key exist krti ha,to jo bad ki nodes hai same h.d. par vo nhi dikhegi top view se, isliye hum map me unhe nhi daalenge
            if(curr.node.left!=null)
                q.add(new pair(curr.hd-1,curr.node.left));
            if(curr.node.right!=null)
                q.add(new pair(curr.hd+1,curr.node.right));
        }
        ArrayList<Integer> ans = new ArrayList<>(map.values()); //al me daal do poore map ki values
        return ans;
    }

    //Bottom View of Binary Tree -> TC,SC- O(n)
    //https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
    public ArrayList <Integer> bottomView(TreeNode root)
    {
        Map<Integer,Integer> map=new TreeMap<>(); //map banao jisme h.d. as key and node corresponding to that h.d. will be stored
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(0,root));
        while(!q.isEmpty()){
            pair curr=q.poll();
            map.put(curr.hd,curr.node.val);//map me key or uske corresponding node daal do
            //agar h.d. ki key pehle se exist krti hogi to fir jo node baad me ayegi same h.d. par, map ki value us se update ho jayegi
            //jo upar ki nodes hai same h.d. par vo nhi dikhegi bottom view se, isliye same h.d par map ki value baad ki node se update kr do
            if(curr.node.left!=null)
                q.add(new pair(curr.hd-1,curr.node.left));
            if(curr.node.right!=null)
                q.add(new pair(curr.hd+1,curr.node.right));
        }
        ArrayList<Integer> ans = new ArrayList<>(map.values()); //al me daal do poore map ki values
        return ans;
    }

    //Left View of Binary Tree -> TC,SC- O(n)
    //https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1
    static class pairLvl{
        int level;
        TreeNode node;
        public pairLvl(int lvl,TreeNode n){
            level=lvl;
            node=n;
        }
    }
    ArrayList<Integer> leftView(TreeNode root)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Map<Integer,Integer> map=new TreeMap<>(); //map will store level and node corresponding to it
        Queue<pairLvl> q=new LinkedList<>();
        q.add(new pairLvl(0,root));
        while(!q.isEmpty()){
            pairLvl curr=q.poll();
            if(!map.containsKey(curr.level)) //agar map me current level ki key pehle se exist nhi krti
                map.put(curr.level,curr.node.val); //to fir key or uske corresponding node dono map me daal do
            //agar key exist krti ha,to jo bad ki nodes hai same level par vo nhi dikhegi left view se, isliye hum map me unhe nhi daalenge
            if(curr.node.left!=null)
                q.add(new pairLvl(curr.level+1,curr.node.left)); //left ya right jaane pe level me +1 hoga
            if(curr.node.right!=null)
                q.add(new pairLvl(curr.level+1,curr.node.right));
        }
        ans.addAll(map.values());
        return ans;
    }

    //Binary Tree Right Side View -> TC,SC- O(n)
    //https://leetcode.com/problems/binary-tree-right-side-view/description/
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if(root==null)
            return ans;
        Map<Integer,Integer> map=new TreeMap<>();
        Queue<pairLvl> q=new LinkedList<>();
        q.add(new pairLvl(0,root));
        while(!q.isEmpty()){
            pairLvl curr=q.poll();
            map.put(curr.level,curr.node.val);//map me key or uske corresponding node daal do
            //agar curr level ki key pehle se exist krti hogi to fir jo node baad me ayegi same level par, map ki value us se update ho jayegi
            //jo pehle ki nodes hai same level par vo nhi dikhegi right view se, isliye same level par map ki value baad ki node se update kr do
            if(curr.node.left!=null)
                q.add(new pairLvl(curr.level+1,curr.node.left));
            if(curr.node.right!=null)
                q.add(new pairLvl(curr.level+1,curr.node.right));
        }
        ans.addAll(map.values());
        return ans;
    }
}
