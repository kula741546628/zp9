package utils.study.jvm;

/**
 * @Author kula
 * @create 2021/8/24 下午7:44
 * i++与++i从jvm的角度考虑区别
 */
public class T_003 {
    public static void main(String[] args) {
        test02();
    }

    /**
     * descriptor: ()I
     *     flags: ACC_PUBLIC, ACC_STATIC
     *     Code:
     *       stack=2, locals=2, args_size=0
     *          0: iconst_0  //将常量0加载到操作数栈（压栈）
     *          1: istore_0  // 将0从操作数栈存储到局部变量表 第0个位置（出栈）
     *          2: iload_0   // 加载局部变量第0个变量压入操作数栈（压栈）
     *          3: iinc          0, 1    // 局部变量表中第0个位置进行+1操作
     *          6: istore_1              // 将0从操作数栈存储到局部变量表 第1个位置（出栈）
     *          7: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *         10: iload_1               // 加载局部变量第1个变量压入操作数栈（压栈）
     *         11: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
     *         14: iload_1
     *         15: ireturn
     * @return
     */
    public static int test01(){
        int i = 0;
        int z = i++;
        System.out.println(i);
        System.out.println(z);
        return z;
    }

    /**
     *  descriptor: ()I
     *     flags: ACC_PUBLIC, ACC_STATIC
     *     Code:
     *       stack=2, locals=2, args_size=0
     *          0: iconst_0            // 将常量0加载到操作数栈中（压栈）
     *          1: istore_0            // 将0赋值到局部变量表中第0个位置（出栈）
     *          2: iinc          0, 1  // 将局部变量表中第0位置进行+1操作
     *          5: iload_0             // 将局部变量表中第0个位置的数值（1）加载到操作数栈中（压栈）
     *          6: istore_1            // 将操作数栈中的值（1）赋值到局部变量表中（出栈）
     *          7: getstatic     #3                  // Field java/lang/System.out:Ljava/io/PrintStream;
     *         10: iload_1
     *         11: invokevirtual #4                  // Method java/io/PrintStream.println:(I)V
     *         14: iload_1
     *         15: ireturn
     * @return
     */
    public static int test02(){
        int i = 0;
        int z = ++i;
        System.out.println(i);
        System.out.println(z);
        return z;
    }
}
