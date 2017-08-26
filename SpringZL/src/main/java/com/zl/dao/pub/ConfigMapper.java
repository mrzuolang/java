package com.zl.dao.pub;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.zl.vo.pub.ConfigVO;
import tk.mybatis.mapper.common.BaseMapper;

@Repository
public interface ConfigMapper extends BaseMapper<ConfigVO> {

	public int insert(ConfigVO vo);
	
	public List<ConfigVO> findAll();
}