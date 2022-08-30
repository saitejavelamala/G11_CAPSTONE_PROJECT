import { Component, OnInit } from '@angular/core';
import { User } from '../user';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})

export class RegisterComponent implements OnInit {

  constructor( private userService:UserService , private router:Router) { }

  ngOnInit(): void {
    this.currentuser=this.userService.giveUserData()
    if(this.currentuser.id !==0){
      alert("Already Logged")
      this.router.navigate(['/user'])
    }
  }
  Register(data:any) {

    this.currentuser.password=data.password
    this.currentuser.phoneNumber=data.mNumber
    this.currentuser.email=data.email
    this.currentuser.name=data.fName+" "+data.lName
		 this.userService.userRegister(this.currentuser).subscribe((data)=>{
      this.currentuser=data
     },err =>{
      alert("User Already Registered")
      this.router.navigate(['/login'])
     }

     )
	}

  currentuser=new User()

  

}
