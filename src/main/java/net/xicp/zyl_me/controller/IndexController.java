package net.xicp.zyl_me.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("/")
public class IndexController {
	@RequestMapping("/")
	public String getViewCount(HttpServletRequest request,Model model) {
		FileOutputStream out = null;
		FileInputStream in = null;
		int viewCount = 0;
		try {
			ServletContext servletContext = request.getServletContext();
			String realPath = servletContext.getRealPath("/WEB-INF/application.properties");
			Properties properties = new Properties();
			in = new FileInputStream(realPath);
			properties.load(in);
			viewCount = Integer.parseInt(properties.getProperty("view.count", "0"));
			model.addAttribute("viewCount", viewCount + 1);
			properties.put("view.count", String.valueOf(viewCount + 1));
			out = new FileOutputStream(realPath);
			properties.store(out, null);
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
			}
		}
		return "index";
	}
}
