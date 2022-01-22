import java.util.*;
public class Amazon1 {
    static Scanner sc = new Scanner(System.in);

    static void home(){
        System.out.println("1. Admin Login");
        System.out.println("2. Merchant Login");
        System.out.println("3. User Login");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");

        int a = sc.nextInt();
            switch(a){
                case 1:
                Admin.adminlogin();
                break;

                case 2:
                Merchantpage.merchant();
                break;

                case 3:
                //userlogin();
                break;

                case 4:
                exit();
                break;

                default:
                System.out.println("Invalid Input");
                System.out.println("Press enter to continue");
                sc.nextLine();
                sc.nextLine();
                System.out.println("\033[H\033[2J");
                home();
                break;
            }
        }

        static void exit(){
            System.out.println("\033[H\033[2J");
            System.out.println("Are you sure to exit?");
                System.out.print("Enter yes/no: ");
                String yes = sc.next();
                if(yes.equals("yes")){
                    System.exit(0);
                }
                else{
                 home();
                }
        }
        public static void main(String ar[]){
            home();
        }
}
