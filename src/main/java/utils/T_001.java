package utils;

/**
 * @Author kula
 * @create 2021/8/3 下午9:49
 */
public class T_001 {
    public static void main(String[] args) {
//        int hash = 97;
//        int n = 16;
//        System.out.println((n - 1) & hash);
//        System.out.println(n & hash);
//        System.out.println("==================");
//        /**
//         * 15
//         * 0000 1111
//         * 0000 0000  0
//         * 0001 0000  16
//         *
//         */
//        System.out.println(0&15);
//        System.out.println(16&15);

        /**
         * h = 97
         */
        System.out.println("abc".hashCode());
        /**
         * 0000 0111 1000 0110 0010
         */
        System.out.println(96354 >>> 16); // 0
        System.out.println(97 ^ 1);
    }
}
