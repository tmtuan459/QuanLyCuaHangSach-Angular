import { Book } from './../../dto/book';
import Swal from 'sweetalert2';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AuthorService } from './../../service/author.service';
import { Router, ActivatedRoute } from '@angular/router';
import { Type } from './../../dto/type';
import { Author } from './../../dto/author';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormGroup, FormBuilder, Validators, FormControl } from '@angular/forms';
import { MessageService } from 'src/app/service/message.service';
import { BookService } from 'src/app/service/book.service';


@Component({
  selector: 'app-author-dashboard',
  templateUrl: './author-dashboard.component.html',
  styleUrls: ['./author-dashboard.component.css'],

})
export class AuthorDashboardComponent implements OnInit {

  id: number;
  formValue !: FormGroup;
  formValueChild !: FormGroup;

  // form: FormGroup;
  authors: Author = new Author();
  authorList: Author[];
  authorData:Author[];
  authorDataById:Book[];
  type: Type[];


  //button;
  showButtonAdd: boolean;
  showButtonUpdate: boolean;

  showTableCon:boolean;

  //showitem
  page = 1; //Trang hiện tại. Số trang bắt đầu bằng 1.
  pageSize = 5;//Số lượng mục trên mỗi trang
  //test
  pageTC2 = 1; //Trang hiện tại. Số trang bắt đầu bằng 1.
  pageSizeTC2 = 5;//Số lượng mục trên mỗi trang

  @ViewChild('input') input: ElementRef;
  ngAfterViewInit() {
    this.input.nativeElement.focus();
  }

  totalLength= 0;
  totalLengthTC2= 0;


  //Label Name of CRU
  public labelData: string;


  constructor(private fb: FormBuilder,
    private authorService: AuthorService,
    private bookService: BookService,
    private router: Router,
    private route: ActivatedRoute,
    private _modalService: NgbModal,
    private message: MessageService
  ) { }

