import { Consultorio } from "src/app/consultorio/model/consultorio";
import { Medico } from "src/app/medico/models/Medico";

export interface Consulta {
    pessoa: Medico[];
    consultorio: Consultorio[];
}
