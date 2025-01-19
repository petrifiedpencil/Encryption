
//check out all this stolen *ahem* BORROWED code

public class Functions {


  
  
    //Modified GfG code to work with Strings
   public static int findIndex(String[] a, String t)
    {
     

        int len = a.length;
        int i = 0;

        // traverse in the array
        while (i < len) {

            // if the i-th element is t
            // then return the index
            //i love .equals(), works when == doesn't
                //on a side note, WHY DOES JAVA MEMORY HAVE TO WORK LIKE THIS!!!!!!! 
                // WHY CANT AN ARRAY ELEMENT AND A SUBSTRING USE THE SAME HEAP MEMORY
                //i assume they have different addresses and thats why it didnt work, got it fixed tho so not looking too much into it
            if ((String.valueOf(a[i])).equals(String.valueOf(t))) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
      
        return -1;
    }

    //GfG code
   public static String removeDuplicates(String s) {
      
        // Create an integer array to store 
        // frequency for ASCII characters
        int[] ch = new int[256];
        StringBuilder ans = new StringBuilder();

        // Traverse the input string
        for (char c : s.toCharArray()) {

            // Check if current character's frequency is 0
            if (ch[c] == 0) {
                
                // Add char if frequency is 0
                ans.append(c);

                // Increment frequency
                ch[c]++;
            }
        }
        return ans.toString();
   }


    //GfG code
    public static int countOccurences(String[] arr, String t) {
        if (arr == null) {       // Check if the array is null
            return 0;       // Return 0 if array is null
        }
        int c = 0;     // Initialize count
        for (String num : arr) {
            if (num == t) {      // Check for matching elements
                c++;      // Increment count
            }
        }
        return c;
    }
    //overload that allows countOccurences to work with chars
    public static int countOccurences(char[] arr, char t) {
        if (arr == null) {       // Check if the array is null
            return 0;       // Return 0 if array is null
        }
        int c = 0;     // Initialize count
        for (char num : arr) {
            if (num == t) {      // Check for matching elements
                c++;      // Increment count
            }
        }
        return c;
    }
}