  ngOnInit(): void {
    this.formValue = this.fb.group({
      tenTacGia: [null, [Validators.required, Validators.maxLength(30)]],
      ghiChu: [null, [Validators.maxLength(255)]],
    });
    //-------------get list author-------------
    this.getAllAuthor();
  }
  selectPage(page: string) {
    this.page = parseInt(page, 5) || 1;
    // console.log(page);
  }
  selectPageTC(page: string) {
    this.pageTC2 = parseInt(page, 5) || 1;
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
  searchAuthors(key: string): void {
    const result: Author[] = [];
    key = key.trim();
    for (const author of this.authorList) {
      if (author.tenTacGia.toLowerCase().indexOf(key.toLowerCase()) !== -1
        )
         {
        result.push(author)
      }
    }
    this.authorData = result//đè data
    this.totalLength = result.length
    this.page = 1
    if (result.length === 0 || !key) {
      this.totalLength = result.length
      this.page = 1
    }
    if (!key) { this.ngOnInit() }
  }
  validateAllFormFields(formGroup: FormGroup) {//check form null
    Object.keys(formGroup.controls).forEach(field => {
      const control = formGroup.get(field);
      if (control instanceof FormControl) {
        control.markAsTouched({ onlySelf: true });
      } else if (control instanceof FormGroup) {
        this.validateAllFormFields(control);
      }
    });
  }
  formatInput(input: HTMLInputElement) {
    input.value = input.value.replace(this.message.FILTER_PAG_REGEX, '');
  }
  formatInput2(input2: HTMLInputElement) {
    input2.value = input2.value.replace(this.message.FILTER_PAG_REGEX, '');
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
  ClickAddAuthor() {
    this.labelData = this.message.labelAddNew + "Tác giả"
    this.formValue.reset();//reset data form
    this.formValue.enable();
    this.showButtonAdd = true;
    this.showButtonUpdate = false;
    this.showTableCon = false;
  }
  //Thêm Tác giả mới
  postAuthorkDetails() {

    if(this.formValue.valid){
      this.authors.tenTacGia = this.formValue.value.tenTacGia;
    this.authors.ghiChu = this.formValue.value.ghiChu;
    this.authorService.createAuthor(this.authors).subscribe(data => {
      this.showAlert(this.message.addSuccess,'success');
      let ref = document.getElementById('cancel')
      ref?.click()
      this.formValue.reset()
      this.getAllAuthor();
    }, error => {
      if (error.status === 500) {
        this.showAlert("Tên tác giả" + this.message.nameExist, 'error');
      }
      if (error.status === 400) {
        this.showAlert(this.message.inputData, 'error');
      }
    }
    )
    }else{
      this.validateAllFormFields(this.formValue);
    }

  }
  //Get về tất cả tác giả
  getAllAuthor() {

    this.authorService.getAuthorList().subscribe(data => {
      this.authorData = data;
      this.authorList = data;
      this.totalLength = this.authorData.length;
    })
  }
  get Dataform(){
    return this.formValue.controls
  }
  //Set data vào form Edit thông tin của Tác giả
  editAuthor(row: any) {
    this.labelData = this.message.labelUpdate + "Tác giả"
    this.formValue.enable();
    this.showButtonAdd = false;
    this.showButtonUpdate = true;
    this.showTableCon = false;


    this.formValue.controls['tenTacGia'].setValue(row.tenTacGia);
    this.formValue.controls['tenTacGia'].disable();
    this.formValue.controls['ghiChu'].setValue(row.ghiChu);
    this.id = row.id;
    // console.log(this.id)


  }
  updateAuthorDetails() {
    this.authors.tenTacGia = this.formValue.value.tenTacGia
    this.authors.ghiChu = this.formValue.value.ghiChu
    this.authors.id = this.id
    // console.log(this.books)


    this.authorService.updateAuthor(this.authors).subscribe(data => {
      this.showAlert(this.message.updateSuccess,'success');
      let ref = document.getElementById('cancel')//nếu click cancle thì rese dataform và back về list
      ref?.click()
      this.formValue.reset()
      this.getAllAuthor();

    }, error => {
      if (error.status === 400) {
        this.showAlert(this.message.inputData, 'error');

      } else if (error.status === 501) {
        Swal.fire({
          position:'top',
          title:'Tác giả'+ this.message.hasDeleteReloadPage,
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
      } else if (error.status === 423) {
        this.showAlert(this.message.recordExist, 'error');
      }
      // else if(error.status === 500){
      //   alert("Tên tác giả đã tồn tại, vui lòng nhập tên khác!");
      // }
    }
    )
  }
  //Delete tác giả
  deleteAuthor(row: any) {
    Swal.fire({
      position:'top',
      title: this.message.confirmDelete,
      // text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      cancelButtonText:'Hủy',
      confirmButtonText: 'Xác nhận'
    }).then((result) => {
      if (result.isConfirmed) {
        this.authorService.deleteAuthor(row.id).subscribe(data =>{
          this.getAllAuthor();
          Swal.fire({
            position:'top',
            icon:'success',
            text:this.message.deleteSuccess,
          }
          )
        }, error => {
          if (error.status === 500) {
            Swal.fire({
              position:'top',
              title:'Tác giả'+ this.message.hasDeleteReloadPage,
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
          }else if(error.status === 501){
            this.showAlert(this.message.authorExits, 'error');
          }
        }
        )

      }
    })
  }
  getListAuthorById(row: any) {
    this.bookService.getBookListByIdAuthor(row.id).subscribe(data => {
      this.authorDataById = data;
      // this.totalLength = this.authorDataById.length;
    })
  }
  // ---Xem thông tin chi tiết tác giả---
  detailBook(row: any) {
    this.showTableCon = true;
    this.formValue.disable();//disalble form
    this.labelData = this.message.labelDetail
    this.showButtonAdd = false;
    this.showButtonUpdate = false;

    this.formValue.controls['tenTacGia'].setValue(row.tenTacGia);
    this.formValue.controls['ghiChu'].setValue(row.ghiChu);

    this.authorService.getAuthorById(row.id).subscribe(data => {
    }, error => {
      if (error.status === 500) {
        Swal.fire({
          position:'top',
          title:'Tác giả'+ this.message.hasDeleteReloadPage,
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
    })
    this.bookService.getBookListByIdAuthor(row.id).subscribe(data => {
      this.authorDataById = data;
      this.totalLengthTC2 = data.length;

    })



  }

  key: string = "id";
  reverse: boolean = false;
  sort(key: string) {
    this.key = key;
    this.reverse = !this.reverse;
  }
  ////Validation
  validation_messages = {

    tenTacGia: [
      { type: 'required', message: 'Tên của tác giả ' + this.message.messageNull },
      { type: 'maxlength', message: 'Tên của tác giả' + this.message.nameOver30 }
    ],
    ghiChu: [
      { type: 'maxlength', message: 'Ghi chú về tác giả ' + this.message.messageOver },

    ]

  }
}
