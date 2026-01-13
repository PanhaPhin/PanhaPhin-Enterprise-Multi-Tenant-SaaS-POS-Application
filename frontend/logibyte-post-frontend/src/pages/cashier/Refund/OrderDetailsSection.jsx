import React from "react";
import { Button } from "@/components/ui/button";
import { ChevronLeft } from "lucide-react";
import { Card, CardContent } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";
import { Table, TableBody, TableCell, TableHeader, TableRow, TableHead } from "@/components/ui/table";

const rielFormatter = new Intl.NumberFormat("km-KH", {
  style: "currency",
  currency: "KHR",
  minimumFractionDigits: 0,
});

const OrderDetailsSection = ({ selectedOrder, handleSelectOrder }) => {
  return (
    <div className="w-1/2 border-r p-4 flex flex-col">
      <div className="mb-4">
        <Button variant="ghost" onClick={() => handleSelectOrder(null)} className="flex items-center gap-2">
          <ChevronLeft className="h-4 w-4" />
          Back to order table
        </Button>
      </div>

      <Card>
        <CardContent>
          <div className="flex justify-between items-start mb-4">
            <div>
              <h2 className="font-semibold text-lg">Order #{selectedOrder.id}</h2>
              <p>{selectedOrder.createdAt}</p>
            </div>
            <Badge variant="outline">{selectedOrder.paymentType}</Badge>
          </div>

          <div className="mb-4">
            <h3 className="font-medium text-sm text-muted-foreground">{selectedOrder?.customer?.fullName}</h3>
            <h3>{selectedOrder?.customer?.phone}</h3>
          </div>

          <div>
            <h2 className="font-medium text-sm text-muted-foreground mb-2">Order summary</h2>
            <div className="text-sm flex justify-between">
              <span>Total Items: {selectedOrder.items.length}</span>
              <span>Order Total: {rielFormatter.format(selectedOrder.totalAmount)}</span>
            </div>
          </div>
        </CardContent>
      </Card>

      <div className="flex-1 overflow-auto mt-10">
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
            {selectedOrder.items.map((item) => {
              const price = item.product?.sellingPrice || 0;
              const total = price * item.quantity;

              return (
                <TableRow key={item.id}>
                  <TableCell>
                    <img src={item.product?.image || "/placeholder.png"} alt={item.product?.name || "product"} className="w-10 h-10 object-cover rounded-md" />
                  </TableCell>
                  <TableCell>
                    <div>
                      <div className="font-medium">{item.product?.name?.slice(0, 20) || "Unnamed Product"}</div>
                      <div className="text-xs text-muted-foreground">SKU: {item.product?.sku || "N/A"}</div>
                    </div>
                  </TableCell>
                  <TableCell>{item.quantity}</TableCell>
                  <TableCell className="text-right">{rielFormatter.format(price)}</TableCell>
                  <TableCell className="text-right font-medium">{rielFormatter.format(total)}</TableCell>
                </TableRow>
              );
            })}
          </TableBody>
        </Table>
      </div>
    </div>
  );
};

export default OrderDetailsSection;
