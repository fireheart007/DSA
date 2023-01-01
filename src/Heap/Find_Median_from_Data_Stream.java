package Heap;
import java.util.*;
//https://leetcode.com/problems/find-median-from-data-stream/description/
public class Find_Median_from_Data_Stream { //TC -> nlogn , logn for adding each element in PQ and we are adding n elements
    //globally declaring max and min heap
    static PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder()); //it will store sorted elements of left half
    static PriorityQueue<Integer> minHeap=new PriorityQueue<>(); //and it will store sorted elements of right half
    
    public static void main(String[] args) {
        int[] arr= {2,3,4};
        for (int i = 0; i < arr.length; i++) {
            addNum(arr[i]);
            System.out.println(findMedian());
        }
    }
    public static void addNum(int num) {
        //if maxheap is empty then minHeap will also be empty because we have assumed that always maxHeap.size()=minHeap.size()+1 or maxHeap.size()=minHeap.size()
        if(maxHeap.isEmpty()) //isliye pehla element maxHeap me add hoga, as after adding element maxHeap.size will be 1 and minHeap.size=0 and condition of size
            maxHeap.add(num); // will remain satisfied

        else if (maxHeap.size()==minHeap.size()) { //if size of both heaps are equal then
            if(num<minHeap.peek()) //if num < top element of minHeap
                maxHeap.add(num); //to use maxHeap me add kr do
            else{ //agar num > top element of maxHeap then add it in minHeap ,but it will make size of minHeap>maxHeap which can not be done
                maxHeap.add(minHeap.poll()); //so first remove top element of minHeap and add it to maxHeap
                minHeap.add(num); //and then add num in minHeap , this will help to maintain the size condition
            }
        }
        else{ //if maxHeap.size=minHeap.size+1
            if(num>maxHeap.peek()) //agar num > top element of maxHeap
            {
                minHeap.add(num); //to use minHeap me add kr do
            }
            else { //else if num < top element of minHeap then add it in maxHeap, but it will make size of maxHeap>minHeap+1 which can not be done
                minHeap.add(maxHeap.poll()); //so first remove top element of maxHeap and add it to minHeap
                maxHeap.add(num);//and then add num in maxHeap , this will help to maintain the size condition
            }
        }
    }

    public static double findMedian() {
        if(maxHeap.size()>minHeap.size()) //agar maxHeap ka size bada hai it means we have odd no. of elements , then uska top element hi median hoga
            return maxHeap.peek();
        else // if we have even no. of elements i.e. size of both are equal
            return (maxHeap.peek()+minHeap.peek())/2.0; //then average of top elements of both the heap will be median
    }
}
