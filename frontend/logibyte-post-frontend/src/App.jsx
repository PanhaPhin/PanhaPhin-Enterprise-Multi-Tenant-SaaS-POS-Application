import CashierRouters from "./routers/CashierRouters";
import { Routes, Route, Navigate } from "react-router-dom";
import StoreRouters from "./routers/StoreRouters";
import BranchRouters from "./routers/BranchRouters";
import AdminDashboard from "./pages/superAdmin/Dashboard/AdminDashboard";
import Login from "./pages/Auth/Login";

function App() {
  return (
    <Routes>
      <Route path="/" element={<Navigate to="/cashier" replace />} />
      <Route path="/cashier/*" element={<CashierRouters />} />
      <Route path="/store/*" element={<StoreRouters />} />
      <Route path="/branch/*" element={<BranchRouters />} />
      <Route path="/super-admin/*" element={<AdminDashboard />} />
      <Route path="/login" element={<Login />} />
      
      
    </Routes>
  );
}

export default App;
