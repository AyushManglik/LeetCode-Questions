class Solution {
    public int findLongestChain(int[][] pairs) {
        /*
         * so we have pairs like (1 2) and (3 4)
         *
         *   1. (1 2) would not "lead to" (2 3) because 2 = 2
         *
         *   2. (1 2) would "lead to" (3 4) because 2 < 3
         *
         * so given that you can form chains of 2, 3, or more pairs,
         * what is the longest length of any valid chain of pairs?
         *
         *
         * can I just greedily search for the single longest?
         *
         *
         * I can sort pairs by forming longs
         *
         *      ( end ) ( start )
         */
        final var N = pairs.length;

        final var P = new long[N];
        for (int i = 0; i < N; i++) {
            final long hi = ((long) pairs[i][1]) << 32;
            final long lo = 0xffff_ffffL & pairs[i][0];
            P[i] = hi | lo;
        }

        Arrays.sort(P);

        var size = 0;
        var lastEnd = Integer.MIN_VALUE;

        for (final var pair : P) {
            final var start = (int) pair;

            if (start > lastEnd) {
                size++;
                lastEnd = (int) (pair >>> 32);
            }
        }

        return size;
    }
}
