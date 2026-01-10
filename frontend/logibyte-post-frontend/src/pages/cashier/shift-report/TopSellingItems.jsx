import React from "react";
import { Card, CardContent } from "@/components/ui/card";

const shiftData = {
  topSellingProduct: [
    {
      id: "2",
      name: "Men T-Shirt",
      sellingPrice: 12000,
      quantitySold: 50,
    },
    {
      id: "3",
      name: "Women Dress",
      sellingPrice: 25000,
      quantitySold: 35,
    },
  ],
};

// Riel formatter
const rielFormatter = new Intl.NumberFormat("km-KH", {
  style: "currency",
  currency: "KHR",
  minimumFractionDigits: 0,
});

const TopSellingItems = () => {
  return (
    <Card>
      <CardContent className="p-6">
        <h2 className="text-xl font-semibold mb-4">Top Selling Items</h2>
        <div className="space-y-3">
          {shiftData.topSellingProduct.map((product, index) => (
            <div key={product.id} className="flex items-center">
              {/* Ranking */}
              <div
                className="w-6 h-6 rounded-full bg-primary/10 flex items-center
                justify-center mr-3 text-sm font-medium"
              >
                {index + 1}
              </div>

              {/* Product info */}
              <div className="flex-1 flex flex-col">
                <div className="flex justify-between">
                  <span className="font-medium">{product.name}</span>
                  <span className="font-bold">
                    {rielFormatter.format(product.sellingPrice)}
                  </span>
                </div>
                <div className="text-sm text-muted-foreground mt-1">
                  <span>
                    {product.quantitySold} unit
                    {product.quantitySold > 1 ? "s" : ""} sold
                  </span>
                </div>
              </div>
            </div>
          ))}
        </div>
      </CardContent>
    </Card>
  );
};

export default TopSellingItems;
