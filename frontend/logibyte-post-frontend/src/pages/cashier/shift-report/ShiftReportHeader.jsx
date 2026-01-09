import React from 'react';
import { Button } from "@/components/ui/button"; // Assuming you are using a UI library like shadcn

const ShiftReportHeader = () => {
  return (
    <header className="p-4 bg-white border-b sticky top-0 z-10 shadow-sm">
      <div className="max-w-7xl mx-auto flex justify-between items-center">
       
        <h1 className="text-2xl font-bold text-gray-900 tracking-tight">
          Shift Summary
        </h1>

      
        <Button 
          variant="destructive" 
          className="bg-red-600 hover:bg-red-700 text-white flex items-center gap-2 px-4 py-2 rounded-md transition-colors"
          onClick={() => console.log("Logging out...")}
        >
          <span>→ End Shift & Logout</span>
        </Button>
      </div>
    </header>
  );
};

export default ShiftReportHeader;