package com.leetcodeproj.leetcode.linkedList;

// Merge two sorted linked list
public class MergeList {
    public static void main(String[] args) {
            int[] a = {};
            int[] b={0};
            ListNode l1=createList(a);
            ListNode l2=createList(b);
            print(mergeTwoLists(l1,l2));

    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode tail = null;
        ListNode currNode = null;

        while(l1!=null && l2!=null){
            if(l1.val < l2.val){
              if(head==null){
                  head=new ListNode(l1.val);
                  tail=head;
              }else {
                  tail.next=new ListNode(l1.val);
                  tail=tail.next;
              }
              l1=l1.next;
            }else {
                if(head==null){
                    head=new ListNode(l2.val);
                    tail=head;
                }else {
                    tail.next=new ListNode(l2.val);
                    tail=tail.next;
                }
                l2=l2.next;
            }
        }
        while (l1!=null){
            if(head==null){
                head=new ListNode(l1.val);
                tail=head;
            }else {
                tail.next=new ListNode(l1.val);
                tail=tail.next;
            }
            l1=l1.next;
        }
        while (l2!=null){
            if(head==null){
                head=new ListNode(l2.val);
                tail=head;
            }else {
                tail.next=new ListNode(l2.val);
                tail=tail.next;
            }
            l2=l2.next;
        }
        return head;
    }
    public static ListNode createList(int[] numbers){
        ListNode head=null;
        ListNode node=null;
        ListNode tail=null;
        for(int n:numbers){
            node = new ListNode(n, null);
            if(head==null) {
                head=node;
                tail=node;
            }else {
                tail.next=node;
                tail=node;
            }
        }
        return head;
    }
    public static void print(ListNode head){
        ListNode node=null;
        node = head;
        while (node!=null){
            System.out.println("Value="+node.val);
            node=node.next;
        }
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){this.val=val;}
    ListNode(int val,ListNode next){
        this.val=val;
        this.next=next;
    }

}