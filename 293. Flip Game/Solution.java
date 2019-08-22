/**
You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

Write a function to compute all possible states of the string after one valid move.

Example:

Input: s = "++++"
Output:
[
  "--++",
  "+--+",
  "++--"
]
Note: If there is no valid move, return an empty list [].
*/
class Solution {
    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() < 2) return result;
        char[] chars = s.toCharArray();
        for (int i=0;i<chars.length-1;i++) {
            if (chars[i] == '+' && chars[i+1] == '+')  {
                chars[i] = '-';
                chars[i+1] = '-';
                result.add(String.valueOf(chars));
                chars[i] = '+';
                chars[i+1] = '+';
            }
        }
        return result;
    }
}
