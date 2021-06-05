package utils.study.test_设计模式.工厂.简单工厂;

/**
 * @Author kula
 * @create 2021/5/9 下午12:21
 */
public class CarFactory {
    public Car getCar(String name) {
        if ("奔驰".equals(name)) {
            return new BenzCar();
        }

        if ("宝马".equals(name)) {
            return new BWMCar();
        }
        return null;
    }


    public static void main(String[] args) {
        CarFactory carFactory = new CarFactory();
        Car bwmCar = carFactory.getCar("宝马");
        bwmCar.run();
    }
}
