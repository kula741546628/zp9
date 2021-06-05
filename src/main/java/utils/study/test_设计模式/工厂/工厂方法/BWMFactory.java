package utils.study.test_设计模式.工厂.工厂方法;

/**
 * @Author kula
 * @create 2021/5/9 下午2:12
 */
public class BWMFactory implements CarFactory {
    @Override
    public Car createCar(String name) {

        if ("宝马".equals(name)) {
            return new BWMCar();
        }
        if ("宝马2".equals(name)) {
            return new BWMCar2();
        }
        return null;
    }
}
