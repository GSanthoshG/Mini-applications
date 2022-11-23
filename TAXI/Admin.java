package Mini_Applications.TAXI;
import java.util.*;
public class Admin {
    private static Scanner sc = new Scanner(System.in);
    static ArrayList <String> driver = new ArrayList<>();

    static void admin(){
        System.out.print("Enter Admin name: ");
        String c = sc.nextLine();
        System.out.print("Enter Admin pass: ");
        int b = sc.nextInt();
        if(!c.equals("admin") || b != 1234){
            System.out.println("Incorrect name/password");
            Taxi.taxi();
        }
        else{
            login();
        }
    }
    
    static void login(){
            System.out.print("""
                    1. Approve Taxis
                    2. View Taxi details
                    3. Exit

                    Enter your choice: 
                    """);
                    int a = sc.nextInt();sc.nextLine();
                    if(a==1){
                        approve();
                    }
                    else if(a==2){
                        viewtaxi();
                    }
                    else if(a==3){
                        Taxi.taxi();
                    }
    }

    static void viewtaxi() {
        System.out.printf("%-8s %-16s %-24s %-24s %-24s %-24s %-24s", "S.NO", "Taxi_Name", "Driver_name", "Driver_ID", "Position", "Status", "Earnings\n");
        System.out.println();
        for(int i=0;i<Book.taxidetails.size();i++){
            System.out.format("%-8s %-16s %-24s %-24s %-24s %-24s %-24s", (i+1), Book.taxidetails.get(i).taxiname, Book.taxidetails.get(i).drivername, Book.taxidetails.get(i).driverid, Book.taxidetails.get(i).position, Book.taxidetails.get(i).status, Book.taxidetails.get(i).earning);
            System.out.println();
        }
        sc.nextLine();
    }

    static void approve(){
        if(driver.size()==0){
            System.out.println("No approval requests");
        }
        else{
            for(int i=0;i<driver.size();i++){
                System.out.print(driver.get(i)+" waiting for approval");
                System.out.print("""
                        1.approve
                        2.disapprove

                        Enter your choice: 
                        """);
                        int a = sc.nextInt();
                        if(a==1){
                            Book.taxidetails.add(new Book("taxi_"+Book.name, "Driver_"+Book.name, "d"+Book.name, Book.id+""));
                            System.out.println("Taxi details --> "+Book.taxidetails.get(Book.taxidetails.size()-1));
                            driver.remove(i);
                            System.out.println("Driver approved");
                        }
                        else if(a==2){
                            driver.remove(i);
                        }
            }
            System.out.println("All approvals requests are done");
        }
        sc.nextLine();
        login();
    }
}
