package dao;

import pojos.Department;
import org.hibernate.*;

import com.google.protobuf.Message;

import static utils.HibernateUtils.getFactory;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public String addNewDepartment(Department dept) {
		String mesg = "Adding new dept failed!!!!!";
		// 1. Get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
		try {
			session.persist(dept);
			tx.commit();// flush --> dirty chking -->1 dept insert , 3 emps recs inserted , FK will
						// assigned
			mesg = "Added new dept with ID " + dept.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Department getDepartmentDetails(String deptName) {
		Department dept = null;
		String jpql = "select d from Department d where d.name=:name";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();

		try {
			dept = session.createQuery(jpql, Department.class).setParameter("name", deptName).getSingleResult();
			// dept : persistent
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return dept;// dept : DETACHED from L1 cache
	}

	@Override
	public Department getDepartmentAndEmpDetails(String deptName) {
		Department dept = null;
		String jpql = "select d from Department d where d.name=:name";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();

		try {
			dept = session.createQuery(jpql, Department.class).setParameter("name", deptName).getSingleResult();// select
																												// :
																												// depts
			// dept : persistent
			dept.getEmployees().size();// select : emps
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return dept;// dept : DETACHED from L1 cache : complete obj graph
	}
	@Override
	public Department getDepartmentAndEmpDetailsJoinFetch(String deptName) {
		Department dept = null;
		String jpql = "select d from Department d left join fetch d.employees where d.name=:name";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();

		try {
			dept = session.createQuery(jpql, Department.class).setParameter("name", deptName).getSingleResult();// select
					// depts
			// dept : persistent
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return dept;// dept : DETACHED from L1 cache : complete obj graph
	}
    
	@Override
	public List<Department> getAllDepatmentAndEmpDeatails() {
	List<Department> depts = null;
		String jpql = "select d from Department d left join fetch d.employees";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();

		try {
			depts = session.createQuery(jpql, Department.class).getResultList();// select
					// depts
			// dept : persistent
			
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return depts;
	}

	@Override
	public String deleteDepartment(String deptName) {
		String jpql = "select d from Department d where d.name=:name";
		// 1. get session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a tx
		Transaction tx = session.beginTransaction();
     Department dept=null;
   String  Message = "Entity not deleted!!!!";
		try {
			dept = session.createQuery(jpql, Department.class).setParameter("name", deptName).getSingleResult();// select
					// depts
			// dept : persistent
			
			session.delete(dept);
			Message = "Entity deleted!!!";
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		
		return Message;
	}


}
