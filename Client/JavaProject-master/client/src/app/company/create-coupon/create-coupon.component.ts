import { CompanyService } from './../../services/company.service';
import { Component, OnInit } from '@angular/core';
import { Coupon } from '../../models/coupon';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-coupon',
  templateUrl: './create-coupon.component.html',
  styleUrls: ['./create-coupon.component.css']
})
export class CreateCouponComponent implements OnInit {

  coupon: Coupon = new Coupon();

  constructor(private companyService: CompanyService, private router: Router) { }

  ngOnInit() {
    this.companyService.setCouponModel(this.coupon)
    this.router.navigate(["company/coupon-form"])
  }

}
