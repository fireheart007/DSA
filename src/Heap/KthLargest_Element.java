package Heap;
import java.util.PriorityQueue;

//https://leetcode.com/problems/kth-largest-element-in-an-array/description/
public class KthLargest_Element {
    public static void main(String[] args) {
        int[] arr={3,2,3,1,2,4,5,5,6};
        int k=4;
        System.out.println(findKthLargest(arr,k));
    }

    //nlogK TC -> logk for adding and removing elements from PQ and loop is running n times
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> PQ=new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            PQ.add(nums[i]);
            if(PQ.size()==k+1)
                PQ.poll();
        }
        return PQ.peek();
    }
}
