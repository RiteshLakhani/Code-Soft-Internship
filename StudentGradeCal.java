import java.util.Scanner;

public class StudentGradeCal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get the number of students
        System.out.println("Enter Number Of Students: ");
        int num = sc.nextInt();
        sc.nextLine();

        // Get the number of subjects
        System.out.println("Enter Number of Subjects: ");
        int sub = sc.nextInt();
        sc.nextLine();

        String[] stuName = new String[num];
        int[][] marks = new int[num][sub];
        int[] total = new int[num];
        float[] avg = new float[num];
        boolean[] failed = new boolean[num]; // Track if any student failed
        String[] grades = new String[num];   // Store grades for each student

        // Input student details
        for (int i = 0; i < num; i++) {
            System.out.println("Enter Name Of Student " + (i + 1) + " : ");
            stuName[i] = sc.nextLine();

            int sum = 0;
            boolean studentFailed = false;

            // Input marks for each subject
            for (int j = 0; j < sub; j++) 
            {
                while (true) 
                {
                    System.out.println("Enter Marks of Subject-" + (j + 1) + ":");
                    if (sc.hasNextInt()) 
                    {
                        int mark = sc.nextInt();
                        sc.nextLine(); // Consume the newline character

                        if (mark < 0) 
                        {
                            System.out.println("Invalid input. Marks cannot be negative. Please enter again:");
                        } 
                        else if (mark > 100) 
                        {
                            System.out.println("Invalid input. Marks cannot be greater than 100. Please enter again:");
                        } 
                        else
                        {
                            marks[i][j] = mark;
                            if (mark < 35) 
                            {
                                studentFailed = true; // Student failed if any mark is below 35
                            }

                            sum = sum + mark;
                            break;
                        }
                    } 
                    else 
                    {
                        System.out.println("Invalid input. Please enter an integer.");
                        sc.next();
                    }
                }
            }

            total[i] = sum;
            avg[i] = (float) sum / sub;
            failed[i] = studentFailed; // Track if the student failed

            if (failed[i]) 
            {
                grades[i] = "Failed";
            } 
            else 
            {
                grades[i] = getGrade(avg[i]);
            }
        }

       // Output results
       System.out.printf("%-20s", "Name");
       for (int j = 1; j <= sub; j++) {
           System.out.printf("%10s", "Subject-" + j);
       }
       System.out.printf("%10s %10s %10s%n", "TotalMarks", "AvgPer", "Grade");

       for (int i = 0; i < num; i++) {
           System.out.printf("%-20s", stuName[i]);
           for (int j = 0; j < sub; j++) {
               System.out.printf("%10d", marks[i][j]);
           }
           System.out.printf("%10d", total[i]);
           if (failed[i]) {
               System.out.printf("%10s", "N/A"); // Show N/A for average if failed
           } else {
               System.out.printf("%10.2f", avg[i]);
           }
           System.out.printf("%10s%n", grades[i]);
       }


    }


    public static String getGrade(float avg) {
        if (avg >= 90) {
            return "A+";
        } else if (avg >= 81) {
            return "A";
        } else if (avg >= 71) {
            return "B+";
        } else if (avg >= 61) {
            return "B";
        } else if (avg >= 51) {
            return "C+";
        } else if (avg >= 41) {
            return "C";
        } else if (avg >= 35) {
            return "D";
        } else {
            return "Failed";
        }
    }
}