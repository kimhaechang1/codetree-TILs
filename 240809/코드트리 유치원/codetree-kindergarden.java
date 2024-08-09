import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int q;
    static int idx;
    static class Node{
        Node prev;
        Node next;
        int val;
        
        public Node(){

        }

        public Node(int val){
            this.val = val;
        }
    }
    static class LinkedList{
        Node head;
        Node tail;

        public LinkedList(int init){
            head = new Node();
            tail = new Node();
            Node newNode = new Node(init);
            head.next = newNode;
            newNode.next = tail;
            tail.prev = newNode;
            newNode.prev = head;
        }

        public Node find(int findVal){
            for(Node nxt = this.head.next; nxt != null; nxt = nxt.next){
                if(nxt.val == findVal){
                    return nxt;
                }
            }
            return null;
        }

        public void addFront(int findVal, int cnt){
            Node target = find(findVal);
            Node tp = target.prev;
            LinkedList unlinked = makeNodes(cnt);
            target.prev = unlinked.tail.prev;
            unlinked.head.next.prev = tp;
            tp.next = unlinked.head.next;
            unlinked.tail.prev.next = target;
        }

        public void addBack(int findVal, int cnt){
            Node target = find(findVal);
            Node tn = target.next;
            LinkedList unlinked = makeNodes(cnt);
            target.next = unlinked.head.next;
            unlinked.tail.prev.next = tn;
            tn.prev = unlinked.tail.prev;
            unlinked.head.next.prev = target;
        }

        public LinkedList makeNodes(int cnt){
            LinkedList linked = new LinkedList(idx++);
            for(int i = 0;i<cnt-1;i++){
                Node tp = linked.tail.prev;
                Node newNode = new Node(idx++);
                linked.tail.prev = newNode;
                newNode.prev = tp;
                tp.next = newNode;
                newNode.next = linked.tail;
            }

            return linked;
        }

    }
    static LinkedList list;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        q = Integer.parseInt(bf.readLine());
        idx = 2;
        list = new LinkedList(1);
        sb = new StringBuilder();
        while(q-- > 0){
            stk = new StringTokenizer(bf.readLine());
            int query = Integer.parseInt(stk.nextToken());
            int a,b;
            switch(query){
                case 1:
                    a = Integer.parseInt(stk.nextToken());
                    b = Integer.parseInt(stk.nextToken());
                    doOne(a, b);
                    break;
                case 2:
                    a = Integer.parseInt(stk.nextToken());
                    b = Integer.parseInt(stk.nextToken());
                    doTwo(a, b);
                    break;
                case 3:
                    a = Integer.parseInt(stk.nextToken());
                    doThree(a);
                    break;
            }
        }
        System.out.print(sb);
    }
    static void doOne(int sIdx, int cnt){
        list.addBack(sIdx, cnt);
    }

    static void doTwo(int sIdx, int cnt){
        list.addFront(sIdx, cnt);
    }
    static void doThree(int sIdx){
        Node node = list.find(sIdx);
        if(node.prev == list.head || node.next == list.tail){
            sb.append(-1).append("\n");
            return;
        }
        sb.append(node.prev.val).append(" ").append(node.next.val).append("\n");
    }
}