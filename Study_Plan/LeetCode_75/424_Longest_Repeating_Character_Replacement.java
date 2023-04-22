//Code (Brute Force)

class Solution {
    public int characterReplacement(String s, int k) {
        
        int[] arr = new int[26];
        int largestCount = 0, beg = 0, maxlen = 0;
        for(int end = 0; end < s.length(); end ++){
            arr[s.charAt(end) - 'A']++;
            largestCount = Math.max(largestCount, arr[s.charAt(end) - 'A']);

            if(end - beg + 1 - largestCount > k){     
                arr[s.charAt(beg) - 'A']--;
                beg ++;
            }
            maxlen = Math.max(maxlen, end - beg + 1);    
        } 
        return maxlen;
    }
}


//Code (Optimized Simple Array)

class Solution{
    public int characterReplacement(String s, int k) {
        int len = s.length();
        int[] count = new int[26];
        int start = 0, maxCount = 0, maxLength = 0;
        for (int end = 0; end < len; end++) {
            maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
            while (end - start + 1 - maxCount > k) {
                count[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}


//Code (Optimized with a Byte Array)

class Solution {
    public int characterReplacement(String s, int k) {
        if (s.length() == k) return k;
        int[] frequency = new int[91];
        byte[] bytes = s.getBytes();
        int maxFrequency = 0;
        int start = 0;

        for (int end = 0; end < bytes.length; end++) {
            maxFrequency = Math.max(maxFrequency, ++frequency[bytes[end]]);
            while (end - start - maxFrequency >= k)
                frequency[bytes[start++]]--;
        }
        return bytes.length - start;
    }
}
