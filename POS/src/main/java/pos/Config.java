package pos;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost/spring5fs?characterEncoding=utf8&serverTimezone=UTC");
		ds.setUsername("spring5");
		ds.setPassword("spring5");
		ds.setInitialSize(2);
		ds.setMaxActive(10);
		ds.setTestWhileIdle(true);
		ds.setMinEvictableIdleTimeMillis(60000 * 3);
		ds.setTimeBetweenEvictionRunsMillis(10 * 1000);

		return ds;
	}

	@Bean
	public MemberDao memberDao() {
		return new MemberDao(dataSource());
	}

	@Bean
	public MemberRegisterService memberRegSvc() {
		return new MemberRegisterService(memberDao());
	}

	@Bean
	public LoginService loginService() {
		return new LoginService(memberDao());
	}

	@Bean
	public MemberDeleteService memberDeleteService() {
		return new MemberDeleteService(memberDao());
	}

	@Bean
	public ItemDao itemDao() {
		return new ItemDao(dataSource());
	}

	@Bean
	public ItemUpdateService itemUpdateService() {
		return new ItemUpdateService(itemDao());
	}

	@Bean
	public ItemSellService itemSellService() {
		return new ItemSellService(itemDao());
	}
}