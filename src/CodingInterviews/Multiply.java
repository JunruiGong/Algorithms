package CodingInterviews;


import org.junit.Test;

/**
 * 剑指offer-52-构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Multiply {

    public int[] multiply(int[] A) {
        if (A.length < 1) {
            return null;
        }

        int[] result = new int[A.length];

        result[0] = 1;


        // 先计算A[0]到A[i-1]
        for (int i = 1; i < A.length; i++) {
            result[i] = result[i - 1] * A[i - 1];
        }


        // 再计算A[n-1]到A[i+1]
        int temp = 1;
        for (int i = A.length - 1; i > 0; i--) {

            temp *= A[i];
            result[i - 1] *= temp;
        }

        return result;
    }

    @Test
    public void Test(){
        int[] A = {1,2,3,4,5};
        multiply(A);
    }
}
