import React from "react"; // Import React
import { Link } from "react-router-dom"; // Import Link from React Router
import "./SettingsPage.scss";
import logoamadeus from "../../../client/src/assets/images/logoamadeus.png"; // Import logo images
import logohome from "../../../client/src/assets/images/logohome.png"; // Import home logo

const Settings = () => {
  return (
    <>
      <header className="page__header">
          <Link to="/menu">
            <img className="logoamadeus" src={logoamadeus} alt="Logo Amadeus" />
            <img className="logohome" src={logohome} alt="Home Logo" />
          </Link>
      </header>

      <h2>Configuraciones</h2>
      <p>
        En Colombia, el pago de las horas extra está regulado por el Código
        Sustantivo del Trabajo, y depende de varios factores como la jornada
        laboral, la hora en que se realicen las horas extra y si estas coinciden
        con días festivos o fines de semana.
        <ol>
          <li>
            Jornada Ordinaria de TrabajoJornada Diurna: De 6:00 a.m. a 9:00
            p.m.Jornada Nocturna: De 9:00 p.m. a 6:00 a.m
          </li>
          <li>
            Recargos por Horas ExtraHoras Extra Diurnas: Se pagan con un recargo
            del 25% sobre el valor de la hora ordinaria.Horas Extra Nocturnas:
            Se pagan con un recargo del 75% sobre el valor de la hora ordinaria.
          </li>
          <li>
            Recargos en Días Festivos o DominicalesTrabajo en Domingo o Festivo
            Diurno: Se paga con un recargo del 75% sobre el valor de la hora
            ordinaria.Horas Extra en Domingo o Festivo Diurno: Se paga con un
            recargo del 100% sobre el valor de la hora ordinaria.Trabajo en
            Domingo o Festivo Nocturno: Se paga con un recargo del 110% sobre el
            valor de la hora ordinaria.Horas Extra en Domingo o Festivo
            Nocturno: Se paga con un recargo del 150% sobre el valor de la hora
            ordinaria
          </li>
          <li>
            LimitacionesEl máximo de horas extra permitido por la ley es de 2
            horas diarias y 12 horas semanales, salvo algunas excepciones como
            casos de emergencia o trabajos en industrias que requieran turnos
            especiales.
          </li>
          <li>
            CálculoEl valor de la hora ordinaria se obtiene dividiendo el
            salario mensual por 240 (que corresponde a 30 días laborales de 8
            horas cada uno). Ejemplo:Si un trabajador gana un salario mínimo
            mensual en 2024 (1.160.000 COP), y trabaja una hora extra diurna, el
            cálculo sería:Valor de la hora ordinaria: 1.160.000 / 240 = 4.833
            COPValor de la hora extra diurna: 4.833 * 1.25 = 6.041 COPEsto
            significa que por cada hora extra diurna trabajada, el trabajador
            recibiría 6.041 COP.
          </li>
          <li>
            Normativa EspecialAlgunas categorías de empleados, como los de
            dirección, confianza y manejo, pueden estar excluidos del pago de
            horas extra, dependiendo de sus responsabilidades y condiciones
            contractuales.Este sistema de pago busca compensar adecuadamente a
            los trabajadores que laboran más allá de la jornada ordinaria,
            teniendo en cuenta la hora y el día en que se realizan las horas
            extra.
          </li>
        </ol>
      </p>
    </>
  );
};

export default Settings;
