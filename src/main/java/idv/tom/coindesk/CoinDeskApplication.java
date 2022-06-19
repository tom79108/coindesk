package idv.tom.coindesk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication()
@EnableJpaAuditing
@EnableJpaRepositories
public class CoinDeskApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoinDeskApplication.class, args);
	}
}