package utils.study.test_多线程.disruptor;


import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.YieldingWaitStrategy;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import utils.study.test_多线程.disruptor.consumer.LongEventHandler;
import utils.study.test_多线程.disruptor.entity.LongEvent;
import utils.study.test_多线程.disruptor.factory.LongEventFactory;
import utils.study.test_多线程.disruptor.product.LongEventProduct;

import java.nio.ByteBuffer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author kula
 * @create 2021/5/8 下午3:47
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        EventFactory<LongEvent> longEventFactory = new LongEventFactory();
        int ringBufferSize = 1024 * 1024;
        Disruptor<LongEvent> disruptor = new Disruptor<LongEvent>(longEventFactory,
                ringBufferSize, executorService, ProducerType.MULTI, new YieldingWaitStrategy());

        disruptor.handleEventsWith(new LongEventHandler());
        disruptor.start();

        RingBuffer<LongEvent> ringBuffer = disruptor.getRingBuffer();
        // 8.创建生产者
        LongEventProduct producer = new LongEventProduct(ringBuffer);
        // 9.指定缓冲区大小
        ByteBuffer byteBuffer = ByteBuffer.allocate(8);

        for (int i = 1; i <= 100; i++) {
            byteBuffer.putLong(0, i);
            producer.onData(byteBuffer);
        }
        //10.关闭disruptor和executor
        disruptor.shutdown();
        executorService.shutdown();


    }
}
