package edu.poly.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="Sanphams")
@NamedQuery(name="Sanpham.findAll", query="SELECT s FROM Sanpham s")
public class Sanpham implements Serializable {

	@Id
	@Column(name="Id")
	private String id;

	@Column(name="Giasanpham")
	private String giasanpham;

	@Column(name="Hinhanh")
	private String hinhanh;

	@Column(name="Mota")
	private String mota;

	@Column(name="Tensanpham")
	private String tensanpham;


	@OneToMany(mappedBy="sanpham")
	private List<Favorite> favorites;


	@OneToMany(mappedBy="sanpham")
	private List<Share> shares;

	public Sanpham() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGiasanpham() {
		return this.giasanpham;
	}

	public void setGiasanpham(String giasanpham) {
		this.giasanpham = giasanpham;
	}

	public String getHinhanh() {
		return this.hinhanh;
	}

	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}

	public String getMota() {
		return this.mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public String getTensanpham() {
		return this.tensanpham;
	}

	public void setTensanpham(String tensanpham) {
		this.tensanpham = tensanpham;
	}

	public List<Favorite> getFavorites() {
		return this.favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Favorite addFavorite(Favorite favorite) {
		getFavorites().add(favorite);
		favorite.setSanpham(this);

		return favorite;
	}

	public Favorite removeFavorite(Favorite favorite) {
		getFavorites().remove(favorite);
		favorite.setSanpham(null);

		return favorite;
	}

	public List<Share> getShares() {
		return this.shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Share addShare(Share share) {
		getShares().add(share);
		share.setSanpham(this);

		return share;
	}

	public Share removeShare(Share share) {
		getShares().remove(share);
		share.setSanpham(null);

		return share;
	}

}