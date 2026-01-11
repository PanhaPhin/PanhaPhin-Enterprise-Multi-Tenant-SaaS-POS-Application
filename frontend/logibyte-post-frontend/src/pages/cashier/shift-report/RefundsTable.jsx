import React from "react";
import { Card, CardContent } from "@/components/ui/card";
import {
  Table,
  TableBody,
  TableCell,
  TableHeader,
  TableRow,
  TableHead,
} from "@/components/ui/table"

const shiftData = {
  refunds:[
    {
        id:234,
        orderId:2,
        reason:"wrong product recieved",
        amount:699
    }
    
  ]


}

const rielFormatter = new Intl.NumberFormat("km-KH", {
  style: "currency",
  currency: "KHR",
  minimumFractionDigits: 0,
});

const RefundsTable = () => {
  return (
    <Card>
      <CardContent>
        <h2 className="text-xl font-semibold mb-4">Recent Orders</h2>

        <Table>
          <TableHeader>
            <TableRow>
              <TableHead>Refund ID</TableHead>
              <TableHead>Order ID</TableHead>
              <TableHead>Reason</TableHead>
              <TableHead className="text-right">Amount</TableHead>
            </TableRow>
          </TableHeader>

          <TableBody>
            {shiftData.refunds.map((refund) => (
              <TableRow key={refund.id}>
                <TableCell className="font-medium"> RFD - {refund.id}</TableCell>
                <TableCell>{refund.orderId}</TableCell>
                <TableCell>{refund.reason}</TableCell> 
               
                <TableCell className="text-right font-medium">
                  {rielFormatter.format(refund.amount)}
                </TableCell>
              </TableRow>
            ))}
          </TableBody>
        </Table>
      </CardContent>
    </Card>
  );
};

export default RefundsTable;
