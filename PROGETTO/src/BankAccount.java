

import java.io.Serializable;

/**
   A bank account has a balance that can be changed by 
   deposits and withdrawals.
*/
public class BankAccount implements Cloneable,Serializable
{  
   /**
      Constructs a bank account with a zero balance
   */
   public BankAccount(int codice)
   {   
      balance = 0;
      code=codice;
   }

   /**
      Constructs a bank account with a given balance
      @param initialBalance the initial balance
   */
   public BankAccount(int codice,double initialBalance)
   {   
      balance = initialBalance;
      code=codice;
   }

   /**
      Deposits money into the bank account.
      @param amount the amount to deposit
   */
   public void deposit(double amount)
   {  
      double newBalance = balance + amount;
      balance = newBalance;
   }

   /**
      Withdraws money from the bank account.
      @param amount the amount to withdraw
   */
   public void withdraw(double amount)
   {   
      double newBalance = balance - amount;
      balance = newBalance;
   }

   /**
      Gets the current balance of the bank account.
      @return the current balance
   */
   public double getBalance()
   {   
      return balance;
   }

   private double balance;
   int code;
   
   public String toString() {
		return getClass().getName() + "[Balance=" + balance + "]";
	}
	
	public boolean equals (Object otherObject){
		if (otherObject == null) return false;
		if (getClass() != otherObject.getClass())
			return false;
		BankAccount other = (BankAccount) otherObject;
		return balance==other.balance;
	}
	
	public BankAccount clone(){
		try
		{
		return (BankAccount) super.clone();
		}
		catch (CloneNotSupportedException e)
		{
		//non succede mai perchè implementiamo Cloneable
		return null
		;
		}
	}

}