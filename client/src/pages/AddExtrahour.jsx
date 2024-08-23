import React from "react";
import "./AddExtrahour.scss";
import background from "../assets/images/background.png";
import { FormExtraHour } from "../components/FormExtraHour/FormExtraHour";
import logo from "../../../server/public/images/logo.png";

const AddExtrahour = () => {
  return (
    <>
      <div
        style={{
          backgroundImage: `url(${background})`,
          backgroundSize: "cover",
          backgroundRepeat: "no-repeat",
          backgroundPosition: "center",
          height: "100vh",
        }}
      >
        <header className="page__header">
          <a href="http://localhost:5173/">
            <img src={logo} />
            {/* <h1 className="heading">Horas Extra Amadeus</h1> */}
          </a>
        </header>
        <h2>Agregar horas extra</h2>
        <FormExtraHour />
      </div>
    </>
  );
};

export default AddExtrahour;
