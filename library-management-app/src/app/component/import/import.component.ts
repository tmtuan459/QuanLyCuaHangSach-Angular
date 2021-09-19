import { BookService } from './../../service/book.service';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { Book } from 'src/app/dto/book';
import { ImportService } from 'src/app/service/import.service';
import { Import } from 'src/app/dto/import';
import { Export } from 'src/app/dto/export';
import { ExportService } from 'src/app/service/export.service';
import { MessageService } from 'src/app/service/message.service';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-import',
  templateUrl: './import.component.html',
  styleUrls: ['./import.component.css']
})
export class ImportComponent implements OnInit {
  // autofocus and tab
  @ViewChild('input') input: ElementRef;
  ngAfterViewInit() {
    this.input.nativeElement.focus();
  }
  bookData :Book[];
  bookList: Book[];
  page = 1; //Trang hiện tại. Số trang bắt đầu bằng 1.
  pageSize = 5;//Số lượng mục trên mỗi trang
  searchValue: any;
  searchText: any;
  totalLength=0;
  formValue !: FormGroup;
  formXuatHang !: FormGroup;
  sum = 0;
  sumE = 0;
  element :any;
  noteTable:string;


  importList: Array<Import> = [];
  exportList: Array<Export> = [];


  import: Import = new Import();
  export: Export = new Export();


  constructor(private fb: FormBuilder,
    private bookService: BookService,
    private importService: ImportService,
    private exportService: ExportService,
    private message: MessageService,
    ) { }


  ngOnInit(): void {

    this.formValue = this.fb.group({
      tensach: [null,[Validators.required]],
      soLuong: [null,[Validators.required]],
      donGia: [null,[Validators.required]]
    });


    this.formXuatHang = this.fb.group({
      tensach: [null,[Validators.required]],
      soLuong: ['', [Validators.required]],
      donGia: ['', [Validators.required]],
      soDienThoai: ['', [Validators.required]],
      diaChi: ['', [Validators.required]],
      tenNguoiNhan: ['', [Validators.required]]
    });

    this.getAllBook();
  }
  //---------------END NGONINIT------------------------
  formatInput(input: HTMLInputElement) {
    // input.value = input.value.replace(this.message.FILTER_PAG_REGEX, '');

  }

