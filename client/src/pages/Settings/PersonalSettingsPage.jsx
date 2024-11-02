import "./PersonalSettingsPage.scss";
import { PersonalSettings } from "../../components/PersonalSettings/PersonalSettings";
// import logo from "../../../server/public/images/logo.png";
// import logo2 from "../../../server/public/images/logo2.png";

const PersonalSettingsPage = () => {
  return (
    <>
      <header className="page__header">
        <a href="http://localhost:5173/">
          {/* <img className="logo1" src={logo} />
          <img className="logo2" src={logo2} /> */}
        </a>
      </header>

      <h2>Ajustes con el personal</h2>
      <PersonalSettings />
    </>
  );
};

export default PersonalSettingsPage;
