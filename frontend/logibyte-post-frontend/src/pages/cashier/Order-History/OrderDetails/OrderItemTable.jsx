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

const rielFormatter = new Intl.NumberFormat("km-KH", {
  style: "currency",
  currency: "KHR",
  minimumFractionDigits: 0,
});

const OrderItemTable = ({ selectedOrder }) => {
  return (
    <Card>
      <CardContent>
        <h2 className="text-xl font-semibold mb-4">Order Items</h2>

        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>Image</TableHead>
              <TableHead>Item</TableHead>
              <TableHead>Quantity</TableHead>
              <TableHead className="text-right">Price</TableHead>
              <TableHead className="text-right">Total</TableHead>
            </TableRow>
          </TableHeader>

          <TableBody>
            {selectedOrder?.items?.map((item) => {
              const price = item.product?.sellingPrice || 0;
              const total = price * item.quantity;

              return (
                <TableRow key={item.id}>
                  <TableCell>
                    <div className="w-10 h-10">
                      <img
                        src={item.product?.image || "/placeholder.png"}
                        alt={item.product?.name || "product"}
                        className="w-10 h-10 object-cover rounded-md"
                      />
                    </div>
                  </TableCell>

                  <TableCell>
                    <div>
                      <div className="font-medium">
                        {item.product?.name?.slice(0, 20) || "Unnamed Product "}
                        
                      </div>
                      <div className="text-xs text-gray-500">
                        SKU: {item.product?.sku || "N/A"}
                      </div>
                    </div>
                  </TableCell>

                  <TableCell>{item.quantity}</TableCell>

                  <TableCell className="text-right">
                    {rielFormatter.format(price)}
                  </TableCell>

                  <TableCell className="text-right font-medium">
                    {rielFormatter.format(total)}
                  </TableCell>
                </TableRow>
              );
            })}
          </TableBody>
        </Table>
      </CardContent>
    </Card>
  );
};

export default OrderItemTable;
