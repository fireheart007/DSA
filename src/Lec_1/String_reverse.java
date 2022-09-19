package Lec_1;

public class String_reverse {
    public static void main(String[] args) {
        String str="My name is Shivang Sharma";
        String temp="";
        while(true) {
            int idx = str.lastIndexOf(' ');
            temp = temp + str.substring(idx + 1)+" ";
            if(idx==-1)
                break;
            str = str.substring(0, idx);
        }
        System.out.println(temp);
    }
}
