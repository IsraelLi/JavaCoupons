import { Company } from './../../models/company';
import { managerService } from './../../services/admin.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {

  companies: Array<Company>

  constructor(private managerService: managerService, private router: Router) { }

  ngOnInit() {
    this.managerService.getAllCompanies().subscribe(data => {
      this.companies = data
    })
  }

  createCompany() {
    const company: Company = new Company()
    this.managerService.setCompanyModel(new Company())
    this.router.navigate(["admin/company-form"])
  }

  editCompany(id: string) {
    this.managerService.getCompany(id).subscribe(data => {
      const company: Company = data
      this.managerService.setCompanyModel(company)
      this.router.navigate(["admin/company-form"])
    })
  }

  removeCompany(id: string) {
    this.managerService.removeCompany(id).subscribe(data => {
      window.location.reload()
    })
  }
}
