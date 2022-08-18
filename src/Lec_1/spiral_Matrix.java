package Lec_1;

public class spiral_Matrix {
    public static void main(String[] args) {
        int[][] arr =   {{1,2,7,8,9},
                {5,10,15,20,11},
                {6,12,18,24,27}};

        int r_max= arr.length-1,r_min=0;
        int c_max= arr[0].length-1,c_min=0;
        int count=0;
        int te=arr.length* arr[0].length;
        while(c_min<=c_max && r_min<=r_max )
        {
            for (int i =c_min; i <=c_max&& count<te ; i++) {
                System.out.print(arr[r_min][i] +" ");
                count++;
            }
            System.out.println();
            for (int i = r_min+1; i <=r_max&& count<te ; i++) {
                System.out.print(arr[i][c_max]+ " ");
                count++;

            }
            System.out.println();
            for (int i = c_max-1; i>=c_min&& count<te ; i--) {
                System.out.print(arr[r_max][i]+ " ");
                count++;

            }
            System.out.println();
            for (int i =r_max-1; i>=r_min+1&& count<te ; i--) {
                System.out.print(arr[i][c_min]+ " ");
                count++;

            }
            System.out.println();
            c_min++;c_max--;r_min++;r_max--;
        }
    }
}
