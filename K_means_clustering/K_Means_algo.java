import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class K_Means_algo {

    public static void Print_options() {
        System.out.println("1. To view data");
        System.out.println("2. For clustres");
        System.out.println("2. For end");
    } // Print_options

    public static ArrayList<Integer> Generate_Data() {
        ArrayList<Integer> data = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            int a = rand.nextInt(50);
            data.add(a);
        }
        return (data);
    } // generate data

    public static double find_distance(int x1, int y1, int x2, int y2) {
        double temp = Math.abs((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        double distance = Math.sqrt(temp);
        return distance;
        // Why double and not float ??????
    } // distance

    public static ArrayList<ArrayList<Double>> Distance_mtx(ArrayList<Integer> x_data, ArrayList<Integer> y_data,
            int k) {

        // choosed points are available in list choosed_points
        ArrayList<Integer> choosed_points = new ArrayList<>(); // store indexes
        ArrayList<Double> temp_distance = new ArrayList<>(); // stpre the distance
        ArrayList<ArrayList<Double>> distances_list = new ArrayList<>(); // Stores distance of each points form other
                                                                         // points

        for (int i = 0; i < k; i++) { ///
            choosed_points.add(i);
            System.out.println(i + ". is X = " + x_data.get(i) + " And y = " + y_data.get(i));
        }

        // calculating distance
        for (int j = 0; j < choosed_points.size(); j++) {
            int x2 = x_data.get(choosed_points.get(j));
            int y2 = y_data.get(choosed_points.get(j));
            for (int i = 0; i < x_data.size(); i++) {
                int x1 = x_data.get(i);
                int y1 = y_data.get(i);

                double d = find_distance(x1, y1, x2, y2);
                System.out.println("the distance is " + d);
                temp_distance.add(d);

            }
            distances_list.add(temp_distance);
            System.out.println("The distance list for one point is " + distances_list);
        }
        // System.out.println("Works");
        return (distances_list);
    }

    public static void Print_gen_Data(ArrayList<Integer> x_data, ArrayList<Integer> y_data) {
        System.out.println("X-Data\t\tY-Data");

        for (int i = 0; i < x_data.size(); i++) {
            System.out.println(x_data.get(i) + "\t\t" + y_data.get(i));
        }
    } // Print_gen_Data

    public static void Print_gen_Cluster(ArrayList<Integer> x_data, ArrayList<Integer> y_data,ArrayList<String> Cluster) {
        System.out.println("X-Data\t\tY-Data\t\tCluster");

        for (int i = 0; i < x_data.size(); i++) {
            System.out.println(x_data.get(i) + "\t\t" + y_data.get(i)+"\t\t"+Cluster.get(i));
        }
    } // Print_gen_cluster

    public static void main(String[] args) {

        // Creating class objects
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Enter the value of k ");
        int k = input.nextInt();

        // List initiaalizations
        ArrayList<Integer> x_data = new ArrayList<>();
        ArrayList<Integer> y_data = new ArrayList<>();
        ArrayList<String> Clusters = new ArrayList<>();
        ArrayList<Double> distance = new ArrayList<>();
        ArrayList<Double> temp = new ArrayList<>();
        ArrayList<ArrayList<Double>> distances_list = new ArrayList<>();
        ArrayList<ArrayList<Double>> sorted_distances_list = new ArrayList<>();
        double mean, std;

        int choice = 0;
        while (true) {
            Print_options();
            choice = input.nextInt();

            if (choice == 1) {
                // System.out.println("Generate data");
                x_data = Generate_Data();
                y_data = Generate_Data();
                Print_gen_Data(x_data, y_data);
            }

            if (choice == 2) {
                distances_list = Distance_mtx(x_data, y_data, k);
                // int i = 0;
                ArrayList<Double> L1 = new ArrayList<>();
                ArrayList<Double> L2 = new ArrayList<>();
                L1 = distances_list.get(0);
                L2 = distances_list.get(1);
                for (int i = 0; i < x_data.size(); i++) {
                    if (L1.get(i) > L2.get(i)) {
                        Clusters.add("Cluster-1");
                    } else {
                        Clusters.add("Cluster-1");
                    }
                }
                Print_gen_Cluster(x_data,y_data,Clusters);

                
            }

            if (choice == 3) {
                System.out.println("break");
                break;
            }
        }

    }
}
