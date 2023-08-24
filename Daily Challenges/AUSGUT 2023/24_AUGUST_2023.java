class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0; // next word
        while (index < words.length) {
            index = addLine(result, words, maxWidth, index); // move index forward
        }
        return result;
    }

    private int addLine(List<String> result, String[] words, int maxWidth, int start) {
        StringBuilder sb = new StringBuilder();
        int end = start;
        int sum = 0;
        while (end < words.length) {
            String word = words[end];
            assert word.length() <= maxWidth;
            if (sum + word.length() + (end - start) > maxWidth) { // cannot pack
                genLineJustified(sb, words, maxWidth - sum, start, end);
                addSpace(sb, maxWidth - sb.length());
                break;
            } else {
                sum += word.length();
            }
            end++;
        }
        if (end == words.length) { // last line
            assert sb.isEmpty();
            genLine(sb, words, start, maxWidth);
        }
        result.add(sb.toString());
        return end;
    }

    private void genLine(StringBuilder sb, String[] words, int start, int maxWidth) {
        for (int i=start; i<words.length; i++) {
            if (!sb.isEmpty()) {
                sb.append(' ');
            }
            sb.append(words[i]);
        }
        addSpace(sb, maxWidth - sb.length());
    }

    private void genLineJustified(StringBuilder sb, String[] words, int spaceCount, int start, int exclusiveEnd) {
        int gapCount = exclusiveEnd - start - 1;
        for (int i=start; i<exclusiveEnd; i++) {
            if (!sb.isEmpty()) {
                int count = spaceCount / gapCount;
                if (i - start - 1 < spaceCount % gapCount) {
                    count++;
                }
                addSpace(sb, count);
            }
            sb.append(words[i]);
        }
    }

    private void addSpace(StringBuilder sb, int count) {
        for (int i=0; i<count; i++) {
            sb.append(' ');
        }
    }
}
