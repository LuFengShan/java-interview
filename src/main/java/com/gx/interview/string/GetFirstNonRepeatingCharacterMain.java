package com.gx.interview.string;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在String中查找第一个非重复字符
 */
public class GetFirstNonRepeatingCharacterMain {
    public static void main(String[] args) {
        System.out.println("String类比的第一个非重复字符是 : " + getNonRepeatedCharacter("sunguang"));
        System.out.println("字符串最简单的第一个非重复字符是 : " + getNonRepeatedCharacterCharArray("sunguang"));
    }

    public static Character getNonRepeatedCharacter(String str) {
        Map<Character, Integer> countCharacters = new LinkedHashMap<Character, Integer>();
        for (int i = 0; i < str.length() - 1; i++) {
            Character c = str.charAt(i);
            if (!countCharacters.containsKey(c)) {
                countCharacters.put(c, 1);
            } else {
                countCharacters.put(c, countCharacters.get(c) + 1);
            }
        }
        // 由于LinkedHashMap维护插入顺序，因此计数为1的第一个字符应返回第一个非重复字符
        for (Map.Entry<Character, Integer> e : countCharacters.entrySet()) {
            if (e.getValue() == 1)
                return e.getKey();

        }
        return null;
    }

    public static Character getNonRepeatedCharacterCharArray(String str) {
        char charaaray[] = str.toCharArray();
        for (int i = 0; i < str.length(); i++) {
            if (str.lastIndexOf(charaaray[i]) == str.indexOf(charaaray[i]))
                return charaaray[i];
        }
        return null;
    }
}

