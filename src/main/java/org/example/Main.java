package org.example;

import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

import static org.example.rsa_enc.decrypt;
import static org.example.rsa_enc.encrypt;

public class Main {
    
    public static void main(String[] args) throws Exception{
        java.security.KeyPair keyPair = generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
        String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());


        String originalmsg = "Hello, this is a secret message!";
        System.out.println("Original message: " + originalmsg);
        //Encrypt this message
        String encryptedMsg = encrypt(originalmsg, publicKeyString);
        System.out.println("Encrypted message: " + encryptedMsg);
        //Decrypt Message
        String decryptedMsg = decrypt(encryptedMsg, privateKeyString);
        System.out.println("Decrypted message: " + decryptedMsg);
    }

    public static java.security.KeyPair generateKeyPair() throws Exception{
        KeyPairGenerator keypairgenerator = KeyPairGenerator.getInstance("RSA");
        keypairgenerator.initialize(2048);
        return keypairgenerator.generateKeyPair();
    }



}