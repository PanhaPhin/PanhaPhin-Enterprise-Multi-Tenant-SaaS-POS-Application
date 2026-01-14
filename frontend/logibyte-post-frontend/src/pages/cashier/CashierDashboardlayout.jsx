import { Clock } from 'lucide-react';
import { ShoppingCart } from 'lucide-react';
import { Outdent } from 'lucide-react';
import { RotateCcw } from 'lucide-react';
import { ReceiptIcon } from 'lucide-react'
import React from 'react'
import { Outlet } from 'react-router';
import POSHeader from './Header/POSHeader';
import { useSidebar } from '@/context/hook/useSidebar';
import { SidebarProvider } from '@/context/SidebarProvider';

const navItems=[
  {
    path:"/cashier",
    icon:<ShoppingCart size={20}/>,
    label:"POS Terminal"
  },
  {
    path:"/cashier/orders",
    icon:<Clock size={20}/>,
    label:"POS Terminal"
  },
  {
    path:"/cashier/returns",
    icon:<RotateCcw size={20}/>,
    label:"Order History"
  }
]
const LayoutContent = () => {

  const[sidebarOpen , setSidebarOpen] = useSidebar();
  return (
    <div className='flex h-screen bg-background'>
      
      {sidebarOpen && <div className='fixed inset-0 bg-black/40'></div>}

      <div className={`fixed z-30 h-full transition-transform duration-200 ${sidebarOpen ? "translate-x-0":"-translate-x-full" }`}>
      <Sidebar navItems={navItems} onClose={()=> setSidebarOpen(false)}/>
      </div>

      <div className='flex-1 overflow-auto'>
        <POSHeader/>
        <Outlet/>
      </div>
    </div>
  )
}


const CashierDashboardLayout = () => {
  return (
    <SidebarProvider>

      <LayoutContent/>

    </SidebarProvider>
  )
   
}




export default CashierDashboardLayout
