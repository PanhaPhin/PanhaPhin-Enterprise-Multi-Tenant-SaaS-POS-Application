import React from "react";
import { Dialog, DialogContent, DialogFooter, DialogHeader, DialogTitle } from "@/components/ui/dialog";
import { Table, TableBody, TableCell, TableHeader, TableRow, TableHead } from "@/components/ui/table";
import { Button } from "@/components/ui/button";
import { PrinterIcon } from "lucide-react";

const rielFormatter = new Intl.NumberFormat("km-KH", {
  style: "currency",
  currency: "KHR",
  minimumFractionDigits: 0,
});

const ReturnReceiptDialog = ({ showReturnReceiptDialog, setShowReturnReceiptDialog, selectedOrder }) => {
  return (
    <Dialog open={showReturnReceiptDialog} onOpenChange={setShowReturnReceiptDialog}>
      <DialogContent className="max-w-3xl">
        <DialogHeader>
          <DialogTitle>Return Receipt</DialogTitle>
        </DialogHeader>

        <div className="bg-background max-h-[70vh] overflow-y-auto space-y-4 p-4">
          <div className="text-center">
            <h3 className="font-bold text-lg">CHIP MONG-MALL Branch</h3>
            <p className="text-sm text-muted-foreground">123 Main Street, City</p>
            <p className="text-sm text-muted-foreground">Tel: 120-1213-212</p>
          </div>

          <div className="text-center">
            <h4 className="font-bold">Return Receipt</h4>
          </div>

          <div className="text-sm space-y-1">
            <p><span className="font-medium">Original Order:</span> {selectedOrder?.id || "N/A"}</p>
            <p><span className="font-medium">Date:</span> {new Date().toLocaleString()}</p>
            <p><span className="font-medium">Customer:</span> {selectedOrder?.customer?.fullName || "N/A"}</p>
          </div>

          <Table>
            <TableHeader>
              <TableRow>
                <TableHead>Image</TableHead>
                <TableHead>Item</TableHead>
                <TableHead>Quantity</TableHead>
                <TableHead className="text-right">Price</TableHead>
                <TableHead className="text-right">Total</TableHead>
              </TableRow>
            </TableHeader>

            <TableBody>
              {selectedOrder?.items?.length ? (
                selectedOrder.items.map((item) => {
                  const price = item.product?.sellingPrice || 0;
                  const total = price * item.quantity;

                  return (
                    <TableRow key={item.id}>
                      <TableCell>
                        <img src={item.product?.image || "/placeholder.png"} alt={item.product?.name || "product"} className="w-10 h-10 object-cover rounded-md" />
                      </TableCell>
                      <TableCell>
                        <div>
                          <div className="font-medium">{item.product?.name || "Unnamed Product"}</div>
                          <div className="text-xs text-muted-foreground">SKU: {item.product?.sku || "N/A"}</div>
                        </div>
                      </TableCell>
                      <TableCell>{item.quantity}</TableCell>
                      <TableCell className="text-right">{rielFormatter.format(price)}</TableCell>
                      <TableCell className="text-right font-medium">{rielFormatter.format(total)}</TableCell>
                    </TableRow>
                  );
                })
              ) : (
                <TableRow>
                  <TableCell colSpan={5} className="text-center text-muted-foreground">No items found</TableCell>
                </TableRow>
              )}
            </TableBody>
          </Table>

          <div className="text-right font-bold mt-4">
            Total Refund: {rielFormatter.format(selectedOrder?.totalAmount || 0)}
          </div>

          <DialogFooter>
            <Button>
              <PrinterIcon className="h-4 w-4"/>
              Print & Complete
            </Button>
          </DialogFooter>

          
        </div>
      </DialogContent>
    </Dialog>
  );
};

export default ReturnReceiptDialog;
