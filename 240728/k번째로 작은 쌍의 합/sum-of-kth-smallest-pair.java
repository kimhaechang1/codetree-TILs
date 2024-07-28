import java.util.*;
import java.io.*;

public class Main {
    static int n,m,k;
    static int[] arr, brr;
    static StringTokenizer stk;
    static class Sum implements Comparable<Sum>{
        int sum;
        int idx1;
        int idx2;

        public Sum(int sum, int idx1, int idx2){
            this.sum = sum;
            this.idx1= idx1;
            this.idx2= idx2; 
        }

        public int compareTo(Sum o){
            if(this.sum == o.sum){
                if(this.idx1 == o.idx1){
                    return this.idx2 - o.idx2;
                }
                return this.idx1 - o.idx1; // 이렇게 해주는 이유는, 기준이 되는 원소를 제외하고 순회되는 N개를 먼저 소비해야 하기 때문
            }
            return this.sum - o.sum;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        arr = new int[n];
        brr = new int[m];
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        stk = new StringTokenizer(bf.readLine());
        for(int i = 0;i<m;i++){
            brr[i] = Integer.parseInt(stk.nextToken());
        }

        // 첫 수열도 10만개가 될 수 있고, 두번째 수열도 10만개가 될 수 있다.
        // 여기서 두 수열의 모든 쌍의 합을 오름차순 하려고하면 10만 * 10만이라 안된다.
        // 하지만 문제에서 k번째는 10만이다. 즉, 모든걸 다 구하면 안된다는것을 알 수 있다.
        // 그럼 어떻게 해야할까? 만약 진짜 10만개 by 10만개라면, 모두 전처리하는것은 힘들겠지만
        // 하나의 기준을 잡고 반대쪽 10만개를 돌리는것은 충분할 것이다.
        // 그리고 k번째가 덜 채워지는 동안에는, 계속적으로 현재의 후보를 제거하고 다음 기준idx를 옮기는것이 좋다.
        // 현재 코드에서는 idx1이 계속 변동이 자주있는 인덱스이고, idx2가 기준 원소가 된다.
        // 이를 달성하기 위해서 클래스를 하나 선언(Sum)그리고 기준 반대쪽 순회되어지는 인덱스가 지속적으로 소비되어야 하기 때문에 해당 원소가 먼저 정렬
        // 이런식으로 전체를 구하기보다는 부분에서 해가 나오는것이 확정이되었다면 축적하는 방식으로 문제를 해결하자.
        // 그리고 영구적으로 배제해도되는 원소가 있는지 검사하자.

        Arrays.sort(arr);
        Arrays.sort(brr);
        PriorityQueue<Sum> pq = new PriorityQueue<>();
        for(int i = 0;i<k-1;i++){
            pq.add(new Sum(arr[i] + brr[0], i, 0));
        }

        for(int i = 0;i<k-1;i++){
            Sum now = pq.poll();
            int idx1 = now.idx1;
            int idx2 = now.idx2;

            idx2++;
            if(idx2 < m){
                pq.add(new Sum(arr[idx1] + brr[idx2], idx1, idx2));
            }
        }

        System.out.println(pq.peek().sum);
    
    }
}