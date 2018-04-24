package org.job.dao;

import java.util.List;

import org.job.vo.ConfigVO;
import org.springframework.stereotype.Repository;

import tk.mybatis.mapper.common.BaseMapper;

@Repository
public interface ConfigMapper extends BaseMapper<ConfigVO> {

	public int insert(ConfigVO vo);
	
	public List<ConfigVO> findAll();
}