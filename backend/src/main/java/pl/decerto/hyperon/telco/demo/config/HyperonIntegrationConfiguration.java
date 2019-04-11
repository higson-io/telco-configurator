package pl.decerto.hyperon.telco.demo.config;

import java.util.Objects;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.lang3.BooleanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.core.env.Environment;
import org.springframework.web.context.WebApplicationContext;

import pl.decerto.hyperon.telco.demo.domain.SelectedDateHolder;
import pl.decerto.hyperon.runtime.core.HyperonEngine;
import pl.decerto.hyperon.runtime.core.HyperonEngineFactory;
import pl.decerto.hyperon.runtime.profiler.jdbc.proxy.DataSourceProxy;
import pl.decerto.hyperon.runtime.sql.DialectRegistry;
import pl.decerto.hyperon.runtime.sql.DialectTemplate;

@Configuration
public class HyperonIntegrationConfiguration {

	private static final Logger LOG = LoggerFactory.getLogger(HyperonIntegrationConfiguration.class);

	private final Environment env;

	private final Boolean hyperonDevMode;

	private final String hyperonDevUser;

	@Autowired
	public HyperonIntegrationConfiguration(Environment env, @Value("${hyperon.dev.mode}") Boolean hyperonDevMode,
		@Value("${hyperon.dev.user}") String hyperonDevUser) {
		this.env = env;
		this.hyperonDevMode = hyperonDevMode;
		this.hyperonDevUser = hyperonDevUser;
	}

	@Bean
	public DialectRegistry getDialectRegistry() {
		var registry = new DialectRegistry();
		registry.setDialect(env.getProperty("hyperon.database.dialect"));
		return registry;
	}

	@Bean
	public DialectTemplate getDialectTemplate() {
		return getDialectRegistry().create();
	}

	@Bean
	public DataSource getDataSource() {
		var dataSource = new BasicDataSource();
		dataSource.setUsername(env.getProperty("hyperon.database.username"));
		dataSource.setPassword(env.getProperty("hyperon.database.password"));
		dataSource.setUrl(env.getProperty("hyperon.database.url"));
		dataSource.setInitialSize(4);
		dataSource.setMaxActive(8);
		dataSource.setDriverClassName(getDialectTemplate().getJdbcDriverClassName());
		return dataSource;
	}

	@Bean
	public DataSource getDataSourceProxy() {
		var proxy = new DataSourceProxy();
		proxy.setDataSource(getDataSource());
		return proxy;
	}

	@Bean(destroyMethod = "destroy")
	public HyperonEngineFactory getHyperonEngineFactory() {
		var hyperonEngineFactory = new HyperonEngineFactory();
		hyperonEngineFactory.setDataSource(getDataSourceProxy());

		if (BooleanUtils.toBoolean(hyperonDevMode)) {
			LOG.info("Hyperon factory set in developer mode!");
			hyperonEngineFactory.setDeveloperMode(true);
			var hyperonDevUser = Objects.requireNonNull(this.hyperonDevUser, "Hyperon dev user not supplied");
			hyperonEngineFactory.setUsername(hyperonDevUser);
		}
		return hyperonEngineFactory;
	}

	@Bean
	public HyperonEngine getHyperonEngine(HyperonEngineFactory hyperonEngineFactory) {
		return hyperonEngineFactory.create();
	}

	@Bean
	@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
	public SelectedDateHolder sessionDate() {
		return new SelectedDateHolder();
	}
}