  selectPage(page: string) {
    this.page = parseInt(page, 5) || 1;
    // console.log(page);
  }
  refresh(): void {
    window.location.reload();
  }
  onKey(event: any) {​
    if (event.key === 'Tab') {​
    this.input.nativeElement.focus();
        }​
 }
  showAlert(message: string, statusIcon: any) {
    Swal.fire({
      position:'top',
      icon: statusIcon,
      // title: 'Oops...',
      text: message,
      timer:2500,
      // showConfirmButton: false,
    })
  }
  searchImports(key: string): void {
    const result: Book[] = [];
    key = key.trim();
    for (const books of this.bookList) {
      if (books.tensach.toLowerCase().indexOf(key.toLowerCase()) !== -1
        )
         {
        result.push(books)
      }
    }
    this.bookData = result//đè data
    this.totalLength = result.length
    this.page = 1
    if (result.length === 0 || !key) {
      this.totalLength = result.length
      this.page = 1
    }
    if (!key) { this.ngOnInit() }
  }
  validateAllFormFields(formGroup: FormGroup) {
    Object.keys(formGroup.controls).forEach(field => {
      console.log(field);
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({ onlySelf: true });
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }
  getAllBook() {
    this.noteTable=this.message.labelAllBook;
    this.element = document.getElementById("btnList");
    this.element.classList.add("target");
    this.element = document.getElementById("btnListI");
    this.element.classList.remove("target");
    this.element = document.getElementById("btnListR");
    this.element.classList.remove("target");
    this.bookService.getBookList().subscribe(data => {
      this.bookData = data;
      this.bookList = data;
      this.totalLength = this.bookData.length;
      //  console.log(this.totalLeght)
    })
  }
  get Dataform(){
    return this.formValue.controls
  }
  get DataformEX(){
    return this.formXuatHang.controls
  }
  ClickInsufficient() {
    this.noteTable=this.message.labelInsufficient;
    this.element = document.getElementById("btnList");
    this.element.classList.remove("target");
    this.element = document.getElementById("btnListI");
    this.element.classList.add("target");
    this.element = document.getElementById("btnListR");
    this.element.classList.remove("target");
    this.bookService.getBookInsufficient().subscribe(data => {
      this.bookData = data;
      this.bookList = data;
      this.totalLength = this.bookData.length;
    })
  }
  ClickRedundant() {
    this.noteTable=this.message.labelRedundant;
    this.element = document.getElementById("btnList");
    this.element.classList.remove("target");
    this.element = document.getElementById("btnListI");
    this.element.classList.remove("target");
    this.element = document.getElementById("btnListR");
    this.element.classList.add("target");
    this.bookService.getBookRedundant().subscribe(data => {
      this.bookData = data;
      this.bookList = data;
      this.totalLength = this.bookData.length;
    })
  }
  deleteRecordImp(row: any) {//delete form Import

    this.importList = this.importList.filter(item => item !== row);//
    this.sum = this.sum-(row.soLuong*row.donGia)

  }



  deleteRecordEx(row:any ) {//delete form Export


    this.exportList=this.exportList.filter(item => item !== row);

    this.sumE -= (row.soLuong*row.donGia)
  }
  ClickImport() {
    this.formValue.reset();
  }
  ClickExport(){
    this.sumE=0;
    this.formXuatHang.reset();
  }
  //----------------Nhập Hàng---------------
  AddImportToList() {
    if(this.formValue.valid  ){//check co value
      this.import = this.formValue.value;//form
      this.import.donGia= this.formValue.value.donGia.toFixed();

      if(this.formValue.value ==null){
         this.showAlert(this.message.addListNull,'error');
      }else if(this.importList.find(item => item.tensach == this.import.tensach)){
        this.showAlert(this.message.importAdd,'error');

      }else{
        this.importList.push(this.import);//mang
        this.sum += this.import.donGia*this.import.soLuong
      }
    }else{
      this.validateAllFormFields(this.formValue);
    }

  }

  CreateImportList() {
    if(this.formValue.valid  ){
      this.importService.ListImport(this.importList).subscribe(data => {
        this.showAlert(this.message.import,'success');
        this.refresh()
        let ref = document.getElementById('cancel')
        ref?.click()
        this.formValue.reset()
        this.getAllBook();
      }, error => {
        if (error.status === 500) {
          Swal.fire({
            position:'top',
            title:'Sách này '+ this.message.hasDeleteReloadPage,
            // text: "You won't be able to revert this!",
            icon: 'question',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            cancelButtonText:'Trở về',
            confirmButtonText: 'Xác nhận'
          }).then((result) => {
            if (result.isConfirmed) {
              this.refresh();
              this.showAlert(this.message.reloadPage,'')
            }
          })
        }
      }
      )
    }else{
      this.validateAllFormFields(this.formValue);
    }


  }

  //----------------Xuất Hàng-----------------
  AddExportToList() {//thêm sách
    if(this.formXuatHang.valid){
      this.export = this.formXuatHang.value;
    if(this.exportList.find(item => item.tensach == this.export.tensach)){
      this.showAlert(this.message.importAdd,'error');
    }else{
      this.exportList.push(this.export);
      this.sumE+= (this.export.donGia*this.export.soLuong)
    }
    }else{
      this.validateAllFormFields(this.formXuatHang);
    }

  }

  CreateExportList() {//xuất
    if(this.formXuatHang.valid  ){
      this.exportService.ListExport(this.exportList).subscribe(data => {
        this.showAlert(this.message.export,'success');
        this.refresh()
        let ref = document.getElementById('cancelEx')
        ref?.click()
        this.formXuatHang.reset()
        this.getAllBook();
      }, error => {
         if(error.status === 423){
          this.showAlert(this.message.formValidEx,'error');
        }else if (error.status === 500) {
          Swal.fire({
            position:'top',
            title:'Sách này '+ this.message.hasDeleteReloadPage,
            // text: "You won't be able to revert this!",
            icon: 'question',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            cancelButtonText:'Trở về',
            confirmButtonText: 'Xác nhận'
          }).then((result) => {
            if (result.isConfirmed) {
              this.refresh();
              this.showAlert(this.message.reloadPage,'')
            }
          })
        }else if(error.status === 501) {
          this.bookService.getBookByName(this.export.tensach).subscribe(data => {
            this.showAlert(this.message.overAmount +" Số lượng của " + data.tensach + " còn: " + data.soLuong,'error'
            )

            // alert(this.message.overAmount)
          });
        }
      }
      )
    }else{
      this.validateAllFormFields(this.formXuatHang);
    }


  }
   ////Validation

   validation_messages = {

    tensach: [
      { type: 'required', message: 'Tên sách '+this.message.messageNull }

    ],
    soLuong: [
      { type: 'required', message: 'Số lượng '+this.message.messageNull }

    ],

    donGia: [
      { type: 'required', message: 'Đơn giá '+this.message.messageNull }

    ],


    tenNguoiNhan: [
      { type: 'required', message: 'Tên người nhận '+this.message.messageNull }

    ],
    diaChi: [
      { type: 'required', message: 'Địa chỉ '+this.message.messageNull }

    ],
    soDienThoai: [
      { type: 'required', message: 'Số điện thoại '+this.message.messageNull }

    ]
  }
}
