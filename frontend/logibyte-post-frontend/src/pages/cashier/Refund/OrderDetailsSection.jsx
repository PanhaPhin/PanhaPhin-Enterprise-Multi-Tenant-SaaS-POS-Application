import React from "react";
import { Button } from "@/components/ui/button";
import { ChevronLeft } from "lucide-react";
import {Card, CardContent} from "@/components/ui/card";
import {Badge} from "@/components/ui/badge";

const OrderDetailsSection = ({ handleSelectOrder, selectedOrder }) => {
  return (
    <div className="w-1/2 border-r p-4">
      <div className="mb-4">
        <Button
          variant="ghost"
          onClick={() => handleSelectOrder(null)}
          className="flex items-center gap-2"
        >
          <ChevronLeft className="h-4 w-4" />
          Back to order table
        </Button>
      </div>

      <Card>
         <CardContent>
            <div className='flex justify-between items-start mb-4'>
                <div>
                    <h2 className='font-semibold text-lg'>Order {selectedOrder.id}</h2>
                    <p>{selectedOrder.createdAt}</p>
                </div>
                <Badge variant={"outline"} >
                    {selectedOrder.paymentType}
                </Badge>
            </div>

            <div className='mb-4'> 
                <h3 className="font-medium text-sm text-muted-foreground">{selectedOrder?.customer?.fullName}</h3>
                <h3>{selectedOrder?.customer?.phone}</h3>
                
            </div>
            <div>
                <h2 className='font-medium text-sm text-muted-foreground mb-2 '>Order summary</h2>
            </div>


         </CardContent>
      </Card>


    </div>
  );
};

export default OrderDetailsSection;
