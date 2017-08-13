package test.mysql.table;

import java.math.BigInteger;

import com.zl.vo.common.CommonVO;

public class ColumnVO extends CommonVO {
	public String table_catalog;
	public String table_schema;
	public String table_name;
	public String column_name;
	public BigInteger ordinal_position;
	public String column_default;
	public String is_nullable;
	public String data_type;
	public BigInteger character_maximum_length;
	public BigInteger character_octet_length;
	public BigInteger numeric_precision;
	public BigInteger nueric_scale;
	public BigInteger datetime_precision;
	public String character_set_name;
	public String collation_name;
	public String column_type;
	public String column_key;
	public String extra;
	public String privileges;
	public String column_comment;
	public String genration_expression;
	
	
	public ColumnVO() {
		super();
		
	}
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
	public String getColumn_name() {
		return column_name;
	}
	public void setColumn_name(String column_name) {
		this.column_name = column_name;
	}
	public BigInteger getOrdinal_position() {
		return ordinal_position;
	}
	public void setOrdinal_position(BigInteger ordinal_position) {
		this.ordinal_position = ordinal_position;
	}
	public String getColumn_default() {
		return column_default;
	}
	public void setColumn_default(String column_default) {
		this.column_default = column_default;
	}
	public String getIs_nullable() {
		return is_nullable;
	}
	public void setIs_nullable(String is_nullable) {
		this.is_nullable = is_nullable;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public BigInteger getCharacter_maximum_length() {
		return character_maximum_length;
	}
	public void setCharacter_maximum_length(BigInteger character_maximum_length) {
		this.character_maximum_length = character_maximum_length;
	}
	public BigInteger getCharacter_octet_length() {
		return character_octet_length;
	}
	public void setCharacter_octet_length(BigInteger character_octet_length) {
		this.character_octet_length = character_octet_length;
	}
	public BigInteger getNumeric_precision() {
		return numeric_precision;
	}
	public void setNumeric_precision(BigInteger numeric_precision) {
		this.numeric_precision = numeric_precision;
	}
	public BigInteger getNueric_scale() {
		return nueric_scale;
	}
	public void setNueric_scale(BigInteger nueric_scale) {
		this.nueric_scale = nueric_scale;
	}
	public BigInteger getDatetime_precision() {
		return datetime_precision;
	}
	public void setDatetime_precision(BigInteger datetime_precision) {
		this.datetime_precision = datetime_precision;
	}
	public String getCharacter_set_name() {
		return character_set_name;
	}
	public void setCharacter_set_name(String character_set_name) {
		this.character_set_name = character_set_name;
	}
	public String getCollation_name() {
		return collation_name;
	}
	public void setCollation_name(String collation_name) {
		this.collation_name = collation_name;
	}
	public String getColumn_type() {
		return column_type;
	}
	public void setColumn_type(String column_type) {
		this.column_type = column_type;
	}
	public String getColumn_key() {
		return column_key;
	}
	public void setColumn_key(String column_key) {
		this.column_key = column_key;
	}
	public String getExtra() {
		return extra;
	}
	public void setExtra(String extra) {
		this.extra = extra;
	}
	public String getPrivileges() {
		return privileges;
	}
	public void setPrivileges(String privileges) {
		this.privileges = privileges;
	}
	public String getColumn_comment() {
		return column_comment;
	}
	public void setColumn_comment(String column_comment) {
		this.column_comment = column_comment;
	}
	public String getGenration_expression() {
		return genration_expression;
	}
	public void setGenration_expression(String genration_expression) {
		this.genration_expression = genration_expression;
	}
}
