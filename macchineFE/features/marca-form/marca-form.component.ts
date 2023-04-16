import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Marca } from 'src/app/core/marca.model';

@Component({
  selector: 'app-marca-form',
  templateUrl: './marca-form.component.html',
  styleUrls: ['./marca-form.component.css']
})
export class MarcaFormComponent implements OnInit {

  @Input() active: Marca = {} as Marca
  @Output() resetActive: EventEmitter<any>= new EventEmitter<any>();
  @Output() saveMarca: EventEmitter<NgForm> = new EventEmitter<NgForm>();

  constructor() { }

  ngOnInit(): void {
  }



}
