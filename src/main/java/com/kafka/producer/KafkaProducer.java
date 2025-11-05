package src.main.java.com.kafka.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

import static org.apache.kafka.clients.CommonClientConfigs.BOOTSTRAP_SERVERS_CONFIG;
import static org.apache.kafka.clients.CommonClientConfigs.SECURITY_PROTOCOL_CONFIG;
import static org.apache.kafka.clients.producer.ProducerConfig.*;
import static org.apache.kafka.common.config.SaslConfigs.*;

public class KafkaProducer {
    public static void main(final String[] args) {
        final Properties props = new Properties();

        props.put(BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        props.put(SASL_JAAS_CONFIG, "org.apache.kafka.common.security.plain.PlainLoginModule required username='<CLUSTER API KEY>' password='<CLUSTER API SECRET>';");
    }
}
