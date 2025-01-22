/*---------------------------------------
TODOS: 
^  Highest priority
|  -UN-SPAGHETTI THE CODE
|  -Add support for 1000+ length inputs by breaking it into 999 character long chunks and decoding/encoding 1 chunk at a time
|  -Make user passwords and input strings be able to be entered into the console instead of directly into the code
|  -Optional feature that actually checks user passwords
|  -Double-layer security feature where a random string is encrytped by user password and that random string is used as the actual password to the input 
|  -Fix documentation for encyption algorithm to more accurately describe the ceasar's cipher-ish process
|  -Add comments into encryption algorithm
v  Lowest priority

Eventually push to git
---------------------------------------*/


import java.util.Scanner;

public class EncryptDecryptRunner{
    public static void main(String[] args){




    Scanner scanner = new Scanner(System.in);
    System.out.println("ENCRYPT OR DECRYPT? [E/D]");
    String encryptString = scanner.nextLine();
    //if you want to decrypt the input put false, to encrypt put true
    boolean encrypt = false;
    boolean debugMode = false;
     String inputString = "HELLO WORLD";
    String password = "PASSWORD";
    Encrypt encrypter = new Encrypt();
    Decrypt decrypter = new Decrypt();

    System.out.println(encryptString.toUpperCase());
    if(String.valueOf(encryptString.toUpperCase()).equals("D")){
      encrypt = false;
      System.out.println("DECRYPTING");
    } else if (String.valueOf(encryptString.toUpperCase()).equals("E")) {
      System.out.println("ENCRYPTING");
        encrypt = true;
    } 

    System.out.println("INPUT: ");
    inputString = (scanner.nextLine()).toUpperCase();

    System.out.println("PASSWORD: ");
    password = (scanner.nextLine()).toUpperCase();

    
      if(debugMode==true){
        System.out.println(encrypter.encryptData(inputString, password, true));
        System.out.println(decrypter.decryptData(encrypter.encryptData(inputString, password, true),password,true));
      } else {
    
      
      if(encrypt == true){
        //please do note that very long passwords (>25 chars) can create absurdly long encoded messages and are not recommended, but the encoder can theoretically account for a lot more
                                                     //(Message to encrypt, password)
        System.out.println(encrypter.encryptData(inputString, password, false));
        
      } else {
        System.out.println(decrypter.decryptData(inputString,password,false));
      }
      }
      
      
    
    
      
    }
    }
