package tlu.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class DeCuongChiTiet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long maDeCuongChiTiet;
	
	@ManyToOne
	@JoinColumn(name = "MA_MON", nullable = true)
	private MonHoc monHoc;
	
	@ManyToOne
	@JoinColumn(name = "MA_NAM_HOC", nullable = true)
	private NamHoc namHoc;
	
	@Column(columnDefinition = "text")
	private String moTa;
	
	@Column(columnDefinition = "text")
	private String thoiLuong;
	
	@Column(columnDefinition = "text")
	private String mucTieuHocPhan;
	
	@Column(columnDefinition = "text")
	private String danhGiaSinhVien;
	
	@Column(columnDefinition = "text")
	private String noiDungChiTiet;
	
	@OneToOne
	private GiaoVien giaoVien;

	@ManyToMany
	private List<TaiLieu> danhSachGiaoTrinh;

	
	public DeCuongChiTiet() {
		super();
	}

	public DeCuongChiTiet(long maDeCuongChiTiet, MonHoc monHoc, NamHoc namHoc, String moTa, String thoiLuong,
			String mucTieuHocPhan, String danhGiaSinhVien, String noiDungChiTiet, GiaoVien giaoVien,
			List<TaiLieu> danhSachGiaoTrinh) {
		super();
		this.maDeCuongChiTiet = maDeCuongChiTiet;
		this.monHoc = monHoc;
		this.namHoc = namHoc;
		this.moTa = moTa;
		this.thoiLuong = thoiLuong;
		this.mucTieuHocPhan = mucTieuHocPhan;
		this.danhGiaSinhVien = danhGiaSinhVien;
		this.noiDungChiTiet = noiDungChiTiet;
		this.giaoVien = giaoVien;
		this.danhSachGiaoTrinh = danhSachGiaoTrinh;
	}

	public long getMaDeCuongChiTiet() {
		return maDeCuongChiTiet;
	}

	public void setMaDeCuongChiTiet(long maDeCuongChiTiet) {
		this.maDeCuongChiTiet = maDeCuongChiTiet;
	}

	public MonHoc getMonHoc() {
		return monHoc;
	}

	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}

	public NamHoc getNamHoc() {
		return namHoc;
	}

	public void setNamHoc(NamHoc namHoc) {
		this.namHoc = namHoc;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public String getThoiLuong() {
		return thoiLuong;
	}

	public void setThoiLuong(String thoiLuong) {
		this.thoiLuong = thoiLuong;
	}

	public String getMucTieuHocPhan() {
		return mucTieuHocPhan;
	}

	public void setMucTieuHocPhan(String mucTieuHocPhan) {
		this.mucTieuHocPhan = mucTieuHocPhan;
	}

	public String getDanhGiaSinhVien() {
		return danhGiaSinhVien;
	}

	public void setDanhGiaSinhVien(String danhGiaSinhVien) {
		this.danhGiaSinhVien = danhGiaSinhVien;
	}

	public String getNoiDungChiTiet() {
		return noiDungChiTiet;
	}

	public void setNoiDungChiTiet(String noiDungChiTiet) {
		this.noiDungChiTiet = noiDungChiTiet;
	}

	public GiaoVien getGiaoVien() {
		return giaoVien;
	}

	public void setGiaoVien(GiaoVien giaoVien) {
		this.giaoVien = giaoVien;
	}

	public List<TaiLieu> getDanhSachGiaoTrinh() {
		return danhSachGiaoTrinh;
	}

	public void setDanhSachGiaoTrinh(List<TaiLieu> danhSachGiaoTrinh) {
		this.danhSachGiaoTrinh = danhSachGiaoTrinh;
	}
	
}