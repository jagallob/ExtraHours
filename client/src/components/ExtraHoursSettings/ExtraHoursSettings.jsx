import { useState } from "react";
import { InputNumber, TimePicker, Form, Button, message } from "antd";
import { useConfig } from "../../utils/ConfigProvider";
import { updateConfig } from "../../services/updateConfig";
import dayjs from "dayjs";
import "dayjs/locale/es";
import customParseFormat from "dayjs/plugin/customParseFormat";
// import PropTypes from "prop-types";
import "./ExtraHoursSettings.scss";

dayjs.extend(customParseFormat);

const ExtraHoursSettings = () => {
  const [form] = Form.useForm();
  const [loading, setLoading] = useState(false);
  const { config, setConfig } = useConfig();

  const handleSubmit = async (values) => {
    setLoading(true);
    try {
      const updatedValues = {
        ...values,
        diurnalStart: values.diurnalStart.format("HH:mm"),
        diurnalEnd: values.diurnalEnd.format("HH:mm"),
      };

      const updatedConfig = await updateConfig(updatedValues); // Llama a la función updateConfig
      setConfig(updatedConfig);
      message.success("Configuración actualizada correctamente");
    } catch (error) {
      message.error("Error al actualizar la configuración");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="config-extra-hours">
      <h3>Configuración de Horas Extra</h3>
      <Form
        form={form}
        layout="vertical"
        onFinish={handleSubmit}
        initialValues={{
          ...config,
          diurnalStart: dayjs(config.diurnalStart, "HH:mm"),
          diurnalEnd: dayjs(config.diurnalEnd, "HH:mm"),
        }}
      >
        <Form.Item label="Multiplicador Hora Diurna" name="diurnalMultiplier">
          <InputNumber min={1} step={0.1} />
        </Form.Item>

        <Form.Item
          label="Multiplicador Hora Nocturna"
          name="nocturnalMultiplier"
        >
          <InputNumber min={1} step={0.1} />
        </Form.Item>

        <Form.Item
          label="Multiplicador Hora Festiva Diurna"
          name="diurnalHolidayMultiplier"
        >
          <InputNumber min={1} step={0.1} />
        </Form.Item>

        <Form.Item
          label="Multiplicador Hora Festiva Nocturna"
          name="nocturnalHolidayMultiplier"
        >
          <InputNumber min={1} step={0.1} />
        </Form.Item>

        <Form.Item label="Inicio Hora Diurna (24h)" name="diurnalStart">
          <TimePicker format="HH:mm" />
        </Form.Item>

        <Form.Item label="Fin Hora Diurna (24h)" name="diurnalEnd">
          <TimePicker format="HH:mm" />
        </Form.Item>

        <Form.Item>
          <Button type="primary" htmlType="submit" loading={loading}>
            Guardar cambios
          </Button>
        </Form.Item>
      </Form>
    </div>
  );
};

// // ExtraHoursSettings.propTypes = {
// //   onUpdateConfig: PropTypes.func.isRequired, // Define que debe ser una función y que es requerida
// };

export default ExtraHoursSettings;
