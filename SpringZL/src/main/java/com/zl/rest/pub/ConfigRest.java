package com.zl.rest.pub;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zl.bo.pub.ConfigBO;
import com.zl.dao.pub.ConfigMapper;
import com.zl.vo.pub.ConfigVO;

@Controller
@RequestMapping ("/config" )
public class ConfigRest {
	@Autowired
	private ConfigMapper configMapper;
	@Autowired
	private ConfigBO configBo;

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("configVO") ConfigVO configVO) {
		configMapper.insert(configVO);
		return "hello world";
	}
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String refresh() {
		configBo.refresh();
		return "hello world";
	}
}
