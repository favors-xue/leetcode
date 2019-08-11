/**
Design a class which receives a list of words in the constructor, and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list. Your method will be called repeatedly many times with different parameters.

Example:
Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

Input: word1 = “coding”, word2 = “practice”
Output: 3
Input: word1 = "makes", word2 = "coding"
Output: 1
Note:
You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
*/
class WordDistance {

    private HashMap<String, ArrayList<Integer>> pos;

    public WordDistance(String[] words) {
        pos = new HashMap<>();
        for (int i=0;i<words.length;i++) {
            if (pos.containsKey(words[i])) {
                pos.get(words[i]).add(i);
            }
            else {
                ArrayList<Integer> indexs = new ArrayList<>();
                indexs.add(i);
                pos.put(words[i],indexs);
            }
        }

    }

    public int shortest(String word1, String word2) {
        int dis = Integer.MAX_VALUE;
        ArrayList<Integer> pos1 = pos.get(word1);
        ArrayList<Integer> pos2 = pos.get(word2);
        for (Integer l1 : pos1) {
            for(Integer l2: pos2) {
                dis = Math.min(dis,Math.abs(l1-l2));
            }
        }
        return dis;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
