import { AcademicQual } from "./academic-qual";
import { Address } from "./address";

export class Student {
    id: number;
    regId: string;
    institutionId: string;
    firstName: string;
    lastName: string;
    email: string;
    regDate: string;
    dateOfBirth: string;
    age: number;
    gender: string;
    nid: number;
    occupation: string;
    homeContact: string;
    stdContact: string;
    address: Address= new Address() ;
    academicQualList: AcademicQual[] = [];
    photo: string;
    createdOn: string;
    createdBy: string;
}
