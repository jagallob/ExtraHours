require("dotenv").config();
const express = require("express");
const fs = require("fs");
const router = require("./routes");
const cors = require("cors");

// const port = process.env.PORT;
const port = process.env.PORT || 8080; // Asegúrate de que el puerto esté configurado correctamente
const app = express();

app.use(express.json());
app.use(express.urlencoded({ extended: true }));
app.use(
  cors({
    origin: "http://localhost:5173",
    methods: ["GET", "POST", "PUT", "DELETE", "OPTIONS"],
    allowedHeaders: ["Content-Type", "Authorization"],
    credentials: true,
  })
);

app.use(express.static("public"));
app.use(router);

// Manejo de errores
app.use((err, req, res, next) => {
  console.error(err.stack);
  res.status(500).send("Something broke!");
});

app.listen(port, () => {
  console.log(`... ⚙️  Server Side listening on port ${port}`);
});
