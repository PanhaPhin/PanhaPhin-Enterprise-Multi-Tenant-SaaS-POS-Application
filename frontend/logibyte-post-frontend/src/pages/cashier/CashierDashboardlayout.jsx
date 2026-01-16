
import React from "react";
import { Outlet } from "react-router-dom";
import { SidebarProvider } from "../../context/SidebarProvider";
import POSHeader from "./Header/POSHeader";
import Sidebar from "./Sidebar/Sidebar";
import { useSidebar } from "../../context/hook/useSidebar";
import { FaCashRegister, FaClipboardList, FaUndo } from "react-icons/fa";
import { ReceiptIcon } from "lucide-react";

const navItems = [
   {
    path: "/cashier",
    icon: <FaCashRegister size={20} />,
    label: "POS Terminal",
  },
  {
    path: "/cashier/orders",
    icon: <FaClipboardList size={20} />,
    label: "Orders",
  },
  {
    path: "/cashier/returns",
    icon: <FaUndo size={20} />,
    label: "Order History",
  },
  {
    path: "/cashier/shift-summary",
    icon: <ReceiptIcon size={20} />,
    label: "Shift Summary",
  },
  

]

const LayoutContent = () => {
  const { sidebarOpen, setSidebarOpen } = useSidebar();

  return (
    <div className="flex h-screen bg-background">
      {sidebarOpen && <div className="fixed inset-0 bg-black/40"></div>}

      <div
        className={`fixed z-30 h-full transition-transform duration-200 ${
          sidebarOpen ? "translate-x-0" : "-translate-x-full"
        }`}
      >
        <Sidebar navItems={navItems} onClose={() => setSidebarOpen(false)} />
      </div>

      <div className="flex-1 overflow-auto">
        <POSHeader />
        <Outlet />
      </div>
    </div>
  );
};

const CashierDashboardLayout = () => (
  <SidebarProvider>
    <LayoutContent />
  </SidebarProvider>
);

export default CashierDashboardLayout;
