import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

Example 1:

Input: "2-1-1"
Output: [0, 2]
Explanation:
((2-1)-1) = 0
(2-(1-1)) = 2
Example 2:

Input: "2*3-4*5"
Output: [-34, -14, -10, -10, 10]
Explanation:
(2*(3-(4*5))) = -34
((2*3)-(4*5)) = -14
((2*(3-4))*5) = -10
(2*((3-4)*5)) = -10
(((2*3)-4)*5) = 10
*/
class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        Map<String,List<Integer>> cache = new HashMap<>();
        return search(input,cache);
    }

    List<Integer> search(String input, Map<String, List<Integer>> cache) {
        if (cache.containsKey(input)) return cache.get(input);


        List<Integer> res = new ArrayList<>();


        int cnt = 0;
        for(int i=0;i<input.length();i++) {
            char c = input.charAt(i);
            if (c == '+' || c== '-' || c == '*' ) {
                String left = input.substring(0,i);
                String right = input.substring(i+1);
                List<Integer> resultL = search(left, cache);
                List<Integer> resultR = search(right, cache);
                if (c == '+') {
                    for (Integer a : resultL) {
                        for (Integer b : resultR) {
                            res.add(a+b);
                        }
                    }
                }
                else if (c == '-') {
                    for (Integer a: resultL) {
                        for(Integer b: resultR) {
                            res.add(a-b);
                        }
                    }
                }
                else{
                    for(Integer a : resultL) {
                        for (Integer b: resultR) {
                            res.add(a*b);
                        }
                    }
                }

                cnt++;
            }
        }
        if (cnt ==0) res.add(Integer.parseInt(input));

            cache.put(input, res);
        return res;

    }
}
