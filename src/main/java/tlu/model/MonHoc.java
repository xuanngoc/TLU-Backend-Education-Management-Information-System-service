package tlu.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class MonHoc {
	
	@Id
	@Column(name = "MA_MON")
	private String maMon;
	
	@Column(name = "TEN_MON", length = 50)
	private String tenMon;
	
	@Column(name = "SO_TIN_CHI")
	private int soTinChi;

	@ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name="HOC_PHAN_TIEN_QUYET_ID")
	private MonHoc monHoc;
	
	@OneToMany(mappedBy = "monHoc")
	@Column(name = "HOC_PHAN_TIEN_QUYET")
	private List<MonHoc> hocPhanTienQuyet;
	
	@Column(name = "SO_GIO")
	private int soGio;
	
	@Column(name = "HE_SO")
	private double heSo;
	
	public MonHoc() {
		super();
	}

	public String getMaMon() {
		return maMon;
	}

	public void setMaMon(String maMon) {
		this.maMon = maMon;
	}

	public String getTenMon() {
		return tenMon;
	}

	public void setTenMon(String tenMon) {
		this.tenMon = tenMon;
	}

	public int getSoTinChi() {
		return soTinChi;
	}

	public void setSoTinChi(int soTinChi) {
		this.soTinChi = soTinChi;
	}

	public List<MonHoc> getHocPhanTienQuyet() {
		return hocPhanTienQuyet;
	}

	public void setHocPhanTienQuyet(List<MonHoc> hocPhanTienQuyet) {
		this.hocPhanTienQuyet = hocPhanTienQuyet;
	}

	public int getSoGio() {
		return soGio;
	}

	public void setSoGio(int soGio) {
		this.soGio = soGio;
	}

	public double getHeSo() {
		return heSo;
	}

	public void setHeSo(double heSo) {
		this.heSo = heSo;
	}
	
}
