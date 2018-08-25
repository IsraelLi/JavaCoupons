import { Router } from '@angular/router';
import { catchError } from 'rxjs/operators';
import { Observable } from 'rxjs';
import { Injectable } from "@angular/core";
import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent, HttpErrorResponse } from '@angular/common/http';
import { throwError } from 'rxjs';


@Injectable()
export class ErrorInterceptor implements HttpInterceptor {

    constructor(private router: Router) {}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // install an error handler
        return next.handle(req).pipe(
            catchError((err: HttpErrorResponse) => {
                if (err.error instanceof Error) {
                    // A client-side or network error occurred. Handle it accordingly.
                    console.log('An internal Angularerror occurred:', err.error.message);
                }

                switch (err.status) {
                    case 401:
                        alert("כניסה נכשלה בבקשה נסה שוב")
                        this.router.navigate(["login"]);
                        break;
                    case 400:
                        alert(err.error.message);
                        break;
                    case 500:
                        console.log("INTERNAL SERVER ERROR", err.error.message);
                        break;
                }
                return throwError(new Error('ERROR HAS BEEN HANDLED!'));
            })
        ) 
    }
}