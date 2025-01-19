
public class Encrypt {
    public String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    
    public String[] convertLetters(String password){
      //nAlpha is the new array of encoded letters which will replace original letters in string
      String[] nAlphabet = new String[26]; 
      //remove all duplicate letters in password
      String cutPass = Functions.removeDuplicates(password);
  
      //k is the same as counter, but i was too lazy to change all k's to counter when updating
      //however k has a maximum value
      int k = 1;
  
      //exists to stop runaway loop
      int counter = 1;
  
    //loop generates the table of which the letters in input will be converted to   
        //updates nAlphabet
    //terminates once all letters are converted or when it runs for too long
     while(Functions.countOccurences(nAlphabet, null)>0&&counter<99999){
  
     
     for(int i = 0; i<10; i++){
       //rather than fix the problem of random stringindexouofbounds exceptions with .substring, im just ignoring them
       try{
       
              
          String passwordLetter /*to encode*/ = cutPass.substring(i,i+1);
          int indexOfPasswordLetter = Functions.findIndex(alphabet, passwordLetter);
          int newIndexOfEncodedLetter = indexOfPasswordLetter /*for now*/;
  
         // will only make letterNumber where Number is at max k
          int numTimes = k;
          while(numTimes>0){
            //moves the index of the new encoded letter to PASLENGTH away from where it was before
            newIndexOfEncodedLetter = newIndexOfEncodedLetter + cutPass.length();
            numTimes--;
  
            //code to reset the index to 0 if it goes over the maximum bound (26 letters, index 25)
            if(newIndexOfEncodedLetter>25){
  
              //brings it back under 25
              while(newIndexOfEncodedLetter>25){
                newIndexOfEncodedLetter=newIndexOfEncodedLetter-cutPass.length();
              }
              //manually adds PASSLENGTH onto the index of the encoded letter and resets to 0 if it reaches 26
              for(int j = 0; j<cutPass.length();j++){
                newIndexOfEncodedLetter++;
                if(newIndexOfEncodedLetter>25){
                newIndexOfEncodedLetter=0;
              }              
            }
          }
        }
  
  
         //code to ensure it does not overwrite itself, example if a comes before b in password, B1 cannot overwrite A1, nor can A2 overwrite B1 
         //essentially, if there already exists a letter at [index] in nalphabet, do no overwrite. otherwise, do write
         if(nAlphabet[newIndexOfEncodedLetter]==null){
         //System.out.println("WRITTEN "+  passwordLetter+k + " AT " + newIndexOfEncodedLetter + " FOR "+alphabet[newIndexOfEncodedLetter] );
          nAlphabet[newIndexOfEncodedLetter] = (passwordLetter +""+ k);
         } else {
          // System.out.println("DID NOT OVERWRITE "+ nAlphabet[newIndexOfEncodedLetter] + " WITH " + passwordLetter+k + " FOR "+ alphabet[newIndexOfEncodedLetter]);
         }
      //code doesnt tweak after this so we're good
      }
      catch(Exception e){
     //   System.out.println(e);
      } 
     }
     //System.out.println("AMOUNT OF NULL'S LEFT: "+(countOccurences(nAlphabet, null)));
  
  
      if(k<20){
       //k shall increase no longer
        k++;
      }
      //and no longer shall I have runaway loops
      counter++;
    }
  
      //saves all of nAlpha to fina for testing, im trying to make sure it contains no NULLS by the time i finish assinging
      String fina = "";
      for(int i = 0; i<26; i++){
        fina = fina + " "+ nAlphabet[i];
      }
      
      //System.out.println("LETTER CONVERSION AT PASSWORD \"" +password+"\"" + " CUT TO " +cutPass + "\n");
  
      //prints a conversion table between the encoded letters and regular alphabet
      //mainly for testing but it seems useful for error checking so i'll leave it in
      System.out.println("CONVERSION TABLE:");
      System.out.println(fina);
      String alphabetPrint = "";
      for(int i = 0; i<26; i++){
        alphabetPrint = alphabetPrint +" "+  alphabet[i]+ " ";
      }
      System.out.println(alphabetPrint);
      
      
      return nAlphabet;
   }
  
  
    
