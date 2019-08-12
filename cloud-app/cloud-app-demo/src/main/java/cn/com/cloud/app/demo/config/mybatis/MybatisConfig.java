package cn.com.cloud.app.demo.config.mybatis;

import com.github.pagehelper.PageInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

import javax.sql.DataSource;
import java.util.Properties;


/**
 * Copyright (C), 2018, 北京同创永益科技发展有限公司
 * FileName: ResultCode
 * Author:   JiangXincan
 * Date:     2018-12-19 16:30:00
 * @Description: mybatis配置
 */
@Configuration
public class MybatisConfig {

    // mybatis扫描实体类
    private static final String  TYPE_ALIASES_PACKAGE = "cn.com.cloud.app.demo.*.entity.**";

    // mybatis数据访问增删改查等操作接口类
    private static final String MYBATIS_BASE_MAPPER = "cn.com.cloud.common.data.universal.IBaseMapper";

    // mybatis扫描当前服务数据接口mapper文件
    private static final String MYBATIS_CURRENT_MAPPER_PACKAGE = "cn.com.cloud.app.demo.*.mapper.**";

    // mybatis扫描当前服务数据接口mapper文件对应的xml SQL处理文件
    private static final String MYBATIS_CURRENT_MAPPER_XML = "classpath*:mapper/**/*.xml";

    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
        factory.setDataSource(dataSource);
        factory.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
        // 添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        factory.setMapperLocations(resolver.getResources(MYBATIS_CURRENT_MAPPER_XML));
        return factory.getObject();
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        mapperScannerConfigurer.setSqlSessionFactoryBeanName("sqlSessionFactoryBean");
        mapperScannerConfigurer.setBasePackage(MYBATIS_CURRENT_MAPPER_PACKAGE);
        Properties properties = new Properties();
        properties.setProperty("mappers", MYBATIS_BASE_MAPPER);
        properties.setProperty("notEmpty","false");
        properties.setProperty("IDENTITY","SELECT REPLACE(UUID(),''-'','''')");
        properties.setProperty("ORDER","BEFORE");
        mapperScannerConfigurer.setProperties(properties);
        return mapperScannerConfigurer;
    }


    /**
     * 分页配置
     * @return
     */
    @Bean
    public PageInterceptor pageInterceptor(){

        PageInterceptor pageInterceptor = new PageInterceptor();
        Properties properties = new Properties();
        properties.setProperty("helperDialect", "mysql");
        properties.setProperty("reasonable", "true");
        properties.setProperty("supportMethodsArguments", "true");
        properties.setProperty("params", "count=countSql");
        properties.setProperty("page-size-zero", "true");

        pageInterceptor.setProperties(properties);
        return pageInterceptor;
    }
}
