package array;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * 将图像顺时针旋转 90 度。
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 解法：
 * 首先沿着副对角线翻转一次，然后沿着水平中线翻转一次，就得到了旋转90度的效果
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf(" " + matrix[i][j]);
            }
            System.out.println();
        }
    }

    static void rotate(final int[][] matrix) {
        int n = matrix.length;

        // 沿副对角线翻转
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
            }
        }

        // 沿水平线反转
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n - 1 - i, j);
            }
        }
    }

    static void swap(int[][] matrix, int i, int j, int m, int n) {
        int num = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = num;
    }
}
