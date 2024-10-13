import Holiday from "date-holidays"; // Importa la librería date-holidays

// Instancia para festivos en Colombia
const hd = new Holiday("CO");

// Función para calcular el tipo de horas extra
export const determineExtraHourType = (
  date,
  startTime,
  endTime,
  setError,
  setExtraHours
) => {
  const startDateTime = new Date(`${date}T${startTime}`);
  const endDateTime = new Date(`${date}T${endTime}`);

  // Verificación para evitar que la hora de fin sea anterior a la de inicio
  if (endDateTime <= startDateTime) {
    setError("La hora de fin debe ser posterior a la hora de inicio.");
    return;
  }

  let current = new Date(startDateTime);
  let diurnal = 0,
    nocturnal = 0,
    diurnalHoliday = 0,
    nocturnalHoliday = 0;

  // Función para obtener la diferencia de tiempo en horas decimales
  const getHourDifference = (start, end) => {
    const diffInMs = end - start;
    const diffInMinutes = diffInMs / 1000 / 60; // Diferencia en minutos
    return diffInMinutes / 60; // Convertir minutos a horas decimales
  };

  while (current < endDateTime) {
    const isHoliday = hd.isHoliday(current); // Verificar si la hora actual es festiva
    const hour = current.getHours();
    const minutes = current.getMinutes();
    const nextHour = new Date(current);
    nextHour.setHours(current.getHours() + 1);
    const actualEnd = nextHour > endDateTime ? endDateTime : nextHour;
    const hoursDiff = getHourDifference(current, actualEnd);

    if (hour >= 6 && hour < 21) {
      // Diurno (6:00 a.m. a 9:00 p.m.)
      if (hour === 20) {
        const remainingMinutes = 21 * 60 - (hour * 60 + minutes); // Hasta las 9 p.m.
        diurnal += isHoliday ? remainingMinutes / 60 : remainingMinutes / 60; // Si es festivo, sumar a diurna festiva
        nocturnal += hoursDiff - remainingMinutes / 60; // El resto es nocturno
      } else {
        // Sumar todas las horas diurnas normales y festivas
        if (isHoliday) {
          diurnalHoliday += hoursDiff; // Festiva diurna
        } else {
          diurnal += hoursDiff; // Diurna normal
        }
      }
    } else if (hour >= 21 || hour < 6) {
      // Nocturno (de 9 p.m. a 6 a.m.)
      if (hour < 6) {
        if (
          current.getHours() === 5 &&
          endDateTime > new Date(`${date}T06:00`)
        ) {
          const remainingMinutes = 6 * 60 - (hour * 60 + minutes); // Hasta las 6 a.m.
          nocturnal += hoursDiff - remainingMinutes / 60; // El resto es nocturno
          diurnal += remainingMinutes / 60; // Sumar la parte diurna
        } else {
          nocturnal += hoursDiff; // Nocturna normal
        }
      } else {
        // Horas después de las 9 p.m.
        if (isHoliday) {
          nocturnalHoliday += hoursDiff; // Festiva nocturna
        } else {
          nocturnal += hoursDiff; // Nocturna normal
        }
      }
    }

    current = nextHour; // Avanzar a la siguiente hora
  }

  const extrasHours = diurnal + nocturnal + diurnalHoliday + nocturnalHoliday;

  // Actualiza el estado con el valor redondeado a 2 decimales
  setExtraHours((prevData) => ({
    ...prevData,
    diurnal: diurnal.toFixed(2),
    nocturnal: nocturnal.toFixed(2),
    diurnalHoliday: diurnalHoliday.toFixed(2),
    nocturnalHoliday: nocturnalHoliday.toFixed(2),
    extrasHours: extrasHours.toFixed(2),
  }));
};
