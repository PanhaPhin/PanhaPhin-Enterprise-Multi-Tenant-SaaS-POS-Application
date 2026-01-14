import {
  Card,
  CardContent,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { Button } from "@/components/ui/button";
import { Input } from "@/components/ui/input";
import { Textarea } from "@/components/ui/textarea";
import { Separator } from "@/components/ui/separator";
import {
  ToggleGroup,
  ToggleGroupItem,
} from "@/components/ui/toggle-group";

import { User, Percent, DollarSign, StickyNote } from "lucide-react";
import { CreditCard, PauseCircle } from "lucide-react";

const CustomerPaymentSection = () => {
  return (
    <Card className="h-full flex flex-col">

      {/* TOP */}
      <CardContent className="flex-1 space-y-6 pt-6">

        {/* Customer */}
        <div className="space-y-2">
          <CardTitle className="text-sm flex items-center gap-2">
            <User className="w-4 h-4" />
            Customer
          </CardTitle>

          <Button
            variant="outline"
            className="w-full justify-start text-muted-foreground"
          >
            Select Customer
          </Button>
        </div>

        {/* Discount */}
        <div className="space-y-3">
          <CardTitle className="text-sm">Discount</CardTitle>

          <Input type="number" placeholder="0" />

          <ToggleGroup
  type="single"
  defaultValue="percent"
  className="inline-flex rounded-lg border border-green-700"
>
  <ToggleGroupItem
    value="percent"
    className="
      px-4 py-2
      flex items-center justify-center gap-2
      text-white bg-green-700
      rounded-l-lg
      data-[state=off]:bg-transparent
      data-[state=off]:text-green-700
      data-[state=off]:hover:bg-green-100
      data-[state=on]:bg-green-700
      data-[state=on]:text-white
      transition-colors
      cursor-pointer
    "
  >
    <Percent className="w-4 h-4" />
    
  </ToggleGroupItem>

  <ToggleGroupItem
    value="amount"
    className="
      px-4 py-2
      flex items-center justify-center gap-2
      text-green-700 bg-transparent
      rounded-r-lg
      border-l border-green-700
      data-[state=on]:bg-green-700
      data-[state=on]:text-white
      data-[state=off]:hover:bg-green-100
      transition-colors
      cursor-pointer
    "
  >
    <DollarSign className="w-4 h-4" />
    
  </ToggleGroupItem>
</ToggleGroup>

        </div>

        {/* Note */}
        <div className="space-y-2">
          <CardTitle className="text-sm flex items-center gap-2">
            <StickyNote className="w-4 h-4" />
            Note
          </CardTitle>

          <Textarea
            rows={3}
            placeholder="Enter note..."
            className="resize-none"
          />
        </div>
      </CardContent>

      {/* BOTTOM */}
      <div className="px-6 pb-6 space-y-4">
        <Separator />

        {/* Total */}
        <div className="text-center">
          <p className="text-green-700 text-4xl font-bold tracking-tight">
            ៛ 899
          </p>
          <p className="text-sm text-muted-foreground">
            Total Amount
          </p>
        </div>

        {/* Actions */}
        <Button className="w-full h-11 text-base bg-green-700 hover:bg-green-800 gap-2">
          <CreditCard className="w-5 h-5"/>
          Process Payment
        </Button>

        <Button variant="outline" className="w-full h-11 gap-2">
           <PauseCircle className="w-5 h-5" />
          Hold Order
        </Button>
      </div>

    </Card>
  );
};

export default CustomerPaymentSection;
