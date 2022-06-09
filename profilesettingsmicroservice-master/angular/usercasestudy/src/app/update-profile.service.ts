import { HttpClient, HttpClientModule, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from 'src/User';
import { SqlauthService } from './sqlauth.service';
import {tap} from 'rxjs/operators';

const baseUrl='http://localhost:9091/api/user';
@Injectable({
  providedIn: 'root'
})


export class UpdateProfileService {
  uid:String=sessionStorage.getItem('userId');
  constructor(private http: HttpClient) {}
  /*
  users:Array<User>=[];
  usersub:BehaviorSubject<Array<User>>;
  currentusersub:BehaviorSubject<User>;
  curruser:Observable<User>;
  //private baseUrl='http://localhost:9001/api/user';
  constructor(private http: HttpClient,private auth: SqlauthService) {
    this.usersub = new BehaviorSubject<Array<User>>([]);
    this.currentusersub=new BehaviorSubject<User>(JSON.parse(localStorage.getItem('curruser')));
    this.curruser=this.currentusersub.asObservable();
  }

 fetchDatafromServer()
 {
    
  let tok=this.auth.getToken();
  return this.http.get<Array<User>>('http://localhost:9001/api/user',
  {
    headers: new HttpHeaders().set('Authorization',`Bearer ${tok}` )
  }).subscribe(
    (res)=> {
      this.users=res;
      this.usersub?.next(this.users);
    }
  );

  
   }


   getUser():any
   {
    return this.currentusersub.value;
   }
   
   updateUser(user:User):Observable<object>
   {
      let tok=this.auth.getToken();
  
      return this.http.put(`http://localhost:9001/api/user/updateUserDetails`,
      user,
      {
        headers: new HttpHeaders().set('Authorization',`Bearer ${tok}` )
      }
      ).pipe
      (
        tap( (modiobj)=>
             {
               let updatedele=this.users.find ( usr=> usr.userId ===user.userId);
               Object.assign(updatedele,modiobj);
               this.usersub.next(this.users);
             }
       )
      )
    }
  */
    getUser(id):Observable<User>
    {
    
        return this.http.get<User>('${baseUrl)/view/${id}');
    }
    updateUser(user:User):Observable<User>
    {
      
        return this.http.put<User>('${baseUrl}/updateUserDetails',user)
    }

}
