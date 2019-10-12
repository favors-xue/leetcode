import java.util.ArrayList;
import java.util.List;

/**
Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.

Example:

MovingAverage m = new MovingAverage(3);
m.next(1) = 1
m.next(10) = (1 + 10) / 2
m.next(3) = (1 + 10 + 3) / 3
m.next(5) = (10 + 3 + 5) / 3
*/
class MovingAverage {
    private int[] nums;
    private int sum=0;
    private int count = 0;
    private int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        nums = new int[size];
        this.size = size;

    }

    public double next(int val) {

        if (count< size) {
            nums[count++] = val;
            sum+=val;
            return (double)sum/count;
        }
        else {
            sum -= nums[count % size];
            nums[count++ % size] = val;
            sum+=val;
            return (double)sum/size;
        }

    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
