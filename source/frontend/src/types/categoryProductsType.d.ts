import { User } from "./userType";
import { Category } from "./categoryType";

export interface CategoryProducts {
  categoryId: Category,
  userId: User
}