package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Address;
import pojos.Employee;

import static utils.HibernateUtils.*;

import java.util.List;
public class AddressDaoImpl implements AddressDao {

	@Override
	public String enterEmpAddress(long empId,Address adr) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		String msg = "address not enter!!!";
		try {
		Employee emp = session.get(Employee.class, empId);
			adr.setEmp(emp);
			session.persist(adr);//cascaded not allowed bcoz  this is uniDir'n
		msg = "address enter with Emp id "+emp.getId();
		tx.commit();
		}catch (Exception e) {
			if(tx!=null)
		tx.rollback();	
			throw e;
		}
		return msg;
	}

	@Override
	public String displayEmployeeAddress(long empId) {
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Address adr=null;
		String message =null;
		try {
		adr = session.get(Address.class, empId);
		Employee emp = session.get(Employee.class, empId);
		if(emp==null) {
		message ="Invalid empId";
		return message;
		}
		if(adr == null) {
			message="emp has no address!!!";
			return message;
		}
		tx.commit();
		}catch (Exception e) {
			if(tx!=null)
		tx.rollback();	
			System.out.println(e.getMessage());
		}
		message = adr.toString();
		return message;
	}

	@Override
	public List<String> displayLastNameOfEmpAndAddress(String lastCity) {
	    String jpql = "select a.emp.lastName from Address a where a.city=:lastCity";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		List<String> adr=null;
		try {
		adr = session.createQuery(jpql, String.class).setParameter("lastCity", lastCity).getResultList();
	
		tx.commit();
		}catch (Exception e) {
			if(tx!=null)
		tx.rollback();	
			System.out.println(e.getMessage());
		}
		return adr;
		
	}
    
}
