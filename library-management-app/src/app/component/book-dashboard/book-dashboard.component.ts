import { Observable } from 'rxjs';
import { Type } from '../../dto/type';
import { BookService } from '../../service/book.service';
import { Component, OnInit, ElementRef, ViewChild, Input } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Book } from '../../dto/book';
import { Author } from '../../dto/author';
import { TypeService } from '../../service/type.service';
import { AuthorService } from '../../service/author.service';
import { Router, ActivatedRoute } from '@angular/router';
import { error } from '@angular/compiler/src/util';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MessageService } from 'src/app/service/message.service';
import Swal from 'sweetalert2';




@Component({
  selector: 'app-book-dashboard',
  templateUrl: './book-dashboard.component.html',
  styleUrls: ['./book-dashboard.component.css']
})

export class BookDashboardComponent implements OnInit {
  // autofocus and tab
  @ViewChild('input') input: ElementRef;


  id: number;
  formValue !: FormGroup;
  // form: FormGroup;
  books: Book = new Book();
  bookData: Book[];
  bookSearchList: Book[];
  type: Type[];
  typenName: Type[];
  author: Author[];
  //button
  showButtonAdd: boolean;
  showButtonUpdate: boolean;
  ////searching
  searchValue: any;
  //showitem
  page = 1; //Trang hiện tại. Số trang bắt đầu bằng 1.
  pageSize = 5;//Số lượng mục trên mỗi trang
  //test
  year= new Date().getFullYear();


  element:any;

  totalLength= 0;


  //Label Name of CRU
  public labelData: string;
  constructor(
    private fb: FormBuilder,
    private bookService: BookService,
    private typeService: TypeService,
    private authorService: AuthorService,
    private router: Router,
    private route: ActivatedRoute,
    private _modalService: NgbModal,
    private message: MessageService,

  ) {

}
  //------------------
  ngOnInit(): void {
    // this.formValue = this.fb.group({
    //   tensach : [''],
    //   namXB : [''],
    //   theLoai : [''],
    //   tacGia : [''],
    //   gioiThieu : [''],
    // })


    this.formValue = this.fb.group({
      tensach: [null, [Validators.required, Validators.maxLength(50)]],
      namXB: [null, [Validators.required, Validators.max(this.year), Validators.min(1000)]],
      nhaXB: [null,[Validators.required, Validators.maxLength(30)] ],
      theLoaiId: [null, [Validators.required]],
      tacGiaId: [null, [Validators.required]],
      gioiThieu: [null, [Validators.maxLength(255)]]


    });

    //-------------get list book-------------
    this.getAllBook();
    //-------------get list type-------------
    this.typeService.getTypeList().subscribe(data => {
      this.type = data
      this.typenName = data
    }, error => console.log(error))
    //-------------get list author-----------
    this.authorService.getAuthorList().subscribe(data => {
      //  console.log(data)
      this.author = data
    }, error => console.log(error))



  }

