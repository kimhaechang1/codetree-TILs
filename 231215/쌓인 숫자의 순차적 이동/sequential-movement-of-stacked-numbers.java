import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int [][] map;
    static int n,m;
    static int [] dy = {-1,1,0,0,-1,-1,1,1};
    static int [] dx = {0,0,-1,1,-1,1,-1,1};
    static HashMap<Integer, int[]> cache;
    static class Node{
        int val;
        Node prev;
        Node next;
        public Node(int item){
            val = item;
        }
    }
    static class NodeLinkedList{
        Node head;
        Node tail;
        public NodeLinkedList(){
            head = new Node(-1);
            tail = new Node(-1);
            head.next = tail;
            tail.prev = head;
        }
        public void pushBack(int item){
            Node newNode = new Node(item);
            Node prev = tail.prev;
            prev.next = newNode;
            tail.prev = newNode;
            newNode.prev = prev;
            newNode.next = tail;
        }

        public Node pop(int from){
            Node temp = head;
            while(true){
                Node next = temp.next;
                if(next.val == from){
                    temp = next;
                    break;
                }else if(next.val == -1){
                    break;
                }   
                temp = next;
            }
            if(temp.val != -1){
                Node prev = temp.prev;
                prev.next = tail;
                tail.prev = prev;
                return temp;
            }else{
                return null;
            }
        }
        public void link(Node start, Node end, int find){
            tail.prev.next = start;
            start.prev = tail.prev;
            end.next = tail;
            tail.prev = end;
        }
        public boolean isEmpty(){
            if(head.next.val == -1){
                return true;
            }
            return false;
        }
        public Node getTailPrevNode() {
        	return tail.prev;
        }
        public void caching(int y, int x) {
        	Node n = head;
        	for(Node next = n.next;next.val != -1;next = next.next) {
        		cache.put(next.val, new int[] {y,x});
        	}
        }
    }
    static NodeLinkedList[][] linkedList;
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        linkedList = new NodeLinkedList[n][n];
        cache = new HashMap<>();
        for(int i =0;i<n;i++){
            stk = new StringTokenizer(bf.readLine());
            for(int j = 0;j<n;j++){
                linkedList[i][j] = new NodeLinkedList();
                int item = Integer.parseInt(stk.nextToken());
                linkedList[i][j].pushBack(item);
                cache.put(item, new int[]{i, j}); 
            }
        }
        
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<m;i++){
            int number = Integer.parseInt(stk.nextToken());
            int [] pos = cache.get(number);
            int max = 0;
            int maxY = -1;
            int maxX = -1;
            for(int k = 0;k<8;k++){
                int ny = pos[0] + dy[k];
                int nx = pos[1] + dx[k];
                if(ny >= n || ny < 0 || nx >= n || nx < 0) continue;
                NodeLinkedList templist = linkedList[ny][nx];
                for(Node pres = templist.head.next; pres.val != -1; pres = pres.next){
                	
                    if(max < pres.val){
                        max = pres.val;
                        maxY = ny;
                        maxX = nx;
                    }
                }
            }
            if(maxY == -1 && maxX == -1) continue;
            Node fromLast = linkedList[pos[0]][pos[1]].getTailPrevNode();
            Node fromStart = linkedList[pos[0]][pos[1]].pop(number);
            
            if(fromLast.val == fromStart.val) {
            	linkedList[maxY][maxX].pushBack(fromStart.val);
            }else {
            	linkedList[maxY][maxX].link(fromStart,fromLast , max);
            }
            //print(linkedList[maxY][maxX]);
            linkedList[maxY][maxX].caching(maxY, maxX);
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j = 0;j<n;j++){
                NodeLinkedList templist = linkedList[i][j];
                if(templist.isEmpty()){
                    sb.append("None").append("\n");
                    continue;
                }
                for(Node node = templist.tail.prev; node.val != -1;node = node.prev){
                    sb.append(node.val).append(" ");
                }
                sb.append("\n");
            }
            
        }
        System.out.println(sb);
    }
    static void print(NodeLinkedList linkedList) {
    	Node init = linkedList.head;
    	System.out.println("########해당 위치의 노드들 순서대로");
    	for(Node next = init.next; next.val !=-1;next = next.next) {
    		System.out.print(next.val+" => ");
    	}
    	System.out.println("\n###################################");
    }
}