package utils.study.test_多线程.disruptor.product;

import com.lmax.disruptor.RingBuffer;
import utils.study.test_多线程.disruptor.entity.LongEvent;

import java.nio.ByteBuffer;

/**
 * @Author kula
 * @create 2021/5/8 下午3:59
 */
public class LongEventProduct {

    public final RingBuffer<LongEvent> ringBuffer;

    public LongEventProduct(RingBuffer<LongEvent> ringBuffer) {
        this.ringBuffer = ringBuffer;
    }

    public void onData(ByteBuffer byteBuffer) {
        // 1.ringBuffer 事件队列 下一个槽
        long sequence = ringBuffer.next();
        Long data = null;
        try {
            //2.取出空的事件队列
            LongEvent longEvent = ringBuffer.get(sequence);
            data = byteBuffer.getLong(0);
            //3.获取事件队列传递的数据
            longEvent.setValue(data);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } finally {
            System.out.println("生产这准备发送数据");
            //4.发布事件
            ringBuffer.publish(sequence);

        }
    }


}
