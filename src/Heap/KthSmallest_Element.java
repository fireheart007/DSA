package Heap;
import java.util.*;

//https://practice.geeksforgeeks.org/problems/kth-smallest-element5635/1
public class KthSmallest_Element {
    public static void main(String[] args) {
        int[] arr={7,10,4,3,20,15};
        int k=3;
        System.out.println(kthSmallest(arr,k));
    }
    public static int kthSmallest(int[] arr,int k)
    {
        PriorityQueue<Integer> PQ=new PriorityQueue<>(Collections.reverseOrder()); //here we will make a max heap
        for (int i = 0; i < arr.length; i++) {
            PQ.add(arr[i]);
            if(PQ.size()==k+1)
                PQ.poll();
        }
        return PQ.peek();
    }
}
