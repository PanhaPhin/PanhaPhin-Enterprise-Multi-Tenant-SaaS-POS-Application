import "./App.css";
import { Button } from "./components/ui/button";
import CreateOrder from "./pages/cashier/CreateOrder";
import SalesSummaryCard from "./pages/cashier/Customer Management/CustomerList";
import { ShiftSummaryPage } from "./pages/cashier/Shift Report/ShiftSummaryPage";

function App() {
  return (
    <>
      <ShiftSummaryPage/>
    </>
  );
}

export default App;
