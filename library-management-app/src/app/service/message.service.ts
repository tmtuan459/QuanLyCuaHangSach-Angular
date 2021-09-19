import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})

export class MessageService {
   FILTER_PAG_REGEX = /[^0-9]/g;
  labelAddNew="Thêm mới ";
  labelUpdate="Cập nhập thông tin ";
  labelDetail="Xem thông tin chi tiết"

  addSuccess="Thêm mới thành công!";
  deleteSuccess="Xóa thành công!"
  updateSuccess="Cập nhật thông tin thành công!"

  confirmDelete="Bạn có chắc muốn xóa?"
  nameExist=" đã tồn tại vui lòng nhập tên khác!"
  recordExist="Bản ghi đã tồn tại vui lòng nhập dữ liệu khác!"

  addFail="Thêm mới thất bại!";
  reloadPage="Tải lại trang thành công!";
  inputData="Vui lòng nhập đúng dữ liệu!";
  hasDeleteReloadPage=" đã bị xóa, bạn có muốn tải lại trang?";
  authorExits="Tác giả này đang tồn tại trong sách, không thể xóa!"
  typeExits="Thể loại này đang tồn tại trong sách, không thể xóa!"

  overAmount="Số lượng xuất ra đã vượt hơn số lượng còn lại trong kho!"
  export="Xuất đơn hàng thành công!"
  import="Nhập đơn hàng thành công!"
  importAdd="Sản phẩm đã tồn tại trong danh sách!"
  addListNull="Vui lòng nhập đầy đủ dữ liệu!"
  messageNull = " không được để trống!";
  messageSelect = "Vui lòng chọn ";
  messageOver=" không được vượt quá 255 ký tự!"
  nameOver30=" không được vượt quá 30 ký tự!"
  nameOver50 = " không được vượt quá 50 ký tự!";
  messageyearOver = "Năm Xuất bản không được ";
  formValidEx="Mời nhập đầy đủ thông tin người dùng!";
  labelAllBook="Hiện thị tất các sản phẩm";
  labelInsufficient="Hiện thị các sản phẩm có số lượng dưới 30";
  labelRedundant="Hiện thị các sản phẩm có số lượng trên 50";

  // constructor() { }
}
