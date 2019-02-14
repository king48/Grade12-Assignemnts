/*
    JuanDiego Castano
    Ms. Krasteva
    02/13/19
    This program creates the first and second bank accounts. It sets the account number, the intrest rate, the balance and the type of account.
*/

import java.awt.*;
import hsa.Console;

public class BankAccounts
{
    public static void main (String[] args)
    {
	Bank_Account bankAcc1 = new Bank_Account (123456789, 166.1, "Chequing", 0.023);
	bankAcc1.getBalance ();
	bankAcc1.getType ();
	bankAcc1.deposit (1051);
	bankAcc1.applyIntrest ();
	Bank_Account bankAcc2 = new Bank_Account (987654321, 598.99, "Savings", 0.07);
	bankAcc2.getBalance ();
	bankAcc2.getType ();
	bankAcc2.withdrawl (781);
	bankAcc2.applyIntrest ();
    }
}
