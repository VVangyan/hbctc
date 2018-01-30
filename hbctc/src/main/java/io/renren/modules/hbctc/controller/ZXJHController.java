package io.renren.modules.hbctc.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.renren.modules.hbctc.entity.ProjectRequestForm;
import io.renren.modules.sys.controller.AbstractController;

/**
 * @Description:执行计划controller
 * @date: 2018-01-24
 * @author: yan
 */
@RestController
public class ZXJHController extends AbstractController{
	@PostMapping("/project")
	public String info(@RequestBody ProjectRequestForm projectRequestForm) {
		System.out.println(projectRequestForm);
		return "ok";
	}
	
}
