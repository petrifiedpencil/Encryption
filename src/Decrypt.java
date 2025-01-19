public class Decrypt{
    public String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    Encrypt encrypt = new Encrypt();
  
      private String decryptLetters(String userInput, String password){
  
      String decodedMessage = "";
        
      System.out.println("\n DECODER ACTIVE");
      
      String[] decodedAlphabet = encrypt.convertLetters(password);
      
      
        
      String decodedAlphabetString = "";
      for(int i = 0; i<26; i++){
        decodedAlphabetString = decodedAlphabetString + " "+ decodedAlphabet[i];
      }
  
     String[] lettersOnly = convertFromStringToLetterArray(userInput);
        
     /*   String lettersOnlyfinahh = "";
        for(int i = 0; i< lettersOnly.length;i++){
          lettersOnlyfinahh = lettersOnlyfinahh + lettersOnly[i];
        }
        System.out.println(lettersOnlyfinahh); */
     
      
    for(int i = 0; i<((lettersOnly.length)); i++){
      
      int indexOfCurrentLetter = Functions.findIndex(decodedAlphabet, lettersOnly[i]);
      
      if(indexOfCurrentLetter==-1){
        decodedMessage = decodedMessage + "_";
       // System.out.println(decodedMessage);
      }
      else{
      decodedMessage = decodedMessage + alphabet[indexOfCurrentLetter];
       // System.out.println(decodedMessage);
      }
    }
    String lettersDecoded = removeFillerParts(decodedMessage, password);
    return lettersDecoded;
      }
  
  
  
    //Takes out the filler parts (check docs, takes out the fake in the real fake real fake real fake parts of letters)
  private String removeFillerParts(String input, String password){
   
    
    for(int i = 0; i<input.length(); i=i+(password.length())){
      
      String highEnd = "";
      String lowEnd = "";
      //System.out.println(i);
     // System.out.println(input.substring(i,i+password.length()));
  
      if(i+password.length()>input.length()-1){
        
      } else {
         lowEnd = input.substring(0,i+password.length());
        //System.out.println("LOW: "+lowEnd);
      }
     
      
      if((i+password.length()+password.length())>(input.length()-1)){
        
      } else {
      highEnd = input.substring((i+password.length()+password.length()),(input.length()));
        //System.out.println("HIGH: "+highEnd);
      }
  
   // System.out.println(lowEnd + " " + highEnd);
      //System.out.println(input.length());
      if(highEnd == "" || lowEnd == ""){
        
      } else {
    input = lowEnd + highEnd;
    //System.out.println(input);
      
   
   
      }
  
      
      
    }
    //System.out.println(input);
    return input;
  }
    
  private String[] convertFromStringToLetterArray(String userInput){
      int p = 0;
      
      
    
    int maximumSearchLength = userInput.indexOf("-");
    
    String[] letterArray = new String[maximumSearchLength/2];
    int letterArrayIndex = 0;
      while(p<userInput.length()-1){
     
       // System.out.println(Functions.findIndex(alphabet, userInput.substring(p,p+1)) + " " + p + " " + userInput.substring(p,p+1));
  
       
        if(p==maximumSearchLength){
         
          break;
        } else {
         letterArray[letterArrayIndex] = userInput.substring(p,p+2);
        }
        letterArrayIndex++;
        p+=2;
      }
  
    return letterArray;
      }
  
    
    
  private String returnSpaceLocationsOnly(String userInput, String password){
    int locationOfStartOfSpaces = userInput.indexOf("-")+1;
    String numbersOnly = userInput.substring(locationOfStartOfSpaces,(userInput.length()-1));
    
    int lowEndBound = (password.length()*password.length());
    //System.out.println(lowEndBound);
    int highEndBound = (numbersOnly.length()-lowEndBound);
    //System.out.println(highEndBound);
    String spaceLocations = numbersOnly.substring(lowEndBound,highEndBound);
    return spaceLocations;
  }
    
    public String decryptData(String userInput, String password, boolean debugMode){
      String decryptedLetters = decryptLetters(userInput, password);
      String spacesLocations = returnSpaceLocationsOnly(userInput, password);
      char[] finalDecryptedMessage = decryptedLetters.toCharArray();
      
      //System.out.println(spacesLocations);
      
      for(int i = 0; i<spacesLocations.length()-3;i+=3){
       int k = Integer.valueOf(spacesLocations.substring(i,i+3));
       if (k!=0){
        finalDecryptedMessage[k] = ' ';
       }
      }
      if(debugMode==true){
       return charToString(finalDecryptedMessage);
      } else {
        return "DCRYPTED INTO: "+ charToString(finalDecryptedMessage);
      }
    }
    private String charToString(char[] input){
      String endResult = "";
     for(int i = 0; i<input.length; i++){
      endResult += input[i];
     } 

    return endResult;
  }
    
  
    
  }