import { Customer } from './../models/customer';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Company } from '../models/company';

@Injectable({
  providedIn: 'root'
})
export class managerService {

  company: Company
  customer: Customer

  constructor(private http: HttpClient) { }

  // Companies

  getAllCompanies(): Observable<any> {
    return this.http.get("/api/manager/companiesGetAll")
  }

  getCompany(id: string): Observable<any> {
    return this.http.get("/api/manager/companyGet/" + id)
  }

  saveCompany(company: Company): Observable<any> {
    return this.http.post("/api/manager/companySave", company)
  }

  removeCompany(id: string): Observable<any> {
    return this.http.get("/api/manager/companyDelete/" + id)
  }
  
  setCompanyModel(c: Company) {
    this.company = c
  }

  getCompanyModel(): Company {
    return this.company
  }
  
  // Customers

  getAllCustomers(): Observable<any> {
    return this.http.get("/api/manager/customersGetAll")
  }

  getCustomer(id: string): Observable<any> {
    return this.http.get("/api/manager/customerGet/" + id)
  }

  saveCustomer(company: Company): Observable<any> {
    return this.http.post("/api/manager/customerSave", company)
  }

  removeCustomer(id: string): Observable<any> {
    return this.http.get("/api/manager/customerDelete/" + id)
  }

  setCustomerModel(c: Customer) {
    this.customer = c
  }

  getCustomerModel(): Customer {
    return this.customer
  }

}
