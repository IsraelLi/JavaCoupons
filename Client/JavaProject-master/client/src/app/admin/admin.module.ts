import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CompanyListComponent } from './company-list/company-list.component';
import { CompanyFormComponent } from './company-form/company-form.component';
import { CustomerListComponent } from './customer-list/customer-list.component';
import { CustomerFormComponent } from './customer-form/customer-form.component';

const routes: Routes = [
  {
    path: 'company-list',
    component: CompanyListComponent
  }, {
    path: 'company-form',
    component: CompanyFormComponent
  }, {
    path: 'customer-list',
    component: CustomerListComponent
  }, {
    path: 'customer-form',
  component: CustomerFormComponent
  }
]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule
  ],
  declarations: [CompanyListComponent, CompanyFormComponent, CustomerListComponent, CustomerFormComponent]
})
export class AdminModule { }
