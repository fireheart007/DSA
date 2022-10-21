package Tree;
//                      7
//               8              9
//          12      11              5
public class client {
    public static void main(String[] args) {
//        Input Copy :-
//        7 true 8 true 12 false false true 11 false false true 9 false true 5 false false

        BinaryTree bt=new BinaryTree();
        System.out.println("The formed tree is : - ");
        bt.Disp();
        System.out.println("The size of the tree is ");
        System.out.println(bt.size());
        System.out.println(25+" is found in the tree or not : "+bt.find(25));
        System.out.println("The height of tree is :"+ bt.height());
//        System.out.println("Max. distance b/w 2 nodes is: "+bt.dia()); // O(n^2) time complexity
        System.out.println("Max. distance b/w 2 nodes is: "+bt.dia2()); //  O(n) time complexity
//        System.out.println("Is the tree balanced ? :- "+bt.isBalanced());//  O(n^2) time complexity
        System.out.println("Is the tree balanced ? :- "+bt.isBalanced2());//  O(n) time complexity
    }
}
