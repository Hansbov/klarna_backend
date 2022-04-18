package exjobb.klarna_backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

@Configuration
public class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PaymentTokenRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new PaymentToken("0b1d9815-165e-42e2-8867-35bc03789e00", new Date(System.currentTimeMillis()))));
            log.info("Preloading " + repository.save(new PaymentToken("xxxxxxxx-xxxx-xxxx-xxxx-xxxxxxxxxxxx", new Date(System.currentTimeMillis()))));
        };
    }
}
