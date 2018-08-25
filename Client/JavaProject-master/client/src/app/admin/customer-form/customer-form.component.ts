import { managerService } from './../../services/admin.service';
import { Component, OnInit } from '@angular/core';
import { Customer } from '../../models/customer';

@Component({
  selector: 'app-customer-form',
  templateUrl: './customer-form.component.html',
  styleUrls: ['./customer-form.component.css']
})
export class CustomerFormComponent implements OnInit {

  customer: Customer = new Customer()

  constructor(private adminService: managerService) { }

  ngOnInit() {
    this.customer = this.adminService.getCustomerModel()
  }

  saveCustomer() {
    this.adminService.saveCustomer(this.customer).subscribe(data => {
      alert("Successfully created/updated customer")
    })
  }

}
