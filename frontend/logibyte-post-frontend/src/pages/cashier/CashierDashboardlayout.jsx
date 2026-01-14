
import React from "react";
import { Outlet } from "react-router-dom";
import { SidebarProvider } from "../../context/SidebarProvider";
import POSHeader from "./Header/POSHeader";
import Sidebar from "./Sidebar/Sidebar";
import { useSidebar } from "../../context/hook/useSidebar";
const navItems = [
  {
    path: "/cashier",
    icon: null,
    label: "POS Terminal",
  },
  {
    path: "/cashier/orders",
    icon: null,
    label: "POS Terminal",
  },
  {
    path: "/cashier/returns",
    icon: null, // replace with <RotateCcw size={20}/>
    label: "Order History",
  },
];

const LayoutContent = () => {
  const { sidebarOpen, setSidebarOpen } = useSidebar(); // ✅ call the hook

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
