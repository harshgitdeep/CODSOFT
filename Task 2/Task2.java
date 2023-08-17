import java.util.*;

public class Task2 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println();
        System.out.println("-------TASK 2---------");
        System.out.println("**GRADE CALCULATOR**");
        System.out.println();
        System.out.print("Enter the number of subjects = ");
        int n = scan.nextInt();

        System.out.print("Enter Maximum Marks for the subjects = ");
        int max = scan.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter marks of subject [" + (i + 1) + "] = ");
            arr[i] = scan.nextInt();
        }

        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        float avg = ((float) sum / (n * max)) * 100;

        System.out.println();
        System.out.println();
        System.out.println("-------------------STUDENT GRADE CARD--------------------");
        System.out.println();
        System.out.println("Total Marks obtained = " + sum + "/"+n*max);
        System.out.println("Average of marks = " + avg);

        char grade;
        if (avg >= 90) {
            grade = 'A';
        } else if (avg >= 80) {
            grade = 'B';
        } else if (avg >= 70) {
            grade = 'C';
        } else if (avg >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

       System.out.println("Grade = " + grade);
       System.out.println();
       System.out.println();

        scan.close();
    }
}
