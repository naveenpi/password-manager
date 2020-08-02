import { Component, OnInit } from '@angular/core';
import { ManagerService } from "./../manager.service";
import { Observable } from "rxjs";
import { Router } from '@angular/router';
import { Manager } from '../manager';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {


  manager: Manager = new Manager();
  submitted = false;

  constructor(private managerService: ManagerService,
    private router: Router) { }

  ngOnInit(): void {
  }

  save() {
     
    this.managerService.createCredentials(this.manager)
      .subscribe(data => console.log(data), error => console.log(error));
    this.manager = new Manager();
    this.gotoList();
  }

  onSubmit() {
    this.submitted = true;
    this.save();    
  }

  gotoList() {
    this.router.navigate(['/list']);
  }

}
