package Mini_Applications.TAXI;
import java.util.*;
public class Taxi {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String ar[]){
        taxi();
    }
    
    static void taxi() {
        System.out.println("Welcome to taxi app");
      while(true)  {
            System.out.println("""
                1.Admin Login
                2.User Sign up
                3.User Sign in
                4.Driver Sign up
                5.Driver Sign in
                6.Exit
                """);
        System.out.print("Enter your choice: ");
        int a = sc.nextInt();
        if(a==1){
            Admin.admin();
        }
        else if(a==2){
            Sign.signup();
        }
        else if(a==3){
            Sign.signin();
        }
        else if(a==4){
            Sign.driversign();
        }
        else if(a==5){
            Sign.driver();
        }
        else if(a==6){
            System.exit(0);
        }
        else{
            System.out.println("Enter correct value");
        }
    }
    }
}
