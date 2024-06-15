import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { InicioComponent } from './view/inicio/inicio.component';
import { AlterarFilmeComponent } from './view/alterar-filme/alterar-filme.component';
import { IncluirFilmeComponent } from './view/incluir-filme/incluir-filme.component';
import { ListarFilmeComponent } from './view/listar-filme/listar-filme.component';
import { ConsultarFilmeComponent } from './view/consultar-filme/consultar-filme.component';

const routes: Routes = [
  { path: '', component: InicioComponent },
  { path: 'alterar-filme', component: AlterarFilmeComponent },
  { path: 'incluir-filme', component: IncluirFilmeComponent },
  { path: 'listar-filme', component: ListarFilmeComponent },
  { path: 'consultar-filme', component: ConsultarFilmeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
