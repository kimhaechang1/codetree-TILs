import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[] arr;
    static StringTokenizer stk;
    static class Data implements Comparable<Data>{
        int s;
        int e;

        public Data(int s){
            this.s = s;
        }
        public Data(int s, int e){
            this.s = s;
            this.e = e;
        }

        public int compareTo(Data o){
            return this.s - o.s;
        }

        public String toString(){
            return "[s: "+s+", e: "+e+"]";
        }
    }
    static class Line implements Comparable<Line>{
        int s;
        int e;
        public Line(int s){
            this.s = s;
        }
        public Line(int s, int e){
            this.s = s;
            this.e = e;
        }

        public int compareTo(Line o){
            return ((o.e - o.s) + 1) - ((this.e - this.s) + 1);
        }

        public String toString(){
            return "[s: "+s+", e: "+e+"]";
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken()); // ~ 10^9
        m = Integer.parseInt(stk.nextToken()); // ~ 10^5

        arr = new int[m];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<m;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        // 시간이 오래걸린 이유: 점을 어떻게 관리할지에 매몰되었음, 점을 관리 == 10억개 관리가 되기때문에 O(N)도 안됨
        // 그렇기 때문에 구간을 어떻게 처리할지를 생각해야함, 왜냐하면 구간은 어짜피 삭제해야할 원소에 의해 나눠지기 때문임(분할정복과 비슷함)
        // 무조건 연속됨이 보장된다면
        // 제거해야 할 숫자 기준으로 왼쪽과 오른쪽으로 나눠짐
        // 그리고 주어진 숫자보다 가장 가까우면서 같거나 작은 점을 포함하는 선분을 찾아야함
        // 이런거 찾는데에는 TreeSet<Data>
        // 그리고 TreeSet<Line>을 관리하여 길이가 가장 큰것을 log 수준의 연산으로 바로바로 뽑아야함
        TreeSet<Data> intervals = new TreeSet<>();
        intervals.add(new Data(0, n));
        TreeMap<Line, Integer> lineMap = new TreeMap<>();
        lineMap.put(new Line(0, n), 1);
        StringBuilder sb =new StringBuilder();
        for(int i= 0;i<arr.length;i++){
            Data lowD = intervals.floor(new Data(arr[i]));
            Line target = new Line(lowD.s, lowD.e);
            if(lineMap.get(target) - 1 == 0){
                lineMap.remove(target);
            }else{
                lineMap.put(target, lineMap.get(target) - 1);
            }
            intervals.remove(new Data(lowD.s, lowD.e));
            int a1 = lowD.s;
            int a2 = Math.max(lowD.s, arr[i]-1);
            int b1 = Math.min(lowD.e, arr[i]+1);
            int b2 = lowD.e;

            intervals.add(new Data(a1, a2));
            intervals.add(new Data(b1, b2));

            Line line1 = new Line(a1, a2);
            Line line2 = new Line(b1, b2);

            lineMap.put(line1, lineMap.get(line1) == null ? 1 : lineMap.get(line1) + 1);
            lineMap.put(line2, lineMap.get(line2) == null ? 1 : lineMap.get(line2) + 1);

            Line most = lineMap.firstKey();
            sb.append((most.e - most.s + 1)).append("\n");
        }
        System.out.print(sb);

    }
}