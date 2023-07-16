class Solution {
public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int min = spells[0];
        {
            int max = min;
            for (int i = 1; i < spells.length; i++) {
                int spell = spells[i];
                if (min > spell) {
                    min = spell;
                } else if (max < spell) {
                    max = spell;
                }
            }
            --success;
 
            int minPotion = (int)Math.min(100000, success / max), maxPotion = (int)Math.min(100000, success / min);
            if (minPotion == maxPotion) {
                int cnt = 0;
                for (int i = 0; i < potions.length; i++) {
                    if (potions[i] > maxPotion) {
                        ++cnt;
                    }
                }
                Arrays.fill(spells, cnt);
                return spells;
            }

            int[] arr = new int[max - --min];
            for (int potion : potions) {
                if (potion > minPotion) {
                    ++arr[potion > maxPotion ? 0 : (int)(success / potion) - min];
                }
            }
            ++min;
 
            for (int i = 1; i < arr.length; i++) {
                arr[i] += arr[i - 1];
            }
            potions = arr;
        }
        int[] r = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            r[i] = potions[spells[i] - min];
        }
        return r;
    }
}
