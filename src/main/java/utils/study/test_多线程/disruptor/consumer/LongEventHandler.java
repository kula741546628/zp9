package utils.study.test_多线程.disruptor.consumer;

import com.lmax.disruptor.EventHandler;
import utils.study.test_多线程.disruptor.entity.LongEvent;

/**
 * @Author kula
 * @create 2021/5/8 下午3:56
 */
public class LongEventHandler implements EventHandler<LongEvent> {

    @Override
    public void onEvent(LongEvent event, long sequence, boolean endOfBatch) throws Exception {
        System.out.println("消费者:"+event.getValue());
    }
}
