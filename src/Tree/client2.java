package Tree;

public class client2 {
    public static void main(String[] args) {
        BST bst=new BST();
        bst.add(5);
        bst.add(7);
        bst.add(3);
        bst.add(2);
        bst.Disp();
        System.out.println("Size of the BST is :- "+bst.size()); //size of BST
        System.out.println("Element is found in the tree : "+bst.find(30)); //Find ele in a BST
        System.out.println("Height of the BST is :- "+bst.ht()); // Ht. of BST
        System.out.println("Max ele of BST is :- "+bst.max()); //max of BST
        System.out.println("Min ele of BST is :- "+bst.min()); //min of BST

        bst.remove(9); //removing an element from BST
        bst.Disp();
    }
}
