import { Author } from './author';
import { Type } from './type';

export class Book {
  id: number;
  tensach: string;
  namXB: number;

  theLoaiId: string;
  tacGiaId: string;
  
  gioiThieu: string;
  nhaXB:String;
  soLuong:number;
  donGia:number;

  theLoai: Type;
  tacGia: Author;

}
