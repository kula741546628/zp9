package utils.study.test_多线程.disruptor.factory;

import com.lmax.disruptor.EventFactory;
import utils.study.test_多线程.disruptor.entity.LongEvent;

/**
 * @Author kula
 * @create 2021/5/8 下午3:58
 */
public class LongEventFactory implements EventFactory<LongEvent>{
    @Override
    public LongEvent newInstance() {
        return new LongEvent();
    }
}
