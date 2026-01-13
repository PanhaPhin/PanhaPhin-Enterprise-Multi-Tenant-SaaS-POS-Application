import React, { useState } from "react";
import { Card, CardContent } from "@/components/ui/card";
import { Label } from "@/components/ui/label";
import {
  Select,
  SelectTrigger,
  SelectValue,
  SelectContent,
  SelectItem,
} from "@/components/ui/select";
import { Textarea } from "@/components/ui/textarea";
import { Button } from "@/components/ui/button";

const RETURN_REASONS = [
  "Wrong product",
  "Damaged product",
  "Not interested anymore",
  "Other",
];

const refundMethods = ["UPI", "CARD", "CASH"];

const ReturnItemSection = ({ selectedOrder, setShowReturnReciptDialog }) => {
  const [returnReason, setReturnReason] = useState("");
  const [otherReason, setOtherReason] = useState("");
  const [refundMethod, setRefundMethod] = useState("UPI");

  const processRefund=()=>{
    setShowReturnReciptDialog(true);
  }

  const handleReturnReasonChange = (value) => {
    setReturnReason(value);
    if (value !== "Other") {
      setOtherReason("");
    }
  };

  return (




    <div className="p-5 w-1/2">
      <Card className="mt-4">
        <CardContent className="p-4 space-y-4">
          
          <div>
            <Label htmlFor="return-reason" className="mb-2 block">
              Return Reason
            </Label>

            <Select
              value={returnReason}
              onValueChange={handleReturnReasonChange}
            >
              <SelectTrigger className={"w-full"}>
                <SelectValue placeholder="Select a reason" />
              </SelectTrigger>

              <SelectContent>
                {RETURN_REASONS.map((reason) => (
                  <SelectItem key={reason} value={reason}>
                    {reason}
                  </SelectItem>
                ))}
              </SelectContent>
            </Select>
          </div>

          
          {returnReason === "Other" && (
            <div>
              <Label htmlFor="other-reason" className="mb-2 block">
                Specify Reason
              </Label>
              <Textarea
                id="other-reason"
                placeholder="Please specify the return reason"
                value={otherReason}
                onChange={(e) => setOtherReason(e.target.value)}
              />
            </div>
          )}

          
          <div>
            <Label htmlFor="refund-method" className="mb-2 block">
              Refund Method
            </Label>

            <Select
              value={refundMethod}
              onValueChange={setRefundMethod}
            >
              <SelectTrigger className={"w-full"}>
                <SelectValue placeholder="Select a refund method" />
              </SelectTrigger>

              <SelectContent>
                {refundMethods.map((method) => (
                  <SelectItem key={method} value={method}>
                    {method}
                  </SelectItem>
                ))}
              </SelectContent>
            </Select>
          </div>

        
          <div className="pt-5 border-t space-y-2">
            <div>
              <span>Total Refund Amount: </span>
              <span>៛{selectedOrder.totalAmount}</span>
            </div>

            <Button onClick={processRefund} className="w-full py-6 mt-5">
              Process Refund
            </Button>
          </div>
        </CardContent>
      </Card>
    </div>
  );
};

export default ReturnItemSection;