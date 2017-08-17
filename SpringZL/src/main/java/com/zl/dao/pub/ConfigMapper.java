package com.zl.dao.pub;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.zl.vo.pub.ConfigVO;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface ConfigMapper extends Mapper<ConfigVO> {

	public int insert(ConfigVO vo);

	public List<ConfigVO> findAll();
}