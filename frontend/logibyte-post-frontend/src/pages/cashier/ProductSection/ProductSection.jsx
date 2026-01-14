import React from "react";
import ProductCard from "./ProductCard";
import { Input } from "@/components/ui/input";
import { Button } from "@/components/ui/button";

const ProductSection = () => {
  return (
    <>
      <div className="flex gap-2 mb-4">
        <Input
          className="flex-1"
          placeholder="Search products..."
          type="search"
          aria-label="Search products"
        />
        <Button variant="outline">Scan</Button>
      </div>

      <p className="text-sm text-muted-foreground mb-3">2 product founds</p>

      <div className="grid grid-cols-3 gap-4">
        <ProductCard />
        <ProductCard />
        <ProductCard />
      </div>
    </>
  );
};

export default ProductSection;
