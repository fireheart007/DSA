package Heap;
import java.util.ArrayList;

//User defined Heap, here we are making min heap
public class Heap {
    ArrayList<Integer> al=new ArrayList<>();

    public void add(int ele){
        al.add(ele); //after adding element in heap in the last
        upHeapify(al.size()-1); //we have to upheapify that last element to maintain the priority
    }

    private void upHeapify(int child) {
        int p=(child-1)/2;
        if(al.get(p)>al.get(child)) { //agar parent, child se bada hai to child ko parent bana do and parent ko child
            swap(child, p);
            upHeapify(p); //after doing so, again call the recursive func.
        }
        //we don't have to write base case here because after going on child=0, p will also be 0, so if condition will fail and we will be out of function
    }
    private void swap(int i, int j) {
        int temp=al.get(j);
        al.set(j,al.get(i));
        al.set(i,temp);
    }
    public void disp(){
        System.out.println(al);
    }
    public int peek(){
        return al.get(0);
    }
    public int size(){
        return al.size();
    }
    public boolean isEmpty(){
        return al.isEmpty();
    }
    public int poll(){
        int first=al.get(0);
        int last=al.get(al.size()-1);
        al.set(0,last); //put last element as the first element to ensure CBT
        al.remove(al.size()-1); //remove the last ele. to avoid duplicate values
        downHeapify(0); //we have to downheapify from 1st ele. to maintain the priority
        return first; //also return the ele. that we have removed
    }
    private void downHeapify(int p) {
        int lc=2*p+1; //left child
        int rc=2*p+2; //right child

        if(lc>= al.size() || rc>=al.size()) //B.C --> agar left ya right child ka index out of bound ho jaaye then return
            return;

        //now we are finding index of the child that has min. value
        int min_idx=0; //initializing min. idx with 0
        if(al.get(lc)<al.get(rc)) { //agar left child chhota hai to uske idx ko min_idx me daal do
            min_idx = lc;
        }
        else { //nhi to right child ka idx daal do min_idx me
            min_idx = rc;
        }
        if(al.get(min_idx)<al.get(p)){ //agar min_idx ka ele parent se chhota hai to
            swap(min_idx,p); //swap them
            downHeapify(min_idx); //and now do downheapify from min_idx ele.
        }
    }

}
