import { Component, OnInit } from '@angular/core';
import { Marca } from 'src/app/core/marca.model';
import { MarcheService } from './marche.service';
import { MarcheStore } from './marche.store';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-marche',
  templateUrl: './marche.component.html',
  styleUrls: ['./marche.component.css']
})
export class MarcheComponent implements OnInit {

  showToast = "";


  constructor(
    private marcheService: MarcheService,
    public marcheStore: MarcheStore
  ) { }

  ngOnInit(): void {
    this.marcheService.loadAll();
  }


  deleteMarca(marca: Marca) {
    if(confirm("Are you sure to delete " + marca.nome + "?")) {
      this.marcheService.delete(marca);
      this.showToast = "Hai cancellato un elemento, scemo!";
      setTimeout(() => {this.showToast = ""}, 3000);
    }
  }

  saveMarca(form: NgForm) {
    if(this.marcheStore.active.id) {
      this.updateMarca(form);
    } else {
      this.addMarca(form);
    }
  }

  updateMarca(form: NgForm) {
    const newMarca = {
      nome: form.value.nome,
      sede: form.value.sede
    }
    this.marcheService.updateMarca(newMarca);
    this.resetActive();
    this.showToast = "Hai modificato un elemento, hai fatto bene!";
    setTimeout(() => {this.showToast = ""}, 3000);
  }

  addMarca(form: NgForm) {
    const newMarca = {
      nome: form.value.nome,
      sede: form.value.sede
    }
    this.marcheService.addMarca(newMarca);
    this.showToast = "Hai aggiunto un elemento, miao miao!";
    setTimeout(() => {this.showToast = ""}, 3000);
  }

  setActive(marca: Marca) {
    this.marcheService.setActive(marca);
  }

  resetActive() {
    this.marcheService.resetActive();
  }

}
