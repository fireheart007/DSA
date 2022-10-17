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
        }
    }
    Node root;
    public BinaryTree(){
//        root=create(null,false);   //using return node method

        System.out.println("Enter root node data"); //using void method
        root=new Node(sc.nextInt());
        create(root);
    }

    public void create(Node parent) {
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
        return left+right+1;
    }
    public int size(){
        return size(root);
    }
}
