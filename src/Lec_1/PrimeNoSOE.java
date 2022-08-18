package Lec_1;

import java.util.Arrays;
import java.util.Scanner;

public class PrimeNoSOE {
    public static void SOE(int n)
    {
        boolean[] isPrime= new boolean[n+1];
        // Here we wil make array of size n+1 because if we take no. of terms 9
        // then array length 9 will contain numbers from 0 to 8 only
        Arrays.fill(isPrime,true);
        for(int i=2;i*i<=n;i++)
            if(isPrime[i])
            {
                for (int mult = 2; mult*i <=n; mult++) {
                    isPrime[mult*i]=false;
                }
            }
        for (int i = 2; i <=n; i++) {
            if(isPrime[i])
                System.out.print(i+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the range of numbers : ");
        int n= sc.nextInt();
        SOE(n);
    }
}
