import { Statistical } from './../../dto/statistical';
import { Book } from './../../dto/book';
import { Component, HostListener, OnInit, ViewChild, ElementRef } from '@angular/core';
import { ChartDataSets, ChartOptions, ChartType } from 'chart.js';
import { Label } from 'ng2-charts';
import { MessageService } from 'src/app/service/message.service';
import { StatisticalService } from 'src/app/service/statistical.service';

@Component({
  selector: 'app-statistical',
  templateUrl: './statistical.component.html',
  styleUrls: ['./statistical.component.css']
})
export class StatisticalComponent implements OnInit {
  @ViewChild('input') input: ElementRef;
  ngAfterViewInit() {
    this.input.nativeElement.focus();
  }
  listData: Array<any> = []

  listDetails: Array<any> = []

  statusIE : string;
  importProductList: Array<any> = []
  IESearchList: Array<any> = []

  element :any;

  totalLength=0;
  page = 1; //Trang hiện tại. Số trang bắt đầu bằng 1.
  pageSize = 5;//Số lượng mục trên mỗi trang

  totalLengthE=0;
  pageE = 1; //Trang hiện tại. Số trang bắt đầu bằng 1.
  pageSizeE = 5



  List: Array<any> = []
  thang: Array<any> = []
  doanhThu: Array<any> = []
  loiNhuan: Array<any> = []

  public barChartOptions: ChartOptions = {
    responsive: true,
    // We use these empty structures as placeholders for dynamic theming.
    scales: { xAxes: [{}], yAxes: [{}] },
    plugins: {
      datalabels: {
        anchor: 'end',
        align: 'end',
      }
    }
  };
  public barChartLabels: Label[] = this.thang;
  public barChartType: ChartType = 'bar';
  public barChartLegend = true;

  public barChartData: ChartDataSets[] = [
    { data: this.doanhThu, label: 'Doanh Thu' },
    { data: this.loiNhuan, label: 'Loi Nhuan' },
  ];


  constructor(private statisticalservice: StatisticalService,
    private message: MessageService) { }

  ngOnInit(): void {
    this.getAll()
    this.getRevenueByBook()
    this.getListDetailsExport()
    this.getListDetailsImport()
  }
  formatInput(input: HTMLInputElement) {
    input.value = input.value.replace(this.message.FILTER_PAG_REGEX, '');
  }
  selectPage(page: string) {
    this.page = parseInt(page, 5) || 1;
  }
  onKey(event: any) {​
    if (event.key === 'Tab') {​
    this.input.nativeElement.focus();
        }​
 }
  searchImports(key: string): void {
    const result: Statistical[] = [];
    key = key.trim();
    for (const imp2 of this.IESearchList) {
      if (imp2[0].toLowerCase().indexOf(key.toLowerCase()) !== -1
      ) {
        result.push(imp2)
      }
    }

    this.listDetails = result//đè data
    this.totalLengthE = result.length
    this.pageE = 1
    if (result.length === 0 || !key) {
      this.totalLengthE = result.length
      this.pageE = 1
    }
    if (!key) {
      this.getRevenueByBook()
      this.getListDetailsExport()
      this.getListDetailsImport()
             }
  }
  searchProduct(key1: string): void {
    const result: Statistical[] = [];
    key1 = key1.trim();
    for (const imp1 of this.importProductList) {
      if (imp1[0].toLowerCase().indexOf(key1.toLowerCase()) !== -1
      ) {
        result.push(imp1)
      }
    }

    this.listData = result//đè data
    this.totalLength = result.length
    this.page = 1
    if (result.length === 0 || !key1) {
      this.totalLength = result.length
      this.page = 1
    }
    if (!key1) {
      this.resetTable()
             }
  }
  resetTable(){
    this.getRevenueByBook()
    this.getListDetailsExport()
    this.getListDetailsImport()
  }
  refresh(): void {
    window.location.reload();
  }
  getRevenueByBook() {
    this.statisticalservice.listStatisticalByBook().subscribe(data => {
      this.listData = data;
      this.importProductList = data;
      this.totalLength = this.listData.length;
    })
  }

  getListDetailsImport() {
    this.statusIE="nhập"
    this.statisticalservice.listtDetailsImport().subscribe(data => {
      this.element = document.getElementById("btnListI");
      this.element.classList.add("target");
      this.element = document.getElementById("btnListE");
      this.element.classList.remove("target");
      this.listDetails = data;
      this.IESearchList = data;
      this.totalLengthE = this.listDetails.length;
    })
  }
  getListDetailsExport() {
    this.statusIE="xuất"
    this.statisticalservice.listtDetailsExport().subscribe(data => {
      this.element = document.getElementById("btnListI");
      this.element.classList.remove("target");
      this.element = document.getElementById("btnListE");
      this.element.classList.add("target");
      this.listDetails = data;
      this.IESearchList = data;
      this.totalLengthE = this.listDetails.length;
    })
  }
  getAll() {
    this.statisticalservice.listStatistical().subscribe(data => {
      this.List = data
      for (let item of this.List) {
        const thang = 'Tháng ' + item[0]
        this.thang.push(thang)
        this.doanhThu.push(item[2])
        this.loiNhuan.push(item[3])
      }

      // console.log(this.List)
      //  console.log(this.totalLeght)
    })
  }
  // events
  public chartClicked({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public chartHovered({ event, active }: { event: MouseEvent, active: {}[] }): void {
    console.log(event, active);
  }

  public randomize(): void {
    // Only Change 3 values
    this.barChartData[0].data = [
      Math.round(Math.random() * 100),
      59,
      80,
      (Math.random() * 100),
      56,
      (Math.random() * 100),
      40];
  }

}
