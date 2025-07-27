package drug.inventory.management_system.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadService {
    private static final String UPLOAD_DIR = "src/main/resources/static/images/";

    public String uploadImage(MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("File is empty");
        }
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if (!extension.equalsIgnoreCase("jpg")) {
            throw new IOException("Only JPG files are allowed");
        }
        String fileName = UUID.randomUUID().toString() + ".jpg";
        Path path = Paths.get(UPLOAD_DIR + fileName);
        Files.createDirectories(path.getParent());
        Files.write( path,file.getBytes());
        return "/images/" + fileName;
    }
}