package pl.coderslab.app.services;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class PhotoLoadService {


    public String uploadFile(MultipartFile file, HttpServletRequest request) {

        String generatedString = RandomStringUtils.random(10, true, false);
        String fileName = file.getOriginalFilename();
        String webFilePathString = "photos/"+generatedString+fileName;
        String rootPathString = request.getServletContext().getRealPath("")+"photos/";

        Path rootPath = Paths.get(rootPathString);
        Path target = Paths.get(rootPathString+generatedString+fileName);

        try{

            if(!Files.exists(rootPath)){
                Files.createDirectories(rootPath);
            }

            Files.copy(file.getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

        }
        catch(IOException e){
            e.printStackTrace();
        }
        return webFilePathString;
    }
}
