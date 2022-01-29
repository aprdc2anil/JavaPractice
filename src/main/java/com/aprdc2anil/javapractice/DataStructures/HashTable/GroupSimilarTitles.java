package com.aprdc2anil.javapractice.DataStructures.HashTable;

import java.util.*;

// netflix
public class GroupSimilarTitles {
    private static List<List<String>> groupTitles(String[] strs) {
        int charSetLength = 26;
        Map<String, List<String>> hashedGroups = new HashMap<String, List<String>>();

        for (String str : strs) {
            int[] charCount = new int[charSetLength];
            Arrays.fill(charCount, 0);

            for (char c : str.toCharArray()) {
                int charIndex = c - 'a';
                charCount[charIndex]++;
            }

            StringBuilder delimStr = new StringBuilder("");

            for (int l = 0; l < charSetLength; ++l) {
                delimStr.append('#');
                delimStr.append(charCount[l]);
            }

            String key = delimStr.toString();

            if (!hashedGroups.containsKey(key)) {
                hashedGroups.put(key, new ArrayList<String>());
            }

            hashedGroups.get(key).add(str);
        }

        return new ArrayList<List<String>>(hashedGroups.values());
    }

    public static void mainMethod() {
        // Driver code
        String titles[] = {"duel", "dule", "speed", "spede", "deul", "cars"};

        List<List<String>> gt = groupTitles(titles);
        String query = "spede";

        // Searching for all titles
        for (List<String> g : gt) {
            if (g.contains(query))
                System.out.println(g);
        }
    }
}

