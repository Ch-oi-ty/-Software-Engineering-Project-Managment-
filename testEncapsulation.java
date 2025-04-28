class Wallet {
    private double money;

    public void addMoney(double amount) {
        if (amount > 0) {
            money += amount;
        }
    }

    public double checkBalance() {
        return money;
    }
}

public class testEncapsulation{
    public static void main(String[] args) {
        Wallet myWallet = new Wallet();
        myWallet.addMoney(500);
        System.out.println(myWallet.checkBalance());
    }
}
