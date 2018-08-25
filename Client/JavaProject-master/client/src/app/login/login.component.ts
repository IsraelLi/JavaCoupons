import { catchError } from 'rxjs/operators';
import { LoginService } from './../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  model: any = {}
  types: Array<string> = ["COMPANY", "CUSTOMER", "ADMIN"]

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.loginService.login(this.model.email, this.model.password, this.model.type).subscribe(data => {
      console.log("Logged in", data);
      sessionStorage.setItem("currentUserId", JSON.parse(data).id)
      sessionStorage.setItem("currentUserType", JSON.parse(data).type)

      switch(JSON.parse(data).type) {
        case "COMPANY":
          this.router.navigate(["company/company-coupons"])
          break
        case "CUSTOMER":
          this.router.navigate(["customer/customer-coupons"])
          break
        case "ADMIN":
          this.router.navigate(["admin/company-list"])
          break
      }
    })
  }

  
}
