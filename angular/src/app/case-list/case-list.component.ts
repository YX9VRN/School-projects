import { Component, OnInit } from "@angular/core";
import { CaseService } from "../Case.service";
import { Case } from "../Case";
import { faCross, faHeart, faVirus } from "@fortawesome/free-solid-svg-icons";
@Component({
  selector: "app-case-list",
  templateUrl: "./case-list.component.html",
  styleUrls: ["./case-list.component.scss"],
})
export class CaseListComponent implements OnInit {
  faCross = faCross;
  faHeart = faHeart;
  faVirus = faVirus;

  cases: Case[];

  mode: "card" | "list" = "card";
  constructor(private svc: CaseService) {}

  ngOnInit(): void {
    this.svc.getCases$().subscribe((data) => {
      this.cases = data;
    });
  }
  changeMode() {
    this.mode = this.mode === "card" ? "list" : "card";
  }
}
