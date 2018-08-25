import { Routes, RouterModule } from '@angular/router';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { CreateCouponComponent } from './create-coupon/create-coupon.component';
import { CompanyCouponsComponent } from './company-coupons/company-coupons.component';
import { CouponFormComponent } from './coupon-form/coupon-form.component';

const routes: Routes = [
  {
    path: 'company-coupons',
    component: CompanyCouponsComponent
  }, {
    path: 'create-coupon',
    component: CreateCouponComponent
  }, {
    path: 'coupon-form',
    component: CouponFormComponent
  }
];

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild(routes),
    FormsModule
  ],
  declarations: [CreateCouponComponent, CompanyCouponsComponent, CouponFormComponent]
})
export class CompanyModule { }
