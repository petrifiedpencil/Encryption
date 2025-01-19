
//dynamic array code stolen from GfG and modified to suit my needs
public class DynamicStringArray {
  
    public String arr[];
  public int count;

  // Method to return length of array
  public DynamicStringArray(int size){
        arr = new String[size]; 
  }

  

  // Method to print array
  public String printArray(){
  String ArrayReturn = "";
    //System.out.println(ArrayReturn);
    
    return null;
  }

  // Method to insert element in array
  public void insert(String ele){

      if (arr.length == count) {

          // Creating a new array double the size
          // of array declared above
          String newArr[] = new String[2 * count];

          for (int i = 0; i < count; i++)
              newArr[i] = arr[i];

          // Assigning new array to original array
          arr = newArr;
      }

      arr[count++] = ele;
  }
}