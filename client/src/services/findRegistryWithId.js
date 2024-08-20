export const findRegistryWithId = async (id) => {
  const response = await fetch("http://localhost:4000/extra-hour/${id}");
  if (!response.ok) {
    throw new Error("Failed to fetch data");
  }
  return await response.json();
};
