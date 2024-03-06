class Node{
    int val;
    Node next;
    Node (int data){
        val=data;
        next=null;
    }
}
public class LinkedListCycle {
    public static void main(String[] args) {

        Node head=new Node(3);
        head.next=new Node(2);
        head.next.next=new Node(0);
        head.next.next.next=new Node(-4);
        head.next.next.next.next=head.next;

        boolean hasCycle=hasCycle(head);
        System.out.println("Linked list has a cycle :"+hasCycle);
    }
    public static boolean hasCycle(Node head){
        if (head==null || head.next==null){
            return false;
        }
        Node slow=head;
        Node fast=head.next;

        while (slow!=fast){
            if (fast==null || fast.next==null){
                return false;
            }
            slow=slow.next;
            fast=fast.next.next;
        }
        return true;
    }
}
