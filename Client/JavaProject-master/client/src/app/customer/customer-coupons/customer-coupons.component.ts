import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../../services/customer.service';

@Component({
  selector: 'app-customer-coupons',
  templateUrl: './customer-coupons.component.html',
  styleUrls: ['./customer-coupons.component.css']
})
export class CustomerCouponsComponent implements OnInit {

  coupons: Array<any>

  constructor(private customerService: CustomerService) { }

  ngOnInit() {
    this.customerService.getPurchasedCoupons(sessionStorage.getItem("currentUserId")).subscribe(data => {
      this.coupons = data
    })
  }

}
