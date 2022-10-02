import java.util.*;
public class practice {
    public static void main(String[] args) {
        int[] arr={4,10,4,3,8,9};
        System.out.println(LIS_nlogn(arr));
    }
    public static int LIS_nlogn(int[] arr){
        List<Integer> AL = new ArrayList<>();
        AL.add(arr[0]); //first element of array is added directly into AL to compare with the rest of the elements of the array
        for (int i = 1; i < arr.length; i++) {
            if(arr[i]>AL.get(AL.size()-1)) //agar array ka element list me pade last element se bada hai to use list ke end me add kr do
                AL.add(arr[i]);
            else {
//                This function returns an index of the element, if it is contained in the AL; otherwise, (-(insertion point) – 1).
//                The insertion point is defined as the idx of just bada element.
                int idx = Collections.binarySearch(AL,arr[i]);
                if(idx<0)
                    idx=Math.abs(idx+1); //if element is not present in AL then we have to do this to make idx +ve
                AL.set(idx,arr[i]);  //we are inserting the element arr[i] in AL at the index where just bada element was present
            }
        }
        return AL.size();
    }



}


