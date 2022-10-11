import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

class Knn_algo {

    public static int Take_input() {
        Scanner input = new Scanner(System.in);
        int value = input.nextInt();
        return value;                    // 
    }

    public static ArrayList<Integer> Generate_data() {
        ArrayList<Integer> data = new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < 25; i++) {
            int temp = random.nextInt(50);
            data.add(temp);
        }
        return (data);
    } // end of Generate_data

    public static String Allocate_movie_type(int data1, int data2) {
        String type = new String("Can't say");

        int dif = data1 - data2;
        boolean b = data1 > data2;

        if (b == true && Math.abs(dif) > 10) {
            type = "Romance";
        }

        if (b == false && Math.abs(dif) > 10) {
            type = "Action";
        }
        return type;
    } // type

    public static void Print_train_logic(ArrayList<Integer> no_kisses, ArrayList<Integer> no_punches,
            ArrayList<String> Movie_type) {

        System.out.println("# Kisses\t# Punches\tMovie Type");
        for (int i = 0; i < no_kisses.size(); i++) {
            System.out.println(no_kisses.get(i) + "\t\t" + no_punches.get(i) + "\t\t" + Movie_type.get(i));
        }
    } // print_logic

    public static void Print_distance_logic(ArrayList<Integer> no_kisses, ArrayList<Integer> no_punches,
            ArrayList<Double> Distances) {

        System.out.println("# Kisses\t# Punches\tMovie Type");
        for (int i = 0; i < no_kisses.size(); i++) {
            System.out.println(no_kisses.get(i) + "\t\t" + no_punches.get(i) + "\t\t" + Distances.get(i));
        }
    } // print_Distances_logic

    public static double find_distance(int x, int y, int a, int b) {
        double temp = Math.abs((x-a)*(x-a) + (y-b)*(y-b));
        double distance = Math.sqrt(temp);
        return distance;
        // Why double and not float ??????
    } // distance

    public static void Print_Result(int count_Romance, int count_Action, int count_cant) {

        if (count_Romance > count_Action && count_Romance > count_cant) {
            System.out.println("Movie type : Romance");
        }
        if (count_Action > count_Romance && count_Action > count_cant) {
            System.out.println("Movie type : Action");
        }
        if (count_cant > count_Action && count_cant > count_Romance) {
            System.out.println("Movie type : Cant't sat");
        } else {
            System.out.println("Movie type : Cant't say");
        }
    } // print results

    public static void Print_details(ArrayList<Integer> three_min_dis_index, ArrayList<Integer> no_kisses,
            ArrayList<Integer> no_punches, ArrayList<String> Movie_type) {
        System.out.println("# Kisses\t# Punches\tMovie Type");
        for (int i = 0; i < three_min_dis_index.size(); i++) {
            System.out.println(no_kisses.get(i) + "\t\t" + no_punches.get(i) + "\t\t" + Movie_type.get(i));
        }
    } // print_details

    public static void Print_options() {
        System.out.println("1. Taking input");
        System.out.println("2. Generate data");
        System.out.println("3. Show Training Data");
        System.out.println("4. For Distance");
        System.out.println("5. Show Result");
        System.out.println("6. For Reason");
    } // print_options


    public static void main(String[] args) {

        ArrayList<Integer> no_kisses = new ArrayList<>();
        ArrayList<Integer> no_punches = new ArrayList<>();
        ArrayList<Double> Distances = new ArrayList<>();
        ArrayList<Integer> three_min_dis_index = new ArrayList<>();
        ArrayList<String> Movie_type = new ArrayList<>();

        int no_kiss = 0;
        int no_punch = 0;
        int count_Romance = 0;
        int count_Action = 0;
        int count_cant = 0;

        int choice = 0;

        System.out.println("Enter Number of kisses: ");
        no_kiss = Take_input();
        // System.out.println(no_kiss);
        try{
            System.out.println("Enter Number of punches: ");
            no_punch = Take_input();
        }
        catch(java.util.NoSuchElementException e){
            no_punch = 15;
        }


        while (true) {
            Print_options();
            System.out.println("Enter your choice: ");
            choice = Take_input();
            System.out.println(choice);
            //Print_options();
// try{
            // taking input
            if (choice == 1) {
                System.out.print("Already taken");
                break;
            }

            if (choice == 2) {
                no_kisses = Generate_data();
                no_punches = Generate_data();

                for (int i = 0; i < 25; i++) {
                    Movie_type.add(Allocate_movie_type(no_kisses.get(i), no_punches.get(i)));
                }
                continue;
            }

            if (choice == 3) {
                Print_train_logic(no_kisses, no_punches, Movie_type);
                continue;
            }

            if (choice == 4) {
                // Finding distance
                for (int i = 0; i < no_kisses.size(); i++) {
                    Distances.add(find_distance(no_kisses.get(i), no_punches.get(i),no_kiss, no_punch));
                }
                Print_distance_logic(no_kisses, no_punches, Distances);
                continue;
            }

            if (choice == 5) {

                for (int i = 0; i < 3; i++) {
                    double min = Collections.min(Distances);
                    int index = Distances.indexOf(min);
                    three_min_dis_index.add(index);
                    Distances.set(index, 500000000.000000);
                    // Distances.remove(min);
                }

                // predicting class for test case
                for (int i = 0; i < 3; i++) {
                    int index = three_min_dis_index.get(i);
                    String M_type = Movie_type.get(index);

                    if (M_type == "Romance") {
                        count_Romance += 1;
                    } else if (M_type == "Action") {
                        count_Action += 1;
                    } else {
                        count_cant += 1;
                    }
                }

                Print_Result(count_Romance, count_Action, count_cant);
                continue;
            }

            if (choice == 6) {
                Print_details(three_min_dis_index, no_kisses, no_punches, Movie_type);
                continue;
            }

            if (choice == 7){
                break;
            }
        }

    } // end of main
}