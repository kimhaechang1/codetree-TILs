import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int m;
    static int k;
    static int[] dy = {-1,1,0,0};
    static int[] dx = {0,0,-1,1};
    static int[][] info;
    static int[][] map;
    static StringTokenizer stk;
    static int answer = 0;
    static int dirCon(int dir) {
        if(dir == 0) {
            return 0;
        }else if (dir == 1) {
            return 3;
        } else if (dir == 2) {
            return 1;
        } else { 
            return 2;
        }
    }
    static class Data {
        int y;
        int x; // 중앙 좌표
        int oDir; // 출구 방향
        public Data(int y, int x, int oDir) {
            this.y = y;
            this.x = x;
            this.oDir = oDir;
        }
    }
    static Data[] rData;
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        stk = new StringTokenizer(bf.readLine());
        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());
        map = new int[n][m];
        info = new int[k][2];
        answer = 0;
        for(int i = 0;i<k;i++) {
            stk = new StringTokenizer(bf.readLine());
            info[i][0] = Integer.parseInt(stk.nextToken());
            info[i][1] = Integer.parseInt(stk.nextToken());
        }
        // 남쪽으로 내려가는것이 1순위
        // 남쪽이 안되면 중심 기준으로 서쪽으로 한칸 이동후, 골렘 출구를 반시계로 회전 후 아래로 이동
        // 서쪽조차 안되면, 동쪽으로 한칸 이동후 골렘 출구를 시계로 회전 후 아래로 이동
        // 어떠한 상황에서도 이동이 불가능하다면, 정령이 인접한 칸을 타고 아래로 이동함.
        // 정령이동때에는 현재 위치가 골램의 출구이면서 다른 골렘으로 이어질 수 있다면 이동가능함
        // 만약 최대한 남쪽으로 이동했음에도 불구하고 숲을 벗어난 상태라면 모든 골렘을 초기화 시키고 답에 포함하지 않는다.
        rData = new Data[info.length];
        int cnt = 0;
        for(int i = 0;i<info.length;i++) {
            rData[i] = new Data(-2, info[i][0]-1, dirCon(info[i][1]));
            while(go(i));
            //System.out.println("y: "+rData[i].y+" x: "+rData[i].x);
            //boolean canFix = pin(i);
            //System.out.println("canFix: "+canFix);
            if (!pin(i)) {
                map = new int[n][m];
                continue;
            }
            //printMap();
            //System.out.println("###########");
            cnt++;
            /*if(cnt == 4) {
                break;
            }*/
            
            gogo(i);
        }
        System.out.print(answer);
    }
    static void printMap() {
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    static boolean go(int rIdx) {
        // 남쪽으로 이동이 가능한지 체크
        Data now = rData[rIdx];
        
        if (goDown(now)) {
            //System.out.println("아래로 호출됨!");
            return true;
        }
        // 왼쪽 회전 후 아래로 내려가는것이 가능한지 체크
        if (goLeftAndDown(now)) {
            //System.out.println("왼쪽으로 구름 호출됨!");
            return true;
        }
        // 오른쪽 회전 후 아래로 내려가는것이 가능한지 체크
        if (goRightAndDown(now)) {
            //System.out.println("오른쪽으로 구름 호출됨!");
            return true;
        }
        return false;
    }
    static boolean goDown(Data now) {
        // 왼팔
        int ly = now.y + dy[2]; 
        int lx = now.x + dx[2];
        // 오른팔
        int ry = now.y + dy[3]; 
        int rx = now.x + dx[3];
        // 다리
        int ddy = now.y + dy[1]; 
        int ddx = now.x + dx[1];

        int lly = ly + dy[1];
        int llx = lx + dx[1];
        int rry = ry + dy[1];
        int rrx = rx + dx[1];
        int dddy = ddy + dy[1];
        int dddx = ddx + dx[1];
        //System.out.println("다리: "+dddy+" "+dddx);

        if(OOB(lly, llx) || OOB(rry, rrx) || OOB(dddy, dddx)) return false;
        if(lly >= 0 && map[lly][llx] != 0) return false;
        if(rry >= 0 && map[rry][rrx] != 0) return false;
        if(dddy >= 0 && map[dddy][dddx] != 0) return false;
        now.y += 1;
        return true;
    }   

    static boolean goLeftAndDown(Data now) {

        int y = now.y;
        int x = now.x;

        int ny = y + dy[2];
        int nx = x + dx[2];

        for(int dir = 0;dir<4;dir++) {
            int ndy = ny + dy[dir];
            int ndx = nx + dx[dir];
            if(OOB(ndy, ndx)) return false;
            if(ndy >= 0 && map[ndy][ndx] != 0) return false;
        }

        int nny = ny + dy[1];
        int nnx = nx + dx[1];
        
        for(int dir = 0;dir<4;dir++) {
            int ndy = nny + dy[dir];
            int ndx = nnx + dx[dir];
            if(OOB(ndy, ndx)) return false;
            if(ndy >= 0 && map[ndy][ndx] != 0) return false;
        }

        now.y = nny;
        now.x = nnx;
        if(now.oDir == 0) {
            now.oDir = 2;
        } else if( now.oDir == 1) {
            now.oDir = 3;
        } else if( now.oDir == 2) {
            now.oDir = 1;
        } else {
            now.oDir = 0;
        }

        return true;
    }   
    static boolean goRightAndDown(Data now) {

        int y = now.y;
        int x = now.x;

        int ny = y + dy[3];
        int nx = x + dx[3];

        for(int dir = 0;dir<4;dir++) {
            int ndy = ny + dy[dir];
            int ndx = nx + dx[dir];
            if(OOB(ndy, ndx)) return false;
            if(ndy >= 0 && map[ndy][ndx] != 0) return false;
        }

        int nny = ny + dy[1];
        int nnx = nx + dx[1];
        
        for(int dir = 0;dir<4;dir++) {
            int ndy = nny + dy[dir];
            int ndx = nnx + dx[dir];
            if(OOB(ndy, ndx)) return false;
            if(ndy >= 0 && map[ndy][ndx] != 0) return false;
        }

        now.y = nny;
        now.x = nnx;
        if(now.oDir == 0) {
            now.oDir = 3;
        } else if( now.oDir == 1) {
            now.oDir = 2;
        } else if( now.oDir == 2) {
            now.oDir = 0;
        } else {
            now.oDir = 1;
        }

        return true;
    }   
    static boolean OOB(int y, int x) {
        return y >= n || x >= m || x < 0;
    }
    static boolean OOB2(int y, int x) {
        return y >=n || y <0 || x>=m || x < 0;
    }
    static boolean isOut(int y) {
        return y < 0;
    }
    static boolean pin(int rIdx) {
        Data pinned = rData[rIdx];
        int y= pinned.y;
        int x= pinned.x;
        if(isOut(y)) return false;
        map[y][x] = rIdx+1;
        for(int dir = 0;dir<4;dir++) {
            int ny = y + dy[dir];
            int nx = x + dx[dir];
            if(isOut(ny)) return false;
            map[ny][nx] = rIdx+1;
        }
        return true;
    }
    static void gogo(int rIdx) {
        Queue<int[]> queue =new ArrayDeque<>();
        int maxH = 0;
        Data pinned = rData[rIdx];
        int y =pinned.y;
        int x =pinned.x;
        boolean[][] v = new boolean[n][m];
        queue.add(new int[]{y, x, rIdx+1});
        v[y][x] = true;
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            boolean isStation = false;
            int pIdx = now[2];
            int py = rData[pIdx-1].y;
            int px = rData[pIdx-1].x;
            int sy = py + dy[rData[pIdx-1].oDir];
            int sx = px + dx[rData[pIdx-1].oDir];
            if(now[0] == sy && now[1] == sx) {
                isStation= true;
            }
            for(int dir = 0;dir<4;dir++) {
                int ny = now[0] + dy[dir];
                int nx = now[1] + dx[dir];
                if (OOB2(ny, nx) || v[ny][nx] || map[ny][nx] <= 0) continue;
                if (map[ny][nx] == pIdx) {
                    v[ny][nx] = true;
                    maxH = Math.max(ny, maxH);
                    queue.add(new int[]{ny, nx, pIdx});
                } else if (map[ny][nx] != pIdx && isStation) {
                    v[ny][nx] = true;
                    maxH = Math.max(ny, maxH);
                    queue.add(new int[]{ny, nx, map[ny][nx]});
                }
            }
        } 
        answer += (maxH+1);
    }

}