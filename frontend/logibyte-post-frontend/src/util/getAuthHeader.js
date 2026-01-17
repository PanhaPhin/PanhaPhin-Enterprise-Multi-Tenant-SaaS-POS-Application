
export const getAuthToken=()=>{
    const jwt=localStorage.getItem("jwt")
    if(!jwt){
        throw new Error("No Jwt token  found")
    }
    return jwt;
}

export const getAuthHeaders= ()=>{
    const jwt=getAuthToken();
    return{
        "Authorization": `Bearer ${jwt}`,
        "Content-Type": 'application/json'
    }
}