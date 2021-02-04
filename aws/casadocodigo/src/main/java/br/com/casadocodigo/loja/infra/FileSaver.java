package br.com.casadocodigo.loja.infra;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.PutObjectRequest;

import br.com.casadocodigo.loja.models.Produto;

@Component
public class FileSaver {

	@Autowired
	private AmazonS3 amazonS3;
	
	@Value("${aws.bucket.images}")
    private String awsBucketImages;

	public String write(MultipartFile file) {
		try {
			
			PutObjectRequest request = new PutObjectRequest(awsBucketImages, file.getOriginalFilename(), file.getInputStream(), null);		
			request.setCannedAcl(CannedAccessControlList.PublicRead);
			
			amazonS3.putObject(request);
			
			return "http://s3.amazonaws.com/" + awsBucketImages + "/" + file.getOriginalFilename();
			
		} catch (IllegalStateException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
}









