package org.blog.jobs.pk10;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateTableByDay {
	public static SimpleDateFormat date_format = new SimpleDateFormat("yyyy_MM_dd");
	public static String getCreateTableSQL() {
		String tableName = "pk10_"+date_format.format(new Date());
		StringBuilder sql = new StringBuilder("CREATE TABLE ");
		sql.append(tableName);
		sql.append(" (`bill_code` bigint(20) NOT NULL COMMENT '期数:677919',");
		sql.append("`plan_code` varchar(50) DEFAULT NULL COMMENT '919-921',");
		sql.append("`plan_content` varchar(50) DEFAULT NULL COMMENT '5,6,2,7,10',");
		sql.append("`num_one` int(11) DEFAULT NULL COMMENT '4',");
		sql.append("`result` bit(1) DEFAULT NULL COMMENT '0是不中 1是中',");
		sql.append("`open_time` datetime DEFAULT NULL COMMENT '开奖时间',");
		sql.append("`nums` varchar(50) DEFAULT NULL COMMENT '出现的结果',");
		sql.append("`persen` int(11) DEFAULT NULL COMMENT '胜率',");
		sql.append("PRIMARY KEY (`bill_code`)");
		sql.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8");
		
		return sql.toString();
	}
}
