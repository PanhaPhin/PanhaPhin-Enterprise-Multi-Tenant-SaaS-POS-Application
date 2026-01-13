import React, { useState, useMemo } from "react";
import { Card, CardContent } from "@/components/ui/card";
import { Label } from "@/components/ui/label";
import { Select, SelectTrigger, SelectValue, SelectContent, SelectItem } from "@/components/ui/select";
import { Textarea } from "@/components/ui/textarea";
import { Button } from "@/components/ui/button";

const RETURN_REASONS = ["Wrong product", "Damaged product", "Not interested anymore", "Other"];
const REFUND_METHODS = ["UPI", "CARD", "CASH"];

const rielFormatter = new Intl.NumberFormat("km-KH", {
  style: "currency",
  currency: "KHR",
  minimumFractionDigits: 0,
});

const ReturnItemSection = ({ selectedOrder, setShowReturnReceiptDialog }) => {
  const [returnReason, setReturnReason] = useState("");
  const [otherReason, setOtherReason] = useState("");
  const [refundMethod, setRefundMethod] = useState("UPI");

  const totalRefund = selectedOrder?.totalAmount || 0;

  const isFormValid = useMemo(() => {
    if (!returnReason) return false;
    if (returnReason === "Other" && !otherReason.trim()) return false;
    return true;
  }, [returnReason, otherReason]);

  const handleReturnReasonChange = (value) => {
    setReturnReason(value);
    if (value !== "Other") setOtherReason("");
  };

  const processRefund = () => {
    if (!isFormValid) return;
    setShowReturnReceiptDialog(true);
  };

  return (
    <div className="p-5 w-1/2">
      <Card className="mt-4">
        <CardContent className="p-4 space-y-4">
          <div>
            <Label className="mb-2 block">Return Reason</Label>
            <Select value={returnReason} onValueChange={handleReturnReasonChange}>
              <SelectTrigger className="w-full">
                <SelectValue placeholder="Select a reason" />
              </SelectTrigger>
              <SelectContent>
                {RETURN_REASONS.map((reason) => (
                  <SelectItem key={reason} value={reason}>{reason}</SelectItem>
                ))}
              </SelectContent>
            </Select>
          </div>

          {returnReason === "Other" && (
            <div>
              <Label className="mb-2 block">Specify Reason</Label>
              <Textarea placeholder="Please specify the return reason" value={otherReason} onChange={(e) => setOtherReason(e.target.value)} />
            </div>
          )}

          <div>
            <Label className="mb-2 block">Refund Method</Label>
            <Select value={refundMethod} onValueChange={setRefundMethod}>
              <SelectTrigger className="w-full">
                <SelectValue placeholder="Select a refund method" />
              </SelectTrigger>
              <SelectContent>
                {REFUND_METHODS.map((method) => (
                  <SelectItem key={method} value={method}>{method}</SelectItem>
                ))}
              </SelectContent>
            </Select>
          </div>

          <div className="pt-5 border-t space-y-3">
            <div className="flex justify-between font-medium">
              <span>Total Refund Amount</span>
              <span>{rielFormatter.format(totalRefund)}</span>
            </div>

            <Button onClick={processRefund} className="w-full py-6" disabled={!isFormValid}>
              Process Refund
            </Button>

            {!isFormValid && (
              <p className="text-xs text-muted-foreground text-center">
                Please select a return reason to continue
              </p>
            )}
          </div>
        </CardContent>
      </Card>
    </div>
  );
};

export default ReturnItemSection;
