import java.util.*;
public class Merchantpage{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> merchantname = new ArrayList<>();
    static ArrayList<Integer> merchantpin = new ArrayList<>();
    static ArrayList<String> status = new ArrayList<>();
    static int index = -1,app=0,index1=0;
    static void merchant(){
        System.out.println("\033[H\033[2J");
        System.out.println("1. New User.");
        System.out.println("2. Existing User");
        System.out.println("3. Back");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
        int az = sc.nextInt();
        switch(az){
            case 1:
            newmerchant();
            break;
            case 2:
            merchanthome();
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
            merchant();
            break;
        }
    }

    static void newmerchant(){
        System.out.println("\033[H\033[2J");
        System.out.print("Merchant Name: ");
        merchantname.add(sc.next());
        System.out.print("Merchant pin: ");
        merchantpin.add(sc.nextInt());
        status.add("pending");
        System.out.println("Waiting for approval.");
        System.out.println("Press enter to continue.");
        sc.nextLine();
        sc.nextLine();
        System.out.println("\033[H\033[2J");
        merchant();
    }

    static void merchanthome(){
        System.out.println("\033[H\033[2J");
        System.out.print("Merchant Name: ");
        String mername = sc.next();
        System.out.print("Merchant pin: ");
        int merpin = sc.nextInt();
        for(int i=0;i<merchantname.size();i++){
            if(merchantname.get(i).equals(mername)){
                index = i;
            }
        }

        if(merchantname.get(index).equals(mername) && merchantpin.get(index).equals(merpin)){
                if(status.get(index).equals("approved")){
                    System.out.println("Merchant login Successfull");
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    System.out.println("\033[H\033[2J");
                    Product.merchantpro();
                }
                else{
                    System.out.println("Your status :-"+status.get(index));
                    System.out.println("Press enter to continue");
                    sc.nextLine();
                    sc.nextLine();
                    merchant();
                }
                
        }
        else{
            System.out.println("Invalid merchant name/password");
        System.out.println("Press enter to continue");
        sc.nextLine();
        System.out.println("\033[H\033[2J");
        merchant();
        }
    }

    static void approvemerchants(){
        for(int i=0;i<status.size();i++){
            if(status.get(i).equals("pending")){
                System.out.println("\033[H\033[2J");
                System.out.println("approvals needed:"+merchantname.get(i));
                System.out.println("1. Approve.");
                System.out.println("2. Disapprove.");
                int approval = sc.nextInt();
                switch(approval){
                    case 1:
                    status.set(i,"approved");
                    break;
                    case 2:
                    status.set(i,"disapproved");
                    break;
                }
            }
    }
    for(int i=0;i<status.size();i++){
        if(status.get(i).equals("pending...")){
    app++;
    }
}
    if(app==0){
        System.out.println("\033[H\033[2J");
        System.out.println("No approvals");
    }
    System.out.println("Press enter to continue");
    sc.nextLine();
    System.out.println("\033[H\033[2J");
    Admin.admin();
    }

    static void add_remove(){
        System.out.println("\033[H\033[2J");
        System.out.println("1. Add Merchant");
        System.out.println("2. Remove Merchant");
        System.out.println("3. Back");
        System.out.println("4. Exit");
        System.out.print("Enter your Choice: ");
        int ax = sc.nextInt();
        switch(ax){
            case 1:
            addmerchant();
            break;

            case 2:
            removemerchant();
            break;

            case 3:
            System.out.println("\033[H\033[2J");
            Admin.admin();
            break;

            case 4:
            Amazon1.exit();
            default:
            System.out.println("Invalid Input");
            System.out.println("Press enter to continue");
            sc.nextLine();
            sc.nextLine();
            System.out.println("\033[H\033[2J");
            add_remove();
            break;
        }
    }
    
    static void addmerchant(){
        System.out.println("\033[H\033[2J");
        System.out.print("Merchant Name: ");
        merchantname.add(sc.next());
        System.out.print("Merchant pin: ");
        merchantpin.add(sc.nextInt());
        status.add("approved");
        System.out.println("Merchant added successfully.");
        System.out.println("Press enter to continue.");
        sc.nextLine();
        sc.nextLine();
        System.out.println("\033[H\033[2J");
        Admin.admin();
    }
    
    static void removemerchant(){
        System.out.println("\033[H\033[2J");
        System.out.print("Merchant Name: ");
        String remover = sc.next();
        for(int i=0;i<merchantname.size();i++){
            if(merchantname.get(i).equals(remover)){
                index1 = i;
            }
        }
        status.set(index1,"Suspended");
        System.out.println("Merchant removed successfully.");
        System.out.println("Press enter to continue.");
        sc.nextLine();
        sc.nextLine();
        System.out.println("\033[H\033[2J");
        Admin.admin();
    }
}