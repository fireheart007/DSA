package Heap;
import java.util.*;

//https://leetcode.com/problems/top-k-frequent-elements/description/
public class Top_K_Frequent_Elements {
    public static void main(String[] args) {
        int[] arr={7,8,8,8,9,9};
        int k=2;
        System.out.println(Arrays.toString(topKFrequent(arr, k)));
    }

    static class Pair{
        int data;
        int frequency;
        public Pair(int d,int f){
            data=d;
            frequency=f;
        }
    }
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>(); //store array element as key and its frequency as value in the map
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]))
                map.put(nums[i],map.get(nums[i])+1); //if key is already present then increase its frequency by 1
            else
                map.put(nums[i],1); //else add the new key with frequency as 1
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.frequency-b.frequency); //make min heap according to the frequency of element
        for (int i : map.keySet()) { //a key in map is an element of the array
            pq.add(new Pair(i,map.get(i))); // add element , frequency in the PQ
            if(pq.size()==k+1) //if size of PQ is greater than k then remove the element which have min. frequency i.e. top element of PQ
                pq.poll();
        }
        int[] arr=new int[k]; //make array of size k for returning ans
        for (int i = 0; i<arr.length; i++) {
            arr[i]=pq.poll().data; //add the element of PQ in the array
        }
        return arr;
    }
}
