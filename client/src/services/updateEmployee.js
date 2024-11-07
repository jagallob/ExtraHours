export const updateEmployee = async (id, data) => {
  try {
    const response = await fetch(`http://localhost:8080/api/employee/${id}`, {
      method: "PUT",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(data),
    });
    if (!response.ok) throw new Error("Error al actualizar empleado");
    return await response.json();
  } catch (error) {
    console.error(error);
    throw error;
  }
};
