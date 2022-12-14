package Tree;
//                      7
//               8              9
//          12      11              5
public class client1 {
    public static void main(String[] args) {
//        Input Copy :-
//        7 true 8 true 12 false false true 11 false false true 9 false true 5 false false

        BinaryTree bt=new BinaryTree();
//        System.out.println("The formed tree is : - ");
//        bt.Disp();
//        System.out.println("The size of the tree is ");
//        System.out.println(bt.size());
//        System.out.println(25+" is found in the tree or not : "+bt.find(25));
//        System.out.println("The height of tree is :"+ bt.height());
////        System.out.println("Max. distance b/w 2 nodes is: "+bt.dia()); // O(n^2) time complexity
//        System.out.println("Max. distance b/w 2 nodes is: "+bt.dia2()); //  O(n) time complexity
////        System.out.println("Is the tree balanced ? :- "+bt.isBalanced());//  O(n^2) time complexity
//        System.out.println("Is the tree balanced ? :- "+bt.isBalanced2());//  O(n) time complexity

//        Given an array with preorder traversal, form the binary tree from it
//        int[] pre={10,20,30,-1,-1,50,-1,-1,40,60,-1,-1,-1};
//        BinaryTree bt=new BinaryTree(pre);
//        bt.Disp();

//        Given preorder and inorder traversal create the binary tree
//        int[] pre={10,20,30,50,40,60};
//        int[] in={30,20,50,10,40,60};
//        BinaryTree bt=new BinaryTree(pre,in);

        //Printing level order of the tree :-
//        BinaryTree bt=new BinaryTree();
//        System.out.println("Level order of the tree is :-");
//        bt.level();
//        bt.levelNextLn(); //level order traversal such that print nodes in next line at each level
//        bt.levelNextLn2();  //level order traversal such that print nodes in next line at each level - 2nd approach

//        System.out.println("Reverse Level order of the tree is :-");
//        bt.reverseLvl();

        // Creating binary tree from given level order
//        int[] lvl= {7,8,9,12,11,-1,5,-1,-1,-1,-1,-1,-1};
//        bt.createLvl(lvl);
//        bt.Disp();

        // Finding if 2 trees are equivalent or not
//        int[] pre1={7,8,12,-1,-1,11,-1,-1,9,-1,5,-1,-1};
//        BinaryTree bt1=new BinaryTree(pre1);
//        int[] pre2={10,20,30,-1,-1,50,-1,-1,40,60,-1,-1,-1};
//        BinaryTree bt2=new BinaryTree(pre2);
//        System.out.println(bt1.equivalent(bt1.root, bt2.root));

        // Finding if 2 trees are flip equivalent or not
//        int[] pre1={7,8,12,-1,-1,11,-1,-1,9,-1,5,-1,-1};
//        BinaryTree bt1=new BinaryTree(pre1);
//        int[] pre2={7,9,-1,5,-1,-1,8,12,-1,-1,11,-1,-1};
//        BinaryTree bt2=new BinaryTree(pre2);
//        System.out.println(bt1.flipEquiv(bt1.root, bt2.root));

        // Check if given Binary Tree is BST or not
//        int[] pre={60,10,7,-1,-1,30,-1,-1,70,65,-1,-1,90,-1,-1};
//        BinaryTree bt=new BinaryTree(pre);
////        System.out.println(bt.isBST());  //o(n^2) time complexity
//        System.out.println(bt.isBST2());  //o(n) time complexity

        //Find the size of biggest BST present in the given Binary Tree
//        int[] pre={10,20,30,-1,-1,50,-1,-1,40,60,-1,-1,-1};
//        BinaryTree bt=new BinaryTree(pre);
////        System.out.println(bt.BiggestBST());
//        System.out.println(bt.BiggestBST2());

        //Morris Traversal
//        bt.morrisTraversalInorder();
//        bt.morrisTraversalPreOrder();
    }
}
