
//dynamic array code stolen from GfG and modified to suit my needs
public class DynamicArray {
  
    public int arr[];
  private int count;

  // Method to return length of array
  public DynamicArray(int size){
        arr = new int[size]; 
  }

  

  // Method to print array
  public String printArray(){
  String ArrayReturn = "";
    
    
      for (int i = 0; i < arr.length; i++) {
       
        if(arr[i]<10){
        //  System.out.println("<10; SPACE AT:"+arr[i]);
        ArrayReturn = ArrayReturn + "00" + (arr[i]);
        } else if(arr[i]<100){
        //  System.out.println("<100; SPACE AT:"+arr[i]);
        ArrayReturn = ArrayReturn + "0" +(arr[i]);
        } else if(arr[i]>99){
        //  System.out.println("<1000; SPACE AT:"+arr[i]);
        ArrayReturn = ArrayReturn + (arr[i]);
      }     
      }
    //System.out.println(ArrayReturn);
    return ArrayReturn;
  }

  // Method to insert element in array
  public void insert(int ele){

      if (arr.length == count) {

          // Creating a new array double the size
          // of array declared above
          int newArr[] = new int[2 * count];

          for (int i = 0; i < count; i++)
              newArr[i] = arr[i];

          // Assigning new array to original array
          arr = newArr;
      }

      arr[count++] = ele;
  }
}