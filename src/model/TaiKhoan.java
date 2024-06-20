package model;

public class TaiKhoan {
	String TenTK;
	String matKhau;
	String vaiTro;
	
	public TaiKhoan() {
		super();
	}
	public TaiKhoan(String TenTK, String matKhau, String vaiTro) {
		super();
		this.TenTK = TenTK;
		this.matKhau = matKhau;
		this.vaiTro = vaiTro;
	}
	
	public String getTenTK() {
		return TenTK;
	}
	public void setTenTK(String tenTK) {
		TenTK = tenTK;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getVaiTro() {
		return vaiTro;
	}
	public void setVaiTro(String vaiTro) {
		this.vaiTro = vaiTro;
	}
	
}
