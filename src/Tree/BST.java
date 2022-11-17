package Tree;

public class BST {
    class Node{ //Same as Binary Tree
        int data;
        Node left;
        Node right;
        Node(int i){
            data=i;
        }
    }
    Node root;

//    Adding an element to the BST or creating a BST
    private Node add(Node n,int ele){
        if(n==null) //agar node null hai to use node pe element add kr do
            return new Node(ele);
        if(ele<=n.data) //agar element current node se chhota ya equal hai to use tree ke left subtree me add kro
            n.left=add(n.left,ele);
        else //agar element current node se bada hai to use tree ke right subtree me add kro
            n.right=add(n.right,ele);
        return n;
    }
    public void add(int ele){
        root=add(root,ele);
    }

    private void Disp(Node n){ //Same as Binary Tree
        if(n==null)
            return;
        System.out.println(n.data);
        Disp(n.left);
        Disp(n.right);
    }
    public void Disp(){
        Disp(root);
    }

    private int size(Node n){ //Same as Binary Tree
        if(n==null)
            return 0;
        int l=size(n.left);
        int r= size(n.right);
        return l+r+1;
    }
    public int size(){
        return size(root);
    }

    private boolean find(Node n,int ele){
        if(n==null)
            return false;
        if(ele==n.data) //agar element mil gya to true return kro
            return true;
        if(ele<n.data) //agar element current node se chhota hai to use tree ke left subtree me find kro
            return find(n.left,ele);
        else //agar element current node se bada hai to use tree ke right subtree me find kro
            return find(n.right,ele);
    }
    public boolean find(int ele){
        return find(root,ele);
    }

    private int ht(Node n){ //Same as Binary Tree
        if(n==null)
            return -1;
        int l=ht(n.left);
        int r=ht(n.right);
        return Math.max(l,r)+1;
    }
    public int ht(){
        return ht(root);
    }

//    Max ele of the BST
    private int max(Node n){
        if(n.right==null)//agar node ka right subtree null hai iska matlab tree end ho gya, so return current node ele.
            return n.data;
        return max(n.right); //jo max ele hai vo humesha BST ke right subtree me hi hoga
    }
    public int max(){
        return max(root);
    }
//    Min ele of BST
    private int min(Node n){
        if(n.left==null)//agar node ka left subtree null hai iska matlab tree end ho gya, so return current node ele.
            return n.data;
        return min(n.left);//jo min ele hai vo humesha BST ke left subtree me hi hoga
    }
    public int min(){
        return min(root);
    }

    //    Removing an element from the BST
    private Node remove(Node n,int ele){
        if(n==null) //agar node exist hi nhi krti to return null
            return null;
        if(ele<n.data) //agar element current node se chhota hai to use left subtree me se remove kro
            n.left=remove(n.left,ele);
        else if (ele>n.data) {//agar element current node se bada hai to use right subtree me se remove kro
            n.right=remove(n.right,ele);
        }
        else { //agar element n.data ke equal hai to -

            // Case 1: if element is leaf node
            if(n.left==null && n.right==null)
                return null; //to pichhle node ko null return kr do

            //Case 2: If element has only a single child
            if(n.left!=null && n.right==null) //agar node ka sirf left child hai
                return n.left; //to pichhle node ko n.left return kr do
            if(n.left==null && n.right!=null) //agar node ka sirf right child hai
                return n.right; //to pichhle node ko n.right return kr do

            //Case 3: If current node has both children
//          to current node ki value ko left subtree ke max ya right subtree ke min se change kr do kyunki agar humne
//          direct element remove kr dia to neeche ka bacha hua poora tree remove ho jayega
//          or n.data ko left subtree ke max ya right subtree ke min ke barabar isliye rkha hai taki BST maintain rhe

            int max=max(n.left); //here we are taking max of left subtree
            n.data=max; //updating the value of current node
            n.left=remove(n.left,max); //removing the max value from left subtree otherwise that element will be
            // present in the tree 2 times
        }
        return n;
    }
    public void remove(int ele){
        root=remove(root,ele);
    }
}
