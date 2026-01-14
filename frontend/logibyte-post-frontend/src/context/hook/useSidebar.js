import { useContext } from "react"

export const useSidebar = () =>{
    const context=useContext(SidebarContext);

    if(!context){
        throw new Error("use Sidebar must be used within SidebarProvider")
    }
    return context;
}