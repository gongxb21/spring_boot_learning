package com.gongxb21.demo.controller;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author gongxb
 *
 * 2017年12月31日
 */
@Controller
public class FileController {
	private static final Logger logger=LoggerFactory.getLogger(FileController.class);
	
	@RequestMapping("/init")
	public String init() {
		return "upload";
	}
	
	@RequestMapping(value="upload")
	@ResponseBody
	public String upload(@RequestParam("file") MultipartFile file) {
		if(file.isEmpty()) {
			return "文件为空";
		}
		String fileName=file.getOriginalFilename();
		logger.info("fileName="+fileName);
		
		String suffixName=fileName.substring(fileName.lastIndexOf("."));
		logger.info("suffixName="+suffixName);
		
		//这两种路径都可以，一个需要用转义，一个不用转义
		//String filePath="G:\\logs\\";
		String filePath="G:/logss/";
		File dest=new  File(filePath+fileName);
		
		if(!dest.getParentFile().exists()) {
			logger.info(" mkdirs ");
			dest.getParentFile().mkdirs();
		}
		try {
			logger.info("dest.fileName"+dest.getName());
			file.transferTo(dest);
			return "上传成功";
		}catch(Exception exception) {
			logger.warn("catch a exception "+ exception.getMessage());
			return "上传失败";
		}
		
	}
	
}
