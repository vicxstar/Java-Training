package Eggs;

/**
*
* @author vic
* date: 31/10/2022
* purpose: Eggs Exercise - class
* 
*/
public class Eggs {
	 
   //declare the variables:
   //writable (setter):
   private int eggs;

   //implement the setter (writable):
   public void setEggs(int eggs) {
       this.eggs = eggs;
   }
   
   //read-only (getter):
   private int gross = 0;
   private int dozen = 0;
   private int remain = 0;

   //implement the getters:
   public int getGross() {
       totalEggs();
       return gross;
   }

   public int getDozen() {
       totalEggs();
       return dozen;
   }

   public int getRemain() {
       totalEggs();
       return remain;
   }
   
   //decalre the getters and setters:
   
   //the method:
   public void totalEggs() {
       //enhanced 'while' loop:
       while(eggs>=12) {
           //enhanced 'if' statement:
           if(eggs>=144) {
               
               gross = gross + 1;
               eggs = eggs - 144;
           } else {
               
               dozen = dozen + 1;
               eggs = eggs - 12;
           }
       }
       remain = eggs; //whatever is left from 'eggs' goes into 'remain'
   }
}
