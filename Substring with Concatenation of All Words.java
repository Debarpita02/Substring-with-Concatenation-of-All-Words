import java.util.*;

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        int wordLength = words[0].length();
        int totalLength = words.length * wordLength;
        
        if (s.length() < totalLength) {
            return result;
        }
        
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i <= s.length() - totalLength; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while (j < words.length) {
                String currentWord = s.substring(i + j * wordLength, i + (j + 1) * wordLength);
                if (wordCount.containsKey(currentWord)) {
                    seen.put(currentWord, seen.getOrDefault(currentWord, 0) + 1);
                    if (seen.get(currentWord) > wordCount.getOrDefault(currentWord, 0)) {
                        break;
                    }
                } else {
                    break;
                }
                j++;
            }
            if (j == words.length) {
                result.add(i);
            }
        }
        
        return result;
    }
}
