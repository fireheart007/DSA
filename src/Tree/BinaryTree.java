package Tree;

import java.util.Scanner;

public class BinaryTree {
    Scanner sc =new Scanner(System.in); //declared globally because scanner should be declared only once in a class
    class Node{
        int data;
        Node left;
        Node right;
        public Node(int i){
            data=i;
        }  //Node Constructor for entering data in the node
    }
    Node root;
    public BinaryTree(){ //Tree Constructor for creating tree

//        root=create(null,false);   //using return node method

        System.out.println("Enter root node data"); //using void method
        root=new Node(sc.nextInt());
        create(root);
    }

    private void create(Node parent) {
        System.out.println(parent.data + " ka Left Child hein ");
        if (sc.nextBoolean()) {
            System.out.println(parent.data + " ka Left Child ka data de ");
            parent.left = new Node(sc.nextInt());
            create(parent.left);
        }

        System.out.println(parent.data + " ka Right Child hein ");
        if (sc.nextBoolean()) {
            System.out.println(parent.data + " ka Right Child ka data de ");
            parent.right = new Node(sc.nextInt());
            create(parent.right);
        }
    }
    private Node create(Node parent, boolean isLeft) {
        if(parent==null)
            System.out.println("Enter data of the root node");
        else if (isLeft) {
            System.out.println("Enter the data of "+parent.data+"'s left child");
        }
        else{
            System.out.println("Enter the data of "+parent.data+"'s right child");
        }
        Node n=new Node(sc.nextInt());
        System.out.println("Does "+n.data+" has left child");
        if(sc.nextBoolean())
            n.left=create(n,true);
        System.out.println("Does "+n.data+" has right child");
        if(sc.nextBoolean())
            n.right=create(n,false);

        return n;
    }
    private void Disp(Node n){
        if(n==null)
            return;
        System.out.println(n.data);
        Disp(n.left);
        Disp(n.right);
    }
    public void Disp(){ //here we have overloaded the function because while calling disp()function in the client class
//        we can not put "root" node as argument in the function because we don't have the address of the root node
        Disp(root);
    }
    private int size(Node n){
        if(n==null)
            return 0;
        int left=size(n.left);
        int right=size(n.right);
        return left+right+1; //add the size of left subtree and right subtree and add 1 to obtain the size from the root
    }
    public int size(){
        return size(root);
    }

    private boolean find(Node n ,int ele){
        if(n==null)
            return false;
        if(ele==n.data)
            return true;
        boolean left=find(n.left,ele);
        boolean right=find(n.right,ele);
        return left||right;
    }
    public boolean find(int ele){
        return find(root,ele);
    }
    private int height(Node n){ //height of a tree is the max. distance b/w its root node and leaf node
        if(n==null)
            return -1;
        int left=height(n.left);
        int right=height(n.right);
        return Math.max(left,right) + 1;
    }
    public int height(){
        return height(root);
    }

   //This approach have O(n^2) time complexity
    private int dia(Node n){ //Diameter means max. distance b/w any 2 nodes in a tree
        if(n==null)
            return 0;
        int ld=dia(n.left); //left dia
        int rd=dia(n.right); //right dia
        int sd= height(n.left)+ height(n.right) + 2; //self dia
        return Math.max(sd,Math.max(ld,rd));
    }
    public int dia(){
        return dia(root);
    }

//  Since the above function has 4 recursive calls and is traversing the whole tree 2 times - once for diameter and again for obtaining height, so we will make a
//  class to return 2 things in a single function to reduce the complexity
    class DiaHtPair{
//    Diameter=0 and Height= -1 are the base cases for dia and height, so we have initialized these variables with them
        int dia=0;
        int ht=-1;
    }

//  Time Complexity of the below code is O(n)
    private DiaHtPair dia2(Node n){ //here the return type of the function is "DiaHtPair", it will help us to return 2 values at once
        if(n==null){
            return new DiaHtPair(); //It will return ht= -1 and dia=0 for the null node
        }
        DiaHtPair L=dia2(n.left); //left dia
        DiaHtPair R=dia2(n.right);//right dia
        int sd= L.ht + R.ht +2; //self dia
        DiaHtPair ans=new DiaHtPair(); //we have formed this object "ans" to store the final values of height and dia and return this object
        ans.dia= Math.max(sd,Math.max(L.dia,R.dia));
        ans.ht=Math.max(L.ht,R.ht)+1;
        return ans;
    }
    public int dia2(){
        return dia2(root).dia; //It will return the max. dia in the whole tree
    }

//   The below code has O(n^2) time complexity
    private boolean isBalanced(Node n){// A tree is balanced if |ht. of left subtree - ht. of right subtree| is <=1 for each node
        if(n==null)
            return true; //null node means it is balanced
        boolean L=isBalanced(n.left);
        boolean R=isBalanced(n.right);
        if(L&&R){ //if both the left subtree and right subtree are balanced then only check the current node
            int result=height(n.left)-height(n.right);
            return Math.abs(result)<=1; //if |ht. left - ht. right| is <=1 then it will return true
        }
        return false; //agar koi ek bhi subtree balanced nhi hai to false return kar do
    }
    public boolean isBalanced(){
        return isBalanced(root);
    }

//    O(n) time complexity code
    class BoolHtPair{
        boolean balanced=true;
        int ht= -1;
    }
    private BoolHtPair isBalanced2(Node n){
        if(n==null)
            return new BoolHtPair();
        BoolHtPair L=isBalanced2(n.left);
        BoolHtPair R=isBalanced2(n.right);
        BoolHtPair ans= new BoolHtPair();
        if(L.balanced && R.balanced){
            int result=L.ht-R.ht;
            ans.balanced=Math.abs(result)<=1;
        }
        else
            ans.balanced=false;
        ans.ht=Math.max(L.ht,R.ht)+1;
        return ans;
    }
    public boolean isBalanced2(){
        return isBalanced2(root).balanced;
    }

    //Given an array with preorder traversal, form the tree from it
    public BinaryTree(int[] pre){
        root=createPre(pre);
    }
    int idx=0; //declaring idx globally to use in the below function, so that we can increment its value for traversing the array
    private Node createPre(int[] pre) {
        if(pre[idx]==-1){
            idx++;
            return null;
        }
        Node n=new Node(pre[idx]); //putting the data of array in the node
        idx++;
        n.left=createPre(pre);
        n.right=createPre(pre);
        return n;
    }

    //Given preorder and inorder traversal create the binary tree
    public BinaryTree(int[] pre, int[] in){
        root=createPreIn(pre,0,pre.length-1,in,0,in.length-1);
    }
    private Node createPreIn(int[] pre, int preS, int preE, int[] in, int inS, int inE) {
        if(preS>preE || inS>inE) //agar index out of bound ho to null return kr do
            return null;
//first find the root node in the inorder traversal and create it!!because position of root node in inorder will tell us the size of left subtree and right subtree
        int idx=inS;
        int left_size=0;
        while (in[idx]!=pre[preS]){//the root node will be the starting node of the preorder traversal, so while the root node is not found in the inorder we will
//            keep incrementing the size of the left subtree
            idx++;
            left_size++; //it will give us the size of left subtree
        }
        Node n=new Node(pre[preS]); //enter the root node in the tree
        n.left=createPreIn(pre,preS+1,preS+left_size,in,inS,idx-1); //root node ka left subtree banao
        n.right=createPreIn(pre,preS+left_size+1,preE,in,idx+1,inE); //root node ka left subtree banao
        return n;
    }
}
