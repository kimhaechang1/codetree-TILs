import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static int k;
    static int [] arr;
    static HashMap<Integer, Integer> map;
    static class Data implements Comparable<Data>{
        int value;
        int cnt;
        public Data(int value, int cnt){
            this.value = value;
            this.cnt = cnt;
        }
        public int compareTo(Data o){
            if(this.cnt == o.cnt){
                return o.value - this.value;
            }
            return o.cnt - this.cnt;
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk =new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        stk = new StringTokenizer(bf.readLine());
        arr = new int[n];
        map = new HashMap<>();
        for(int i= 0;i<n;i++){
            arr[i] = Integer.parseInt(stk.nextToken());
            if(map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        ArrayList<Data> list =new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            list.add(new Data(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        int idx = list.size()-1;
        while(k-- > 0){
            sb.append(list.get(idx--).value).append(" ");
        }
        System.out.println(sb);
    }
}