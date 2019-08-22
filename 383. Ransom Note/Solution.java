/**
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
*/
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (magazine == null || ransomNote == null) return false;
        HashMap<Character,Integer> cache = new HashMap<>();
        for (int i=0;i<ransomNote.length();i++) {
            int start = 0;
            if (cache.containsKey(ransomNote.charAt(i))) {
                start = cache.get(ransomNote.charAt(i))+1;
            };
            if (start == magazine.length() || magazine.substring(start).indexOf(ransomNote.charAt(i))<0){
                return false;
            }
            cache.put(ransomNote.charAt(i),start+magazine.substring(start).indexOf(ransomNote.charAt(i)));
        }
        return true;

    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] cache = new int[26];
        for (int i=0;i<magazine.length();i++) {
            cache[magazine.charAt(i)-'a'] ++;
        }
        for (int i=0;i<ransomNote.length();i++) {
            if (cache[ransomNote.charAt(i)-'a'] == 0 || --cache[ransomNote.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;

    }

}
