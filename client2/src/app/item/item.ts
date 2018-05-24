import { Category } from "./category";
import { Status } from "./status";
import { Person } from "../person/person";

export class Item {
    id: number;
    name: string;
    description: string;
    category: Category;
    initialValue: number;
    purchaseDate: Date;
    status: Status;
    owner: Person;
}
