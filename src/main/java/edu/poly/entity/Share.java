package edu.poly.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="Shares",uniqueConstraints = {@UniqueConstraint(columnNames = {"UserId","SanphamId"})})
@NamedQuery(name="Share.findAll", query="SELECT s FROM Share s")
public class Share implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="Id")
	private Long id;

	@Column(name="Email")
	private String email;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Sharedate")
	private Date sharedate = new Date();


	@ManyToOne
	@JoinColumn(name="SanphamId")
	private Sanpham sanpham;


	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	public Share() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Date getSharedate() {
		return sharedate;
	}

	public void setSharedate(Date sharedate) {
		this.sharedate = sharedate;
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