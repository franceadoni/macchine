import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { MarcheComponent } from './features/marche/marche.component';
import { HomeComponent } from './features/home/home.component';
import { ModelliComponent } from './features/modelli/modelli.component';

const routes: Routes = [
  {
    path: "", component: HomeComponent
  },
  {
    path: "marche", component: MarcheComponent
  },
  {
    path: "modelli", component: ModelliComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
