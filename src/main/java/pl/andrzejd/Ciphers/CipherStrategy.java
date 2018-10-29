package pl.andrzejd.Ciphers;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;

public abstract class CipherStrategy {
    SecretKeySpec secretKey;
    IvParameterSpec ivParameterSpec;

    void setKey(String myKey) {
        try {
            int ivSize = 16;
            byte[] iv = new byte[ivSize];
            SecureRandom secureRandom = new SecureRandom();
            secureRandom.nextBytes(iv);
            ivParameterSpec = new IvParameterSpec(iv);

            secretKey = new SecretKeySpec(
                    Arrays.copyOf(
                            MessageDigest.getInstance("SHA-1")
                                    .digest(myKey.getBytes(StandardCharsets.UTF_8)),
                            ivSize
                    ),
                    "AES"
            );
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    abstract public byte[] encrypt(String value, String key);

    abstract public String decrypt(byte[] value, String key);
}
