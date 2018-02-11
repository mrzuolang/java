package org.code.vo;

import java.math.BigInteger;


public class TableVO extends CommonVO {
	private static final long serialVersionUID = 1L;
	public String table_catalog = "";
	public String table_schema = "";
	public String table_name = "";
	public String table_type = "";
	public String engine = "";
	public BigInteger version;
	public String row_format = "";
	public BigInteger table_rows;
	public BigInteger avg_row_length;
	public BigInteger data_length;
	public BigInteger max_data_length;
	public BigInteger index_length;
	public BigInteger data_free;
	public BigInteger auto_increment;
	public String create_time = "";
	public String update_time = "";
	public String check_time = "";
	public String talbe_collation = "";
	public String checksum = "";
	public String create_options = "";
	public String table_comment = "";
	public String getTable_catalog() {
		return table_catalog;
	}
	public void setTable_catalog(String table_catalog) {
		this.table_catalog = table_catalog;
	}
	public String getTable_schema() {
		return table_schema;
	}
	public void setTable_schema(String table_schema) {
		this.table_schema = table_schema;
	}
	public String getTable_name() {
		return table_name;
	}
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}
	public String getTable_type() {
		return table_type;
	}
	public void setTable_type(String table_type) {
		this.table_type = table_type;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public BigInteger getVersion() {
		return version;
	}
	public void setVersion(BigInteger version) {
		this.version = version;
	}
	public String getRow_format() {
		return row_format;
	}
	public void setRow_format(String row_format) {
		this.row_format = row_format;
	}
	public BigInteger getTable_rows() {
		return table_rows;
	}
	public void setTable_rows(BigInteger table_rows) {
		this.table_rows = table_rows;
	}
	public BigInteger getAvg_row_length() {
		return avg_row_length;
	}
	public void setAvg_row_length(BigInteger avg_row_length) {
		this.avg_row_length = avg_row_length;
	}
	public BigInteger getData_length() {
		return data_length;
	}
	public void setData_length(BigInteger data_length) {
		this.data_length = data_length;
	}
	public BigInteger getMax_data_length() {
		return max_data_length;
	}
	public void setMax_data_length(BigInteger max_data_length) {
		this.max_data_length = max_data_length;
	}
	public BigInteger getIndex_length() {
		return index_length;
	}
	public void setIndex_length(BigInteger index_length) {
		this.index_length = index_length;
	}
	public BigInteger getData_free() {
		return data_free;
	}
	public void setData_free(BigInteger data_free) {
		this.data_free = data_free;
	}
	public BigInteger getAuto_increment() {
		return auto_increment;
	}
	public void setAuto_increment(BigInteger auto_increment) {
		this.auto_increment = auto_increment;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	public String getCheck_time() {
		return check_time;
	}
	public void setCheck_time(String check_time) {
		this.check_time = check_time;
	}
	public String getTalbe_collation() {
		return talbe_collation;
	}
	public void setTalbe_collation(String talbe_collation) {
		this.talbe_collation = talbe_collation;
	}
	public String getChecksum() {
		return checksum;
	}
	public void setChecksum(String checksum) {
		this.checksum = checksum;
	}
	public String getCreate_options() {
		return create_options;
	}
	public void setCreate_options(String create_options) {
		this.create_options = create_options;
	}
	public String getTable_comment() {
		return table_comment;
	}
	public void setTable_comment(String table_comment) {
		this.table_comment = table_comment;
	}
	
}
