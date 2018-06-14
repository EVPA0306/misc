package com.evpa.cass.db;

import com.datastax.driver.core.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CassandraConnect {

    private static final Logger LOGGER = LoggerFactory.getLogger(CassandraConnect.class);

    private static final String LOCAL_HOST = "127.0.0.1";
    private static final String KEY_SPACE = "dvr";

    public static void main(String[] args) {

        Cluster cassCluster = null;

        try {
            cassCluster = Cluster.builder()
                    .addContactPoints(LOCAL_HOST)
                    .withPort(9142)
                    .build();
            Session session = cassCluster.connect(KEY_SPACE);
            Statement statement = new SimpleStatement("select * from recordings");
            //Statement statement = new SimpleStatement("select release_version from system.local");
            statement.enableTracing();

            ResultSet rs = session.execute(statement);
            Row row = rs.one();
            //LOGGER.info("RELEASE_VERSION: {}", row.getString(0));
            LOGGER.info("DEVICE_ID: {}", row.getString(0));

            ProtocolVersion myCurrentVersion = cassCluster.getConfiguration()
                    .getProtocolOptions()
                    .getProtocolVersion();
            LOGGER.info("Protocol version {}", myCurrentVersion);

        } finally {
            if (cassCluster != null) {
                //cassCluster.close();
                CloseFuture closeFuture = cassCluster.closeAsync();
                while (closeFuture.isDone())
                    LOGGER.info("Cluster is still running...");
                //LOGGER.info("Cluster has been stopped!");
            }
        }
    }

    private Object method(final Object...args) {
        return new Object();
    }
}
