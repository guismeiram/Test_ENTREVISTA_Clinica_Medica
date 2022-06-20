import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ConsultorioService } from '../services/consultorio.service';
import { Location } from '@angular/common';


@Component({
  selector: 'app-consultorio-form',
  templateUrl: './consultorio-form.component.html',
  styleUrls: ['./consultorio-form.component.scss']
})
export class ConsultorioFormComponent implements OnInit {

  form: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private service: ConsultorioService,
    private snackBar: MatSnackBar,
    private location: Location) { 
    this.form = this.formBuilder.group({
      numero: [null],
      data_hora: [null]
    });
  }

  ngOnInit(): void {
  }
 
  onSubmit() {
    this.service.save(this.form.value)
      .subscribe(result => this.onSuccess(), error => this.onError());
  }

  onCancel() {
    this.location.back();
  }

  
  private onSuccess() {
    this.snackBar.open('Medico salvo com sucesso!', '', { duration: 5000 });
    this.onCancel();
  }

  private onError() {
    this.snackBar.open('Erro ao salvar Medico.', '', { duration: 5000 });
  }

}
