package org.blog.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.blog.util.StringUtil;
import org.blog.vo.UserVO;


@Mapper
public interface UserDao {
	static final Logger log = LogManager.getLogger();
    @Delete("delete from pub_user where user_id=#{pk}")
	public int deleteByPk(@Param("pk") int pk);
	
	@Insert("insert into pub_user (user_id, user_name, password,bill_code, nick_name, mail,phone) "
			+ "values (#{user.user_id}, #{user.user_name},#{user.password},#{user.bill_code},#{user.nick_name},#{user.mail},#{user.phone})")
	public int insert(@Param("user") UserVO user);
	
	@Select("select * from pub_user where user_id=#{pk}")
	public UserVO findByPk(@Param("pk")int pk);
	
	@UpdateProvider(type=UserDaoProvider.class, method = "updateByBillcode")
	public int updateByBillcode(@Param("user")UserVO user);
	
	class UserDaoProvider{
		public String updateByBillcode(@Param("user") UserVO user) {
			StringBuilder sql = new StringBuilder("update pub_user set user_name=#{user.user_name} where ");
			if(user.getUser_id()>0) {
				sql.append(" user_id=#{user.user_id}");
			}else if(!StringUtil.isEmpty(user.getBill_code())) {
				sql.append(" bill_code=#{user.bill_code}");
			}
			log.info(sql.toString());
			return sql.toString();
			
		}
	}
} 