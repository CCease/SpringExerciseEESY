package config;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * 和事务相关的配置类
 */
public class TransactionConfig {

    /**
     * 创造事务管理器对象
     * @param dataSource
     * @return
     */
    public PlatformTransactionManager createTransactionManager(DataSource dataSource){
         return new DataSourceTransactionManager(dataSource);
    }
}
