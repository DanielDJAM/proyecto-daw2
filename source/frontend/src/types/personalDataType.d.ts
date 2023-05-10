import { Address } from "./addressType"

export interface PersonalData {
  dni: string,
  addressId: Address,
  age: number,
  name: string,
  surname: string
}