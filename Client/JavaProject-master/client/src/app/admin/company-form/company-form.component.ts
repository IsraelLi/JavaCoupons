import { managerService } from './../../services/admin.service';
import { Component, OnInit, Input } from '@angular/core';
import { Company } from '../../models/company';

@Component({
  selector: 'app-company-form',
  templateUrl: './company-form.component.html',
  styleUrls: ['./company-form.component.css']
})
export class CompanyFormComponent implements OnInit {

  company: Company = new Company()

  constructor(private adminService: managerService) { }

  ngOnInit() {
    this.company = this.adminService.getCompanyModel()
  }

  saveCompany() {
    this.adminService.saveCompany(this.company).subscribe(data => {
      
    })
  }
}