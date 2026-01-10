import React from "react";
import { Card, CardContent } from "@/components/ui/card";
import { CreditCard } from "lucide-react";

const shiftData = {
  paymentSummaries: [
    {
      type: "CASH",
      totalAmount: 2999,
      transactionCount: 6,
    },
    {
      type: "CARD",
      totalAmount: 3499,
      transactionCount: 8,
    },
     {
      type: "UPI",
      totalAmount: 4499,
      transactionCount: 32,
    },
  ],
};

const rielFormatter = new Intl.NumberFormat("km-KH", {
  style: "currency",
  currency: "KHR",
  minimumFractionDigits: 0,
});

const totalSales = shiftData.paymentSummaries.reduce(
  (sum, item) => sum + item.totalAmount,
  0
);

const PaymentSummaryCard = () => {
  return (
    <Card>
      <CardContent className="p-6">
        <h2 className="text-xl font-semibold mb-4">Payment Summary</h2>

        <div className="space-y-4">
          {shiftData.paymentSummaries.map((payment, index) => {
            const percentage = (
              (payment.totalAmount / totalSales) *
              100
            ).toFixed(1);

            return (
              <div className="flex items-center" key={index}>
                <div className="w-10 h-10 rounded-full bg-primary/10 flex items-center justify-center mr-4">
                  <CreditCard className="w-5 h-5 text-primary" />
                </div>

                <div className="flex-1">
                  <div className="flex justify-between">
                    <span className="font-medium">{payment.type}</span>
                    <span className="font-bold">
                      {rielFormatter.format(payment.totalAmount)}
                    </span>
                  </div>

                  <div className="flex justify-between text-sm text-muted-foreground">
                    <span>{payment.transactionCount} transactions</span>
                    <span>{percentage}%</span>
                  </div>
                </div>
              </div>
            );
          })}
        </div>
      </CardContent>
    </Card>
  );
};

export default PaymentSummaryCard;
