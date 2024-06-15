import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InicioComponent } from './view/inicio/inicio.component';
import { AlterarFilmeComponent } from './view/alterar-filme/alterar-filme.component';
import { IncluirFilmeComponent } from './view/incluir-filme/incluir-filme.component';
import { ListarFilmeComponent } from './view/listar-filme/listar-filme.component';
import { ConsultarFilmeComponent } from './view/consultar-filme/consultar-filme.component';
import { FilmeService } from './service/filme.service';
import { NgModule } from '@angular/core';

@NgModule({
    declarations: [
        AppComponent,
        InicioComponent,
        AlterarFilmeComponent,
        IncluirFilmeComponent,
        ListarFilmeComponent,
        ConsultarFilmeComponent  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [FilmeService],
 // bootstrap: [AppComponent]
})
export class AppModule { }
