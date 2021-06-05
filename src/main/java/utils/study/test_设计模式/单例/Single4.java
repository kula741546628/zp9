package utils.study.test_设计模式.单例;

/**
 * @Author kula
 * @create 2021/5/9 上午11:18
 */
public class Single4 {

    private Single4() {

    }

    public static Single4 getSingle4() {
        return En.INIT.getSingle4();
    }

    enum En {
        INIT
        ;

        private Single4 single4;
        En(){
            this.single4 = new Single4();
        }
        public Single4 getSingle4(){
            return single4;
        }
    }


    public static void main(String[] args) {
        Single4 single4 = Single4.getSingle4();


    }
}
