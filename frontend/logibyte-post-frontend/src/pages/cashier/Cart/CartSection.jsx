import React from "react";
import CartItem from "./CartItem";
import { Button } from "@/components/ui/button";
import { Badge } from "@/components/ui/badge";
import { ScrollArea } from "@/components/ui/scroll-area";
import { PauseCircle, Trash2 } from "lucide-react";

const CartSection = () => {
  return (
    <div className="flex flex-col h-full">

      {/* Header */}
      <div className="flex items-center justify-between pb-3 border-b">
        <div className="flex items-center gap-2">
          <h2 className="text-lg font-semibold">Cart</h2>
          <Badge variant="secondary">3 items</Badge>
        </div>

        <div className="flex gap-2">
          <Button variant="outline" size="sm" className="gap-1">
            <PauseCircle className="w-4 h-4" />
            Hold
          </Button>

          <Button
            variant="outline"
            size="sm"
            className="gap-1 text-red-600 hover:text-red-600 hover:bg-red-50"
          >
            <Trash2 className="w-4 h-4" />
            Clear
          </Button>
        </div>
      </div>

      {/* Cart Items */}
      <ScrollArea className="flex-1 pt-4 pr-2">
        <div className="space-y-3">
          <CartItem />
          <CartItem />
          <CartItem />
        </div>
      </ScrollArea>

    </div>
  );
};

export default CartSection;
