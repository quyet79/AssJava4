package edu.poly.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import edu.poly.entity.Report;
import edu.poly.entity.Sanpham;
import edu.poly.utils.JpaUtils;

public class SanPhamDAO {
	public List<Sanpham> findAll() {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select o from Sanpham o";
		TypedQuery<Sanpham> query = em.createQuery(jpql, Sanpham.class);
		return query.getResultList();
	}

	public List<Sanpham> findByNameSP(String tensanpham) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select o from Sanpham o where o.tensanpham like:keyword";
		TypedQuery<Sanpham> query = em.createQuery(jpql, Sanpham.class);
		query.setParameter("keyword", "%" + tensanpham + "%");
		return query.getResultList();
	}

	public void insert(Sanpham sanpham) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(sanpham);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public void update(Sanpham sanpham) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.merge(sanpham);
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public void delete(String id) throws Exception {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			Sanpham sanpham = em.find(Sanpham.class, id);
			if (sanpham != null) {
				em.remove(sanpham);
			} else {
				throw new Exception("Không tìm thấy thông tin của sản phẩm !");
			}
			trans.commit();
		} catch (Exception e) {
			e.printStackTrace();
			trans.rollback();
			throw e;
		} finally {
			em.close();
		}
	}

	public Sanpham findById(String id) {
		EntityManager em = JpaUtils.getEntityManager();
		Sanpham sanpham = em.find(Sanpham.class, id);
		return sanpham;

	}

	public List<Sanpham> findByPage(int offset, int limit) {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Sanpham> query = em.createNamedQuery("Sanpham.findAll", Sanpham.class);
		query.setFirstResult(offset);
		query.setMaxResults(offset + limit);
		return query.getResultList();
	}

	public List<Report> countFavoriteOfProduct() {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select new Report(v.sanpham.id, count(v),max(v.likedate),min(v.likedate)) from"
				+ " Favorite v group by v.sanpham.id ";
		TypedQuery<Report> query = em.createQuery(jpql, Report.class);
		return query.getResultList();
	}

	public List<Report> countShareOfProduct() {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select new Report(v.sanpham.id, count(v),max(v.sharedate),min(v.sharedate)) from"
				+ " Share v group by v.sanpham.id ";
		TypedQuery<Report> query = em.createQuery(jpql, Report.class);
		return query.getResultList();
	}

}
