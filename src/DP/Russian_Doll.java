package DP;
//https://leetcode.com/problems/russian-doll-envelopes/
import java.util.*;
//Similar question to LIS
public class Russian_Doll {
    public static void main(String[] args) {
        int[][] arr={{5,4},{6,4},{6,7},{2,3}}; //increasing order of width ke basis pe sort kr do, and agar same width hai to jiski height zyada hai use pehle le lo
        // kyunki agar chhoti height waala pehle le lia to jab height ke basis pe LIS nikalenge to ans ayega ---> {2,3}->{6,4}->{6,7} which is not possible
        // as we can't fit {6,4} size envelope in {6,7} only possible solution will be {2,3}->{5,4}->{6,7}

        //SORTING LOGIC :-
        // "->" it is known as lambda operator, and it is used to define specific sorting that we want to do in the Arrays.sort or Collections.sort method
        // here a and b will be 1d array that contains an element of the 2d array arr, for eg:- a={5,4} , b={6,7}
        //if arr is a 1d array then a and b will be element of that array, for eg:- int[] arr={4,5,6} then a=4, b=5
        Arrays.sort(arr,(a, b) ->{ //a-b means array will be sort in increasing order and b-a means array will be sort in decreasing order
            if(a[0]==b[0]) //agar width same hai
                return b[1]-a[1]; // to height ko decreasing order me sort kr do
            else
                return a[0]-b[0]; // agar width same nhi hai to width ko increasing order me sort kr do
        });

        System.out.println(Russian_Doll(arr));
    }
    public static int Russian_Doll(int[][] arr){ //same logic of LIS
        List<Integer> AL =new ArrayList<>();
        AL.add(arr[0][1]);  //adding the height of first element
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i][1]> AL.get(AL.size()-1))
                AL.add(arr[i][1]);
            else{
                int idx= Collections.binarySearch(AL,arr[i][1]);
                if(idx<0)
                    idx=Math.abs(idx+1);
                AL.set(idx,arr[i][1]);
            }
        }
        return AL.size();
    }
}
