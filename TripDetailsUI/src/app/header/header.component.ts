import { Component, OnInit,ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from '../auth/token-storage.service';
import { UserRoleService } from '../service/user-role.service';
import { TripDetails } from '../model/trip.model';
import {MatPaginator, MatTableDataSource,MatDialog ,MatSort } from '@angular/material';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  info: any;
  
  
  displayedColumns: string[] = ['customerName','employeeName','vehicleNo','fromLocation',
        'toLocation','vehicleType','seater','travelCost','travelStatus','travelDate','travelTime'];
   dataSource = new MatTableDataSource<TripDetails>();
   
   @ViewChild(MatPaginator) paginator: MatPaginator;
   @ViewChild(MatSort) sort: MatSort;


  constructor(private router: Router,public token: TokenStorageService,public tripService : UserRoleService) { }

  ngOnInit() {
    this.userAuthenticate(); 
    if(this.info.role == 'ADMIN') {
      this.getAllTripDetails(); 
    } else if(this.info.role == 'CUSTOMER') {
      this.getTripDetailsOfCustomer();
    }else{
      this.getTripDetailsOfEmployee();
    }
    
  }

  userAuthenticate() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      role: this.token.getRole()
    };
    if(this.info.role == null || this.info.token == null || this.info.username == null){
      this.router.navigate(['/denied']);
    }
  }
  getAllTripDetails() {
    
    this.dataSource = new MatTableDataSource<TripDetails>();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;

    this.tripService.getTripDetails().subscribe(
      trip => {
        this.dataSource.data = trip as TripDetails[];

      }
    );
    console.log(this.dataSource.data);
  }

  getTripDetailsOfCustomer() {
    
    this.dataSource = new MatTableDataSource<TripDetails>();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;

    this.tripService.getCusTripDetails(this.info.username).subscribe(
      trip => {
        this.dataSource.data = trip as TripDetails[];

      }
    );
    console.log(this.dataSource.data);
  }

  getTripDetailsOfEmployee() {
    
    this.dataSource = new MatTableDataSource<TripDetails>();
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;

    this.tripService.getEmpTripDetails(this.info.username).subscribe(
      trip => {
        this.dataSource.data = trip as TripDetails[];

      }
    );
    console.log(this.dataSource.data);
  }

  logout() {
    this.token.signOut();
    window.location.reload();
  }
}

