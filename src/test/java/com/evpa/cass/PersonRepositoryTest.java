package com.evpa.cass;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;
import org.apache.cassandra.exceptions.ConfigurationException;
import org.apache.thrift.transport.TTransportException;
import org.assertj.core.api.Assertions;
import org.cassandraunit.utils.EmbeddedCassandraServerHelper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = PersonRepository.class)
public class PersonRepositoryTest {



    //@Autowired
    //PersonRepository personRepository;
    private static Session session = null;

    @BeforeClass
    public static void startCassandraEmbedded() throws InterruptedException, IOException, TTransportException, ConfigurationException {
        EmbeddedCassandraServerHelper.startEmbeddedCassandra();
        Cluster cluster = Cluster.builder()
                .addContactPoints("127.0.0.1").withPort(9142).build();
        session = cluster.connect();
    }

    @Test
    public void testFindOnePersonById() {
        //Person found = personRepository.findOne("c1c39dc2-960a-43b7-b3c4-b11b5dcc6146");
        Assertions.assertThat(session).isNotNull();
    }

    @AfterClass
    public static void stopCassandraEmbedded() {
        EmbeddedCassandraServerHelper.cleanEmbeddedCassandra();
    }
}

