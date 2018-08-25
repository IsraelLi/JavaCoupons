import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CustomerCouponsComponent } from './customer-coupons/customer-coupons.component';
import { PurchaseCouponsComponent } from './purchase-coupons/purchase-coupons.component';

const routes: Routes = [{
  path: 'customer-coupons',
  component: CustomerCouponsComponent
}, {
  path: 'purchase-coupons',
  component: PurchaseCouponsComponent
}]

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes)
  ],
  declarations: [CustomerCouponsComponent, PurchaseCouponsComponent]
})
export class CustomerModule { }
