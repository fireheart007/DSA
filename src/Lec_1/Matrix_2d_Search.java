package Lec_1;

public class Matrix_2d_Search {
    public static void main(String[] args) {

        int[][] arr =   {{4,6,7,8},
                        {9,10,11,12},
                        {18,19,20,21},
                        {23,27,30,31}};
//        int ele=1;
        search(4,arr);

    }
    public static void search(int ele, int[][] arr)
    {
        //This logic will work for sorted array only
        //Here we will iterarte the array from 1st row's last element
        // agar element us se bada hoga to hum neeche vaali row me search krenge
        // or agar element chhota hoga to hum left side chalenge
        int c_max=arr[0].length-1,r_min=0;

        while (c_max>=0 && r_min<arr.length)
        {
            if(ele==arr[r_min][c_max])
            {
                System.out.println(" Element found at "+ (r_min+1)+","+(c_max+1));
                return;
            }
            else if(ele>arr[r_min][c_max])
            {
                r_min++;
            }
            else if(ele<arr[r_min][c_max])
            {
                c_max--;
            }
        }
        System.out.println("Element not found");
        //Above line while loop ke bahar likhni padegi kyunki agar element nhi mila to loop exit ho jayega
        //aur agar ye statement loop ke andar hogi to ye line print nhi hogi
    }

}
