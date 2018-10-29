package pl.andrzejd;

import pl.andrzejd.Ciphers.AesEcbStrategy;
import pl.andrzejd.Ciphers.CipherStrategy;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class MainClass {
    public static void main(String[] args) {
        CipherStrategy cipherStrategies = new AesEcbStrategy();
        String[] files = {
                "src\\main\\resources\\5mb.txt",
                "src\\main\\resources\\10mb.txt",
                "src\\main\\resources\\15mb.txt",
                "src\\main\\resources\\20mb.txt",
                "src\\main\\resources\\25mb.txt",
        };
        FileLoader fileLoader = new FileLoader();
        List<byte[]> encryptedText = new ArrayList<>();

        String key = "abcdefghijklmopaabcdefghijklmopaabcdefghijklmopaabcdefghijklmopa";

        for (String file : files) {
            String text = fileLoader.load(file);
            long start1 = System.currentTimeMillis();

            encryptedText.add(cipherStrategies.encrypt(text, key));

            long elapsedTime1 = System.currentTimeMillis() - start1;
            System.out.println(elapsedTime1);
        }

        System.out.println("---");

        for(byte[] encryptText : encryptedText) {
            long start1 = System.currentTimeMillis();

            String decryptedText = cipherStrategies.decrypt(encryptText, key);

            long elapsedTime1 = System.currentTimeMillis() - start1;
            System.out.println(elapsedTime1);
        }

    }
}
