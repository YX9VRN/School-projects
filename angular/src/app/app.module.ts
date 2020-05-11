import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";
import { HttpClientInMemoryWebApiModule } from "angular-in-memory-web-api";
import { InMemoryDataService } from "./inMemoryData.service";
import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { HttpClientModule } from "@angular/common/http";
import { CaseListComponent } from "./case-list/case-list.component";
import { CaseService } from "./Case.service";
import { TopBarComponent } from "./top-bar/top-bar.component";
import { CaseDetailsComponent } from "./case-details/case-details.component";
import { FontAwesomeModule } from "@fortawesome/angular-fontawesome";
import { NewCaseComponent } from "./new-case/new-case.component";
import { NgbModule } from "@ng-bootstrap/ng-bootstrap";
import { FormsModule } from "@angular/forms";
import { BrowserAnimationsModule } from "@angular/platform-browser/animations";
import { DatePipe } from "@angular/common";
@NgModule({
  declarations: [
    AppComponent,
    CaseListComponent,
    TopBarComponent,
    CaseDetailsComponent,
    NewCaseComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    HttpClientInMemoryWebApiModule.forRoot(InMemoryDataService, {
      dataEncapsulation: false,
    }),
    FontAwesomeModule,
    NgbModule,
    FormsModule,
    BrowserAnimationsModule,
  ],
  providers: [CaseService, DatePipe],
  bootstrap: [AppComponent],
})
export class AppModule {}
