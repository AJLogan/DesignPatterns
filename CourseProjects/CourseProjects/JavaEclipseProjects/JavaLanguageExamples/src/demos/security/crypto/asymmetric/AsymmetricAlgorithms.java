package demos.security.crypto.asymmetric;

import java.io.*;
import java.security.*;
import java.security.spec.*;
import javax.crypto.*;


public class AsymmetricAlgorithms {
    public static void main(String[] args) throws Exception {
        loadRSACapableProvider();
        
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
        Key key = null;
        try {
            key = loadPublicKey("public.key");
        } catch(Exception ex) {
            System.out.println("Cannot load key - did you forget to generate one?");
            System.out.println("\t[" + ex + "]");
            return;
        }
        cipher.init(Cipher.ENCRYPT_MODE,key);
        byte[] clearText = "Lorem ipsum dolor sit amet".getBytes();
        
        printData("Original Text", clearText);
        
        byte[] cypherText = cipher.doFinal(clearText);
        
        printData("Encrypted Text", cypherText);
        
        cipher.init(Cipher.DECRYPT_MODE,loadPrivateKey("private.key"));
        byte[] decryptedText = cipher.doFinal(cypherText);
        
        printData("Decrypted Text", decryptedText);
    }
    private static void loadRSACapableProvider() {
        Provider p = new org.bouncycastle.jce.provider.BouncyCastleProvider();
        Security.insertProviderAt(p,5);   
    }
    private static Key loadPublicKey(String name) throws Exception {
        KeyFactory factory = KeyFactory.getInstance("RSA");
        KeySpec keySpec = new X509EncodedKeySpec(loadFile(name));
        return factory.generatePublic(keySpec);
    }
    private static Key loadPrivateKey(String name) throws Exception {
        KeyFactory factory = KeyFactory.getInstance("RSA");
        KeySpec keySpec = new PKCS8EncodedKeySpec(loadFile(name));
        return factory.generatePrivate(keySpec);
    }
    private static byte[] loadFile(String name) throws IOException {
        RandomAccessFile input = new RandomAccessFile("output" + File.separatorChar + name,"r");
        byte[] data = new byte[(int)input.length()];
        input.readFully(data);
        return data;
    }
    private static void printData(String title, byte[] buffer) {
        final String titlePadding = " ---------- ";
        System.out.println(titlePadding + title + titlePadding);
        System.out.println(new String(buffer));
    }
}
