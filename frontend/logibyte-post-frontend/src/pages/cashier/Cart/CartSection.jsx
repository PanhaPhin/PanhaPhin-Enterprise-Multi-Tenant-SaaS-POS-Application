import React from "react";
import CartItem from "./CartItem";
import { Button } from "@/components/ui/button";
import { Badge } from "@/components/ui/badge";
import { ScrollArea } from "@/components/ui/scroll-area";
import { PauseCircle, Trash2 } from "lucide-react";

// Sample cart data
const cartItems = [
  { id: 1, name: "Men Slim Fit Checkered Shirt", qty: 2, price: 799 },
  { id: 2, name: "Casual T-Shirt", qty: 1, price: 499 },
  { id: 3, name: "Jeans", qty: 1, price: 1200 },
];

const TAX_RATE = 0.1; // 10% tax

const CartSection = () => {
  // Calculate subtotal
  const subtotal = cartItems.reduce((sum, item) => sum + item.price * item.qty, 0);

  // Calculate tax
  const tax = subtotal * TAX_RATE;

  // Calculate total
  const total = subtotal + tax;

  return (
    <div className="flex flex-col h-full">

      {/* Header */}
      <div className="flex items-center justify-between pb-3 border-b">
        <div className="flex items-center gap-2">
          <h2 className="text-lg font-semibold">Cart</h2>
          <Badge variant="secondary">{cartItems.length} items</Badge>
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
          {cartItems.map((item) => (
            <CartItem key={item.id} item={item} />
          ))}
        </div>
      </ScrollArea>

      {/* Summary */}
      <div className="border-t mt-4 pt-4 space-y-2 text-sm">
        <div className="flex justify-between">
          <span>Subtotal</span>
          <span>៛ {subtotal.toLocaleString()}</span>
        </div>
        <div className="flex justify-between">
          <span>Tax (10%)</span>
          <span>៛ {tax.toLocaleString()}</span>
        </div>
        <div className="flex justify-between font-bold text-lg">
          <span>Total</span>
          <span>៛ {total.toLocaleString()}</span>
        </div>
      </div>

    </div>
  );
};

export default CartSection;
