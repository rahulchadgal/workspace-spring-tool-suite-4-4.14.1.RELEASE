package com.example.embeddedmongo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.client.MongoClients;

import de.flapdoodle.embed.mongo.MongodExecutable;
import de.flapdoodle.embed.mongo.MongodStarter;
import de.flapdoodle.embed.mongo.config.ImmutableMongodConfig;
import de.flapdoodle.embed.mongo.config.MongodConfig;
import de.flapdoodle.embed.mongo.config.Net;
import de.flapdoodle.embed.mongo.distribution.Version;
import de.flapdoodle.embed.process.runtime.Network;

public class MongoDbIntergration {
	private static final String CONNECTION_STRING = "mongodb://%s:%d";
	
	private MongodExecutable mongodExecutable;
    private MongoTemplate mongoTemplate;
    
    @AfterTest
    void clean() {
    	mongodExecutable.stop();
    }
    
    @BeforeTest
    void setup() throws Exception {
        String ip = "localhost";
        int port = 27017;

        ImmutableMongodConfig mongodConfig = MongodConfig
            .builder()
            .version(Version.Main.PRODUCTION)
            .net(new Net(ip, port, Network.localhostIsIPv6()))
            .build();

        MongodStarter starter = MongodStarter.getDefaultInstance();
        mongodExecutable = starter.prepare(mongodConfig);
        mongodExecutable.start();
        mongoTemplate = new MongoTemplate(MongoClients.create(String.format(CONNECTION_STRING, ip, port)), "test");
    }

    @DisplayName("given object to save"
        + " when save object using MongoDB template"
        + " then object is saved")
   @Test
    void test() throws Exception {
        // given
        DBObject objectToSave = BasicDBObjectBuilder.start()
            .add("key", "value")
            .get();

        // when
        mongoTemplate.save(objectToSave, "collection");

        // then
        assertThat(mongoTemplate.findAll(DBObject.class, "collection")).extracting("key")
            .containsOnly("value");
    }
}
