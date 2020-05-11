import { NgModule, Component } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { CaseListComponent } from "./case-list/case-list.component";
import { CaseDetailsComponent } from "./case-details/case-details.component";
import { NewCaseComponent } from "./new-case/new-case.component";

const routes: Routes = [
  { path: "", component: CaseListComponent },
  { path: "cases/new", component: NewCaseComponent, pathMatch: "full" },
  { path: "cases/:id", component: CaseDetailsComponent },
  { path: "cases/:id/edit", component: NewCaseComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
