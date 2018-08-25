import { CompanyService } from './../../services/company.service';
import { Component, OnInit } from '@angular/core';
import { Coupon } from '../../models/coupon';
import { Router } from '@angular/router';

@Component({
  selector: 'app-company-coupons',
  templateUrl: './company-coupons.component.html',
  styleUrls: ['./company-coupons.component.css']
})
export class CompanyCouponsComponent implements OnInit {

  coupons: Array<any>

  constructor(private companyService: CompanyService, private router: Router) { }

  ngOnInit() {
    this.companyService.getAllCoupons(sessionStorage.getItem("currentUserId")).subscribe(data => {
      this.coupons = data;
    })
  }

  deleteCoupon(couponId: string) {
    this.companyService.deleteCoupon(couponId).subscribe(data => {
      console.log("Successfully deleted coupon", data);
      window.location.reload()
    })
  }

  updateCoupon(id: string) {
    this.companyService.getCoupon(id).subscribe(data => {
      this.companyService.setCouponModel(data)
      this.router.navigate(["company/coupon-form"])
    })
  }

}
