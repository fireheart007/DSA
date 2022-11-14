package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

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

    private int max(Node n){
        if(n==null)
            return Integer.MIN_VALUE;
        int L=max(n.left);
        int R=max(n.right);
        return Math.max(n.data,Math.max(L,R));
    }
    public int max(){
        return max(root);
    }

    private int min(Node n){
        if(n==null)
            return Integer.MAX_VALUE;
        int L=min(n.left);
        int R=min(n.right);
        return Math.min(n.data,Math.min(L,R));
    }
    public int min(){
        return min(root);
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
    public BinaryTree(int[] pre){
        root=createPre(pre);
    }

    //Given preorder and inorder traversal create the binary tree
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
    public BinaryTree(int[] pre, int[] in){
        root=createPreIn(pre,0,pre.length-1,in,0,in.length-1);
    }
//    Similarly we can make tree if postorder and inorder traversal is given,but we can't make tree if preorder and postorder are given only because then we can't
//    identify the size of left and right subtree

    //Level Order Traversal
    public void level(){
        Queue<Node> Q=new LinkedList<>();
        Q.add(root);
        while(!Q.isEmpty()){
            Node n=Q.poll(); //Q ka first element nikalo or node 'n' me daalo
            System.out.println(n.data);
            if(n.left!=null) //agar ka node ka left child 'null' nhi hai to use Q me add kro
                Q.add(n.left);
            if(n.right!=null) //agar ka node ka right child 'null' nhi hai to use Q me add kro
                Q.add(n.right);
        }
    }

//    level order traversal such that print nodes in next line at each level

//    Approach 1st:- time complexity O(n), using single queue
    public void levelNextLn(){
        Queue<Node> Q=new LinkedList<>();
        Q.add(root);
        while(true){
            int nodeCount=Q.size();
            while(nodeCount>0){
                Node n=Q.poll();
                System.out.print(n.data+" ");
                if(n.left!=null)
                    Q.add(n.left);
                if(n.right!=null)
                    Q.add(n.right);
                nodeCount--;
            }
            System.out.println();
            if(Q.isEmpty())
                break;
        }
    }

//    Approach 2nd:- Using 2 queues
    public void levelNextLn2(){
        Queue<Node> currLvl = new LinkedList<>();
        Queue<Node> nextLvl = new LinkedList<>();
        currLvl.add(root);
        while(!currLvl.isEmpty()){
            Node n=currLvl.poll();
            System.out.print(n.data+" ");
            if(n.left!=null)
                nextLvl.add(n.left);
            if(n.right!=null)
                nextLvl.add(n.right);
            if(currLvl.isEmpty()){ //currlvl is finished --> move to next level
                System.out.println(); //change the line
                currLvl=nextLvl;
//            Now, currlvl equals to nextlvl, so we have to make nextlvl again using "new" keyword otherwise the address of both currlvl and nextlvl would be same
                nextLvl=new LinkedList<>();
                //now previous nextlvl is removed automatically after creating new one due to garbage collector
            }
        }
    }

    //Reverse Level Order
    public void reverseLvl(){
        Queue<Node> Q=new LinkedList<>();
        Stack<Node> S=new Stack<>();
        Q.add(root);
        while(!Q.isEmpty()){
            Node n=Q.poll();
            S.push(n); //instead of printing like level order put the node in stack because it follows LIFO, so it will print in reverse order

//          To get the correct sequence (left to right at every level) --> Right subtree is visited before left subtree because in stack when left child will
//          be added at last, so it will print it first which will maintain the level order
//          If we don't do this then for tree :-                         7
//                                                               8              9
//                                                          12      11              5
//          we will print reverse level order 5,11,12,9,8,7 instead of 12,11,5,8,9,7
            if(n.right!=null)
                Q.add(n.right);
            if(n.left!=null)
                Q.add(n.left);
        }

//        printing the nodes :-
        while(!S.isEmpty()){
            Node n=S.pop();
            System.out.println(n.data);
        }
    }

//    Create the binary tree from given level order traversal in an array
    public void createLvl(int[] lvl){
        root=new Node(lvl[0]);
        int idx=1;
        Queue<Node> Q=new LinkedList<>();
        Q.add(root);
        while(!Q.isEmpty()){
            Node n=Q.poll();
            if(lvl[idx]!=-1){ //agar next element null nhi hai to tree ka left child banao
                Node L=new Node(lvl[idx]);
                n.left=L;
                Q.add(L);
            }
            idx++; //next element pe jaane ke liye index increment kro
            if(lvl[idx]!=-1){ //agar next element null nhi hai to tree ka right child banao
                Node R=new Node(lvl[idx]);
                n.right=R;
                Q.add(R);
            }
            idx++; //next element pe jaane ke liye index increment kro
        }
    }

//    Finding if 2 trees are equivalent or not
    public boolean equivalent(Node root1, Node root2){
        if(root1==null && root2==null) //agar dono tree empty hai then return true
            return true;
        if(root1==null || root2==null) //agar dono me se sirf ek tree empty hai then return false
            return false;
        boolean L=equivalent(root1.left, root2.left);
        boolean R=equivalent(root1.right,root2.right);
        return L && R && root1.data==root2.data;//Agar left & right subtree dono tree ke equal hai & dono tree ke root bhi same hai to return true otherwise false
    }

//    Finding if 2 trees are flip equivalent or not
//    https://leetcode.com/problems/flip-equivalent-binary-trees/description/
    public boolean flipEquiv(Node root1, Node root2) {
        if(root1==null && root2==null) //agar dono tree empty hai then return true
            return true;
        if(root1==null || root2==null) //agar dono me se sirf ek tree empty hai then return false
            return false;

        if(root1.data==root2.data){ //agar dono tree ke roots equal hai to flip and noflip ki conditions check kro

//            har node ke pass 2 choices hai, vo flip ho ya na ho
//            agar nodes flip nhi hai to dono tree ke nodes ke left subchild and right subchild equal hone chahiye
            boolean noflip= flipEquiv(root1.left, root2.left) && flipEquiv(root1.right,root2.right);

//   agar nodes flip hai to tree1 ke node ka left subchild == tree2 ke node ka right subchild and tree1 ke node ka right subchild == tree2 ke node ka left subchild
            boolean flip= flipEquiv(root1.left,root2.right) && flipEquiv(root1.right, root2.left);

            return noflip||flip; //agar nodes equal hai flip ya noflip then return true
        }
        else //agar dono tree ke roots equal nhi hai to false return kro
            return false;
    }

//    Check if the given binary tree is BST

//    O(n^2) time complexity approach:-
    private boolean isBST(Node n){ //here there are 4 recursive calls
        if(n==null)
            return true;
        if(max(n.left)<=n.data && min(n.right)>n.data){
            boolean L= isBST(n.left);
            boolean R= isBST(n.right);
            return L&&R;
        }
        return false;
    }
    public boolean isBST(){
        return isBST(root);
    }

//    O(n) time complexity approach :-
    class isBSTpair{
        boolean isBST=true;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
    }
    private isBSTpair isBST2(Node n){
        if(n==null)
            return new isBSTpair();

        isBSTpair L=isBST2(n.left);
        isBSTpair R=isBST2(n.right);
        isBSTpair ans=new isBSTpair();
        ans.min=Math.min(n.data,Math.min(L.min,R.min));
        ans.max=Math.max(n.data,Math.max(L.max,R.max));

        if(L.max<=n.data && R.min>n.data){
            ans.isBST= L.isBST && R.isBST;
        }
        else
            ans.isBST=false;

        return ans;
    }
    public boolean isBST2(){
        return isBST2(root).isBST;
    }
}
