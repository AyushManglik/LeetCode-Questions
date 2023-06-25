class Solution {
    private static final int modulo = (int) 1e9 + 7;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int n = locations.length;
        int startPosition = locations[start];
        int finishPosition = locations[finish];

        Arrays.sort(locations);

        for (int i = 0; i < n; ++i) {

            if (startPosition == locations[i]) {
                start = i;
            }

            if (finishPosition == locations[i]) {
                finish = i;
            }
        }

        int[][] dpLeft = new int[n][fuel + 1];
        int[][] dpRight = new int[n][fuel + 1];
        dpLeft[start][0] = dpRight[start][0] = 1;

        for (int used = 0; used <= fuel; ++used) {
            for (int city = n - 2; city >= 0; --city) {
                int delta = locations[city + 1] - locations[city];

                if (used >= delta) {
                    dpLeft[city][used] = ((used == delta ? 0 : dpLeft[city + 1][used - delta]) * 2 % modulo + dpRight[city + 1][used - delta]) % modulo;
                }
            }

            for (int city = 1; city < n; ++city) {
                int delta = locations[city] - locations[city - 1];

                if (used >= delta) {
                    dpRight[city][used] = ((used == delta ? 0 : dpRight[city - 1][used - delta]) * 2 % modulo + dpLeft[city - 1][used - delta]) % modulo;
                }
            }
        }

        int result = 0;

        for (int used = 0; used <= fuel; ++used) {
            result += (dpLeft[finish][used] + dpRight[finish][used]) % modulo;
            result %= modulo;
        }

        if (start == finish) {
            result = (result + modulo - 1) % modulo;
        }
        
        return result;
    }
}
/*Time: O(n)
Space: O(n)*/
