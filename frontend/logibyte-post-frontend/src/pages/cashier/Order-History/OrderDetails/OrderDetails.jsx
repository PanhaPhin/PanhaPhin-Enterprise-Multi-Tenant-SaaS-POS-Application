import React from 'react'
import OrderInformation from './OrderInformation'
import CustomerInformation from './CustomerInformation'
import OrderItemTable from './OrderItemTable'


const OrderDetails = ({selectedOrder}) => {
  return (
    <div>
        <div className='grid grid-cols-2 gap-4 mb-4'>
            <OrderInformation selectedOrder={selectedOrder}/>
            <CustomerInformation selectedOrder={selectedOrder}/>
        </div>
        <OrderItemTable selectedOrder={selectedOrder}/>
    </div>
  )
}

export default OrderDetails
