import React from 'react';
import { Card, CardContent } from "@/components/ui/card";
import { Badge } from "@/components/ui/badge";

const CustomerInformation = ({ selectedOrder }) => {
  if (!selectedOrder) return null;

  return (
    <Card>
      <CardContent className="p-4">
        <h3 className="font-semibold mb-2">Customer Information</h3>

        <div className="space-y-1 text-sm">
          <div className="flex justify-between">
            <span className="text-muted-foreground">Name :</span>
            <span>{selectedOrder.customer.fullName}</span>
          </div>

          

          <div className="flex justify-between " >
            <span className="text-muted-foreground">Phone :</span>
            <span>{selectedOrder.customer.phone}</span>
          </div>

          


        </div>

      </CardContent>
    </Card>
  );
};

export default CustomerInformation;
