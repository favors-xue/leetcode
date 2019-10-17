import java.util.Arrays;

public class Solution {
    public int[][] merge(int[][] input) {
        int[] start = new int[input.length];
        int[] end = new int[input.length];
        for (int i=0;i<input.length;i++) {
            start[i] = input[i][0];
            end[i] = input[i][1];

        }
        Arrays.sort(start);
        Arrays.sort(end);
        int indexStart = 0, indexEnd = 0, num = 0;
        while(indexStart<input.length || indexEnd<input.length) {
            int[] interval = new int[2];
            interval[0] = start[indexStart++];
            while(indexStart<input.length && end[indexEnd]>=start[indexStart]) {
                indexEnd++;
                indexStart++;
            }
            interval[1] = end[indexEnd];
            input[num++] = interval;
        }
        int[][] result = new int[num][2];
        for (int i=0;i<num;i++) {
            result[i] = input[i];
        }
        return result;
    }
}
