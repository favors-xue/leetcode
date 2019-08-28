/**
Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

word1 and word2 may be the same and they represent two individual words in the list.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “makes”, word2 = “coding”
Output: 1
Input: word1 = "makes", word2 = "makes"
Output: 3
Note:
You may assume word1 and word2 are both in the list.
*/
class Solution {
    private HashMap<String, ArrayList<Integer>> pos = new HashMap<>();
    public int shortestWordDistance(String[] words, String word1, String word2) {
        //init the pos;
        for (int i=0;i<words.length;i++) {
            if (pos.containsKey(words[i])) {
                pos.get(words[i]).add(i);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(i);
                pos.put(words[i],list);
            }
        }
        int dis = Integer.MAX_VALUE;

        if (word1.equals(word2)) {
            ArrayList<Integer> loc = pos.get(word1);
            int l = 0;
            while (l+1<loc.size()) {
                dis = Math.min(dis,Math.abs(loc.get(l)-loc.get(l+1)));
                l++;
            }
        }
        else {
            ArrayList<Integer> loc1 = pos.get(word1);
            ArrayList<Integer> loc2 = pos.get(word2);
            int l1 =0, l2=0;
            while(l1<loc1.size() && l2<loc2.size()) {
                dis = Math.min(dis,Math.abs(loc1.get(l1)-loc2.get(l2)));
                if (loc1.get(l1) <loc2.get(l2)) {
                    l1++;
                }
                else {
                    l2++;
                }
            }
        }
        return dis;
    }
}
