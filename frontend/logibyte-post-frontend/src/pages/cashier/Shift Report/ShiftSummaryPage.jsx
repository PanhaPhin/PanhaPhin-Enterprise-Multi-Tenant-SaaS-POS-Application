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
    <div className="h-full flex flex-col ">
      <ShiftReportHeader />

      <div className="flex-1 overflow-auto p-4">
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mb-6"></div>
        <ShiftInformation />
        <SalesSummaryCard />
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mb-6"></div>
        <PaymentSummaryCard />
        <TopSellingItems />
        <div className="grid grid-cols-1 md:grid-cols-2 gap-4 mb-6"></div>
        <RecentOrderTable />
        <RefundsTable />
      </div>
    </div>
  );
};
