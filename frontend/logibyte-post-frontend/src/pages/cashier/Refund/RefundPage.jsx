import React, { useState } from "react";
import OrderTable from "./OrderTable";
import OrderDetailsSection from "./OrderDetailsSection";
import ReturnItemSection from "./ReturnItemSection";
// import ReturnReciptDialog from "./ReturnReciptDialog";

const Refundpage = () => {
  const [selectedOrder, setSelectedOrder] = useState(null);

  const handleSelectOrder = (order) => {
    setSelectedOrder(order);
  };

  return (
    <div className="h-full flex flex-col">
      <div className="p-4 bg-card border-b">
        <h1 className="text-2xl font-bold">Return / Refund</h1>
      </div>

      <div className="flex-1 flex overflow-hidden">
        {!selectedOrder ? (
          <OrderTable handleSelectOrder={handleSelectOrder} />
        ) : (
          <>
            <OrderDetailsSection
              selectedOrder={selectedOrder} handleSelectOrder={null}
            />
            <ReturnItemSection selectedOrder={selectedOrder} />
          </>
        )}
      </div>

      {/* {selectedOrder && <ReturnReciptDialog />} */}
    </div>
  );
};

export default Refundpage;
