import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router, ParamMap } from "@angular/router";
import { Case } from "../Case";
import { CaseService } from "../Case.service";
import { NgbModal, ModalDismissReasons } from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: "app-case-details",
  templateUrl: "./case-details.component.html",
  styleUrls: ["./case-details.component.scss"],
})
export class CaseDetailsComponent implements OnInit {
  id: string;
  case: Case;
  closeResult = "";

  constructor(
    private route: ActivatedRoute,
    private svc: CaseService,
    private router: Router,
    private modalSvc: NgbModal
  ) {}
  ngOnInit(): void {
    this.route.paramMap.subscribe((params) => {
      this.id = params.get("id");
    });
    this.svc.getCase$(this.id).subscribe((data) => {
      this.case = data;
    });
  }
  delete() {
    this.svc.deleteCase(this.id).subscribe(() => {
      this.router.navigateByUrl("");
    });
  }
  open(content) {
    this.modalSvc
      .open(content, { ariaLabelledBy: "modal-basic-title" })
      .result.then(
        (result) => {
          this.closeResult = `${result}`;
          console.log(this.closeResult);
        },
        (reason) => {
          this.closeResult = `Dismissed ${this.getDismissReason(reason)}`;
        }
      );
  }
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return "by pressing ESC";
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return "by clicking on a backdrop";
    } else {
      return `with: ${reason}`;
    }
  }
}
