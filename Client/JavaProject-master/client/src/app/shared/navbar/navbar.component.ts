import { LoginService } from './../../services/login.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  constructor(private loginService: LoginService, private router: Router) { }

  ngOnInit() {
  }

  isUserType(type: string): boolean {
    return sessionStorage.getItem("currentUserType") === type
  }

  logout() {
    sessionStorage.clear()
    this.loginService.logout().subscribe(data => {
      console.log(data)
      this.router.navigate(["login"])
    })
  }
}
