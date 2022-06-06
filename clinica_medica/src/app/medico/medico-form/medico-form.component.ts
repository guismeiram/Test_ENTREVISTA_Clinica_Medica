import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { MedicoService } from '../services/medico.service';
import { Location } from '@angular/common';


@Component({
  selector: 'app-medico-form',
  templateUrl: './medico-form.component.html',
  styleUrls: ['./medico-form.component.scss']
})
export class MedicoFormComponent implements OnInit {

  form: FormGroup;

  constructor(private formBuilder: FormBuilder,
    private service: MedicoService,
    private snackBar: MatSnackBar,
    private location: Location) { 
    this.form = this.formBuilder.group({
            crm: [null],
            especialidade: [null],
            nome: [null],
            idade: [null],
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

