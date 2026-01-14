import { Button } from '@/components/ui/button';
import React from 'react';
import {Cross} from "lucide-react";

const Sidebar = ({navItems , onClose}) => {
  return (
    <div className='w-64 border-r border-border bg-sidebar p-4 
    flex flex-col h-full relative'>

        <div>
            <h1 className='text-xl font-bold text-sidebar-foreground '>POS SYSTEM</h1>
        </div>

        <Button>
            <Cross/>
        </Button>
      
    </div>
    
  )
}

export default Sidebar
