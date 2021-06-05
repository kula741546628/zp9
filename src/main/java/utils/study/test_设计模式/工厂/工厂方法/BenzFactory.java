package utils.study.test_设计模式.工厂.工厂方法;

/**
 * @Author kula
 * @create 2021/5/9 下午2:12
 */
public class BenzFactory implements CarFactory {
    @Override
    public Car createCar(String name) {
        return new BenzCar();
    }
}
