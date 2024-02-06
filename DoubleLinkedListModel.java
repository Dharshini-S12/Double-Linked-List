package prob1;
import java.util.*;
import prob1.LinkedModel.Node;
class DLL{
	Node head;
	Node tail;
	class Node{
		int data;
		Node prev;
		Node next;
		Node(int val){
			this.data=val;
			this.next=null;
		}
	}
	DLL(){
		head=null;
		tail=null;
	}
	public void insertAtBeginning(int data) {
		Node newNode = new Node(data);
		newNode.next=head;
		if(head==null) 
		{
		    tail= newNode;
		}
		else
		{
			head.prev=newNode;
		}
		head=newNode;
	}
	public void insertAtPos(int pos, int val) {
		pos-=1;
		if(pos==0)
		{
			insertAtBeginning(val);
			return;
		}
		Node newNode=new Node(val);
		Node temp=head;
	    
		for(int i=1;i<=pos;i++) {
			temp=temp.next;
			if(temp==null)
			{
				System.out.println("Invalid pos");
				return;
			}
		}
		Node p= temp.prev;
		p.next=newNode;
		newNode.prev=p;
		newNode.next=temp;
		temp.prev=newNode;
	}
	public void insertAtEnd(int data)
	{
		Node a = new Node(data);
		if(head == null)
		{
			head=a;
			tail=a;
		}
		
		else {
			tail.next=a;
			a.prev=tail;
			tail=a;
		}
	}
	public void dispaly() {
		Node temp= head;
		while(temp!=null)
		{
			System.out.print(temp.data);
			System.out.println();
			temp=temp.next;
		}
	}
	public int search(int target) {
		Node temp=head;
		int pos=-1;
		while(temp!= null) {
			if(temp.data==target) {
				return pos+1;
			}
			pos++;
			temp=temp.next;
		}
		return -1;
	}
	public boolean contains(int target) {
        Node temp = head;
        while (temp != null) {
            if (temp.data == target) {
            	return true;
            }
            temp = temp.next;
        }
        return false;
    }
	public void deleteAtBeg(){
		if(head==null) {
			System.out.println("List is empty");
			return;
		}
		head=head.next;
		head.prev=null;
	}
	void deleteAtLast(){
        if(head==null) {
            System.out.println("the list is Empty");
            return;
        }
        tail=tail.prev;
        tail.next=null;
    }
	void deletePos(int pos){
        pos-=1;
        if(pos==0){
            deleteAtBeg();
            return;
        }
        Node temp=head;
        Node per=null;
        for(int i=0;i<pos;i++){
            per=temp;
            temp=temp.next;
        }
        per.next=temp.next;
        temp=temp.next;
        temp.prev=per;

    }
}
public class DoubleLinkedListModel {
	public static void main(String[] args) {
		DLL dl=new DLL();
		dl.insertAtBeginning(10);
		dl.insertAtBeginning(20);
		dl.insertAtBeginning(30);
		dl.insertAtBeginning(40);
		dl.dispaly();
        /*System.out.println(dl.search(20));
        System.out.println(dl.contains(30));
        dl.insertAtEnd(25);
        dl.deleteAtBeg();*/
		dl.insertAtPos(4, 100);
        dl.dispaly();
	}

}
