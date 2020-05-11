import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";
import { Case } from "./Case";
import { Injectable } from "@angular/core";
@Injectable()
export class CaseService {
  constructor(private http: HttpClient) {}
  private casesUrl = "api/cases";

  getCases$(): Observable<Case[]> {
    return this.http.get<Case[]>(this.casesUrl);
  }
  getCase$(id: string): Observable<Case> {
    return this.http.get<Case>(`${this.casesUrl}/${id}`);
  }
  deleteCase(id: string) {
    return this.http.delete(`${this.casesUrl}/${id}`);
  }
  createCase(newCase: Case) {
    return this.http.post(`${this.casesUrl}`, newCase);
  }
  updateCase(id: string, updateCase: Case) {
    return this.http.put(`${this.casesUrl}/${id}`, updateCase);
  }
}
