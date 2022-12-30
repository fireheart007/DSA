package Heap;

public class Client {
    public static void main(String[] args) {
        Heap h=new Heap();
        h.add(10);
        h.add(50);
        h.add(6);

        h.disp();
        System.out.println("peek : "+h.peek());
        System.out.println(h.poll());
        h.disp();
        System.out.println(h.poll());
        h.disp();
        System.out.println(h.poll());
        h.disp();

    }
}
