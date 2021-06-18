package edu.poly.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="Favorites",uniqueConstraints = {@UniqueConstraint(columnNames = {"UserId","SanphamId"})})
@NamedQuery(name="Favorite.findAll", query="SELECT f FROM Favorite f")
public class Favorite implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Likedate")
	private Date likedate = new Date();

	@ManyToOne
	@JoinColumn(name="SanphamId")
	private Sanpham sanpham;

	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	public Favorite() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Date getLikedate() {
		return likedate;
	}

	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}

	public Sanpham getSanpham() {
		return this.sanpham;
	}

	public void setSanpham(Sanpham sanpham) {
		this.sanpham = sanpham;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}