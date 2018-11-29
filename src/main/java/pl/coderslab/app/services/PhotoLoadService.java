package pl.coderslab.app.services;

import org.springframework.stereotype.Service;
import pl.coderslab.app.dtos.FormDataWithFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class PhotoLoadService {


    public String uploadFile(FormDataWithFile formDataWithFile, HttpServletRequest request, Long loggedUserId) {
        String fileName = formDataWithFile.getFile().getOriginalFilename();
        String webFilePathString = "photos/"+loggedUserId+"/" +fileName;
        String rootPathString = request.getServletContext().getRealPath("")+"photos/"+loggedUserId+"/";

        Path rootPath = Paths.get(rootPathString);
        Path target = Paths.get(rootPathString+fileName);


        try{

            if(!Files.exists(rootPath)){
                Files.createDirectories(rootPath);
            }

            Files.copy(formDataWithFile.getFile().getInputStream(), target, StandardCopyOption.REPLACE_EXISTING);

        }catch(IOException e){
            e.printStackTrace();
        }


        return webFilePathString;
    }

}
