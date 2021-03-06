package tlu.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="maNamHoc", scope=NamHoc.class)
public class NamHoc {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ma_nam_hoc")
	private long maNamHoc;
	
	
	private String tenNamHoc;
	
		
	public NamHoc() {
		super();
	}
	
	public NamHoc(long maNamHoc, String tenNamHoc) {
		super();
		this.maNamHoc = maNamHoc;
		this.tenNamHoc = tenNamHoc;
	}

	public long getMaNamHoc() {
		return maNamHoc;
	}
	
	public void setMaNamHoc(long maNamHoc) {
		this.maNamHoc = maNamHoc;
	}
	
	public String getTenNamHoc() {
		return tenNamHoc;
	}
	
	public void setTenNamHoc(String tenNamHoc) {
		this.tenNamHoc = tenNamHoc;
	}
	
	
	
	
}
