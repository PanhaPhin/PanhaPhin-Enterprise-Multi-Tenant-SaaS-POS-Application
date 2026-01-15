import React from "react";
import ProductSection from "./ProductSection/ProductSection";
import CustomerPaymentSection from "./Customer-Management/CustomerPaymentSection";
import CartSection from "./Cart/CartSection";
import POSHeader from "./Header/POSHeader";

const CreateOrder = () => {
  return (
    <div className="grid grid-cols-12 gap-6 p-6 bg-muted/30 min-h-[calc(100vh-80px)]">
    
  
      <section className="col-span-12 md:col-span-5 bg-white rounded-xl p-6 shadow-sm overflow-auto">
        <ProductSection />
      </section>

     
      <section className="col-span-12 md:col-span-4 bg-white rounded-xl p-6 shadow-sm overflow-auto">
        <CartSection />
      </section>

      <section className="col-span-12 md:col-span-3 bg-white rounded-xl p-6 shadow-sm overflow-auto">
        <CustomerPaymentSection />
      </section>

    </div>
  );
};

export default CreateOrder;
