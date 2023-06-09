package cf.laptrinhweb.btl.controller.danhgia;

import static cf.laptrinhweb.btl.helper.HoTroXacThuc.yeuCauQuyen;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cf.laptrinhweb.btl.constant.QuyenNguoiDung;
import cf.laptrinhweb.btl.entity.DanhGia;
import cf.laptrinhweb.btl.entity.NguoiDung;
import cf.laptrinhweb.btl.helper.HoTroXacThuc;
import cf.laptrinhweb.btl.service.DanhGiaService;
import cf.laptrinhweb.btl.service.impl.DanhGiaServiceImpl;

/**
 * Servlet implementation class XemTatCaDanhGia
 */
@WebServlet("/xem-tat-ca-danh-gia")
public class XemTatCaDanhGiaController extends HttpServlet {
	public final DanhGiaService danhGiaService = new DanhGiaServiceImpl(); 
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NguoiDung nguoiDung = HoTroXacThuc.nguoiDungHienTai(request);
        yeuCauQuyen(request, List.of(QuyenNguoiDung.KHACH_HANG));
        List<DanhGia> ldg = danhGiaService.layTatCaDanhGia(Long.parseLong(request.getParameter("ma_san_pham")));
        request.setAttribute("tat_ca_danh_gia", ldg);
        request.getRequestDispatcher("WEB-INF/danh_gia.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}
