import { LoginComponent } from './login/login.component';

export const AppRoutes = [{
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
}, {
    path: 'login',
    component: LoginComponent
}, {
    path: 'customer',
    loadChildren: './customer/customer.module#CustomerModule'
}, {
    path: 'company',
    loadChildren: './company/company.module#CompanyModule'
}, {
    path: 'admin',
    loadChildren: './admin/admin.module#AdminModule'
}]