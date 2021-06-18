package edu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import edu.poly.entity.User;
import edu.poly.utils.JpaUtils;

public class UserDAO {
	public void insert(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(user);
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public User findById(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		User user = em.find(User.class, id);
		return user;
	}
	
	public List<User> findAll(){
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}
	
	public void update(User user) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(user);
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
		} finally {
			em.close();
		}
	}
	
	public void delete(String id) throws Exception {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			User user = em.find(User.class, id);
			if(user!=null) {
				em.remove(user);
			} else {
				throw new Exception("Không tìm thấy thông tin nhân viên !");
			}
			trans.commit();
		}catch(Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			em.close();
		}
	}
	
	public User findByUserIdAndEmail(String id, String email) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select u from User u where u.id=:id and u.email=:email";
		try {
			TypedQuery<User> query = em.createQuery(jpql,User.class);
			query.setParameter("id", id);
			query.setParameter("email", email);
			return query.getSingleResult();
		} finally {
			em.close();
		}
		
	}
	
}
