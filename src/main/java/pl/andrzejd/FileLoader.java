package pl.andrzejd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileLoader {

    public String load(String fileName){
        List<String> list;

        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

            //1. filter line 3
            //2. convert all content to upper case
            //3. convert it into a List
            list = stream
                    .filter(line -> !line.startsWith("line3"))
                    .map(String::toUpperCase)
                    .collect(Collectors.toList());

            StringBuilder sb = new StringBuilder();
            list.forEach(sb::append);

            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

}