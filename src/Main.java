import java.util.Scanner;

/**
 @author  Gaurav Bhatt
 @since 2023
 @version 1.0
 @deprecated  none


 */

public class Main {

    static void options(){
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("\n\tHospital Management System");
            System.out.println("1.Admit Patient");
            System.out.println("2.Discharge Patient");
            System.out.println("3.Patient Records");
            System.out.println("4. Update Doctor's Records");
            System.out.println("5. Show Doctor's Records");
            System.out.println("6.Exit");
            System.out.println("----------------------------------------------------------------------------------------");

    }

    public static void main(String[] args) {
           int choice;
        Scanner input=new Scanner(System.in);
        Management mod1=new Management();
            while (true){

                    options();
                    System.out.println("Enter choice");
                    choice=input.nextInt();
                System.out.println("------------------------------------------------------------------------------------");

                    if(choice==1){
                        mod1.addPatient();
                    }
                    else if (choice==2) {
                         mod1.DischargePatient();
                    }

                    else if (choice==3) {
                             mod1.showPatients();
                    }

                    else if (choice==4) {
                         mod1.updateDoctor();
                    }

                    else if (choice==5) {

                        mod1.showDoctors();

                    }

                    else if (choice==6) {
                         System.out.println("Exiting program");
                         break;
                    }

                    else {
                        System.out.println("Invalid choice .....try again later");

                    }


            }

    }
}