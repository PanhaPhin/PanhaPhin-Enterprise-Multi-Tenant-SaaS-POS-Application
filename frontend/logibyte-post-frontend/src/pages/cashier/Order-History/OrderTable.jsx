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
import { Printer, Eye } from "lucide-react";


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
    items:[
      {
        id:101,
        product:{
          image:"https://www.monde-selection.com/wp-content/uploads/2025/05/1044847-768x768.png",
          name:"product 1",
          sellingPrice:50000,
          sku:"T Shirt"
        },
        quantity:2,
      }
    ]

  },
];


const rielFormatter = new Intl.NumberFormat("km-KH", {
  style: "currency",
  currency: "KHR",
  minimumFractionDigits: 0,
});

const OrderTable = ({ handleViewOrderDetails }) => {
  return (
    <div>
      <h2 className="text-2xl font-bold mb-4">Recent Orders</h2>

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
              <TableCell className="font-medium">
                #{order.id}
              </TableCell>

              <TableCell>
                {order.createdAt || "—"}
              </TableCell>

              <TableCell>
                {order.customer?.fullName || "—"}
              </TableCell>

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
                <div className="flex justify-end gap-2">
                  <Button
                    variant="ghost"
                    size="icon"
                    onClick={() => handleViewOrderDetails(order)}
                  >
                    <Eye className="h-4 w-4" />
                  </Button>

                  <Button variant="ghost" size="icon">
                    <Printer className="h-4 w-4" />
                  </Button>
                </div>
              </TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </div>
  );
};

export default OrderTable;
