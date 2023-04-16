import { Injectable } from "@angular/core";
import { Marca } from "src/app/core/marca.model";

@Injectable({
  providedIn: 'root'
})

export class MarcheStore {

  marche: Marca[] = []
  active: Marca = {} as Marca

  loadAll(marche: Marca[]) {
    this.marche = marche;
  }

  delete(marca: Marca) {
    this.marche = this.marche.filter(m => m.id !== marca.id);
  }

  update(marca: Marca) {
    this.marche = this.marche.map(m => m.id === marca.id ? marca : m);
  }

  add(marca: Marca) {
    this.marche = [...this.marche, marca];
  }

  setActive(marca: Marca) {
    this.active = marca;
  }

  resetActive() {
    this.active = {} as Marca;
  }

}
