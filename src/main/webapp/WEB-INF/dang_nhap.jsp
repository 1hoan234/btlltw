<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/chung.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/static/css/dang_nhap.css">
</head>
<body>
    <jsp:include page="components/header.jsp"/>
    <div id="khung-dang-nhap">
        <h1>Đã có tài khoản</h1>
        <h2>Đăng nhập</h2>
        <c:if test="${thongBao != null}">
            <div class="thong-bao loi">${thongBao}</div>
        </c:if>
        <form id="form-dang-nhap" class="tieu-chuan" method="POST">
            <div class="truong bat-buoc">
                <label>Tên đăng nhập</label>
                <input
                        type="text"
                        name="tenDangNhap"
                        placeholder="Tên đăng nhập, email hoặc số điện thoại"
                        required
                        autofocus
                />
            </div>
            <div class="truong bat-buoc">
                <label>Mật khẩu</label>
                <input type="password" name="matKhau" placeholder="Mật khẩu" required />
            </div>
            <div class="hanh-dong">
                <button class="nut kieu-1" type="submit">Xác nhận</button>
            </div>
        </form>
        <a class="lien-ket gach-chan mo-rong quen-mat-khau" href="#">
            <span>Quên mật khẩu?</span>
        </a>
        <h1>Khách hàng mới</h1>
        <p class="mo-ta">Đăng ký để nhận được những ưu đãi mới nhất dành riêng cho các khách hàng mới</p>
        <a class="nut kieu-2 tao-tai-khoan" href="<%=request.getContextPath()%>/dang-ky">Tạo tài khoản</a>
    </div>
</body>
</html>
