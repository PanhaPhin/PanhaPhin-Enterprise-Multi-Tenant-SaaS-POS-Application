import React from "react";
import { Card, CardContent } from "@/components/ui/card";

const shiftData = {
  recentOrders: [
    {
      id: 1,
      createdAt: "01:25 PM",
      paymentType: "CASH",
      totalAmount: 7899,
    },
    {
      id: 2,
      createdAt: "01:40 PM",
      paymentType: "CARD",
      totalAmount: 12999,
    },
  ],
};

// Riel currency formatter
const rielFormatter = new Intl.NumberFormat("km-KH", {
  style: "currency",
  currency: "KHR",
  minimumFractionDigits: 0,
});

const RecentOrderTable = () => {
  return (
    <Card>
      <CardContent>
        <h2 className="text-xl font-semibold mb-4">Recent Orders</h2>

        <div className="overflow-x-auto">
          <table className="min-w-full divide-y divide-gray-200">
            <thead className="bg-gray-50">
              <tr>
                <th className="px-4 py-2 text-left text-sm font-medium text-gray-700">
                  Order ID
                </th>
                <th className="px-4 py-2 text-left text-sm font-medium text-gray-700">
                  Time
                </th>
                <th className="px-4 py-2 text-left text-sm font-medium text-gray-700">
                  Payment
                </th>
                <th className="px-4 py-2 text-right text-sm font-medium text-gray-700">
                  Amount
                </th>
              </tr>
            </thead>
            <tbody className="bg-white divide-y divide-gray-200">
              {shiftData.recentOrders.map((order) => (
                <tr key={order.id} className="hover:bg-gray-50">
                  <td className="px-4 py-2 font-medium">{order.id}</td>
                  <td className="px-4 py-2">{order.createdAt}</td>
                  <td className="px-4 py-2">
                    <span
                      className={`px-2 py-1 rounded-full text-xs font-semibold ${
                        order.paymentType === "CASH"
                          ? "bg-green-100 text-green-800"
                          : "bg-blue-100 text-blue-800"
                      }`}
                    >
                      {order.paymentType}
                    </span>
                  </td>
                  <td className="px-4 py-2 text-right font-medium">
                    {rielFormatter.format(order.totalAmount)}
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </CardContent>
    </Card>
  );
};

export default RecentOrderTable;
