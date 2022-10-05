import java.util.*;
public class practice {
    public static void main(String[] args) {
        int[] arr={7,3,5,2,-4,8,11};
        int[] ans=new int[2];
        int ele=arr[0];
        int[] nums=new int[arr.length-1];
        for (int i = 0; i <nums.length; i++) {
            nums[i]=arr[i+1];
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int s=0,e=nums.length-1;
        while(s<e){
            if((nums[s]+nums[e])>ele)
            {
                e--;
            }
            else if((nums[s]+nums[e])<ele)
            {
                s++;
            }
            break;
        }
        ans[0]=nums[s];
        ans[1]=nums[e];
    }

}
