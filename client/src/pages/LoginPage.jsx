import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { Form, Input, Button, message } from "antd";
import { useAuth } from "../utils/AuthContext";
import { UserService } from "../services/UserService";
import "./LoginPage.scss";
import Logo from "../../../client/src/assets/images/Logo.png"; 

const Login = () => {
  const [loading, setLoading] = useState(false);
  const navigate = useNavigate();
  const { auth, login } = useAuth();

  useEffect(() => {
    console.log(auth);
    if (auth?.role) {
      navigate("/menu");
    }
  }, [auth, navigate]);

  const handleLogin = async (values) => {
    setLoading(true);

    try {
      const data = await UserService.login(values.email, values.password);
      console.log(data);
      const { token, role } = data;

      if (role) {
        login({ token, role: role });
        navigate("/menu");
        message.success(`Bienvenido ${values.email}`);
      } else {
        message.error("No se pudo determinar el rol del usuario");
      }
    } catch (error) {
      message.error("Usuario o contraseña incorrectos");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="login-container">
      <h2>Bienvenido</h2>
      <img className="Logo" src={Logo} alt="Logo Amadeus" />
      <Form name="login-form" onFinish={handleLogin} layout="vertical">
        <Form.Item
          label="Correo Electrónico"
          name="email"
          rules={[
            {
              required: true,
              message: "Por favor ingrese su correo electrónico",
            },
          ]}
        >
          <Input placeholder="example@mail.com" />
        </Form.Item>

        <Form.Item
          label="Contraseña"
          name="password"
          rules={[
            { required: true, message: "Por favor ingrese su contraseña" },
          ]}
        >
          <Input.Password placeholder="Contraseña" />
        </Form.Item>

        <Form.Item>
          <Button
            className="button"
            type="primary"
            htmlType="submit"
            loading={loading}
            block
          >
            Iniciar Sesión
          </Button>
        </Form.Item>
      </Form>
    </div>
  );
};

export default Login;
