import { Badge } from '@/components/ui/badge'
import { Button } from '@/components/ui/button'
import React from 'react'

const ProductCard = () => {
  return (
    <div className="group bg-white border rounded-xl overflow-hidden cursor-pointer transition hover:shadow-lg">
      {/* Image */}
      <div className="relative h-44 bg-muted">
        <img
          src="https://picsum.photos/300/300"
          alt="Product"
          className="h-full w-full object-cover group-hover:scale-105 transition"
        />

        <Badge className="absolute top-2 left-2 bg-green-600">
          In Stock
        </Badge>
      </div>

      {/* Content */}
      <div className="p-4 space-y-1">
        <h3 className="font-semibold text-sm line-clamp-2">
          Men Slim Fit Checkered Shirt
        </h3>

        <p className="text-xs text-muted-foreground">
          SKU: SHIRT-S-COTTON-BLACK-2025
        </p>

        <div className="flex items-center justify-between mt-2">
          <span className="text-lg font-bold text-green-600">
            $899
          </span>

          <Button
            size="sm"
            className="opacity-0 group-hover:opacity-100 transition"
          >
            Add
          </Button>
        </div>
      </div>
    </div>
  )
}

export default ProductCard
