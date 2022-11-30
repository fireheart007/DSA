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
}
