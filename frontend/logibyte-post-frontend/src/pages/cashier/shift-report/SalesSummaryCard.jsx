import React from "react";
import { CardContent } from "@/components/ui/card";
import { Card } from "@/components/ui/card";

const shiftData = {
  cashier: {
    fullName: "John Son", 
  },
  shiftStart: "Aug 8, 2025, 09:34 AM",
  shiftEnd: "",
  totalOrders: 59,
  totalSales: "500000",
  totalRefund: 400000,
  netSales: 10000,
};

const SalesSummaryCard = () => {
  
  return (
    <Card className="h-full border-gray-200 shadow-sm">
      <CardContent className="p-6">
        <h2 className="text-xl font-bold mb-6 text-gray-800">Sales Summary</h2>

        <div className="space-y-4">
          <div className="flex justify-between items-center">
            <span className="text-gray-500 font-medium">Total Orders:</span>
            <span className="font-semibold text-gray-900">{shiftData.totalOrders}</span>
          </div>

          <div className="flex justify-between items-center">
            <span className="text-gray-500 font-medium">Total Sales:</span>
            <span className="font-semibold text-gray-900">{shiftData.totalSales}៛</span>
          </div>

          <div className="flex justify-between items-center">
            <span className="text-gray-500 font-medium">Total Refund:</span>
            <span className="font-semibold text-red-500">-{shiftData.totalRefund}៛</span>
          </div>

          <div className="flex justify-between items-center pt-2 border-t border-gray-100">
            <span className="text-gray-900 font-bold italic">Net Sales:</span>
            <span className="font-bold text-lg text-green-600">
              {shiftData.netSales.toLocaleString()}៛
            </span>
          </div>
        </div>
      </CardContent>
    </Card>
  );
};

export default SalesSummaryCard;
