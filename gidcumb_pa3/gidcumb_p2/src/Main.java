import java.text.DecimalFormat;


public class Main {

    private static DecimalFormat formatKey = new DecimalFormat("####.##");
    public static void main(String[] args) {

            int n=1;

            SavingsAccount saver1 = new SavingsAccount();
            SavingsAccount saver2 = new SavingsAccount();

            saver1.setBalance(2000.00);
            saver2.setBalance(3000.00);
            saver1.modifyInterestRate(.04);
            saver2.modifyInterestRate(.04);

            for(int i=0; i<12; i++)
            {

                saver1.calculateMonthlyInterest();
                saver2.calculateMonthlyInterest();
                System.out.println("Month: " + n +" Account 1: $" + formatKey.format(saver1.returnBalance()) + "    Account 2: $" + formatKey.format(saver2.returnBalance()));
                n++;
            }
            saver1.modifyInterestRate(.05);
            saver2.modifyInterestRate(.05);

            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
            System.out.println("Month: " +n  +" Account 1: $" + formatKey.format(saver1.returnBalance()) + "    Account 2: $" + formatKey.format(saver2.returnBalance()));
        }
    }

