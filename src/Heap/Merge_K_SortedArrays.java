package Heap;
import java.util.*;

//https://practice.geeksforgeeks.org/problems/merge-k-sorted-arrays/1
public class Merge_K_SortedArrays {
    public static void main(String[] args) {
        int k = 3;
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(mergeKArrays(arr,k));
    }

    //if we use comparable then we have to define the compareTo func. in which we have to define how we want to sort the objects and also comparable is implemented
    // on the same class whose objects we want to make, to agar hum comparable use krenge to humesha hum us class ke objects ko ek hi tarike se sort kr payenge
    //But if we use comparator then we can make seperate classes for implementing compare func. in which we can define different sorting logics each time
    //we can also use lambda for implementing comparator, comparator ka use krke hum alag alag sorting logic ka use kr skte hai same class ke object banate waqt
    static class Pair{ //we are making a class which will store curr element data, its index and 1D array index
        int arr_idx;
        int ele_idx;
        int data;
        public Pair(int d,int ai,int ei){
            data=d;
            arr_idx=ai;
            ele_idx=ei;
        }

        //we can define toString method for printing objects
//        @Override
//        public String toString() {
//            return "["+data+","+arr_idx+","+ele_idx+"]";
//        }

//        @Override
//        public int compareTo(Pair o) { //we have to define this function if we want to implement comparable to this class
//            return this.data-o.data;
//        }
    }
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K)
    {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.data-b.data); //using lambda or comparator & storing data in increasing order -> we are making min heap

        //klogk TC of for loop -> logk for adding each element in PQ, and we are adding k elements
        for (int i = 0; i < arr.length; i++) {
            pq.add(new Pair(arr[i][0],i,0)); //adding first element of each array in PQ along with array index and element index
        }
        //After adding k elements in PQ, the first element in pq will be the min. element of the whole 2D array, as array is sorted so first element of each 1D array
        // is its min. element and after adding 1st ele of each 1D array in PQ, due to min. heap property, we will have the min. element of the whole 2D array as
        // the first element of PQ

        ArrayList<Integer> ans=new ArrayList<>(); //for storing final ans. and returning it

        //suppose there are n elements in each 1D array and there are k 1D arrays then complexity will be -
        //n*klogk TC  of while loop -> logk for removing each element from PQ and logk for adding (n*k-k) elements in PQ
        while (!pq.isEmpty()){
            Pair curr=pq.poll(); //pq me se first element nikalo
            ans.add(curr.data); //or use AL me daalo kyunki vo hi min. ele hoga
            if(curr.ele_idx+1==arr[curr.arr_idx].length) //agar curr. array ke end me aa gye to us array ke element pq me add krna band kro
                continue;
            pq.add(new Pair(arr[curr.arr_idx][curr.ele_idx+1], curr.arr_idx, curr.ele_idx+1)); //curr 1D array ka next element PQ me add kr do
        }
        return ans;
    }
    // Overall TC = klogk + n*klogk = n*klogk

}
