
import java.util.*;

public class Admin{
    static Scanner sc = new Scanner(System.in);

    static void adminlogin(){
                System.out.println("\033[H\033[2J");
                System.out.print("Enter Admin Name: ");
                String adminname = sc.next();
                System.out.print("Enter Admin Pin: ");
                int adminpin = sc.nextInt();

                if(adminname.equals("admin")&& adminpin==1234){
                    System.out.println("\033[H\033[2J");
                    admin();
                }
                else{
                    System.out.println("Invalid Input");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    Amazon1.home();
                }
            }

    static void admin(){
        System.out.println("1. Approve Merchants");
        System.out.println("2. Add/Remove Merchants");
        System.out.println("3. Back");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int c = sc.nextInt();
        switch(c){
            case 1:
            Merchantpage.approvemerchants();
            break;

            case 2:
            Merchantpage.add_remove();
            break;

            case 3:
            System.out.println("\033[H\033[2J");
            Amazon1.home();
            break;

            case 4:
            Amazon1.exit();
            break;
            
            default:
            System.out.println("Invalid Input");
            System.out.println("Press enter to continue");
            sc.nextLine();
            sc.nextLine();
            System.out.println("\033[H\033[2J");
            admin();
            break;
        }
    }

}