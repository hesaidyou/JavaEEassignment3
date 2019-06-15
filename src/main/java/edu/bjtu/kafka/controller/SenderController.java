package edu.bjtu.kafka.controller;

import static org.mockito.Mockito.after;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.bjtu.kafka.config.Receiver;

@RestController
@RequestMapping("/")
public class SenderController {
	protected final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;
    
	private static final Logger LOGGER = 
			LoggerFactory.getLogger(Receiver.class);
	public final static List<String>  costomer = new ArrayList<String>();
	
    @KafkaListener(topics = {"helloworld.t"})
	public void receive(String payload) {
		LOGGER.info("received payload'{}'",payload);
		costomer.add(payload);
		System.out.println(costomer);
	}
	

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String send(String msg) {
    	kafkaTemplate.send("helloworld.t",msg);
    	logger.info("sending payload='{}'",msg);
    	return msg;
    }
    

    @RequestMapping(value = "/join", method = RequestMethod.GET)
    public String joinclub(String msg) {
    	
    	kafkaTemplate.send("helloworld.t",msg);
    	logger.info("sending payload='{}'",msg);
    	return msg + " joins in the club";
    }
    

    
    @RequestMapping(value = "/receive", method = RequestMethod.GET)
    public String getclub(String msg) {
    	String abc = "Welcome:";
    	for(int i=0;i<costomer.size();i++) {
    		System.out.println("costomer" + costomer.get(i));
    		abc = abc.concat(costomer.get(i));
    		if(i!=costomer.size()-1) {
        		abc = abc.concat("、");
    		}
    		System.out.println(abc);
    	}
    	abc = abc.concat(" join in the club");
    	System.out.println("receive" + " " + abc);

    	return abc;
    }
    

}
