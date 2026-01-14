import { SidebarContext } from "./SidebarContext";
import { useState } from "react";

export const SidebarProvider = ({children}) =>{
    cosnt [sidebarOpen , setSidebarOpen] =  useState(false);

    return <SidebarProvider.Provider value ={{setSidebarOpen,sidebarOpen}}  >
   {children}
    </SidebarProvider.Provider>
}