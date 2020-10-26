package tlu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class NganhHoc {
	@Id
	@Column(name = "MA_NGANH_HOC", length = 10)
	private String maNganhHoc;
	
	@Column(name = "TEN_NGANH_HOC", length = 50)
	private String tenNganhHoc;
	
	@ManyToOne
	@JoinColumn(name = "MA_BO_MON")
	private BoMon boMon;
	
	public NganhHoc() {
		
	}

	public NganhHoc(String maNganhHoc, String tenNganhHoc, BoMon boMon) {
		super();
		this.maNganhHoc = maNganhHoc;
		this.tenNganhHoc = tenNganhHoc;
		this.boMon = boMon;
	}

	public String getMaNganhHoc() {
		return maNganhHoc;
	}

	public void setMaNganhHoc(String maNganhHoc) {
		this.maNganhHoc = maNganhHoc;
	}

	public String getTenNganhHoc() {
		return tenNganhHoc;
	}

	public void setTenNganhHoc(String tenNganhHoc) {
		this.tenNganhHoc = tenNganhHoc;
	}

	public BoMon getBoMon() {
		return boMon;
	}

	public void setBoMon(BoMon boMon) {
		this.boMon = boMon;
	}
	
}
