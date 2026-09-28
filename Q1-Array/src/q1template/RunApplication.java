package q1template;

import java.util.Scanner;



public class RunApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Single-dimensional array of row labels
        String[] labels = {"Cape Town", "Port Elizabeth", "Pretoria"};   

        // Column headings (used only for printing) 
        String[] columns = {"PS5", "Xbox", "SWITCH"};                            

        // Two-dimensional array: row and column
        double[][] values = new double[labels.length][columns.length];

        //
        for (int i = 0; i < labels.length; i++) {
            for (int j = 0; j < columns.length; j++) {
                System.out.print("Enter the number of " + columns[j] + " for " + labels[i] + ": ");
                values[i][j] = sc.nextDouble();
            }
        }

        
        double THRESHOLD = 15;   

        // Print the raw report 
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("GAMING CONSOLE REPORT");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("%-15s", "");
        for (String col : columns) System.out.printf("%-15s", col);
        System.out.println();

        for (int i = 0; i < labels.length; i++) {
            System.out.printf("%-15s", labels[i]);
            for (int j = 0; j < columns.length; j++) {
                System.out.printf("%-15.0f", values[i][j]);
            }
            System.out.println();
        }

        //  Totals per row 
        System.out.println("\n--------------------------------------------------------------");
        System.out.println("CONSOLE SALES TOTALS FOR EACH CITY");
        System.out.println("--------------------------------------------------------------");

        double greatestTotal = -1;
        String labelWithGreatest = "";

        for (int i = 0; i < labels.length; i++) {
            double rowTotal = 0;
            for (int j = 0; j < columns.length; j++) {
                rowTotal += values[i][j];
            }

            String flag = (rowTotal >= THRESHOLD) ? "  ***" : "";
            System.out.printf("%-15s %-10.0f%s%n", labels[i], rowTotal, flag);

            if (rowTotal > greatestTotal) {
                greatestTotal = rowTotal;
                labelWithGreatest = labels[i];
            }
        }

        System.out.println("--------------------------------------------------------------");
        System.out.println("CITY WITH THE MOST SALES: " + labelWithGreatest);
        System.out.println("--------------------------------------------------------------");

        sc.close();
    }
}
