import { Book } from 'src/app/dto/book';
import { Type } from './../../dto/type';
import { FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { TypeService } from 'src/app/service/type.service';
import { ActivatedRoute, Router } from '@angular/router';
import { NgbActiveModal, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MessageService } from 'src/app/service/message.service';
import Swal from 'sweetalert2';
import { BookService } from 'src/app/service/book.service';


@Component({
  selector: 'app-type-dashboard',
  templateUrl: './type-dashboard.component.html',
  styleUrls: ['./type-dashboard.component.css']
})
export class TypeDashboardComponent implements OnInit {
  // autofocus and tab
  @ViewChild('input') input: ElementRef;
  ngAfterViewInit() {
    this.input.nativeElement.focus();
  }
  id: number;
  formValue !: FormGroup;
  // message:Message[];
  // form: FormGroup;
  types: Type = new Type();
  typeList: Type[];
  typeData : Type[];
  type: Type[];//variable message
  typeDataById:Book[];

  //button;
  showButtonAdd: boolean;
  showButtonUpdate: boolean;
  showTableCon: boolean;
  ////searching
  searchValue: any;
  //showitem
  page = 1; //Trang hiện tại. Số trang bắt đầu bằng 1.
  pageSize = 5;//Số lượng mục trên mỗi trang
  //
  pageTC = 1; //Trang hiện tại. Số trang bắt đầu bằng 1.
  pageSizeTC = 5;//Số lượng mục trên mỗi trang

  totalLength=0;
  totalLengthTC=0;

  //Label Name of CRU
  public labelData: string;



  constructor(private fb: FormBuilder,
    private typeService: TypeService,
    private bookService: BookService,
    private router: Router,
    private route: ActivatedRoute,
    private _modalService: NgbModal,
    private message: MessageService,
  ) { }

  ngOnInit(): void {
    this.formValue = this.fb.group({
      tenTheLoai: [null, [Validators.required, Validators.maxLength(30)]],
      ghiChu: [null, [Validators.maxLength(255)]],
    });

    //-------------get list Type-------------
    this.getAllType();
  }
  selectPage(page: string) {
    this.page = parseInt(page, 5) || 1;
    // console.log(page);
  }
  selectPageTC(page: string) {
    this.pageTC = parseInt(page, 5) || 1;
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
  searchTypes(key: string): void {
    const result: Type[] = [];
    key = key.trim();
    for (const type of this.typeList) {
      if (type.tenTheLoai.toLowerCase().indexOf(key.toLowerCase()) !== -1
        )
         {
        result.push(type)
      }
    }
    this.typeData = result//đè data
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
  // open() {
  //   this._modalService.open(MODALS);
  // }

  ClickAddType() {
    this.labelData = this.message.labelAddNew + "Thể Loại"
    this.formValue.reset();//reset data form
    this.formValue.enable();
    this.showButtonAdd = true;
    this.showButtonUpdate = false;
    this.showTableCon = false;
  }
  //Thêm thể loại mới
  postTypeDetails() {
    if(this.formValue.valid){
      this.types.tenTheLoai = this.formValue.value.tenTheLoai;
    this.types.ghiChu = this.formValue.value.ghiChu;

    this.typeService.createType(this.types).subscribe(data => {
      this.showAlert(this.message.addSuccess,'success');

      let ref = document.getElementById('cancel')
      ref?.click()
      this.formValue.reset()
      this.getAllType();
    }, error => {
      if (error.status === 500) {
        this.showAlert("Tên thể loại" + this.message.nameExist,'error');
      }
      if (error.status === 400) {
        this.showAlert(this.message.inputData,'error');
      }
    }
    )
    }else{
      this.validateAllFormFields(this.formValue);
    }

  }
  //Get về tất cả sách
  getAllType() {
    this.typeService.getTypeList().subscribe(data => {
      this.typeData = data;
      this.typeList = data;
      this.totalLength = this.typeData.length;
    })
  }
  get Dataform(){
    return this.formValue.controls
  }
  //Call form và set data Edit
  editType(row: any) {
    this.labelData = this.message.labelUpdate + "Thể Loại Sách"
    this.formValue.enable();
    this.showButtonAdd = false;
    this.showButtonUpdate = true;
    this.showTableCon = false;

    this.formValue.controls['tenTheLoai'].setValue(row.tenTheLoai);
    this.formValue.controls['tenTheLoai'].disable();
    this.formValue.controls['ghiChu'].setValue(row.ghiChu);
    this.id = row.id;
    // console.log(this.id)
  }

  updateTypeDetails() {//update data từ form về BE
    this.types.tenTheLoai = this.formValue.value.tenTheLoai
    this.types.ghiChu = this.formValue.value.ghiChu
    this.types.id = this.id
    // console.log(this.books)
    this.typeService.updateType(this.types).subscribe(data => {
      this.showAlert(this.message.updateSuccess,'success');

      let ref = document.getElementById("cancel")//nếu click cancle thì rese dataform và back về list
      ref?.click()
      this.formValue.reset()
      this.getAllType();
    }, error => {
      if (error.status === 501) {
        Swal.fire({
          position:'top',
          title:'Thể loại sách này'+ this.message.hasDeleteReloadPage,
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

  //Call form và set data
  deleteType(row: any) {
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
        this.typeService.deleteType(row.id).subscribe(data =>{
          this.getAllType();
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
              title:'Thể loại sách này'+ this.message.hasDeleteReloadPage,
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
            this.showAlert(this.message.typeExits, 'error');
          }
        }
        )

      }
    })

  }
  //end-Delte

  // // ---Xem thông tin chi tiết sách---
  detailType(row: any) {
    this.formValue.disable();//disalble form
    this.labelData = this.message.labelDetail
    this.showButtonAdd = false;
    this.showButtonUpdate = false;

    this.formValue.controls['tenTheLoai'].setValue(row.tenTheLoai);
    this.formValue.controls['ghiChu'].setValue(row.ghiChu);

    this.typeService.getTypeById(row.id).subscribe(data => {

    }, error => {
      if (error.status === 500) {
        Swal.fire({
          position:'top',
          title:'Thể loại sách này '+ this.message.hasDeleteReloadPage,
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
    this.bookService.getBookListByIdType(row.id).subscribe(data => {
      this.typeDataById = data;
       this.totalLengthTC = data.length;
    })
  }
  goToTypeList() {
    this.router.navigate(['type-dashboard'])//router về list
  }


  ////Validation
  validation_messages = {

    tenTheLoai: [
      { type: 'required', message: 'Tên của thể loại ' + this.message.messageNull },
      { type: 'maxlength', message: 'Tên của thể loại' + this.message.nameOver30 }
    ],
    ghiChu: [
      { type: 'maxlength', message: 'Ghi chú về thể loại' + this.message.messageOver },

    ]

  }

}
