import { HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { SessionStorageService } from 'angular-web-storage';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MyInterceptorService {
  constructor(private session: SessionStorageService) { }
  //function which will be called for all http calls
  intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    const token1 = this.session.get('token');
    let newHeaders = req.headers;

    if (token1) {
      newHeaders = newHeaders.append('Authorization', token1)

      // newHeaders.append('Access-Control-Allow-Origin', '*');

    }
      newHeaders.append('Access-Control-Allow-Origin', '*');

    const authReq = req.clone({ headers: newHeaders });
    return next.handle(authReq);



  }
}
