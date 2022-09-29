import java.util.*;
public class practice {
    public static void main(String[] args) {
        int[] arr={1,3,2,4,7,6,9,10};
        List<Integer> AL=new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]%2==0) {
                AL.add(arr[i]);
                arr[i] = -1;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=-1)
                AL.add(arr[i]);
        }
        System.out.println(AL);
    }

}


