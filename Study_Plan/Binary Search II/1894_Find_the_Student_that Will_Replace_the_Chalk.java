class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        // First calculate the total sum of the array
        long total = 0;
        for(int i=0;i<chalk.length;i++)
        {
            total+=chalk[i];
        }

        // Now find the remaining chalk by dividing k by sum and take reminder. This will give you the remaining chalk for the last iteration.
        long left = k%total;
    
        for(int i=0;i<chalk.length;i++)
        {
            if(chalk[i]>left)
             return i;
            left -= chalk[i];
        }
        return 0;
    }
}
