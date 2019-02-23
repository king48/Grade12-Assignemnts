/*
JuanDiego Castano
Ms. Krasteva
02/13/19
This program takes will take a specific account, with a specific amount
    of money either deposit or withdraw cash into or out of the account if
    there are sufficient funds, and it will calculate the amount of interest
    this person will receive monthly.
*/

public class Bank_Account
{
    /*
	acc_num: long - this variable takes in a 9 digit number that identifies the account
	balance: double - this variable will store the account balance
	type: String - this variable will store the account type (either chequing or savings)
	intrest_rate : float - this variable will store the amount of monthly intrest (eg. 2.3%)
    */
    public long acct_num;
    private double balance;
    private String type;
    private double intrest_rate; // should to be float but it doesnt work

    /*This constructor will initialize the object.*/
    public Bank_Account (long acct, double bal, String ty, double intrest)
    {
	acct_num = acct;
	balance = bal;
	type = ty;
	intrest_rate = intrest;
    }


    //This method will get the current balance of a cirtain account
    public double getBalance ()
    {
	System.out.println ("Your current balance is: " + balance);
	return balance;
    }


    //This method gets the type of account either chequing or savings
    public String getType ()
    {
	System.out.println ("Your account type is: " + type);
	return type;
    }


    public void deposit (double amt)
    {
	balance += amt;
	System.out.println ("Your new account balance with your " + amt + " dollar deposit is: " + balance);
    }


    /*
    This method will allow the user to withdraw money if they have enough fund
    if they dont have enough funds they will not be allowed to take out funds
    */
    public boolean withdrawl (double amt)
    {
	if (balance < amt) // if the balance is less then the amount they are trying to withdraw
	{
	    System.out.println ("You do not have sufficient funds");
	    return false; // they will not be able to withdraw cash
	}
	else
	{
	    balance -= amt;
	    System.out.println ("Your new balance is: " + balance);
	    return true;
	}
    }


    //This Method applies the intrest to the account depending on the balance.
    public void applyIntrest ()
    {
	balance *= (intrest_rate + 1); // calculates the new balance including intrest
	System.out.println ("Your balance with a " + intrest_rate + " percent intrest rate this month is: " + balance);
    }
}
