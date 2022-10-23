import { UserService } from '../service/user.service';
import { UserModel } from '../model/user.model';
import { Component, OnInit } from '@angular/core';
import {MatDialog} from '@angular/material/dialog';
import { VechileRegistrationComponent } from '../registration/vechile-registration/vechile-registration.component';


//const baseUrl = '/principal';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  userList: UserModel[] = [];

  constructor(private userService: UserService, public dialog: MatDialog) { }

  ngOnInit(): void {
      this.userService.getAll().subscribe(response => {
        this.userList = response;
      })
  }
  displayedColumns: string[] = ['Veiculo', 'Marca', 'Ano', 'Descrição', 'Cor', 'Vendido', 'Data de Criação', 'Data de Atualização'];
  dataSource = this.userList;

  openDialog(): void {
    const dialogRef = this.dialog.open(VechileRegistrationComponent, {
      width: '500px',
      data: {name: "sim", animal: "this.animal"},
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
      //this.animal = result;
    });
  }

 

  
}
