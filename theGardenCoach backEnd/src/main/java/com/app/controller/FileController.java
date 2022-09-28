package com.app.controller;

import java.io.IOException;
import java.io.InputStream;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.Utils.IStorageService;

@CrossOrigin
@Controller
public class FileController {

	@Autowired
	private IStorageService storageService;

	@RequestMapping(value="/{photo}", produces = "image/*")
	public void download(@PathVariable("photo") String photo, HttpServletResponse resp) {
		System.out.println("Loading file: " + photo);
		Resource resource = storageService.load(photo);
		if(resource != null) {
			try(InputStream in = resource.getInputStream()) {
				ServletOutputStream out = resp.getOutputStream();
				FileCopyUtils.copy(in, out);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
