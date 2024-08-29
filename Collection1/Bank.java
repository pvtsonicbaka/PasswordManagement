import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;


/**
 * Bank
 */
public class Bank {
    Hashtable<Integer,INFO> customers =  new Hashtable<>();
    
    public static void main(String[] args) {
        Bank b = new Bank();
        System.out.println("<<<<<- Welcome to bank system ->>>>>");;

        int n =-1;
        Scanner sc = new Scanner(System.in);
        while (n!=99) {
            System.out.println("Enter 1 to add acc \n2 to deposit \n3 to withdraw \n4 to view passbook \n99 to exit");
            n=sc.nextInt();
            switch (n) {
                case 1:
                
                    b.addAccount();
                    break;
                case 2:
                    b.deposit();
                    break;
                case 3:
                    b.withdraw();
                    break;
                case 4:
                    b.viewPass();
                    break;
                case 5:
                    System.out.println(b.customers);
                    break;
                case 99:
                    System.out.println("nigga"); 
                    break;
                default:
                System.out.println("huh");
                    break;
            }
        }
    }
    public static int id =1;
    void addAccount(){
        Scanner sc = new Scanner(System.in);
        System.out.println("enter name ");
        String name = sc.nextLine();
        System.out.println("total balance -20000 \nid - "+id);
        INFO customer = new INFO(id, name, 20000);
        customers.put(id, customer);
        id++;
    }
    void deposit(){
        System.out.println("Enter account id");
        Scanner sc = new Scanner(System.in);
        int acc_id = sc.nextInt();
        if(customers.containsKey(acc_id)){
            INFO cus = customers.get(acc_id);
            System.out.println("Enter amount to deposit-");
            double amt = sc.nextDouble();
            cus.addBalance(amt);
            cus.setBalance(cus.balance+amt);
            customers.put(acc_id, cus);
            System.out.println("new balance "+cus.getBalance());
        }
        else{
            System.out.println("customer not found");
        }

    }
    void withdraw(){
        System.out.println("Enter account id");
        Scanner sc = new Scanner(System.in);
        int acc_id = sc.nextInt();
        if(customers.containsKey(acc_id)){
            INFO cus = customers.get(acc_id);
            System.out.println("Enter amount to withdraw -");
            double amt = sc.nextDouble();
            if(cus.getBalance() < amt){
                System.out.println("not enough balance ");
                return;
            }
            cus.deductBalance(amt);
            cus.setBalance(cus.balance-amt);
            customers.put(acc_id, cus);
            System.out.println("new balance "+cus.getBalance());

        }
        else{
            System.out.println("customer not found");
        }
    }
    void viewPass(){
        System.out.println("Enter account id");
        Scanner sc = new Scanner(System.in);
        int acc_id = sc.nextInt();
        if(customers.containsKey(acc_id)){
            INFO cus = customers.get(acc_id);
            File f = new File(acc_id+".txt");
            try {
                FileReader fw = new FileReader(f) ;
                BufferedReader bf = new BufferedReader(fw);
                String line = bf.readLine();
                while (line!=null) {
                    System.out.println(line);
                    line =bf.readLine();
                }
                bf.close();
                fw.close();


            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        else{
            System.out.println("customer not found");
        }
    }

    
}
class INFO{
    String name;
    int accountNumber;
    static int num = 1;

    double balance;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
    
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    @Override
    public String toString() {
        return "INFO [name=" + name + ", accountNumber=" + accountNumber + ", balance=" + balance + "]\n";
    }
    public INFO(int accountNumber,String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.accountNumber = accountNumber; 
    }
    void addBalance(double amt){
        File f = new File(accountNumber+".txt");
        FileWriter fw;
        try {
            fw = new FileWriter(f,true);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write(transaction_no++ +" ->deposited-> " + this.balance +" -> " +(balance+amt)+"\n");
            bf.close();
            fw.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
    static int transaction_no =1;
    void deductBalance(double amt){
        File f = new File(accountNumber+".txt");
        FileWriter fw;
        try {
            fw = new FileWriter(f,true);
            BufferedWriter bf = new BufferedWriter(fw);
            bf.write(transaction_no++ +" ->deducted-> " + this.balance +" -> " +(balance-amt)+"\n");
            bf.close();
            fw.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
        
}