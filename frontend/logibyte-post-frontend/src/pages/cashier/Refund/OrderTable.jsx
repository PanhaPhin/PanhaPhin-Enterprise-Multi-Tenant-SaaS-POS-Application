import React from "react";
import {
  Table,
  TableBody,
  TableCell,
  TableHeader,
  TableRow,
  TableHead,
} from "../../../components/ui/table";
import { Button } from "../../../components/ui/button";

const orders = [
  {
    id: 1,
    createdAt: "2025-01-11 13:45",
    customer: {
      fullName: "Walk-in Customer",
      phone: "123456789",
    },
    totalAmount: 2999,
    paymentType: "CASH",
    status: "COMPLETED",
    items: [
      {
        id: 101,
        quantity: 2,
        product: {
          image:
            "https://www.monde-selection.com/wp-content/uploads/2025/05/1044847-768x768.png",
          name: "Product 1",
          sellingPrice: 50000,
          sku: "T Shirt",
        },
      },
    ],
  },
];

const rielFormatter = new Intl.NumberFormat("km-KH", {
  style: "currency",
  currency: "KHR",
  minimumFractionDigits: 0,
});

const OrderTable = ({ handleSelectOrder }) => {
  return (
    <div className="w-full">
      <Table>
        <TableHeader>
          <TableRow>
            <TableHead>Order ID</TableHead>
            <TableHead>Date / Time</TableHead>
            <TableHead>Customer</TableHead>
            <TableHead>Amount</TableHead>
            <TableHead>Payment</TableHead>
            <TableHead>Status</TableHead>
            <TableHead className="text-right">Action</TableHead>
          </TableRow>
        </TableHeader>

        <TableBody>
          {orders.map((order) => (
            <TableRow key={order.id}>
              <TableCell className="font-medium">#{order.id}</TableCell>
              <TableCell>{order.createdAt}</TableCell>
              <TableCell>{order.customer?.fullName}</TableCell>
              <TableCell>
                {rielFormatter.format(order.totalAmount)}
              </TableCell>
              <TableCell>{order.paymentType}</TableCell>
              <TableCell>
                <span className="rounded-full bg-green-100 px-2 py-1 text-xs font-semibold text-green-700">
                  {order.status}
                </span>
              </TableCell>
              <TableCell className="text-right">
                <Button
                  variant="destructive"
                  size="sm"
                  onClick={() => handleSelectOrder(order)}
                >
                  Return / Refund
                </Button>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </div>
  );
};

export default OrderTable;
