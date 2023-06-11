let cacBinhLuan = document.getElementsByClassName("binh-luan");

function themFormBinhLuan(khungChua, maBinhLuanPhanHoi) {
    // neu da co form phan hoi => xoa di thay the
    let formDaCo = khungChua.querySelector("form.tao-binh-luan");
    if (formDaCo) {
        formDaCo.remove();
    }
    // tao form binh luan moi
    let formBinhLuan = document.createElement("form");
    formBinhLuan.classList.add("tao-binh-luan");
    formBinhLuan.innerHTML = `
        ${maBinhLuanPhanHoi ? '<input type="hidden" name="phanHoiBinhLuan" value="${maBinhLuanPhanHoi}" />' : ""}
        <textarea name="noiDung" placeholder="Nội dung phản hồi"></textarea>
        <button class="nut kieu-2 nut-gui-bl" type="submit">
          Gửi
        </button>
    `;
    khungChua.appendChild(formBinhLuan);
    formBinhLuan.querySelector("textarea").focus();
}

function laBinhLuanCapDau(binhLuan) {
    return binhLuan.parentElement.classList.contains("khung-binh-luan");
}

Array.from(cacBinhLuan).forEach((binhLuan) => {
    let nutPhanHoi = binhLuan.querySelector(".nut-phan-hoi");
    console.log(nutPhanHoi);
    nutPhanHoi.addEventListener("click", function () {
        let khungPhanHoi;
        if (laBinhLuanCapDau(binhLuan)) {
            khungPhanHoi = binhLuan.nextElementSibling;
        } else {
            khungPhanHoi = binhLuan.parentElement.parentElement;
        }
        themFormBinhLuan(khungPhanHoi, binhLuan.getAttribute("data-ma-binh-luan"));
    });
});