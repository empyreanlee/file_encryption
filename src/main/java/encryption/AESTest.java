package encryption;

import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class AESTest {
    @Test
    public void givenString_whenEncrypt_thenSuccess() throws IllegalBlockSizeException, InvalidKeyException,
            BadPaddingException, InvalidAlgorithmParameterException, NoSuchPaddingException, NoSuchAlgorithmException {
        String input = "baeldung";
        SecretKey key = string_AES.generateKey(128);
        IvParameterSpec ivParameterSpec = string_AES.generateIv();
        String ciphertext = string_AES.encrypt(input, key, ivParameterSpec);
        String plaintext = string_AES.decrypt(ciphertext, key, ivParameterSpec);

        org.junit.jupiter.api.Assertions.assertEquals(input, plaintext);

    }
}
