import java.util.ArrayList;

/*
We will use the dataset below to learn a decision tree which predicts if people pass machine
learning (Yes or No), based on their previous GPA (High, Medium, or Low) and whether or
not they studied.

GPA|Studied|Passed
L    F      F
L    T      T
M    F      F
M    T      T
H    F      T
H    T      T
 */


 /*
  * Observations
  log b (x) = log(x) / log(b)
  */

public class Naive_bayse {

    public static void Calculate_Entropy(char[] A) {

        int l = A.length;
        // creating Array list of unique elements in array
        ArrayList<Character> Temp = new ArrayList<>();
        for(int i=0;i<l;i++){
            char ch = A[i];
            if(Temp.contains(ch)){
                continue;
                //break;
            }
            else{
                Temp.add(ch);
            }
        }

        System.out.println(Temp);  
    }

    public static void Log(){
        
    }
    public static void main(String[] args) {

        // Crating Dataset
        // ArrayList<String> CGP = new ArrayList<>();
        // ArrayList<String> Studied = new ArrayList<>();
        // ArrayList<String> Passed = new ArrayList<>();

        char[] CGP = new char[]{'L','L','M','M','H','M'};
        char[] Studied = new char[]{'F','T','F','T','F','T'};
        char[] Passed = new char[]{'F','T','F','T','T','T'};

        Calculate_Entropy(CGP);
        Calculate_Entropy(Studied);
        Calculate_Entropy(Passed);
        
    }
}
