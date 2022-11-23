package Mini_Applications.TAXI;
import java.util.*;
public class Book {
    String taxiname;
    String drivername;
    String driverpass;
    String driverid;
    int earning;
    char position;
    String status;
    int positiondiff;
    Book(String taxiname, String drivername,String driverpass, String driverid){
        this.taxiname = taxiname;
        this.drivername=drivername;
        this.driverpass = driverpass;
        this.driverid=driverid;
        this.earning=0;
        this.position='a';
        this.status="available";
        this.positiondiff = 30;
        id++;
        name++;
    }
    static ArrayList <Book> taxidetails = new ArrayList<>();
    static int id = 101;
    static int name = 1;
    static{
        taxidetails.add(new Book("taxi_1", "Driver_1","d1",id+""));
        taxidetails.add(new Book("taxi_2", "Driver_2","d2",id+""));
        taxidetails.add(new Book("taxi_3", "Driver_3","d3",id+""));
        taxidetails.add(new Book("taxi_4", "Driver_4","d4",id+""));
    }

    private static Scanner sc = new Scanner(System.in);
    static void booking(String username){
        System.out.println("----welcome "+username+"----");
        while(true)  {
            System.out.println("""
          _ _ _ _ _ _ _ _ _ _ _
        |                      |
        |   1. Taxi booking    |
        |   2. Exit            |
        |_ _ _ _ _ _ _ _ _ _ _ |
                """);
        System.out.print("Enter your choice: ");
        int a = sc.nextInt();
        if(a==1){
            booktaxi();
        }
        else if(a==2){
            Taxi.taxi();
        }
        else{
            System.out.println("Enter correct value");
        }
    }
    }

    static void booktaxi(){
        int count = 0;
        for(Book i: taxidetails){
            if(i.status.equals("booked")){
                count++;
            }
        }
        if(count==taxidetails.size()){
            System.out.println("All taxis are booked. Try after some time");
            return;
        }
        System.out.print("Enter Boarding point: ");
        char a = sc.next().charAt(0);
        System.out.print("Enter Destination point: ");
        char b = sc.next().charAt(0);
        ArrayList <Book> ls=new ArrayList<>();
        for(Book i:taxidetails){
            if(i.status.equals("available")){
                char c = i.position;
                i.positiondiff = Math.abs(a-c); 
                ls.add(i);
            }
        }
        Collections.sort(ls,(d,e)->d.positiondiff-e.positiondiff);
        ArrayList <Book> earn=new ArrayList<>();
        int f = ls.get(0).positiondiff;
        for(Book i:ls){
            if(i.positiondiff==f){
                earn.add(i);
            }
        }
        Collections.sort(earn,(d,e)->d.earning-e.earning);
            earn.get(0).status = "booked";
            earn.get(0).position = b;
            earn.get(0).earning += (Math.abs((a-b))+f)*10;
        System.out.println(earn.get(0).taxiname+" is booked for you");
    }
}
