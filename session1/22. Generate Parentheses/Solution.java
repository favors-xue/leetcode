/**
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
  */
  class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        if (n==0) return result;
        helper(result,"",n,n);
        return result;
    }

    helper(List<String> result, String s, int left, int right) {
        if (left > right)
            return;
        if (left == 0 && right ==0) {
            result.add(s);
        }
        if (left >0) {
            helper(result,s+"(",left-1,right);
        }
        if (right>0) {
            helper(result,s+")",left, right-1);
        }

    }
}
