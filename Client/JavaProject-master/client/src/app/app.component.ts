import { Component } from '@angular/core';
import { LoginService } from './services/login.service';
import { CompanyService } from './services/company.service';
import { catchError, map } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
}
