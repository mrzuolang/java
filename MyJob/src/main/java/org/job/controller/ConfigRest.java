package org.job.controller;

import org.job.bo.ConfigBO;
import org.job.dao.ConfigMapper;
import org.job.vo.ConfigVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
