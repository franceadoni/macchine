import { Injectable } from '@angular/core';
import { MarcheStore } from './marche.store';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Marca } from 'src/app/core/marca.model';

@Injectable({
  providedIn: 'root'
})
export class MarcheService {

  constructor(
    public marcheStore: MarcheStore,
    private httpClient: HttpClient
  ) { }

  loadAll() {
    const url = environment.baseUrl + "/api/marche";
    this.httpClient.get<Marca[]>(url).subscribe(m => this.marcheStore.loadAll(m));
  }

  delete(marca: Marca) {
    const url = environment.baseUrl + "/api/marche/" + marca.id;
    this.httpClient.delete<any>(url).subscribe(m => this.marcheStore.delete(marca));
  }

  updateMarca(marca: Marca) {
    const url = environment.baseUrl + "/api/marche/" + this.marcheStore.active.id;
    this.httpClient.put<Marca>(url, marca).subscribe(m => this.marcheStore.update(m));
  }

  addMarca(marca: Marca) {
    const url = environment.baseUrl + "/api/marche";
    this.httpClient.post<Marca>(url, marca).subscribe(m => this.marcheStore.add(m));
  }

  setActive(marca: Marca) {
    this.marcheStore.setActive(marca);
  }

  resetActive() {
    this.marcheStore.resetActive();
  }

}
