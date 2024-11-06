import React from "react"; // Import React
import { Link } from "react-router-dom"; // Import Link from React Router
import "./ReportsPage.scss";
import { ReportInfo } from "../components/ReportInfo/ReportInfo";
import logoamadeus from "../../../client/src/assets/images/logoamadeus.png"; // Import logo images
import logohome from "../../../client/src/assets/images/logohome.png"; // Import home logo

const Reports = () => {
  return (
    <>
      <header className="page__header">
         <Link to="/menu">
            <img className="logoamadeus" src={logoamadeus} alt="Logo Amadeus" />
            <img className="logohome" src={logohome} alt="Home Logo" />
          </Link>
      </header>
      <h2>Informes</h2>
      <ReportInfo />
    </>
  );
};

export default Reports;
