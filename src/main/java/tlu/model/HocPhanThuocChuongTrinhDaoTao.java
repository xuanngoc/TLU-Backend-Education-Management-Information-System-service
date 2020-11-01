package tlu.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="id", scope=HocPhanThuocChuongTrinhDaoTao.class)
public class HocPhanThuocChuongTrinhDaoTao {

//	@EmbeddedId
//	private HocPhanThuocChuongTrinhDaoTaoID hocPhanThuocChuongTrinhDaoTaoID = new HocPhanThuocChuongTrinhDaoTaoID();
//	
//	@ManyToOne
//	@MapsId("maMonHoc")
//	private MonHoc monHoc;
//	
//	@ManyToOne
//	@MapsId("maChuongTrinhDaoTao")
//	private ChuongTrinhDaoTao chuongTrinhDaoTao;
//	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;
	
	@ManyToOne
	private ChuongTrinhDaoTao chuongTrinhDaoTao;	
	
	@OneToOne
	private MonHoc monHoc;
	
	private String loaiChuongTrinh;

	
	public HocPhanThuocChuongTrinhDaoTao() {
		super();
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public ChuongTrinhDaoTao getChuongTrinhDaoTao() {
		return chuongTrinhDaoTao;
	}


	public void setChuongTrinhDaoTao(ChuongTrinhDaoTao chuongTrinhDaoTao) {
		this.chuongTrinhDaoTao = chuongTrinhDaoTao;
	}


	public MonHoc getMonHoc() {
		return monHoc;
	}


	public void setMonHoc(MonHoc monHoc) {
		this.monHoc = monHoc;
	}


	public String getLoaiChuongTrinh() {
		return loaiChuongTrinh;
	}


	public void setLoaiChuongTrinh(String loaiChuongTrinh) {
		this.loaiChuongTrinh = loaiChuongTrinh;
	}
		
}
