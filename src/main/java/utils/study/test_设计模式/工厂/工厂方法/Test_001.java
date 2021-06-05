package utils.study.test_设计模式.工厂.工厂方法;

/**
 * @Author kula
 * @create 2021/5/9 下午2:14
 */
public class Test_001 {
    public static void main(String[] args) {
        CarFactory carFactory = new BWMFactory();
        Car car = carFactory.createCar("宝马2");
        car.run();
    }
}
