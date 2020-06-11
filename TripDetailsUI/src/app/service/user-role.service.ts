import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders,HttpEvent,HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from '../model/user.model';
import { TripDetails } from '../model/trip.model';

@Injectable()
export class UserRoleService {

  private userUrl = window["apiBaseUrl"]+"userDetails";
  private tripUrl = window["apiBaseUrl"]+"tripDetails";

  constructor(private http: HttpClient) { }

  getTripDetails(): Observable<TripDetails[]>{
	  return this.http.get<TripDetails[]>(this.tripUrl+"/get");
  }

  getCusTripDetails(userId : string): Observable<TripDetails[]>{
	  return this.http.get<TripDetails[]>(this.tripUrl+"/customer/"+ userId);
  }

  getEmpTripDetails(userId : string): Observable<TripDetails[]>{
	  return this.http.get<TripDetails[]>(this.tripUrl+"/employee/"+ userId);
  }
  
  getUsers(): Observable<User[]>{
	  return this.http.get<User[]>(this.userUrl+"/get");
  }

     /** POST: add a new user to the server */
  addUser (user: User) : Observable<User> {
    return this.http.post<User>(this.userUrl+"/create", user);
  }

  deleteUser (associateId: number) {
    return this.http.delete(this.userUrl+"/"+ associateId);
  }


  updateUser(user : User){
    const headers = new HttpHeaders({'Content-Type':'application/json; charset=utf-8'});
    this.http.put(this.userUrl+"/update", JSON.stringify(user), {headers: headers}).subscribe(() => user);
  }
 

}
