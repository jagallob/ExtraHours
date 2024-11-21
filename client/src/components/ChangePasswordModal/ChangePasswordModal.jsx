import { useState } from "react";
import { UserService } from "../../services/UserService";
import PropTypes from "prop-types";
import "./ChangePasswordModal.scss";

const ChangePasswordModal = ({ onClose }) => {
  const [id, setId] = useState("");
  const [newPassword, setNewPassword] = useState("");
  const [message, setMessage] = useState("");

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const responseMessage = await UserService.changePassword(id, newPassword);
      setMessage(responseMessage);
    } catch (error) {
      setMessage("Error al cambiar la contraseña: " + error.message);
    }
  };

  return (
    <div className="modal-container">
      <div className="modal-content">
        <h2>Cambiar Contraseña</h2>
        <form onSubmit={handleSubmit}>
          <div className="form-group">
            <label>ID de Usuario:</label>
            <input
              type="text"
              value={id}
              onChange={(e) => setId(e.target.value)}
              placeholder="Ingrese su cédula"
              required
            />
          </div>
          <div className="form-group">
            <label>Nueva Contraseña:</label>
            <input
              type="password"
              value={newPassword}
              onChange={(e) => setNewPassword(e.target.value)}
              placeholder="Ingrese su nueva contraseña"
              required
            />
          </div>
          <div className="button-group">
            <button type="submit" className="save-button">
              Cambiar Contraseña
            </button>
            <button type="button" className="cancel-button" onClick={onClose}>
              Cancelar
            </button>
          </div>
        </form>
        {message && <p>{message}</p>}
      </div>
    </div>
  );
};

export default ChangePasswordModal;

ChangePasswordModal.propTypes = {
  onClose: PropTypes.func.isRequired,
};
