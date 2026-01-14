import React from "react";
import { Trash } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Badge } from "@/components/ui/badge";

const CartItem = () => {
  return (
    <div className="group border rounded-xl p-4 flex justify-between gap-4 hover:shadow-md transition bg-white">

      {/* LEFT: Product Info */}
      <div className="flex flex-col gap-2">
        <h4 className="text-sm font-semibold leading-snug">
          Men Slim Fit Checkered Spread Collar Casual Shirt
          <span className="block text-xs font-normal text-muted-foreground">
            (Pack of 2)
          </span>
        </h4>

        <p className="text-xs text-muted-foreground">
          SHRT-S-COTTON-BLACK-2025
        </p>

        {/* Quantity */}
        <div className="flex items-center w-fit border rounded-lg overflow-hidden mt-1">
          <Button variant="outline" size="sm" className="px-3 py-1 rounded-none hover:bg-muted">
            −
          </Button>
          <span className="px-4 py-1 text-sm font-medium bg-muted/50">
            2
          </span>
          <Button variant="outline" size="sm" className="px-3 py-1 rounded-none hover:bg-muted">
            +
          </Button>
        </div>
      </div>

      {/* RIGHT: Price & Delete */}
      <div className="flex flex-col items-end justify-between">

        {/* Price */}
        <div className="text-right">
          <p className="text-xs text-muted-foreground">
            ៛ 799 × 2
          </p>
          <p className="text-green-700 font-bold text-lg">
            ៛ 1,598
          </p>
        </div>

        {/* Delete */}
        <Button
          variant="ghost"
          size="icon"
          className="opacity-0 group-hover:opacity-100 transition-colors"
          aria-label="Remove item"
        >
          <Trash className="w-4 h-4 text-muted-foreground hover:text-red-600" />
        </Button>
      </div>
    </div>
  );
};

export default CartItem;
