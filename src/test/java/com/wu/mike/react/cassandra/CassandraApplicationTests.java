package com.wu.mike.react.cassandra;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;


class CassandraApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void testUuid() {
        String superSecretId = "f000aa01-0451-4000-b000-000000000000";
        System.out.println(UUID.fromString(superSecretId));

        String id = "1234567890123456";
        String cassandraId = "39393446-4633-3132-2d31-3131452d3132";
        UUID uuid = java.util.UUID.nameUUIDFromBytes(id.getBytes());



    }
}
