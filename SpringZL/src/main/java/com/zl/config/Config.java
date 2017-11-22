package com.zl.config;

public class Config {
	/**数据库url配置*/
    public static final String DB_URL = "jdbc:mysql://182.18.22.97:3306/blog?characterEncoding=utf8&serverTimezone=UTC";
    /**数据库名称*/
    public static final String DB_NAME="blog";
    /**数据库用户名*/
    public static final String DB_USERNAME = "mysql";
    /**数据库密码*/
    public static final String DB_PASSWORD = "1234";
    /**MySQL驱动类*/
    public static final String MYSQL_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver"; 
    
    
    /**项目路径配置*/
    public static final String PROJECT_PATH = "D:/git/java/SpringZL";
    /**项目源码路径配置*/
    public static final String JAVA_PATH = "/src/main/java";
    /**项目资源路径配置*/
    public static final String RESOURCES_PATH = "/src/main/resources";
}
