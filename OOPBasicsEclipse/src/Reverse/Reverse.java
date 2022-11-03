package Reverse;

/**
*
* @author vic
* date: 31/10/2022
* purpose: Reverse a numbered input - The Method
* 
*/
public class Reverse {
   
   //create a writable variable:
   private int number;

   //the method to set it (use it/get the setter):
   //call the private variable into the parameter
   public void setNumber(int number) {
       this.number = number;
   }
   
   //create a read-only variable
   public int getReverse() {
       //call the method:
      calculateReverse();
       return reverse;
   }
   private int reverse = 0;
   
   //the method:
   private void calculateReverse() {
      while(number>0) {
           int remainer = number % 10;
           reverse = reverse * 10;
           reverse = reverse + remainer;
           number = number / 10;
           
       } 
      
   }
   
}