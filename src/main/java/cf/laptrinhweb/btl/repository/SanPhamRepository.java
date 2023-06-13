package cf.laptrinhweb.btl.repository;

import cf.laptrinhweb.btl.entity.DanhGia;
import cf.laptrinhweb.btl.entity.SanPham;
import cf.laptrinhweb.btl.model.DieuKienSanPham;
import cf.laptrinhweb.btl.model.ThongTinSanPham;

import java.util.List;
import java.util.Optional;

public interface SanPhamRepository extends JdbcRepository {
    SanPham taoMoi(ThongTinSanPham thongTinSanPham);
    Optional<SanPham> timTheoMa(Long maSanPham);
    List<SanPham> timTatCa(DieuKienSanPham dieuKien);
    SanPham timSanPham(Long ma_san_pham);
    void giamSoLuong(Long maSanPham, int soLuongGiam);
    void capNhatDanhGia(DanhGia ldg,Long maSanPham);
}
