import { UserService } from '../service/user.service';
import { UserModel } from '../model/user.model';
import { Component, OnInit } from '@angular/core';


//const baseUrl = '/principal';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  userList: UserModel[] = [];

  constructor(private userService: UserService) { }

  ngOnInit(): void {
      this.userService.getAll().subscribe(response => {
        this.userList = response;
      })
  }
  displayedColumns: string[] = ['Veiculo', 'Marca', 'Ano', 'Descrição', 'Cor', 'Vendido', 'Data de Criação', 'Data de Atualização'];
  dataSource = this.userList;

  
}
