package com.old_api;
import kafka.consumer.ConsumerConfig;
import kafka.consumer.KafkaStream;
import kafka.javaapi.consumer.ConsumerConnector;
 
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
 
public class ConsumerMain {
    private final ConsumerConnector consumer;
    private final String topic;
    private  ExecutorService executor;
 
    public ConsumerMain(String a_zookeeper, String a_groupId, String a_topic) {
        consumer = kafka.consumer.Consumer.createJavaConsumerConnector(
                createConsumerConfig(a_zookeeper, a_groupId));
        this.topic = a_topic;
    }
 
    public void shutdown() {
        if (consumer != null) consumer.shutdown();
        if (executor != null) executor.shutdown();
    }
 
    public void run(int a_numThreads) {
        Map<String, Integer> topicCountMap = new HashMap<String, Integer>();
        topicCountMap.put(topic, new Integer(1));
        topicCountMap.put("test", new Integer(1));
        //返回的Map包含所有的Topic以及对应的KafkaStream
        Map<String, List<KafkaStream<byte[], byte[]>>> consumerMap = consumer.createMessageStreams(topicCountMap);
        List<KafkaStream<byte[], byte[]>> streams = consumerMap.get(topic);
 
        //创建Java线程池
        executor = Executors.newFixedThreadPool(a_numThreads);
 
        // 创建 consume 线程消费messages
        int threadNumber = 0;
        for (final KafkaStream stream : streams) {
            executor.submit(new ConsumerThread(stream, threadNumber));
            threadNumber++;
        }
    }
 
    private static ConsumerConfig createConsumerConfig(String a_zookeeper, String a_groupId) {
        Properties props = new Properties();
        //指定连接的Zookeeper集群，通过该集群来存储连接到某个Partition的Consumer的Offerset
        props.put("zookeeper.connect", a_zookeeper);
       //consumer group 的ID
        props.put("group.id", a_groupId);
        //Kafka等待Zookeeper的响应时间（毫秒）
        props.put("zookeeper.session.timeout.ms", "400");
       //ZooKeeper 的‘follower’可以落后Master多少毫秒
        props.put("zookeeper.sync.time.ms", "200");
      //consumer更新offerset到Zookeeper的时间
        props.put("auto.commit.interval.ms", "1000");
 
        return new ConsumerConfig(props);
    }
 
    public static void main(String[] args) {
        String zooKeeper = "192.168.0.203:2181";
        String groupId = "test1";
        String topic = "test1";
        int threads = 1;
 
        ConsumerMain example = new ConsumerMain(zooKeeper, groupId, topic);
        example.run(threads);
         //因为consumer的offerset并不是实时的传送到zookeeper（通过配置来制定更新周期），所以shutdown Consumer的线程，有可能会读取重复的信息
        //增加sleep时间，让consumer把offset同步到zookeeper
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ie) {
 
        }
        example.shutdown();
    }
}