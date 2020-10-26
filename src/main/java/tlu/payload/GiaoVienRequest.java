package tlu.payload;

public class GiaoVienRequest {
	
	private String username;
	private String password;
	private String fullname;
	private String email;
	private String phone;
	private String maGiaoVien;
	private String maBoMon;
	
	public GiaoVienRequest() {
		super();
	}

	public GiaoVienRequest(String username, String password, String fullname, String email, String phone,
			String maGiaoVien, String maBoMon) {
		super();
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.phone = phone;
		this.maGiaoVien = maGiaoVien;
		this.maBoMon = maBoMon;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMaGiaoVien() {
		return maGiaoVien;
	}

	public void setMaGiaoVien(String maGiaoVien) {
		this.maGiaoVien = maGiaoVien;
	}

	public String getMaBoMon() {
		return maBoMon;
	}

	public void setMaBoMon(String maBoMon) {
		this.maBoMon = maBoMon;
	}
	
	
}
