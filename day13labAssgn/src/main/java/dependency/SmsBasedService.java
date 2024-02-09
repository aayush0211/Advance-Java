package dependency;

public class SmsBasedService implements CustomerNotificationService{

	@Override
	public void alertCustomer(String mesg) {
		// TODO Auto-generated method stub
		System.out.println("in SMS : "+mesg);
	}

}
