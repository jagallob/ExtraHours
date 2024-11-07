import React from "react"; // Import React
import { Link } from "react-router-dom"; // Import Link from React Router
import "./ApprovePage.scss";
import { Approve } from "../components/Approve/Approve";
import logoamadeus from "../../../client/src/assets/images/logoamadeus.png"; // Import logo images
import logohome from "../../../client/src/assets/images/logohome.png"; // Import home logo

const ApproveExtrahour = () => {
  return (
    <>
      <header className="page__header">
      <Link to="/menu">
            <img className="logoamadeus" src={logoamadeus} alt="Logo Amadeus" />
            <img className="logohome" src={logohome} alt="Home Logo" />
          </Link>
      </header>

      <h2>Aprobar - Eliminar horas extra</h2>
      <Approve />
    </>
  );
};

export default ApproveExtrahour;
