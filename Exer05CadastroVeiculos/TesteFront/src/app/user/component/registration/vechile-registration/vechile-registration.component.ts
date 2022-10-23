import { UserModel } from './../../model/user.model';
import { UserService } from '../../service/user.service';
import { FloatLabelType } from '@angular/material/form-field';
import { FormControl, FormBuilder } from '@angular/forms';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Location } from '@angular/common';

@Component({
  selector: 'app-vechile-registration',
  templateUrl: './vechile-registration.component.html',
  styleUrls: ['./vechile-registration.component.css']
})
export class VechileRegistrationComponent implements OnInit {

  

  constructor(private _formBuilder: FormBuilder, private vehicleService : UserService, private location: Location, public vehicleModel: UserModel, private snackBar: MatSnackBar) { }

  ngOnInit(): void {
  }

  hideRequiredControl = new FormControl(false);
  floatLabelControl = new FormControl('auto' as FloatLabelType);

  options = this._formBuilder.group({
    hideRequired: this.hideRequiredControl,
    floatLabel: this.floatLabelControl,
  });

  onSubmit() {
    this.vehicleService.save(this.vehicleModel).subscribe(result => this.onSucess(), error => this.onError());

  }

  private onSucess() {
    this.snackBar.open('New Veiculo add!', '', {duration: 5000});
    this.location.back();
  }

  private onError(){
    this.snackBar.open('Error when save Veiculo!', '', {duration: 5000});
  }
}
