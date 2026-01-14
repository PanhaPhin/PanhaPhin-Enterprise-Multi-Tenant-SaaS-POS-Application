import React from 'react'
import POSHeader from './Header/POSHeader'
import CustomerPaymentSection from './Customer-Management/CustomerPaymentSection'
import ProductSection from './ProductSection/ProductSection'

const CreateOrder = () => {
  return (
    <div className="grid grid-cols-12 gap-4 h-full">
   
      <div className="col-span-7">
        <ProductSection />
      </div>

     
      <div className="col-span-5">
        <CustomerPaymentSection />
      </div>
    </div>
  )
}

export default CreateOrder
