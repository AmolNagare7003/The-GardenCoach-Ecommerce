package com.app.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

//import custom_exception.ResourceNotFoundException;


@Service
@Component
public class StorageServiceImpl implements IStorageService {
	@Value("${disk.upload.basepath}")
	private String BASEPATH;

	
	@Override
	public List<String> loadAll() 
	{
		File dirPath = new File(BASEPATH);
		return Arrays.asList(dirPath.list());
	}

	@Override
	public String store(MultipartFile file) {
		System.out.println(file.getOriginalFilename());
		String ext=file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		System.out.println(ext);
		String fileName = UUID.randomUUID().toString().replaceAll("-", "")+ext;
		File filePath = new File(BASEPATH, fileName);
		try(FileOutputStream out = new FileOutputStream(filePath)) {
			FileCopyUtils.copy(file.getInputStream(), out);
			return fileName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
		
//Product prod = pdao.findById(prodid).orElseThrow(()->new ResourceNotFoundException("Err in service of Image adding!!!!"));
//		
//		String completePath=baseFolder + File.separator + imageFile.getOriginalFilename();
//		
//		System.out.println("copmletePath "+completePath);
//		System.out.println("coping no.of bytes : "+Files.copy(imageFile.getInputStream(),Paths.get(completePath),StandardCopyOption.REPLACE_EXISTING));
//		
//		prod.setPhoto(completePath);
//		return mapper.map(prod, ProductDTO.class);
	}

	@Override
	public Resource load(String fileName) {
		File filePath = new File(BASEPATH, fileName);
		if(filePath.exists())
			return new FileSystemResource(filePath);
		return null;
	}

	@Override
	public void delete(String fileName) {
		File filePath = new File(BASEPATH, fileName);
		if(filePath.exists())
			filePath.delete();
	}


}
