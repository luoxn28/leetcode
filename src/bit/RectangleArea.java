package bit;

/**
 * 在二维平面上计算出两个由直线构成的矩形重叠后形成的总面积。
 * 每个矩形由其左下顶点和右上顶点坐标表示，如图所示。
 * 输入: -3, 0, 3, 4, 0, -1, 9, 2  (两个左下标点，两个右上标点)
 * 输出: 45
 */
public class RectangleArea {

    public static void main(String[] args) {
        System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        if (C <= E || D <= F || G <= A || H <= B) {
            return area;
        }

        return area - (Math.min(C, G) - Math.max(A, E)) * (Math.min(D, H) - Math.max(B, F));
    }
}
