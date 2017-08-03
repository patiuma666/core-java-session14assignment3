//notify() method calls when a single thread after waiting the wait()method and notifyall() specifies after the amount of time specified and sleep completed
package assignmnet14; //created package assignment14

public class Customer { //created class Customer 
	int amount=10000;   //taking an integer variable of amount and initializing some the value
	  
	synchronized void withdraw(int amount){    // here Synchronized block is used to lock an object for any shared resource.
	System.out.println("going to withdraw amount");   //here it prints 
	  
	if(this.amount<amount){  //here taking if statement whether it shows the balance 
	System.out.println("Less balance : waiting for deposit...");  
	try{wait();}catch(Exception e){}   //here wait() method  waits until object is notified. it shows an error while we use wait method 
	}                                        //so we use try catch to handle the error
	this.amount-=amount;  
	System.out.println("withdraw completed");  
	}  
	  
	synchronized void deposit(int amount){   //here it locks the deposit method and 
	System.out.println("going to deposit...!");  
	this.amount+=amount;   
	System.out.println("deposit completed... ");   //calls for notify method. it Wakes up a single thread that is waiting on this object's 
	notify();  
	}  
	}  
	  
	class Test{       //created a subclass Test
	public static void main(String args[]){   //created the main method
	final Customer c=new Customer();          //by using final keyword we created an object
	new Thread(){                              //which calls thread
	public void run(){c.withdraw(15000);}  
	}.start();                                  //here created run method to executes the output 
	new Thread(){  
	public void run(){c.deposit(10000);}  
	}.start();  
	  
	}}  