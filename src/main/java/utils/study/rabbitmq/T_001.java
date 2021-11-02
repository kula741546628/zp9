package utils.study.rabbitmq;

import com.google.common.collect.Maps;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Author kula
 * @create 2021/10/14 下午2:35
 * rabbitMQ 消息持久化
 *
 * 消息队列持久化包括3个部分：
 * (TODO https://www.cnblogs.com/ericli-ericli/p/5938106.html)
 * 1、exchange持久化，在声明时指定durable => true
 * 2、queue持久化，在声明时指定durable => true
 * 3、消息持久化，在投递时指定delivery_mode=> 2（1是非持久化）
 *
 *
 *
 * Q:rabbitMQ消息持久化原理与何时需要持久化？
 * A:https://www.iteye.com/blog/chenja-2378368
 */
public class T_001 {

    @Resource
    private AmqpTemplate amqpTemplate;

    private void rabbitMqTest_01(Channel channel) throws IOException {
        /**
         * rabbitMQ 设置消息持久化 durable=true
         */
        channel.queueDeclare("",true, true, true, null);
    }
    private void rabbitMqTest_02(String queueName) throws IOException {
        /**
         * rabbitMQ 设置消息持久化 创建queue时，设置queue的durable属性为true
         * 另外，队列的exclusive属性设置为true（排他性队列）的话，只要调用了连接的Close方法或者客户端退出了，rabbitmq也会删除这个队列
         *
         *         this.durable = durable; 是否持久化
         *         this.exclusive = exclusive; 是否排他性队列
         *         this.autoDelete = autoDelete; 当所有消费客户端连接断开后，是否自动删除队列，
         */
        new Queue(queueName, true, false, false, Maps.newHashMap());
    }
}
