package edu.bjtu.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SimpleKafkaApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger("SimpleKafkaApplication");
    @Value("${message.topic.name}")
    private String topicName;
    private final KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    public SimpleKafkaApplication(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    
//    @Override
//    public void run(String... strings) {
//        kafkaTemplate.send(topicName, "Hello Geek!");
//        LOG.info("Published message to topic: {}.", topicName);
//        System.out.println("发送消息成功");
//    }
//
//    @KafkaListener(topics = "helloworld.t", groupId = "jcg-group")
//    public void listen(String message) {
//        LOG.info("Received message in JCG group: {}", message);
//        System.out.println("接受消息成功");
//    }
    

    public static void main(String[] args) {
        SpringApplication.run(SimpleKafkaApplication.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("启动卡夫卡项目");
	}



}

