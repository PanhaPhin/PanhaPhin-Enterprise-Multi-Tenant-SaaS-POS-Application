import React from "react";
import { Card, CardContent } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";

const OrderInformation = ({ selectedOrder }) => {
  if (!selectedOrder) return null;

  return (
    <Card>
      <CardContent className="p-4">
        <h3 className="font-semibold mb-2">Order Information</h3>

        <div className="space-y-1 text-sm">
          <div className="flex justify-between">
            <span className="text-muted-foreground">Date :</span>
            <span>{selectedOrder.createdAt}</span>
          </div>

          <div className="flex justify-between items-center">
            <span className="text-muted-foreground">Status :</span>
            <Badge className="capitalize">{selectedOrder.status}</Badge>
          </div>

          <div className="flex justify-between " >
            <span className="text-muted-foreground">Payment Method :</span>
            <span>{selectedOrder.paymentType}</span>
          </div>

          <div className="flex justify-between " >
            <span className="text-muted-foreground">Total amount :</span>
            <span>៛{selectedOrder.totalAmount}</span>
          </div>


        </div>

      </CardContent>
    </Card>
  );
};

export default OrderInformation;
