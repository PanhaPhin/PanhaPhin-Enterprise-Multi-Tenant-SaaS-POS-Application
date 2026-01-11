import React, { useState } from "react";
import OrderTable from "./OrderTable";
import OrderDetails from "./OrderDetails/OrderDetails";
import { Download } from "lucide-react";

import { Button } from "../../../components/ui/button";
import {
  Dialog,
  DialogContent,
  DialogHeader,
  DialogTitle,
  DialogFooter,
} from "../../../components/ui/dialog";

const OrderHistory = () => {
  const [showOrderInvoiceDialog, setShowOrderInvoiceDialog] = useState(false);

  return (
    <div className="h-full flex flex-col">
      <div className="flex-1 p-4 overflow-auto">
        <OrderTable setShowOrderInvoiceDialog={setShowOrderInvoiceDialog} />
      </div>

      <Dialog
        open={showOrderInvoiceDialog}
        onOpenChange={setShowOrderInvoiceDialog}
      >
        <DialogContent className="max-w-3xl max-h-[85vh] overflow-auto">
          <DialogHeader>
            <DialogTitle>Order – Invoice</DialogTitle>
          </DialogHeader>

          <OrderDetails />

          <DialogFooter>
            <Button>
              <Download className="mr-2 h-4 w-4" />
              Download PDF
            </Button>
          </DialogFooter>
        </DialogContent>
      </Dialog>
    </div>
  );
};

export default OrderHistory;
