import { HttpClient, HttpClientModule, HttpErrorResponse, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, throwError } from 'rxjs';
import { User } from 'src/app/User';
import {catchError, tap} from 'rxjs/operators';
import { AuthenticationService } from './authentication.service';
import { RoutingService } from './routing.service';

//const baseUrl='http://localhost:9091/api/user';
@Injectable({
  providedIn: 'root'
})


export class UpdateProfileService {
  
  
  users:Array<User>=[];
  usersub:BehaviorSubject<Array<User>>;
  uId:String;
  user:User;
  currentuser:User;

  //private baseUrl='http://localhost:9001/api/user';
  constructor(private http: HttpClient,private auth: AuthenticationService,private routingservice: RoutingService) {
    this.usersub = new BehaviorSubject<Array<User>>([]);
    this.uId=routingservice.getid();
    this.user=new User();
    this.currentuser=new User();
    
  }

 fetchDatafromServer()
 {
    
  let tok=this.auth.getToken();
  return this.http.get<Array<User>>(`http://localhost:9090/api/user`,
  {
    headers: new HttpHeaders().set('Authorization',`Bearer ${tok}` )
  }).subscribe(
    (res)=> {
      this.users=res;
      this.usersub?.next(this.users);
    }
  );

  
   }

   getUsers():BehaviorSubject<Array<User>>{
     return this.usersub;
   }
   getUser()
   {
    for(var usr of this.users ){
      if(usr.userId == this.uId){
        this.currentuser=usr;
        //console.log(usr.firstName,usr.lastName,usr.mobileNumber,usr.password);
      }
    }
    return this.currentuser;
   }
   viewUser():any
   {
     let tok=this.auth.getToken();
     return this.http.get<User>(`http://localhost:9090/api/user/view/${this.uId}`,
     {
      headers: new HttpHeaders().set('Authorization',`Bearer ${tok}` )
    }).pipe(
      catchError(this.handleError)
    );
   }
   
   updateUser(user:User):Observable<object>
   {
      let tok=this.auth.getToken();
  
      return this.http.put<User>(`http://localhost:9090/api/user/updateUserDetails/${this.uId}`,
      user,
      {
        headers: new HttpHeaders().set('Authorization',`Bearer ${tok}` )
      }
      ).pipe
      (
        tap( (modiobj)=>
             {
               let updatedele=this.users.find ( usr=> usr.userId ===this.uId);
               Object.assign(updatedele,modiobj);
               this.usersub?.next(this.users);
             }
       )
      )
    }
  /*
    getUser(id):Observable<User>
    {
    
        return this.http.get<User>('${baseUrl)/view/${id}');
    }
    updateUser(user:User):Observable<User>
    {
      
        return this.http.put<User>('${baseUrl}/updateUserDetails',user)
    }
    */
    private handleError(error: HttpErrorResponse) {
      if (error.status === 0) {
        // A client-side or network error occurred. Handle it accordingly.
        console.error('An error occurred:', error.error);
      } else {
        // The backend returned an unsuccessful response code.
        // The response body may contain clues as to what went wrong.
        console.error(
          `Backend returned code ${error.status}, body was: `, error.error);
      }
      // Return an observable with a user-facing error message.
      return throwError(
        'Something bad happened; please try again later.');
    }


}
