package dependent;

import dependency.CustomerNotificationService;
import dependency.Transport;

public class ATMImpl implements ATM {
	private Transport myTransport; //dependency
    private double cash;
    
    private CustomerNotificationService myService;
    
    public ATMImpl(double cash12) {
    	this.cash = cash12;
    }
    
	private ATMImpl(Transport t1234) {
		myTransport = t1234;
		System.out.println("in cnstr of " + getClass().getName() + " " + myTransport);
	}

	@Override
	public void deposit(double amt) {
		System.out.println("depositing " + amt);
		byte[] data = ("depositing " + amt).getBytes();
		myTransport.informBank(data);
		myService.alertCustomer("successfully deposit!!!");;// dependent obj is calling dependency's method to inform the bank
	}

	public double getCash() {
		return cash;
	}

	public void setCash(double cash) {
		this.cash = cash;
	}

	@Override
	public void withdraw(double amt) {
		System.out.println("withdrawing " + amt);
		byte[] data = ("withdrawing " + amt).getBytes();
		myTransport.informBank(data);
	}

	// custom init method
	public void myInit() {
		System.out.println("in init " + myTransport);// not null
	}

	// custom destroy method
	public void myDestroy() {
		System.out.println("in destroy " + myTransport);// not null
	}
	//factory method based D.I it is static bcoz SC call without instance
	public static ATMImpl myFactoryMethod(Transport t12) {
		System.out.println("in factory method "+t12);
		return new ATMImpl(t12);
	}
	
	public void setMyService(CustomerNotificationService c1234) {
			this.myService = c1234;
				
	}
	public void setMyTransport(Transport myTransport) {
		this.myTransport = myTransport;
		System.out.println("in setter " + this.myTransport);
	}
}
