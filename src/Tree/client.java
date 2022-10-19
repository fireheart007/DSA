package Tree;
//                      7
//               8              9
//          12      11              5
public class client {
    public static void main(String[] args) {
        BinaryTree bt=new BinaryTree();
        System.out.println("The formed tree is : - ");
        bt.Disp();
        System.out.println("The size of the tree is ");
        System.out.println(bt.size());
        System.out.println(25+" is found in the tree or not : "+bt.find(25));
        System.out.println("The height of tree is :"+ bt.height());
        System.out.println("Max. distance b/w 2 nodes is: "+bt.dia());
    }
}
