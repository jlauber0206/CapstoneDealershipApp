package dealershipapplicationB;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;


@SpringBootApplication
@EnableMongoAuditing
public class DealershipApplication {


    public static void main(String[] args) {
        SpringApplication.run(DealershipApplication.class, args);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void initIndicesAfterStartup() {
//
//        IndexOperations indexOps = mongoTemplate.indexOps(DomainType.class);
//
//        IndexResolver resolver = new MongoPersistentEntityIndexResolver(mongoMappingContext);
//        resolver.resolveIndexFor(DomainType.class).forEach(indexOps::ensureIndex);
//    }

}

