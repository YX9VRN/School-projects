import { Component, OnInit } from "@angular/core";
import {
  faCross,
  faHeart,
  faVirus,
  faCalendar,
} from "@fortawesome/free-solid-svg-icons";
import { CaseService } from "../Case.service";
import { Router, ActivatedRoute, ParamMap } from "@angular/router";
import { Status } from "../Status";
import { Case } from "../Case";
import { Observable } from "rxjs";
import { switchMap } from "rxjs/operators";
import { DatePipe } from "@angular/common";
import * as moment from "moment";
@Component({
  selector: "app-new-case",
  templateUrl: "./new-case.component.html",
  styleUrls: ["./new-case.component.scss"],
})
export class NewCaseComponent implements OnInit {
  //font-awesome icons
  faCalendar = faCalendar;
  faCross = faCross;
  faHeart = faHeart;
  faVirus = faVirus;

  case: Case = new Case("", "", "", "", "Positive");
  id: string;
  mode: "new" | "edit";

  constructor(
    private svc: CaseService,
    private router: Router,
    private route: ActivatedRoute,
    private datePipe: DatePipe
  ) {}

  ngOnInit(): void {
    this.route.url.subscribe((e) => {
      if (e[1].path === "new") {
        this.mode = "new";
      } else {
        this.mode = "edit";
      }
    });
    this.route.paramMap.subscribe((params) => {
      this.id = params.get("id");
    });
    if (this.id) {
      this.svc.getCase$(this.id).subscribe((data) => {
        this.case = data;
      });
    }
  }
  update() {
    let currentDate = new Date();
    this.case.updated = this.datePipe.transform(currentDate, "yyyy-MM-dd");
    this.svc.updateCase(this.id, this.case).subscribe(() => {
      this.router.navigateByUrl("");
    });
  }
  newCase() {
    this.svc
      .createCase({
        firstName: this.case.firstName,
        lastName: this.case.lastName,
        updated: this.case.updated,
        dateOfBirth: this.case.dateOfBirth,
        status: this.case.status,
        imgUrl: this.case.imgUrl,
      })
      .subscribe(() => {
        this.router.navigateByUrl("");
      });
  }
}
