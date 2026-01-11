import React from "react";
import { Card, CardContent } from "@/components/ui/card";
import {
  Table,
  TableBody,
  TableCell,
  TableHeader,
  TableRow,
  TableHead,
} from "@/components/ui/table";

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

        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>Order ID</TableHead>
              <TableHead>Time</TableHead>
              <TableHead>Payment</TableHead>
              <TableHead className="text-right">Amount</TableHead>
            </TableRow>
          </TableHeader>

          <TableBody>
            {shiftData.recentOrders.map((order) => (
              <TableRow key={order.id}>
                <TableCell className="font-medium">
                  {order.id}
                </TableCell>
                <TableCell>{order.createdAt}</TableCell>
                <TableCell>
                  <span
                    className={`px-2 py-1 rounded-full text-xs font-semibold ${
                      order.paymentType === "CASH"
                        ? "bg-green-100 text-green-800"
                        : "bg-blue-100 text-blue-800"
                    }`}
                  >
                    {order.paymentType}
                  </span>
                </TableCell>
                <TableCell className="text-right font-medium">
                  {rielFormatter.format(order.totalAmount)}
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </CardContent>
    </Card>
  );
};

export default RecentOrderTable;
