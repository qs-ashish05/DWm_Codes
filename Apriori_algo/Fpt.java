import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Fpt {

    // Function to remove duplicates from an ArrayList
    public static <T> ArrayList<T> removeDuplicates(ArrayList<T> list)
    {
  
        // Create a new ArrayList
        ArrayList<T> newList = new ArrayList<T>();
  
        // Traverse through the first list
        for (T element : list) {
  
            // If this element is not present in newList
            // then add it
            if (!newList.contains(element)) {
  
                newList.add(element);
            }
        }
  
        // return the new list
        return newList;
    }
 
    public static   ArrayList<Character> Generate_data(int a){
        // .Contains
        ArrayList<Character> temp = new ArrayList<>();
        Random random = new Random();
        String alphabet = "ABCDE";
        
         for(int i=0;i<a;i++){
             int l = alphabet.length();
             int index = random.nextInt(l);
             while(index == 0)
                 index = random.nextInt(l);
             System.out.println(index);
             char c = alphabet.charAt(index);
         temp.add(c);
         }
        temp = removeDuplicates(temp);
        return(temp);
    } 

    public static void Print_data(ArrayList<Integer> Tran_id,ArrayList<ArrayList<Character>> Items){
        System.out.println("Transaction-id\t\tItemset");
        int l_id = Tran_id.size();
        for(int i=0;i<l_id;i++){
            ArrayList<Character> temp = new ArrayList<>();
            temp = Items.get(i);
            int l_item = temp.size();
            for(int j=0;j<l_item;j++){
                System.out.println(Tran_id.get(i)+"\t\t"+temp.get(j));
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        Random random = new Random();
        
       System.out.print("Enter number of transactions : ");
       int no_tran = Input.nextInt(); 

        ArrayList<Integer> Tran_id = new ArrayList<>();
        ArrayList<ArrayList<Character>> Items = new ArrayList<>();

    
        for(int i=0;i<no_tran;i++){
           Tran_id.add(i);
           int n = random.nextInt(5);
           while(n==0)
                n = random.nextInt(5);
           Items.add(Generate_data(n));
        }
        // System.out.println(Tran_id);
        // System.out.println(Items);
        Print_data(Tran_id,Items);


    }
}
