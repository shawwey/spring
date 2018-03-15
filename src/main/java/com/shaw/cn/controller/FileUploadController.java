package com.shaw.cn.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.shaw.cn.pojo.AjaxResult;

@Controller
@RequestMapping(value="file/")
public class FileUploadController {
	
	@RequestMapping(value="upload.do")
	@ResponseBody
	public AjaxResult uploadFile(@RequestParam("file") MultipartFile file,HttpServletRequest request,HttpServletResponse response){
		
		if(!file.isEmpty()){
			 try {  
	                // 文件保存路径  
	                String filePath = request.getSession().getServletContext().getRealPath("/")+ file.getOriginalFilename();  
	                // 转存文件  
	                file.transferTo(new File(filePath));  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
		}
		return  AjaxResult.SUCCESS;
	}
	
	@RequestMapping(value="download.do")
	@ResponseBody
	public void downloadFile(HttpServletRequest request,HttpServletResponse response) throws IOException{
		
		  String path="F:/changeLog.txt";
          String suffix = path.substring(path.lastIndexOf("."));
          String file_name = path.substring(path.lastIndexOf("/") + 1);
          if(suffix.indexOf("doc") > 0) {
               response.setContentType("application/msword;charset=UTF-8");
          } else if (".xls".equals(suffix)) {
               response.setContentType("application/vnd.ms-excel application/x-excel");
          } else {
               response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
          }
          response.setContentType("application/octet-stream");
          response.setHeader("Content-Disposition", "inline;filename="+ new String(file_name.getBytes("gb2312"), "ISO-8859-1"));
          // 读取要下载的文件，保存到文件输入流
          FileInputStream in = new FileInputStream(path);
          // 创建输出流
          OutputStream out = response.getOutputStream();
          // 创建缓冲区
          byte buffer[] = new byte[1024];
          int len = 0;
          // 循环将输入流中的内容读取到缓冲区当中
          while ((len = in.read(buffer)) > 0) {
           // 输出缓冲区的内容到浏览器，实现文件下载
           out.write(buffer, 0, len);
          }
          // 关闭文件输入流
          in.close();
          // 关闭输出流
          out.close();
	}
	

	
}
