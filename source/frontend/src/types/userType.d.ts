import { PersonalData } from "./personalDataType"

export interface User {
  userId: string,
  dni: PersonalData,
  username: string,
  email: string,
  password: string
}

