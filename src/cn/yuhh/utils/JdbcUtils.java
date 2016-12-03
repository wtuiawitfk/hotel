package cn.yuhh.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;



/**
 * Created by Brill on 2016/12/3.
 */
public class JdbcUtils {

    //初始化连接池
    private static DataSource dataSource;
    static {
        dataSource = new ComboPooledDataSource();
    }

    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 创建DbUtils常用工具类对象
     */
    public static QueryRunner getQuerrRunner() {
        return new QueryRunner(dataSource);
    }
}
