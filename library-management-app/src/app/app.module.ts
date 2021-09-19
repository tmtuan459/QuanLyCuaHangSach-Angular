
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatSliderModule } from '@angular/material/slider';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ChartsModule } from 'ng2-charts';
import { Ng2OrderModule } from 'ng2-order-pipe';
import { Ng2SearchPipeModule } from 'ng2-search-filter';
import { TooltipModule } from 'ngx-bootstrap/tooltip';
import { NgxPaginationModule } from 'ngx-pagination';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AuthorDashboardComponent } from './component/author-dashboard/author-dashboard.component';
import { AutoFocusDirectiveDirective } from './component/auto-focus.directive';
import { BookDashboardComponent } from './component/book-dashboard/book-dashboard.component';
import { ImportComponent } from './component/import/import.component';
import { StatisticalComponent } from './component/statistical/statistical.component';
import { TypeDashboardComponent } from './component/type-dashboard/type-dashboard.component';







@NgModule({
  declarations: [
    AppComponent,
    BookDashboardComponent,
    TypeDashboardComponent,
    AuthorDashboardComponent,
    ImportComponent,
    StatisticalComponent,
    AutoFocusDirectiveDirective

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    Ng2SearchPipeModule,
    Ng2OrderModule,
    NgxPaginationModule,
    NgbModule,
    TooltipModule,
    MatSidenavModule,
    MatSliderModule,
    ChartsModule,




  ],
  providers: [],
  bootstrap: [AppComponent],
  // entryComponents: [NgbdModalConfirm]//

})
export class AppModule { }
