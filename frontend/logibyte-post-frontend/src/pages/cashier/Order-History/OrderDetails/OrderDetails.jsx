import React from 'react'
import OrderInformation from './OrderInformation'
import CustomerInformation from './CustomerInformation'
import OrderItemTable from './OrderItemTable'

const OrderDetails = () => {
  return (
    <div>
        <div className='grid grid-cols-2 gap-4 mb-4'>
            <OrderInformation/>
            <CustomerInformation/>
        </div>
        <OrderItemTable/>
    </div>
  )
}

export default OrderDetails
