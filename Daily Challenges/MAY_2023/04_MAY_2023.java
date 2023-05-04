class Solution {
    public String predictPartyVictory(String senate) {
        
        boolean r = true;
        boolean d = true;
        char[] senates = senate.toCharArray();
        int flag = 0;

        while (r && d) {
            r = false;
            d = false; 

            for (int i = 0; i < senates.length; i++) {
                if (senates[i] == 'R') {
                    if (flag < 0) {
                        senates[i] = 0;
                    } else {
                        r = true;
                    }
                    flag++;
                } else if (senates[i] == 'D') {
                    if (flag > 0) {
                        senates[i] = 0;
                    } else {
                        d = true;
                    }
                    flag--;
                }
            }
        }

        return r ? "Radiant" : "Dire";
    }
}
