package demos.security.crypto.asymmetric;

import java.io.*;
import java.security.*;

public class GeneratingKeyPairs {
    public static void main(String[] args) throws Exception {
        File publicKeyFile = new File("output" + File.separator + "public.key");
        File privateKeyFile = new File("output" + File.separator + "private.key");
        
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(1024);
        
        KeyPair pair = generator.genKeyPair();
        
        FileOutputStream publicKeyOut = new FileOutputStream(publicKeyFile);
        FileOutputStream privateKeyOut = new FileOutputStream(privateKeyFile);
        
        publicKeyOut.write(pair.getPublic().getEncoded());
        publicKeyOut.close();
        privateKeyOut.write(pair.getPrivate().getEncoded());
        privateKeyOut.close();
        
        System.out.println("Key pair written");
    }
}
