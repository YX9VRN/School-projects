import { Component, OnInit } from "@angular/core";
import { faVirus } from "@fortawesome/free-solid-svg-icons";
@Component({
  selector: "app-top-bar",
  templateUrl: "./top-bar.component.html",
  styleUrls: ["./top-bar.component.scss"],
})
export class TopBarComponent implements OnInit {
  faVirus = faVirus;
  constructor() {}
  ngOnInit(): void {}
}
