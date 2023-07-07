class Solution {
  public int maxConsecutiveAnswers(String answerKey, int k) {
		char[] chars = answerKey.toCharArray();
		int result = 0, max = 0, count[] = new int[128];
		for (int i = 0; i < chars.length; i++)
			if (result - (max = Math.max(max, ++count[chars[i]])) < k) 
        result++;
			else 
        count[chars[i - result]]--;
		return result;
  }
}
