package com.zl.interceptor;

import java.sql.Connection;
import java.util.List;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@Intercepts(@Signature(type=StatementHandler.class,method="prepare",args={Connection.class, Integer.class })) 
public class SQLPrintInterceotor implements Interceptor{
	private Logger log= LogManager.getLogger(SQLPrintInterceotor.class.getName());
	private String key;
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler)invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		String sql = boundSql.getSql();
		List<ParameterMapping> params = boundSql.getParameterMappings();
		
		for(ParameterMapping param : params) {
			log.debug(param.getJavaType()+":"+param.getExpression());
		}
		Object parameterObject = boundSql.getParameterObject();
        List<ParameterMapping> parameterMappingList = boundSql.getParameterMappings();
        log.debug(parameterObject);
        log.debug(parameterMappingList);
        log.debug(sql);
        if(parameterObject!=null) {
        	log.debug(sql.replaceAll("\\?", parameterObject.toString()));
        }
		
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		//读取在配置文件中属性
		
		
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
