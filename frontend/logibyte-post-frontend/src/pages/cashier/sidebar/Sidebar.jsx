import React from 'react';
import { Cross, X } from 'lucide-react';   // Icons
import { Link } from 'react-router-dom';   // Navigation links
import { Button } from '@/components/ui/button'; // Your Button component

const Sidebar = ({ navItems, onClose }) => {
  return (
    <div className="w-64 border-r border-border bg-sidebar p-4 flex flex-col h-full relative">

      <div className="flex items-center justify-between">  {/* fixed className */}
        <h1 className="text-xl font-bold text-sidebar-foreground">POS SYSTEM</h1>

        <Button size="icon" onClick={onClose}>
          <X />
        </Button>
      </div>

      <nav className="space-y-2 flex-1 overflow-y-auto">
        {navItems.map((item) => (
          <Link
            key={item.path}
            to={item.path}
            className="block px-3 py-2 rounded-lg hover:bg-muted hover:text-foreground transition"
            onClick={onClose}
          >
            {item.label}
          </Link>
        ))}
      </nav>
    </div>
  );
};

export default Sidebar;
