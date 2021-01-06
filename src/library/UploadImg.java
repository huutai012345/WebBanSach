package library;

import java.io.File;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.web.multipart.MultipartFile;

public class UploadImg {
	private MultipartFile img;
	
	public UploadImg(MultipartFile img) {
		this.img=img;
	}
	
	public boolean check()
	{
		if(img.isEmpty())
		{
			return false;
		}
		
		if(!img.getContentType().equals("image/jpg") && !img.getContentType().equals("image/png") && !img.getContentType().equals("image/jpeg"))
		{
			return false;
		}
		
		return true;
	}
	
	public String update()
	{
		String type=img.getOriginalFilename().substring(img.getOriginalFilename().length()-4,img.getOriginalFilename().length());
		String ext = "tai";
		String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
		String path="D:/Code/Java/Eclipse/workspace2/DoAnCuoiKi/WebContent/resources/images/books/"+name+type;
		
		try {
			img.transferTo(new File(path));
			return "/resources/images/books/"+name+type;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
