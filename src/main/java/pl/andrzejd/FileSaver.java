package pl.andrzejd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSaver {

    public boolean save(String text, String path){
        try {
            Files.write(Paths.get(path+"\\encryptedText.txt"), text.getBytes());
            return true;
        } catch(IOException e) {
            return false;
        }
    }

}
