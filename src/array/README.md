# 数组类算法

## 最大值最小值问题

- 取数组最大值和最小值：遍历数组，获取最大值和最小值，时间复杂度O(n)，空间复杂度O(2)
- 取数组最大值和最小值差值，最大值坐标需小于最小值坐标：时间复杂度O(n)，空间复杂度O(2)
- 取数组最大值和最小值差值，最大值坐标需大于最小值坐标：时间复杂度O(n)，空间复杂度O(2)

后面2种最大值最小值问题，约束条件是最大值/最小值的位置。
最大值坐标需小于最小值坐标，也就是需要一个`max`变量记录已遍历元素中的最大值，先获取`max`变量-当前元素和result的最大值，然后更新`max`变量；
最大值坐标需大于最小值坐标，也就是需要一个`min`变量记录已遍历最小值，先获取当前元素-`min`变量和result的最大值，然后更新`min`变量；
由此，代码如下：
```
// 最大值坐标小于最小值坐标
int maxBeforeMinDifferenceValue(int[] nums) {
    int result = 0;
    int max = nums[0];
    for (int i = 1; i < nums.length; i++) {
        result = Math.max(max - nums[i], result);
        max = Math.max(max, nums[i]);
    }
    return result;
}

// 最大值坐标大于最小值坐标
int maxAfterMinDifferenceValue(int[] nums) {
    int result = 0;
    int min = nums[0];
    for (int i = 1; i < nums.length; i++) {
        result = Math.max(nums[i] - min, result);
        min = Math.min(min, nums[i]);
    }
    return result;
}
```

## 和为K的子数组问题

- 数组中和为k的2个数（或者n个数）：暴力法就是n次循环遍历；或者经过排序之后n-1次循环遍历，同时进行左右加逼；或者借助map数据结构，可节省循环遍历次数
- 数组中和为k的子数组：递归方式
- 数组中和为k的连续子数组：递归方法；另外一种方式是

数组中和为k的子数组，针对数组中的元素，一种是包含该元素的子数组和为K，另一种是不包含该数组的子数组和为K，所以可以使用递归方式来完成。
连续子数组要求递归过程中的元素都是临近的，可以使用循环+递归方式来做；非连续子数组直接使用递归方式来做。代码如下：
```
// 和为k的子数组，子数组不要求是连续的
static void sumK(int[] nums, int start, int cur, int target, List<Integer> list) {
    if (start >= nums.length) {
        return;
    } else if (cur + nums[start] > target) {
        return;
    }

    cur += nums[start];
    list.add(nums[start]);
    if (cur == target) {
        System.out.println(list);
    }

    sumK(nums, start + 1, cur, target, list);
    list.remove(list.size() - 1);
    cur -= nums[start];

    int i = start + 1;
    while (i < nums.length && nums[i] == nums[start]) {
        i++;
    }
    sumK(nums, i, cur, target, list);
}

// 和为k的子数组，子数组必须是连续的
for (int i = 0; i < nums.length; i++) {
    sumK2(nums, i, 0, 6, new ArrayList<>());
}
static void sumK2(int[] nums, int start, int cur, int target, List<Integer> list) {
    if (start >= nums.length) {
        return;
    } else if (cur + nums[start] > target) {
        return;
    }

    cur += nums[start];
    list.add(nums[start]);
    if (cur == target) {
        System.out.println(list);

        int i = start + 1;
        while (i < nums.length && nums[i] == 0) {
            i++;
            list.add(0);
            System.out.println(list);
        }

        cur = 0;
        list.clear();
        return;
    }

    sumK2(nums, start + 1, cur, target, list);
}
```

和和为K的子数组问题类似的问题有和最接近K的子数组问题，解题思路类似，只不过递归终止条件是之和最接近K为止。

## 数组元素移动问题

- 移除重复元素：遍历数组，如果当前元素(nums[j])不等于前一个元素(nums[i])，则nums[++i]=nums[j]
- 移除指定元素：遍历数组，如果当前元素(nums[j])不等于指定元素，则nums[++i]=nums[j]
- 数组整体移动：比如整体元素右移一位，之前最后边元素移动到最左边

## 数组第K大元素问题

第一种解法是先经过排序，然后直接返回第k个元素即可。
另一种解法是按照快排思想，先将数组分为2个子数组，左边子数组元素都小于右边子数组，如果左边子数组个数大于等于k，则在左边子数组继续寻找第k大元素；否则在右边子数组继续寻找第(k-左子数组.length)大元素
