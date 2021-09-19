//Jamie Baggott R00149982


import java.util.Scanner;

public class Grades {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String names[] =new String[5];
        int grades[] = new int[5];
        String marks[] = new String[5];
        Scanner scan= new Scanner(System.in);



        for (int i =0;i<5;i++) {
            System.out.println("enter name: ");
            String s =scan.nextLine();
            names[i]= s;
        }

        for (int i =0;i<5;i++) {
            System.out.println("enter a mark:");
            int n = scan.nextInt();
            grades[i] = n;
      
            if (grades[i] <= 39)
                marks[i] = ("Fail");
            else if (grades[i] >= 40 && grades[i] <= 49)
                marks[i] = ("Pass");
            else if (grades[i] >= 50 && grades[i] <= 62)
                marks[i] = ("H2.2");
            else if (grades[i] >= 63 && grades[i] <= 69)
                marks[i] = ("H2.1");
            else if (grades[i] >= 70 && grades[i] <= 100)
                marks[i] = ("H1");
            else marks[i] = (" Invalid Mark");





        }
        for (int i =0;i<5;i++) {
                System.out.println(names[i] + " recieved a mark of " + marks[i] + " and the grade "+ grades[i]);


        }


    }

}