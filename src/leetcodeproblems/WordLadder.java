package leetcodeproblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {

    void test() {
        String[] lst = {"hot", "dot", "dog", "lot", "log", "cog"};
        System.out.println(ladderLength("hit", "cog", Arrays.asList(lst)));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;
        int a = (int) 'a';
        int z = (int) 'z';
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size > 0) {
                size--;
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return level;
                }
                for (int i = 0; i < word.length(); i++) {
                    char[] aux = word.toCharArray();
                    for (int j = a; j <= z; j++) {
                        if ((char) j == aux[i]) {
                            continue;
                        }
                        aux[i] = (char) j;
                        String newVal = new String(aux);
                        if (set.contains(newVal) && visited.add(newVal)) {
                            queue.add(newVal);
                        }
                    }
                }
            }
        }
        return 0;
    }
}
