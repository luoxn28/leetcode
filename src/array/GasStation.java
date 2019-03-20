package array;

/**
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 *
 * 解法：
 * 1. O(N )的解法，对每个点进行模拟
 * 2. O(N) 的解法是，设置两个变量， sum 判断当前的指针的有效性； total 则判断整个数组是否有解，有
 *   就返回通过 sum 得到的下标，没有则返回-1。
 */
public class GasStation {

    public static void main(String[] args) {
        int[] gas = new int[] {1,2,3,4,5};
        int[] cost = new int[] {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));
    }

    static int canCompleteCircuit(int[] gas, int[] cost) {
        int result = -1;
        int total = 0;

        for (int i = 0, sum = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                result = i;
            }
        }
        return total >= 0 ? result + 1 : -1;
    }
}
