package com.zl.dao.pub;

import org.springframework.stereotype.Service;

import com.zl.vo.pub.UserVO;

import tk.mybatis.mapper.common.Mapper;
@Service
public interface UserMapper extends Mapper<UserVO>{
	
	public int insert(UserVO vo);
	
	public UserVO findByPK(String user_id);
}