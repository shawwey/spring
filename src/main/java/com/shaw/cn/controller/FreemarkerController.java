package com.shaw.cn.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import freemarker.template.Configuration;
import freemarker.template.Template;

@Controller
@RequestMapping(value="freemarker/")
public class FreemarkerController {
	
	@RequestMapping(value="generateFreemarker.do")
	public String generateFreemarkerModule(Model model){
		try {
			
			//第一步:读取html模板
			Configuration conf=new Configuration();
			String dir="F:\\angular2\\spring\\src\\main\\webapp\\resources\\ftl";
			conf.setDirectoryForTemplateLoading(new File(dir));
			Template template=conf.getTemplate("template.jsp");
			
	        //第二步: 加载数据模型
	        Map<String,Object> root = new HashMap<String,Object>();
	        root.put("world", "世界你好");
	        
	        //List集合
	        List<String> persons = new ArrayList<String>();
	        persons.add("范冰冰");
	        persons.add("李冰冰");
	        persons.add("何炅");
	        root.put("persons", persons);
	        
	        //Map集合
	        Map<String,Object> map = new HashMap<String,Object>();
	        map.put("fbb", "范冰冰");
	        map.put("lbb", "李冰冰");
	        root.put("map", map);
	        
	        //list和map混合
	        List<Map> maps = new ArrayList<Map>();
	        Map<String,String> pms1 = new HashMap<String,String>();
	        pms1.put("id1", "范冰冰");
	        pms1.put("id2", "李冰冰");
	        Map<String,String> pms2 = new HashMap<String,String>();
	        pms2.put("id1", "曾志伟");
	        pms2.put("id2", "何炅");
	        maps.add(pms1);
	        maps.add(pms2);
	        root.put("maps", maps);
	        
	        String resultdir="F:\\angular2\\spring\\src\\main\\webapp\\WEB-INF\\view\\";
	        Writer out = new FileWriter(new File(resultdir + "hello.jsp"));
	        template.process(root, out);
	        System.out.println("生成完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "hello";
	}
	
	@RequestMapping(value="showIndex.do")
	public ModelAndView showFreemarkerIndex(ModelAndView mv){
		//Model model=new 
		
		return mv;
	}
}
