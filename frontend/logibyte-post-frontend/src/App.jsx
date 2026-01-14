import CashierRouters from "./routers/CashierRouters";
import { Routes, Route, Navigate } from "react-router-dom";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/cashier" replace />} />
      <Route path="/cashier/*" element={<CashierRouters />} />
    </Routes>
  );
}

export default App;
