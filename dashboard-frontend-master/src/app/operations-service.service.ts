import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class OperationsServiceService {

  constructor(private httpcli : HttpClient) { }

  adduser(data:any):Observable<any>
  {
    return this.httpcli.post('',data);
  }

}
