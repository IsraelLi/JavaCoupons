import { CompanyService } from './../../services/company.service';
import { Coupon } from './../../models/coupon';
import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-coupon-form',
  templateUrl: './coupon-form.component.html',
  styleUrls: ['./coupon-form.component.css']
})
export class CouponFormComponent implements OnInit {

  @Input() 
  coupon: Coupon = new Coupon()
  types: Array<string>

  constructor(private companyService: CompanyService, private router: Router) { }

  ngOnInit() {
    this.coupon = this.companyService.getCouponModel()
    this.companyService.getCouponTypes().subscribe(data => {
      this.types = data;
    })
  }

  submit() {
    if (this.coupon.id) {
      this.companyService.updateCoupon(this.coupon).subscribe(data => {
        alert("Coupon successfully updated")
      })
    } else {
      this.companyService.createCoupon(this.coupon, sessionStorage.getItem("currentUserId")).subscribe(data => {
        alert("Coupon successfully created")   
      })
    }
  }

}
