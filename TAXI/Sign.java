package Mini_Applications.TAXI;
import java.util.*;

public class Sign {
    private static Scanner sc = new Scanner(System.in);
    static ArrayList<Sign> cusdetails=new ArrayList<>();
    String cusname;
    String cuspass;
    int cusid;
    static int id=1;
    Sign(String cusname, String cuspass, int id){
        this.cusname = cusname;
        this.cuspass = cuspass;
        cusid = id;
    }
    static {
        cusdetails.add(new Sign("user1", "111",id++));
        cusdetails.add(new Sign("user2", "222",id++));
        cusdetails.add(new Sign("user3", "333",id++));
        cusdetails.add(new Sign("user4", "444",id++));
    }

    static void signup(){
        System.out.println("Sign up");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        for(int i=0;i<cusdetails.size();i++){
            if(cusdetails.get(i).cusname.equals(name)){
                System.out.println("name already exists");
                signup();
            }
        }
        System.out.print("Enter your password: ");
        String pass = sc.nextLine();
        cusdetails.add(new Sign(name,pass,id++));
        System.out.println("User signup successfull...");
        signin();
    }
    
    static void signin(){
        System.out.println("Sign in");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        int ind = -1;
        for(int i=0;i<cusdetails.size();i++){
            if(cusdetails.get(i).cusname.equals(name)){
                ind = i;
            }
        }
        if(ind == -1){
            System.out.println("Name not exists");
            Taxi.taxi();
        }
        System.out.print("Enter your password: ");
        String pass = sc.nextLine();
        if(cusdetails.get(ind).cuspass.equals(pass)){
            System.out.println("user sign-in successfull");
           Book.booking(cusdetails.get(ind).cusname);
        }
        else{
            System.out.println("Incorrect password");
            return;
        }
    }
static int index = -1;
    static void driver() {
        System.out.print("Enter driver id: ");
        String a = sc.nextLine();
        System.out.print("Enter driver pass: ");
        String b = sc.nextLine();
        for(int i=0;i<Book.taxidetails.size();i++){
            if(Book.taxidetails.get(i).driverid.equals(a) && Book.taxidetails.get(i).driverpass.equals(b)){
                System.out.println("Driver login successfull");
                index = i;
                drivermenu();
            }
        }
        if(index == -1){
            System.out.println("Enter valid details");
        }

    }

    static void drivermenu() {
        
        while(true){
        System.out.println("""
                1. Update Status
                2. View Earnings
                3. Exit
                """);
                System.out.print("Enter your choice: ");
                int a = sc.nextInt();sc.nextLine();
                if(a==1){
                    updatestatus();
                }
                else if(a==2){
                    viewearnings();
                }
                else if(a==3){
                    Taxi.taxi();
                }
                else{
                    System.out.println("Invalid Input");
                }
            }
    }

    static void viewearnings() {
        System.out.println("Your earnings: "+Book.taxidetails.get(index).earning);
    }

    static void updatestatus() {
        System.out.println("""
                1. Update
                2. Exit
                """);
                System.out.print("Enter your choice: ");
                int a = sc.nextInt();
                if(a==1){
                    update();
                }
                else if(a==2){
                  drivermenu();  
                }
                else{
                    System.out.println("Enter correct option");
                    updatestatus();
                }
    }

    private static void update() {
       System.out.println("""
               1. Reached
               2. Not reached
               """);
               System.out.print("Enter your choice: ");
               int a = sc.nextInt();sc.nextLine();
               if(a==1){
            System.out.println("Updated...");
            Book.taxidetails.get(index).status = "available";
            Book.taxidetails.get(index).positiondiff = 30;
        }
        else if(a==2){
            drivermenu();
        }
        else{
            System.out.println("Enter valid status");
            update();
        }
    }

    static void driversign(){
            System.out.print("Enter your name: ");
            String s = sc.nextLine();
            Admin.driver.add(s);
            System.out.println("Waiting for approval...");
            sc.nextLine();
            Taxi.taxi();
    }
}
