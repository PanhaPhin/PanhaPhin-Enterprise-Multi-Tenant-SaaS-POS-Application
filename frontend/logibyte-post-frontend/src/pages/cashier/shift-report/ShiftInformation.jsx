import { CardContent } from '@/components/ui/card'
import {Card} from '@/components/ui/card'
import React from 'react'


const shiftData = {
  cashier: {
    fullName: "John Son"
  },
  shiftStart: "Aug 8, 2025, 09:34 AM",
  shiftEnd: ""
}

const ShiftInformation = () => {
  return (
    <Card className="h-full border-gray-200 shadow-sm">
      <CardContent className="p-6">
        <h2 className="text-xl font-bold mb-6 text-gray-800">Shift Information</h2>

        <div className='space-y-4'>
         
          <div className='flex justify-between items-center'>
            <span className="text-muted-foreground font-medium">Cashier:</span>
            <span className="font-semibold text-gray-900">{shiftData.cashier.fullName}</span>
          </div>

          
          <div className='flex justify-between items-center'>
            <span className="text-muted-foreground font-medium">Shift Start:</span>
            <span className="font-semibold text-gray-900">{shiftData.shiftStart}</span>
          </div>

          
          <div className='flex justify-between items-center'>
            <span className="text-muted-foreground font-medium">Shift End:</span>
            <span className="font-semibold text-gray-900">
              {shiftData.shiftEnd ? shiftData.shiftEnd : "ongoing"}
            </span>
          </div>

         
          <div className='flex justify-between items-center pt-2 border-t border-gray-100'>
            <span className="text-muted-foreground italic text-sm">duration:</span>
            <span className="font-semibold text-gray-900">{"8 hours"}</span>
          </div>
        </div>
      </CardContent>
    </Card>
  )
}

export default ShiftInformation
