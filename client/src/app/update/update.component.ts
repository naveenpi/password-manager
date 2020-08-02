import { Component, OnInit } from '@angular/core';
import { Manager } from '../manager';
import { ActivatedRoute, Router } from '@angular/router';
import { ManagerService } from '../manager.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  id: string;
  manager: Manager;
  constructor(private route: ActivatedRoute,private router: Router,
    private managerService: ManagerService) { }

  ngOnInit(): void {

    this.manager = new Manager();

    this.id = this.route.snapshot.paramMap.get("id");
    
    this.managerService.getCredentials(Number(this.id))
      .subscribe(data => {
        console.log(data)
        this.manager = data;
      }, error => console.log(error));
  }

  updateCredentials() {
    this.managerService.updateCredentials(Number(this.id), this.manager)
      .subscribe(data => console.log(data), error => console.log(error));
    this.manager = new Manager();
    this.gotoList();
  }

  onSubmit() {
    this.updateCredentials();    
  }

  gotoList() {
    this.router.navigate(['/list']);
  }
}
