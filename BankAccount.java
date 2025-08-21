public class BankAccount {
    private long balance;

    public synchronized void deposit(long amount){
        balance += amount;
    }
    public synchronized void Withdraw(long amount){
        if(balance>=amount)
        balance -= amount;
    }
    public long getBalance(){
        return this.balance;
    }
}