    public String encryptData(String Userinput, String password, boolean debugMode){
  
      //If input has less than two spaces, adds two at the end so we can benefit from randomization based on spaces
      //needs more testing to see if it works with only wih 0 or 1 spaces
      char[] tempMessage = Userinput.toCharArray();
      if((Functions.countOccurences(tempMessage, ' '))<=0){
        Userinput = Userinput + " ";
      }
      //uppercase it because users are dumb
      password = password.toUpperCase();
      Userinput = Userinput.toUpperCase();
  
      String[] encodedAlphabet = convertLetters(password);
      char[] message = Userinput.toCharArray();
      String encodedMessage = "";
  
  
      if(message.length>999){
        return "USER INPUT IS TOO LONG. PLEASE USE SOMETHING LESS THAN 1000 CHARACTERS (SPACES INCLUDED)";
      } else {
      
      DynamicArray locationsOfSpaces = new DynamicArray(1);
      
      int numOfLettersReplacedInThisInstant = 0;
      int numTimesToRandomLetter = 0;
      
      for(int i = 0; i<Userinput.length();i++){
        String originalLetter = String.valueOf(message[i]);
  
        
        //if(//count occurances of space is 1 or less add two spaces onlto userInput)
  
  
        
        //System.out.println(encodedAlphabet[findIndex(alphabet, String.valueOf(originalLetter))] +" "+ originalLetter +" "+findIndex(alphabet, String.valueOf(originalLetter)));
        if((message[i])==' '){
         // System.out.println("SPACE AT: "+i);
          encodedMessage = encodedMessage + randomLetter(5);
          numOfLettersReplacedInThisInstant++;
          
         locationsOfSpaces.insert(i);
          
          if(numOfLettersReplacedInThisInstant==password.length()){
           
            for(int q = 0; q<password.length(); q++){
              encodedMessage = encodedMessage + randomLetter(5);
            }
            numOfLettersReplacedInThisInstant = 0;
          }
        } else {
        
        String encodedLettter = encodedAlphabet[Functions.findIndex(alphabet, String.valueOf(originalLetter))];
        encodedMessage = encodedMessage + encodedLettter;
  
          numOfLettersReplacedInThisInstant++;
          if(numOfLettersReplacedInThisInstant==password.length()){
         
            for(int q = 0; q<password.length(); q++){
              encodedMessage = encodedMessage + randomLetter(5);
            }
            numOfLettersReplacedInThisInstant = 0;
          }
          
        }
     
      }
      //System.out.println(locationsOfSpaces.printArray()+" I");
      System.out.println((randomNumbers(password.length()) + locationsOfSpaces.printArray() + randomNumbers(password.length())).length());
      System.out.println((randomNumbers(password.length())).length());

      if(debugMode == false){
      return "\n ENCODED MESSAGE \""+Userinput+"\" INTO: \n"+ String.valueOf(encodedMessage + "-" + randomNumbers(password.length()) + locationsOfSpaces.printArray() + randomNumbers(password.length()) + "\n USING PASSWORD OF: "+password);
      }  else {
        return String.valueOf(encodedMessage + "-" + randomNumbers(password.length()) + locationsOfSpaces.printArray() + randomNumbers(password.length()));
      }
    }
    }
  
    
    
    //Generates a random letter followed by number between 0 and upperBound
    //example output: R4
    public String randomLetter(int upperBound){
      int value = (int) (Math.random()*25);
      int num = (int) ((Math.random()*upperBound)+1);
      return (alphabet[value] + num);  
    }
  
    //outputs a string of random numbers with length length
    //however it has a higher chance for each digit to be 0 than any other digit
    public String randomNumbers(int length){
      String finalString = "";
      for(int i = 0; i<length*length; i++){
        int initialValue = (int) (Math.round(Math.random()*1.5));
        int value;
        if(initialValue == 1){
          value = (int) (Math.random()*10);
        } else {
          value = 0;
        }
        
        finalString += value;
      }
      return finalString;
    }
    
  }
  