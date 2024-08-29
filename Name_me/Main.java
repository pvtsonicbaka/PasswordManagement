import java.io.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        PrintStream p = new PrintStream(System.out);
        p.println("niger");
        try {
            throw new invalidBank("hiii");
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
        
    }
}

class invalidBank extends IOException{
    invalidBank(String s){
        super(s);
        }

}
 class BankAccount {
    
    double bank ;
    BankAccount(double bank){
        this.bank = bank ;
    }
    void DepositAccount(double amount){
        bank+= amount;
    }
    void WithdrawAccount(double amount){
        if(bank<amount){
        this.bank -= amount;

        }

        else{
            System.out.println("yeh garib");
        }

    }
    void display(){
        System.out.println("balance b "+bank);
    }


}
class DepositThread extends Thread{
    BankAccount balance;
    double amount ; 
    DepositThread(BankAccount b , double amount){
    balance = b ;
    this.amount = amount;
    }
    public void run(){
        balance.DepositAccount(amount);
    }
}
class WithdrawThread extends Thread{
    BankAccount balance;
    double amount ; 
    WithdrawThread(BankAccount b , double amount){
    balance = b ;
    this.amount = amount;
    }
    public void run(){
        balance.WithdrawAccount(amount);

    }

    
}
