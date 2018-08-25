import { managerService } from './../../services/admin.service';
import { Component, OnInit } from '@angular/core';
import { Customer } from '../../models/customer';
import { Router } from '@angular/router';

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {

  customers: Array<Customer>

  constructor(private adminService: managerService, private router: Router) { }

  ngOnInit() {
    this.adminService.getAllCustomers().subscribe(data => {
      this.customers = data
    })
  }

  createCustomer() {
    const customer: Customer = new Customer()
    this.adminService.setCustomerModel(new Customer())
    this.router.navigate(["admin/customer-form"])
  }

  editCustomer(id: string) {
    this.adminService.getCustomer(id).subscribe(data => {
      const customer: Customer = data
      this.adminService.setCustomerModel(customer)
      this.router.navigate(["admin/customer-form"])
    })
  }

  removeCustomer(id: string) {
    this.adminService.removeCustomer(id).subscribe(data => {
      window.location.reload()
    })
  }

}
