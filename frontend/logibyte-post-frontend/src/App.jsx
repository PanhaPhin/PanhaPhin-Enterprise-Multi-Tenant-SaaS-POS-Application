import "./App.css";
import OrderHistory from "./pages/cashier/Order-History/OrderHistory";
import { ShiftSummaryPage } from "./pages/cashier/shift-report/ShiftSummaryPage";

function App() {
  return (
    <div className="min-h-screen bg-gray-50">
      {/* <CreateOrder/> */}
      {/* <CustomerLookup /> */}
      {/* <ShiftSummaryPage /> */}
       <OrderHistory/>
      
      
    </div>
  );
}

export default App;
