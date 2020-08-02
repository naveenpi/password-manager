import { Component, OnInit } from '@angular/core';
import { Manager } from "./../manager";
import { ManagerService } from "./../manager.service";
import { Observable } from "rxjs";
import { Router } from '@angular/router';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  passwordList: Observable<Manager[]>;
  constructor(private managerService: ManagerService,
    private router: Router) { }

  ngOnInit(): void {
    this.reloadData();
  }

  reloadData() {
    this.passwordList = this.managerService.getList();
  }

  deleteCredentials(id: number) {
    this.managerService.deleteCredentials(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }

  updateCredentials(id: number){
    this.router.navigate(['update', id]);
  }
}
