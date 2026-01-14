import { Badge } from '@/components/ui/badge'
import { Button } from '@/components/ui/button'
import React from 'react'

const ProductCard = () => {
  return (
    <div className="border rounded-xl overflow-hidden hover:shadow cursor-pointer">
      <img
        src="https://picsum.photos/300"
        className="h-40 w-full object-cover"
      />

      <div className="p-3">
        <h4 className="text-sm font-medium">Product Name</h4>
        <p className="text-xs text-muted-foreground">SKU12345</p>

        <div className="flex justify-between items-center mt-2">
          <span className="text-green-600 font-bold">$899</span>
          <span className="text-xs">men_shirt</span>
        </div>
      </div>
    </div>
  );
};

export default ProductCard;

