import java.util.Scanner;

class MarksCalculator {
    double[] marks;
    double totalMarks;
    double ave_P;

    public MarksCalculator(double[] marks)
    {
        this.marks = marks;
    }

    double cal_TotalMarks() {
        for (double mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }

    double calc_Ave_P() {
        int numberOfSubjects = marks.length;
        ave_P =totalMarks / (numberOfSubjects * 100) * 100;
        return ave_P;
    }
}

class GradeCalculator {
    public static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) 
        {
            return "O";
        } 
        else if (averagePercentage >= 80) 
        {
            return "E";
        } 
        else if (averagePercentage >= 70) 
        {
            return "A";
        } 
        else if (averagePercentage >= 60) 
        {
            return "B";
        } 
        else if (averagePercentage >= 50) 
        {
            return "C";
        } 
        else 
        {
            return "F";
        }
    }
}

public class grade_cslc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = scanner.nextInt();
        double[] marks = new double[numberOfSubjects];

        for (int i = 0; i <numberOfSubjects; i++) {
            System.out.print("Enter marks for subject " + (i+1) + " (out of 100): ");
            marks[i] = scanner.nextInt();
        }

        MarksCalculator m = new MarksCalculator(marks);
        double  totalMarks = m.cal_TotalMarks();
        double averagePercentage = m.calc_Ave_P();
        String grade = GradeCalculator.calculateGrade(averagePercentage);

        System.out.println("Total Obtain Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);
    }
}
