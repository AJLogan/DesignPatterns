package demos.security.crypto.streams;

import java.io.*;
import javax.crypto.*;
import javax.crypto.spec.*;


public class EncryptionUsingStreamsPartOne {
    private static final String cypherTextFile = "output" + File.separator + "ciphertext.out";
	private static final String keyFile = "output" + File.separator + "key.out";

	public static void main(String[] args) throws Exception {
		//Find the DES Algorithm Provider
        KeyGenerator generator = KeyGenerator.getInstance("DES");
        //Generate a key using the provider that we just loaded
        SecretKey key = generator.generateKey();
        
        Cipher cipher = Cipher.getInstance("DES/CFB8/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE,key);
        //Initialisation Vector - random start character to Exclusively OR the first byte of the string against to kick off the chain
        IvParameterSpec iv = new IvParameterSpec(cipher.getIV());
        
        CipherOutputStream cipherOutput = new CipherOutputStream(new FileOutputStream(cypherTextFile),cipher);
        ObjectOutputStream keyOutput = new ObjectOutputStream(new FileOutputStream(keyFile));
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.println("Enter some text (XXXX to end)");
        while(true) {
	        String text = console.readLine();
	        if(text.equals("XXXX")) {
	            break;
	        } else {
	            text += "\n";
	            cipherOutput.write(text.getBytes());
	        }
        }
        keyOutput.writeObject(key);
        keyOutput.write(iv.getIV());
        
        cipherOutput.close();
        keyOutput.close();
    }
}
