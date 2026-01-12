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

const RETURN_REASONS = [
  "Wrong product",
  "Damaged product",
  "Not interested anymore",
  "Other",
];

const ReturnItemSection = () => {
  const [returnReason, setReturnReason] = useState("");

  return (
    <div className="p-5 w-1/2">
      <Card className="mt-4">
        <CardContent className="p-4 space-y-4">
          <div>
            <Label htmlFor="return-reason" className="mb-2 block">
              Return Reason
            </Label>

            <Select value={returnReason} onValueChange={setReturnReason}>
              <SelectTrigger id="return-reason">
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
        </CardContent>
      </Card>
    </div>
  );
};

export default ReturnItemSection;
