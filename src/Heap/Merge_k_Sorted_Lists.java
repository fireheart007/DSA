package Heap;
import java.util.PriorityQueue;

//https://leetcode.com/problems/merge-k-sorted-lists/description/
public class Merge_k_Sorted_Lists {
    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        a.next=new ListNode(4);
        a.next.next=new ListNode(5);
        ListNode b=new ListNode(1);
        b.next=new ListNode(3);
        b.next.next=new ListNode(4);
        ListNode c=new ListNode(2);
        c.next=new ListNode(6);

        ListNode[] arr={a,b,c}; //arr = [[1,4,5],[1,3,4],[2,6]]
        System.out.println(mergeKLists(arr)); //output: 1->1->2->3->4->4->5->6
    }
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() { //made this only for printing ans in the main() func.
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    //Similar Logic to merge k sorted arrays , Overall TC -> klogk + n*klogk = n*klogk, SC ->O(k) for making PQ of size k
    //n is the no. of elements in each L.L array and there are k L.L
    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a, b)->a.val-b.val); //creating min heap acc. to data of L.L

        for(int i=0;i<lists.length;i++){ //adding first k node in L.L , klogk TC
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        ListNode head=null; //initializing head and tail of ans L.L
        ListNode tail=null;
        while(!pq.isEmpty()){ // n*klogk TC
            ListNode temp=pq.poll(); //removing first element from PQ and store it in temp
            if(temp.next!=null) //add the next element of that L.L to PQ if it is not null
                pq.add(temp.next);
            if(head==null){ //if we are adding first element
                head=temp; //then head and tail will be pointing to same node
                tail=temp;
            }
            else{ //otherwise update the next of tail to temp
                tail.next=temp;
                tail=temp; //and then go to next node
            }
        }
        return head; //return head of the ans L.L
    }
}
