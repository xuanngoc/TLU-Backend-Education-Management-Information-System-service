package tlu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaiLieu {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long maTaiLieu;
	
	
	private String tenTaiLieu;
	
	private String tacGia;
	
	private String maISBN;
	
	private String nhaXuatBan;
	
	private String namXuatBan;
	
	private String maThuVIen;
	
	private String loaiTaiLieu;


	public TaiLieu() {
		super();
	}

	public TaiLieu(long maTaiLieu, String tenTaiLieu, String tacGia, String maISBN, String nhaXuatBan,
			String namXuatBan, String maThuVIen, String loaiTaiLieu) {
		super();
		this.maTaiLieu = maTaiLieu;
		this.tenTaiLieu = tenTaiLieu;
		this.tacGia = tacGia;
		this.maISBN = maISBN;
		this.nhaXuatBan = nhaXuatBan;
		this.namXuatBan = namXuatBan;
		this.maThuVIen = maThuVIen;
		this.loaiTaiLieu = loaiTaiLieu;
	}

	public long getMaTaiLieu() {
		return maTaiLieu;
	}

	public void setMaTaiLieu(long maTaiLieu) {
		this.maTaiLieu = maTaiLieu;
	}

	public String getTenTaiLieu() {
		return tenTaiLieu;
	}

	public void setTenTaiLieu(String tenTaiLieu) {
		this.tenTaiLieu = tenTaiLieu;
	}

	public String getTacGia() {
		return tacGia;
	}

	public void setTacGia(String tacGia) {
		this.tacGia = tacGia;
	}

	public String getMaISBN() {
		return maISBN;
	}

	public void setMaISBN(String maISBN) {
		this.maISBN = maISBN;
	}

	public String getNhaXuatBan() {
		return nhaXuatBan;
	}

	public void setNhaXuatBan(String nhaXuatBan) {
		this.nhaXuatBan = nhaXuatBan;
	}

	public String getNamXuatBan() {
		return namXuatBan;
	}

	public void setNamXuatBan(String namXuatBan) {
		this.namXuatBan = namXuatBan;
	}

	public String getMaThuVIen() {
		return maThuVIen;
	}

	public void setMaThuVIen(String maThuVIen) {
		this.maThuVIen = maThuVIen;
	}

	public String getLoaiTaiLieu() {
		return loaiTaiLieu;
	}

	public void setLoaiTaiLieu(String loaiTaiLieu) {
		this.loaiTaiLieu = loaiTaiLieu;
	}
	
}