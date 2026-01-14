import React from 'react'
import ProductCard from './ProductCard'

const ProductSection = () => {
  return (
    <>
      <input
        className="w-full mb-4 px-4 py-2 border rounded"
        placeholder="Search products..."
      />

      <div className="grid grid-cols-3 gap-4">
        <ProductCard />
        <ProductCard />
        <ProductCard />
      </div>
    </>
  )
}

export default ProductSection
