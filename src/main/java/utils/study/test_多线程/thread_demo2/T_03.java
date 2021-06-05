package utils.study.test_多线程.thread_demo2;

/**
 * @Author kula
 * @create 2021/4/28 下午7:25
 */

class Res2 implements Runnable {

    public volatile boolean flag = true;
    @Override
    public void run() {
        System.out.println("子线程开始");
        while (flag) {

        }
        System.out.println("子线程结束");
    }
    public void setFlag(boolean b){
        this.flag = b;
    }
}
public class T_03 {
    public static void main(String[] args) throws InterruptedException {
        Res2 res2 = new Res2();
        new Thread(res2).start();
        Thread.sleep(1000*3);
        res2.setFlag(false);
        System.out.println("flag修改为false");
        Thread.sleep(1000);
        System.out.println(res2.flag);
    }
}
