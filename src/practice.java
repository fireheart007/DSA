import Tree.BinaryTree;
import Tree.Leetcode_BinaryTree;

import java.util.*;
public class practice {
    //if we use comparable then we have to define the compareTo func. in which we have to define how we want to sort the objects and also comparable is implemented
    // on the same class whose objects we want to make, to agar hum comparable use krenge to humesha ek hi tarike se sort kr payenge hum us class ke objects ko
    //But if we use comparator then we can make seperate classes for implementing compare func. in which we can define different sorting logics each time
    //we can also use lambda for implementing comparator, comparator ka use krke hum alag alag sorting logic ka use kr skte hai same class ke object banate waqt
    static class Pair{
        int data;
        int arr_idx;
        int ele_idx;

        public Pair(int d, int ai, int ei) {
            // TODO Auto-generated constructor stub
            data = d;
            arr_idx = ai;
            ele_idx = ei;
        }

        @Override
        public String toString() { //define toString method for printing objects
            return "["+data+","+arr_idx+","+ele_idx+"]";
        }

//        @Override
//        public int compareTo(Pair o) {
//            return this.data-o.data;
//        }
    }

        public static void main(String[] args) {
        PriorityQueue<Pair>  pq=new PriorityQueue<>((o1, o2)->o1.data-o2.data); //using lambda or comparator and storing data in increasing order
        pq.add(new Pair(10,0,0));
            pq.add(new Pair(17,0,7));
            pq.add(new Pair(7,5,3));

            System.out.println(pq);
            System.out.println(pq.poll());
            System.out.println(pq );
            System.out.println(pq.poll());
            System.out.println(pq.poll());

            System.out.println(pq);

    }
}
