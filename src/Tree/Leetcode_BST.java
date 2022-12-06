package Tree;
import java.util.*;
public class Leetcode_BST {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //Convert Sorted Array to Binary Search Tree
    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/description/
    public TreeNode sortedArrayToBST(int[] nums) {
        return createBST(nums,0,nums.length-1);
    }
    public TreeNode createBST(int[] arr,int s,int e){
        if(s>e)
            return null;
        int mid=(s+e)/2;
        TreeNode root=new TreeNode(arr[mid]);
        root.left=createBST(arr,s,mid-1);
        root.right=createBST(arr,mid+1,e);
        return root;
    }

    //Convert Sorted List to Binary Search Tree ->
    //2nd Approach - do this ques. using fast and slow pointer concept of link list without converting link list to al
    //https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/description/

//    Definition for singly-linked list
    public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> al=new ArrayList<>();
        while(head!=null){ //converting link list to arraylist
            al.add(head.val);
            head=head.next;
        }
        return createBSTfromList(al,0,al.size()-1);
    }
    public TreeNode createBSTfromList(List<Integer> al,int s,int e){
        if(s>e)
            return null;
        int mid=(s+e)/2;
        TreeNode root=new TreeNode(al.get(mid));
        root.left=createBSTfromList(al,s,mid-1);
        root.right=createBSTfromList(al,mid+1,e);
        return root;
    }

    //Lowest Common Ancestor of a Binary Search Tree - O(h) tc
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root.val>p.val && root.val >q.val) //agar dono p&q nodes current node ke left me hai
            return lowestCommonAncestor(root.left,p,q); //to current node ke left me lca dhoondo

        else if(root.val<p.val && root.val<q.val) //agar dono p&q nodes current node ke right me hai
            return lowestCommonAncestor(root.right,p,q);//to current node ke right me lca dhoondo

        else //agar p&q me se ek current node ke left me hai or ek current node ke right me then return the current node
            return root;
    }

    //Kth Smallest Element in a BST - O(n) tc and O(n) sc --> to optimize use morrris traversal where tc=O(n) and sc=O(1)
    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> al=new ArrayList<>();
        inorder(root,al); //BST ka inorder AL me store kr lo
        return al.get(k-1); //or BST ka inorder sorted hota hai isliye (k-1)th index element return kr do, vo hi kth smallest element hoga
    }
    public void inorder(TreeNode n, List<Integer> al){
        if(n==null)
            return;
        inorder(n.left,al);
        al.add(n.val);
        inorder(n.right,al);
    }

    //Kth largest element in BST - O(n) tc and O(n) sc --> to optimize use morrris traversal where tc=O(n) and sc=O(1)
    //https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1
    public int kthLargest(TreeNode root,int K)
    {
        List<Integer> al=new ArrayList<>();
        inorder(root,al);
        return al.get(al.size()-K); // kth largest element will be (AL.size-k)th index element of the sorted array list
    }

    //Predecessor And Successor In BST - O(n) tc
    // Alternative approach -> store the inorder of BST in AL and then find index of key in it and then pred =(idx-1)th ele and succ =(idx+1)th ele
    //https://www.codingninjas.com/codestudio/problems/_893049
    public static ArrayList<Integer> predecessorSuccessor(TreeNode root, int key) {
        int pred=-1,succ=-1; //initializing predecessor and successor with -1
        TreeNode temp=root;

        //finding position of key
        while(temp.val!=key){
            if(temp.val<key){ //agar current node key se chhota hai to
                pred=temp.val;//current node possible predecessor ho skta hai isliye use pred me store kro
                temp=temp.right;// or ab key ko current node ke right subtree me dhoondo
            }
            else{ //agar current node key se bada hai to
                succ=temp.val; //current node possible successor ho skta hai isliye use succ me store kro
                temp=temp.left;// or ab key ko current node ke left subtree me dhoondo
            }
        }
        //finding pred and succ
        TreeNode leftTree=temp.left; //key vaale node ka left subtree lo
        while(leftTree!=null){ //or left subtree ka max element find kro
            pred=leftTree.val; //max of left subtree will be the predecessor
            leftTree=leftTree.right; //we can find max of left subtree by going to its rightest node
        }
        TreeNode rightTree=temp.right;//key vaale node ka right subtree lo
        while(rightTree!=null){//or right subtree ka min element find kro
            succ=rightTree.val;//min of right subtree will be the successor
            rightTree=rightTree.left;//we can find min of right subtree by going to its leftest node
        }
        ArrayList<Integer> al=new ArrayList<>();
        al.add(pred);al.add(succ); //store both pred and succ in al and return it
        return al;
    }

    //Flatten BST To A Sorted List --> TC-O(n),  SC-O(n)
    //https://www.codingninjas.com/codestudio/problems/1169459
    public static void inorderBST(TreeNode root,List<TreeNode> al){
        if(root==null)
            return;
        inorderBST(root.left,al);
        al.add(root);
        inorderBST(root.right,al);
    }
    public static TreeNode flatten(TreeNode root)
    {
        List<TreeNode> al=new ArrayList<>();
        //Storing nodes in sorted format in AL using inorder of BST
        inorderBST(root,al);

        for(int i=0;i<al.size();i++){ //ab AL ko traverse kro or curr node ke right ko next node pe point kro or curr node ka left null kr do
            TreeNode curr=al.get(i);
            if(i==al.size()-1){ //agar last node pe ho to uska left bhi null kro or right bhi
                curr.left=null;
                curr.right=null;
                continue;
            }
            curr.right=al.get(i+1);
            curr.left=null;
        }
        return al.get(0); //first node of AL return kr do, vo root hoga sorted Link list ka
    }

}
