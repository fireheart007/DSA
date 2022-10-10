import java.util.*;
public class practice {
    public static void main(String[] args) {
        List<Integer> AL=new ArrayList<>();
        AL.add(40);AL.add(60);AL.add(20);

        System.out.println(mixture(AL,0,1));
    }

    public static int mixture(List<Integer> AL,int i, int j){
        if(i>=AL.size() || j>= AL.size())
            return (int)1e9;
        int sp1=mixture(AL,i+2,j+2) + AL.get(i)*AL.get(j);
        int sp2=mixture(AL,i+1,j+1);
        return Math.min(sp1,Math.min(sp2,AL.get(i)*AL.get(j)));
    }

}
