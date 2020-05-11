import { Status } from "./Status";
export class Case {
  constructor(
    public firstName: string,
    public lastName: string,
    public updated: string,
    public dateOfBirth: string,
    public status: Status,
    public id?: number,
    public imgUrl?: string
  ) {}
}
