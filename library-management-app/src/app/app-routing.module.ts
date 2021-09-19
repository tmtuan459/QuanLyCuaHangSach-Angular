import { StatisticalComponent } from './component/statistical/statistical.component';
import { ImportComponent } from './component/import/import.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AuthorDashboardComponent } from './component/author-dashboard/author-dashboard.component';
import { BookDashboardComponent } from './component/book-dashboard/book-dashboard.component';
import { TypeDashboardComponent } from './component/type-dashboard/type-dashboard.component';



const routes: Routes = [
    { path: '', redirectTo: 'books-dashboard', pathMatch: 'full' },
    { path: 'books-dashboard', component: BookDashboardComponent },
    { path:'author-dashboard',component: AuthorDashboardComponent},
    { path: 'type-dashboard', component: TypeDashboardComponent},
    { path: 'import', component: ImportComponent},
    { path: 'statistical', component: StatisticalComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
