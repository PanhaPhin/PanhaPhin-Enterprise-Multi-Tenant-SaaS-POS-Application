import "./App.css";
import CashierRouters from "./routers/CashierRouters";
import { BrowserRouter, Routes, Route } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/cashier/*" element={<CashierRouters />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
