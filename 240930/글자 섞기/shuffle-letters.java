import java.util.*;
import java.io.*;

public class Main {
    static StringTokenizer stk;
    static int n;
    static String[] words;
    static class Word implements Comparable<Word>{
        String best;
        String worst;
        String basic;
        String gizun;
        int idx;
        public Word(String basic, int idx) {
            this.basic = basic;
            char[] frags = basic.toCharArray();
            StringBuilder sb = new StringBuilder();
            Arrays.sort(frags);
            for(int i = 0;i<frags.length;i++) {
                sb.append(frags[i]);
            }
            best = sb.toString();
            sb.setLength(0);
            for(int i = frags.length - 1;i > -1;i--) {
                sb.append(frags[i]);
            }
            worst = sb.toString();
            this.gizun = basic;
            this.idx = idx;
        }

        public Word(Word other) {
            this.basic = other.basic;
            this.worst = other.worst;
            this.best = other.best;
            this.gizun = other.gizun;
            this.idx = other.idx;
        }

        public void toBest() {
            this.gizun = best;
        }

        public void toWorst() {
            this.gizun = worst;
        }

        public int compareTo(Word o) {
            return this.gizun.compareTo(o.gizun);
        }

        public String toString() {
            return this.gizun +" " + this.idx;
        }

        

    }
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        words = new String[n];
        ArrayList<Word> wordList = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            words[i] = bf.readLine();
            wordList.add(new Word(words[i], i));
        }
        // 알파벳 순서대로 정렬하려고 한다.
        // 이 때 각 단어에 있는 문자들의 순서를 원하는대로 바꿀 수 있다.
        int[] worstRank = new int[n];
        int[] bestRank = new int[n];
        for(int i = 0;i<wordList.size();i++) {
            ArrayList<Word> temp = new ArrayList<>();
            for(int j = 0;j<wordList.size();j++){
                temp.add(new Word(wordList.get(j)));
            }
            // System.out.println(temp);
            temp.get(i).toBest();
            Collections.sort(temp);
            // System.out.println(temp);
            for(int j = 0;j<temp.size();j++) {
                if (temp.get(j).idx == i) {
                    bestRank[i] = j;
                    temp.get(j).toWorst();
                    break;
                }
            }
            Collections.sort(temp);
            for(int j = 0;j<temp.size();j++) {
                if (temp.get(j).idx == i) {
                    worstRank[i] = j;
                    break;
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(int i = 0;i<n;i++) {
            result.append(bestRank[i] + 1).append(" ").append(worstRank[i] + 1).append("\n");
        }
        System.out.print(result);
    }
}