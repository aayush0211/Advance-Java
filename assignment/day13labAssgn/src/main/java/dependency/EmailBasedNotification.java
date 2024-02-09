package dependency;

public class EmailBasedNotification implements CustomerNotificationService{

	@Override
	public void alertCustomer(String mesg) {
		// TODO Auto-generated method stub
		System.out.println("in email "+mesg);
	}

}
