package com.interview.questions.hackerrank;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 * Created by raja on 02/10/15.
 */
public class LongestIncreasingSubSequenceCorrectSolution {

    static final int mod = (int) 1e9 + 7;
    static final int m = (int) 1e5;
    static int n;
    static int a[];
    static int dp[][];
    static int segtree[][][];
    static ArrayList<Integer> g[];

    @SuppressWarnings("unchecked")
    public static void main(String args[]) {
        InputReader in = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);

        n = in.nextInt();

        a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();

        g = new ArrayList[2 * m + 1];
        for (int i = 0; i <= 2 * m; i++)
            g[i] = new ArrayList<Integer>();

        for (int i = 0; i < n; i++)
            g[h(a[i])].add(i);

        //System.out.println(g[6] + " " + g[5]);
        segtree = new int[2][4 * (n + 1)][2];
        dp = new int[n][2];

        update(0, 0, n, 0, n, 0, 1);
        update(1, 0, n, 0, n, 0, 1);


        //System.out.println(Arrays.deepToString(segtree[1]));
        //System.out.println(Arrays.toString(find(1,0,n,0,2,n)));
        //System.out.println(Arrays.deepToString(segtree[1]));
        /*update(0,0,n,0,n-1,1,1);
        System.out.println(Arrays.deepToString(segtree[1]));
		System.out.println(Arrays.toString(find(1,0,n,0,0,n)));
		System.out.println(Arrays.deepToString(segtree[1]));
		System.out.println(Arrays.toString(find(1,0,n,0,1,n)));
		System.out.println(Arrays.deepToString(segtree[1]));*/

        for (int i = m; i >= 1; i--) {
            for (int x : g[i]) {
                dp[x] = find(1, 0, n, 0, x, n);
                dp[x][0]++;
            }
            //System.out.println(Arrays.deepToString(segtree[1]));
            for (int x : g[i + m]) {
                dp[x] = find(0, 0, n, 0, x, n);
                dp[x][0]++;
            }
            for (int x : g[i])
                update(0, 0, n, 0, x, dp[x][0], dp[x][1]);
            for (int x : g[i + m])
                update(1, 0, n, 0, x, dp[x][0], dp[x][1]);
        }

        //System.out.println(Arrays.deepToString(dp));

        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(max, dp[i][0]);

        long ans = 0;
        for (int i = 0; i < n; i++)
            if (dp[i][0] == max)
                ans += dp[i][1];

        w.print(max);
        w.print(" ");
        w.println(ans % mod);
        w.close();
    }

    static int h(int x) {
        return x >= 0 ? x : (m - x);
    }

    static void update(int id, int s, int e, int c, int x, int v, int cnt) {
        if (s == e) {
            segtree[id][c][0] = v;
            segtree[id][c][1] = cnt;
            return;
        }
        int m = (s + e) >> 1;
        if (x <= m) update(id, s, m, 2 * c + 1, x, v, cnt);
        else update(id, m + 1, e, 2 * c + 2, x, v, cnt);
        segtree[id][c] = merge(segtree[id][2 * c + 1], segtree[id][2 * c + 2]);
    }

    static int[] find(int id, int s, int e, int c, int l, int r) {
        if (s == l && e == r) {
            int ret[] = Arrays.copyOf(segtree[id][c], 2);
            return ret;
        }
        int m = (s + e) >> 1;
        if (l <= m && r <= m) return find(id, s, m, 2 * c + 1, l, r);
        if (l > m && r > m) return find(id, m + 1, e, 2 * c + 2, l, r);
        return merge(find(id, s, m, 2 * c + 1, l, m), find(id, m + 1, e, 2 * c + 2, m + 1, r));
    }

    static int[] merge(int[] l, int[] r) {
        //System.out.println(Arrays.toString(l) + " " + Arrays.toString(r));
        int ret[] = new int[2];
        ret[0] = Math.max(l[0], r[0]);
        if (l[0] == ret[0]) ret[1] += l[1];
        if (r[0] == ret[0]) ret[1] += r[1];
        if (ret[1] >= mod) ret[1] -= mod;
        //System.out.println(Arrays.toString(l) + " " + Arrays.toString(r));
        return ret;
    }

    static class InputReader {

        private InputStream stream;
        private byte[] buf = new byte[8192];
        private int curChar;
        private int snumChars;
        private SpaceCharFilter filter;

        public InputReader(InputStream stream) {
            this.stream = stream;
        }

        public int snext() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }

            int res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));

            return res * sgn;
        }

        public long nextLong() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = snext();
            }

            long res = 0;

            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = snext();
            } while (!isSpaceChar(c));

            return res * sgn;
        }

        public String readString() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }


}
