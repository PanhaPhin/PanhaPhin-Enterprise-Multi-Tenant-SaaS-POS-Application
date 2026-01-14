import React from "react";
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import { Button } from "@/components/ui/button";
import { AlignJustify } from "lucide-react";
import { useSidebar } from "@/context/hook/useSidebar";

const POSHeader = ({
  title = "POS Dashboard",
  subtitle = "Welcome Back!",
  userName = "John Doe",
  userImage = ""
}) => {
  const { setSidebarOpen } = useSidebar();

  return (
    <header className="bg-card border-b px-6 py-4">
      <div className="flex items-center justify-between">
        <Button onClick={() => setSidebarOpen(true)}>
          <AlignJustify className="h-5 w-5" />
        </Button>

        <div className="text-center">
          <h1 className="text-xl font-semibold">{title}</h1>
          <p className="text-sm text-muted-foreground">{subtitle}</p>
        </div>

        <Avatar>
          <AvatarImage src={userImage} alt={userName} />
          <AvatarFallback>{userName.slice(0, 2).toUpperCase()}</AvatarFallback>
        </Avatar>
      </div>
    </header>
  );
};

export default POSHeader;
