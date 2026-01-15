import React from "react";
import { Trash } from "lucide-react";
import { Button } from "@/components/ui/button";

const CartItem = ({ item }) => {
  const { name, qty, price } = item;

  return (
    <div className="group border rounded-xl p-4 flex justify-between gap-4 hover:shadow-md transition bg-white">
      {/* LEFT: Product Info */}
      <div className="flex flex-col gap-2">
        <h4 className="text-sm font-semibold leading-snug">
          {name}
        </h4>

        <p className="text-xs text-muted-foreground">
          {/* SKU or additional info */}
        </p>

        {/* Quantity */}
        <div className="flex items-center w-fit border rounded-lg overflow-hidden mt-1">
          <Button variant="outline" size="sm" className="px-3 py-1 rounded-none hover:bg-muted">
            −
          </Button>
          <span className="px-4 py-1 text-sm font-medium bg-muted/50">
            {qty}
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
            ៛ {price} × {qty}
          </p>
          <p className="text-green-700 font-bold text-lg">
            ៛ {(price * qty).toLocaleString()}
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
