import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AuthService  } from "./auth.service";

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    constructor(private authService: AuthService) { }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add authorization header with jwt token if available
        let token = this.authService.getToken();
        const re = '/login';
        if (request.url.search(re) === -1) {
        if (token) {
            console.log("Current user added token")
            request = request.clone({
                setHeaders: {
                    Authorization: `Token ${token}`
                }
            });
        }
    }

        return next.handle(request);
    }
}