package com.kafka.vo;

/**
 * @author zuolang
 *
 */
public class KafkaMessage {
	public String key;
	public String value;
	public String topic;
	@Override
	public String toString() {
		return "KafkaMessage [key=" + key + ", value=" + value + ", topic=" + topic + "]";
	}
}