  searchBooks(key: string): void {
    const result: Book[] = [];
    key = key.trim();
    for (const book of this.bookSearchList) {

      if (book.tensach.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || book.nhaXB.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || book.theLoai.tenTheLoai.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || book.tacGia.tenTacGia.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || book.namXB.toString().indexOf(key.toLowerCase()) !== -1
        )
         {
        result.push(book)
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
  selectPage(page: string) {
    this.page = parseInt(page, 5) || 1;
    // console.log(page);
  }
  change(event:any){
    this.page=1
  }
  refresh(): void {
    window.location.reload();
  }

// tabPress
  onKey(event: any) {
    console.log(event.key);​
    if (event.key === 'Tab') {​
    this.input.nativeElement.focus();
        }​
 }​
  validateAllFormFields(formGroup: FormGroup) {
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

  ClickAddBook() {
    this.labelData = this.message.labelAddNew + "Sách"
    this.formValue.reset();//reset data form
    this.formValue.enable();
    this.showButtonAdd = true;
    this.showButtonUpdate = false;
    this.element= document.getElementById("InputTenSach")
    this.element.setAttribute("autofocus")

  }
  //Thêm sách mới
  postBookDetails() {
    if(this.formValue.valid){
      this.books.tensach = this.formValue.value.tensach;
      this.books.namXB = this.formValue.value.namXB;
      this.books.nhaXB = this.formValue.value.nhaXB;
      this.books.theLoaiId = this.formValue.value.theLoaiId;
      this.books.tacGiaId = this.formValue.value.tacGiaId;
      this.books.gioiThieu = this.formValue.value.gioiThieu;

      this.bookService.createBook(this.books).subscribe(data => {
        this.showAlert(this.message.addSuccess,'success');
        let ref = document.getElementById('cancel')
        ref?.click()
        this.formValue.reset()
        this.getAllBook();
      }, error => {
        if (error.status === 500) {
          this.showAlert("Tên sách" + this.message.nameExist, 'error');
        }else if (error.status === 400) {
          this.showAlert(this.message.inputData, 'error');
        }

      }

      )
    }else{
      this.validateAllFormFields(this.formValue);
    }

  }
  //Get về tất cả sách
  getAllBook() {
    this.bookService.getBookList().subscribe(data => {
      this.bookData = data;
      this.bookSearchList=data;
      this.totalLength = data.length;
    })
  }
  get Dataform(){
    return this.formValue.controls
  }
  //Edit thông tin của Sách
  editBook(row: any) {
    this.labelData = this.message.labelDetail
    this.formValue.enable();
    this.showButtonAdd = false;
    this.showButtonUpdate = true;
    this.formValue.controls['tensach'].setValue(row.tensach);
    this.formValue.controls['namXB'].setValue(row.namXB);
    this.formValue.controls['nhaXB'].setValue(row.nhaXB);
    this.formValue.controls['theLoaiId'].setValue(row.theLoai.tenTheLoai);
    this.formValue.controls['tacGiaId'].setValue(row.tacGia.tenTacGia);
    this.formValue.controls['gioiThieu'].setValue(row.gioiThieu);
    this.id = row.id;
    this.formValue.controls['tensach'].disable();
    // console.log(this.id)

  }
  updateBookDetails() {
    this.books.tensach = this.formValue.value.tensach
    this.books.namXB = this.formValue.value.namXB
    this.books.nhaXB = this.formValue.value.nhaXB
    this.books.theLoaiId = this.formValue.value.theLoaiId//chú ý đừng đặt trung tên formcontrolname ở html vs tên của field,sẽ sinh ra lỗi
    this.books.tacGiaId = this.formValue.value.tacGiaId//chú ý đừng đặt trung tên formcontrolname ở html vs tên của field,sẽ sinh ra lỗi
    this.books.gioiThieu = this.formValue.value.gioiThieu;
    this.books.id = this.id

      this.bookService.updateBook(this.books).subscribe(data => {
        this.showAlert(this.message.updateSuccess,'success');
        let ref = document.getElementById('cancel')//nếu click cancle thì rese dataform và back về list
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

    // }

  }
  //Delete sách
  deleteBook(row: any) {
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
        this.bookService.deleteBook(row.id).subscribe(data =>{
          this.getAllBook();
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

      }
    })


  }
  // ---Xem thông tin chi tiết sách---
  detailBook(row: any) {
    this.formValue.disable();//disalble form
    this.labelData = this.message.labelDetail
    this.showButtonAdd = false;
    this.showButtonUpdate = false;
    this.formValue.controls['tensach'].setValue(row.tensach);
    this.formValue.controls['namXB'].setValue(row.namXB);
    this.formValue.controls['nhaXB'].setValue(row.nhaXB);
    this.formValue.controls['theLoaiId'].setValue(row.theLoai.tenTheLoai);
    this.formValue.controls['tacGiaId'].setValue(row.tacGia.tenTacGia);
    this.formValue.controls['gioiThieu'].setValue(row.gioiThieu);

    this.bookService.getBookById(row.id).subscribe(data => {



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
    })
  }




  ////Validation
  validation_messages = {

    tensach: [
      { type: 'required', message: 'Tên của sách ' + this.message.messageNull },
      { type: 'maxlength', message: 'Tên của sách' + this.message.nameOver50 }
    ],
    namXB: [
      { type: 'required', message: 'Năm xuất bản ' + this.message.messageNull },
      { type: 'max', message: this.message.messageyearOver + ' lớn hơn năm hiện tại: '+this.year },
      { type: 'min', message: this.message.messageyearOver + ' bé hơn năm 1000!' },



    ],
    nhaXB: [
      { type: 'required', message: 'Nhà xuất bản ' + this.message.messageNull },
      { type: 'maxlength', message: 'Tên của nhà xuất bản' + this.message.nameOver30 },

    ],

    theLoaiId: [
      { type: 'required', message: 'Thể loại sách' + this.message.messageNull },

    ],
    tacGiaId: [
      { type: 'required', message: 'Tác giả' + this.message.messageNull },

    ],
    gioiThieu: [
      { type: 'maxlength', message: 'Nội dung giới thiệu' + this.message.messageOver}
    ]

  }

}




