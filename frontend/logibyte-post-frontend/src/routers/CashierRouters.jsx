import CreateOrder from '@/pages/cashier/CreateOrder'
import React from 'react';
import { Routes, Route } from 'react-router-dom';

import OrderHistory from '@/pages/cashier/Order-History/OrderHistory';
import CustomerLookup from '@/pages/cashier/Customer-Management/CustomerLookup';
import RefundPage from '@/pages/cashier/Refund/RefundPage';
import { ShiftSummaryPage } from '@/pages/cashier/shift-report/ShiftSummaryPage';
import CashierDashboardLayout from '@/pages/cashier/CashierDashboardLayout';

const CashierRouters = () => {
  return (
    <Routes>
      <Route index element={<CreateOrder />} />
      <Route path="/" element={<CashierDashboardLayout />} />
      <Route path="orders" element={<OrderHistory />} />
      <Route path="customers" element={<CustomerLookup />} />
      <Route path="returns" element={<RefundPage />} />
      <Route path="shift-summary" element={<ShiftSummaryPage/>} />
      

    </Routes>
  );
};

export default CashierRouters;

