
public class SavingsAccount {
    private static double annualInterestRate;
    private double savingsBalance;
    public void calculateMonthlyInterest()
    {
        double monthlyInterestIncrease=((savingsBalance*annualInterestRate)/12);
        savingsBalance=(savingsBalance+monthlyInterestIncrease);
    }
    public void modifyInterestRate(double newRate)
    {
        annualInterestRate=newRate;
        return;
    }
    public void setBalance(double balance)
    {
        savingsBalance=balance;
        return;
    }
    public double returnBalance()
    {
        // System.out.println(savingsBalance);
        return savingsBalance;
    }

}
