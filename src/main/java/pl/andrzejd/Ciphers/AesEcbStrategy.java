package pl.andrzejd.Ciphers;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;

public class AesEcbStrategy extends CipherStrategy {
    @Override
    public byte[] encrypt(String strToEncrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            return cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    @Override
    public String decrypt(byte[] strToDecrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            return new String(cipher.doFinal(strToDecrypt));
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }
}