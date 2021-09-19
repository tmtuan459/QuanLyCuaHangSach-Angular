import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'library-management-app';
  element :any;
  ClickBook() {
    this.element = document.getElementById("sach");
    this.element.classList.add("target-manu-a");
    this.element = document.getElementById("kho");
    this.element.classList.remove("target-manu-a");
    this.element = document.getElementById("thongKe");
    this.element.classList.remove("target-manu-a");
  }
  ClickWarehouse() {
    this.element = document.getElementById("sach");
    this.element.classList.remove("target-manu-a");
    this.element = document.getElementById("kho");
    this.element.classList.add("target-manu-a");
    this.element = document.getElementById("thongKe");
    this.element.classList.remove("target-manu-a");
  }
  ClickStatistical() {
    this.element = document.getElementById("sach");
    this.element.classList.remove("target-manu-a");
    this.element = document.getElementById("kho");
    this.element.classList.remove("target-manu-a");
    this.element = document.getElementById("thongKe");
    this.element.classList.add("target-manu-a");
  }

}
