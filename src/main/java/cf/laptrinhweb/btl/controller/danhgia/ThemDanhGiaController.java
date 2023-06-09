package cf.laptrinhweb.btl.controller.danhgia;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import static cf.laptrinhweb.btl.helper.HoTroXacThuc.yeuCauQuyen;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.helper.HoTroXacThuc;
import cf.laptrinhweb.btl.repository.impl.NguoiDungRepositoryImpl;
import cf.laptrinhweb.btl.service.DanhGiaService;
import cf.laptrinhweb.btl.service.impl.DanhGiaServiceImpl;
import cf.laptrinhweb.btl.entity.*;


@WebServlet("/them-danh-gia")
public class ThemDanhGiaController extends HttpServlet {
	public final DanhGiaService danhGiaService = new DanhGiaServiceImpl();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		yeuCauQuyen(request, List.of(QuyenNguoiDung.KHACH_HANG));
		NguoiDung nguoiDung = HoTroXacThuc.nguoiDungHienTai(request);
		DanhGia danhGia = new DanhGia();
		danhGia.setKhachHangDanhGia(new NguoiDungRepositoryImpl().timNguoiDung((Long.parseLong(request.getParameter("ma_khach_hang")))));
		System.out.println(request.getParameter("ma_khach_hang"));
		danhGia.setNoi_dung_danh_gia(request.getParameter("noi_dung_danh_gia"));
		System.out.println(danhGia.getNoi_dung_danh_gia());
		danhGia.setNgay_danh_gia(new Date(System.currentTimeMillis()));
		System.out.println(danhGia.getNgay_danh_gia());
		danhGia.setSoDiemDanhGia(Integer.parseInt(request.getParameter("so_diem_danh_gia")));
		System.out.println(request.getParameter("so_diem_danh_gia"));
		Long ma_san_pham_dat = Long.parseLong(request.getParameter("ma_san_pham_dat"));
		System.out.println(request.getParameter("ma_san_pham_dat"));
		danhGiaService.themDanhGia(danhGia,ma_san_pham_dat);
		System.out.println("ok");
		response.sendRedirect(request.getContextPath()+"/xem-tat-ca-danh-gia?ma_san_pham=" + request.getParameter("ma_san_pham"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}