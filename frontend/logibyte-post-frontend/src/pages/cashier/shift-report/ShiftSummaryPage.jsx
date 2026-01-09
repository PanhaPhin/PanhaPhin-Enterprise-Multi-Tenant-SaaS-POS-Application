import React from "react";
import ShiftReportHeader from "./ShiftReportHeader";
import ShiftInformation from "./ShiftInformation";
import SalesSummaryCard from "./SalesSummaryCard";
import PaymentSummaryCard from "./PaymentSummaryCard";
import TopSellingItems from "./TopSellingItems";
import RecentOrderTable from "./RecentOrderTable";
import RefundsTable from "./RefundsTable";

export const ShiftSummaryPage = () => {
 return (
    <div className="min-h-screen flex flex-col bg-gray-50 antialiased">
      
      <ShiftReportHeader />

      
      <main className="flex-1 overflow-auto p-4 md:p-6 max-w-7xl mx-auto w-full space-y-6">
        
        
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
          <ShiftInformation />
          <SalesSummaryCard  />
        </div>

        
        <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
          <PaymentSummaryCard />
          <TopSellingItems />
        </div>

        <div className="grid grid-cols-1 md:grid-cols-2 gap-6 pb-10">
          <RecentOrderTable />
          <RefundsTable />
        </div>

      </main>
    </div>
  );
};