import React from "react";
import { Card, CardContent } from "@/components/ui/card";
import { CreditCard } from "lucide-react";

const shiftData = {
  pamentSummaries: [
    {
      type: "CASH",
      totalAmount: 2999,
      transactionCount: 6,
    },
    {
      type: "CASH",
      totalAmount: 3499,
      transactionCount: 6,
    },
  ],
};

const PaymentSummaryCard = () => {
  return (
    <Card>
      <CardContent className={"p-6"}>
        <h2 className="text-xl font-semibold mb-4">Payment Summary</h2>

        <div className="space-y-4">
          {shiftData.pamentSummaries.map((payment) => (
            <div className="flex items-center" key={payment.type}>
              <div
                className="w-10 h-10 rounded-full bg-primary/10 flex 
              items-center justify-center mr-4">
                <CreditCard />
              </div>
            </div>
          ))}
        </div>
      </CardContent>
    </Card>
  );
};

export default PaymentSummaryCard;
