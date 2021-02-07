package com.code;

import java.util.*;

/**
 * 472. Concatenated Words
 * Given an array of strings words (without duplicates), return all the concatenated words in the given list of words.
 * <p>
 * A concatenated word is defined as a string that is comprised entirely of at least two shorter words in the given array.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * Output: ["catsdogcats","dogcatsdog","ratcatdogcat"]
 * Explanation: "catsdogcats" can be concatenated by "cats", "dog" and "cats";
 * "dogcatsdog" can be concatenated by "dog", "cats" and "dog";
 * "ratcatdogcat" can be concatenated by "rat", "cat", "dog" and "cat".
 * Example 2:
 * <p>
 * Input: words = ["cat","dog","catdog"]
 * Output: ["catdog"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= words.length <= 104
 * 0 <= words[i].length <= 1000
 * words[i] consists of only lowercase English letters.
 * 0 <= sum(words[i].length) <= 6 * 105
 * <p>
 * Time Complexity
 */
public class ConcatenatedWords {

    public static void main(String[] args) {
        String[] words = {"cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInDict(words));
    }

    static List<String> findAllConcatenatedWordsInDict(String[] words) {

        Arrays.sort(words, (a, b) -> a.length() - b.length());
        List<String> result = new ArrayList<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < words.length; i++) {

            if (words[i].length() != 0 && helper(set, words[i])) {
                result.add(words[i]);
            }

            set.add(words[i]);
        }

        return result;
    }

    static boolean helper(Set<String> set, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }

        if (set.contains(word)) return true;
        int length = word.length();
        for (int i = 1; i < length; i++) {
            String temp = word.substring(0, i);
            if (set.contains(temp)) {
                if (helper(set, word.substring(i))) {
                    set.add(word);
                    return true;
                }
            }
        }
        return false;
    }
}
