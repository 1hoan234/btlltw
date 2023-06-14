package cf.laptrinhweb.btl.service;

import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.model.DieuKienNguoiDung;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface XacThucService {
    void dangKy(Map<String, String[]> thongTinDangKy);
    NguoiDung dangNhap(String tenDangNhap, String matKhau);
    void doiMatKhau(HttpServletRequest req);
    List<NguoiDung> timNguoiDung(DieuKienNguoiDung dieuKien);
    void doiTrangThaiTaiKhoan(Long maNguoiDung, boolean khoa);
    void phanQuyen(NguoiDung nguoiDung, Set<QuyenNguoiDung> quyenDuocChon);
    void doiThongTinTaiKhoan(NguoiDung nguoiDung);
}
