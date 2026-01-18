import { createSlice } from "@reduxjs/toolkit";
import { createCustomer, updateCustomer, deleteCustomer, getCustomerById, getAllCustomer } from "./customerThunk";

const initialState = {
  customers: [],
  selectedCustomer: null,
  loading: false,
  error: null,
};

const customerSlice = createSlice({
  name: "customer",
  initialState,
  reducers: {},
  extraReducers: (builder) => {
    builder
      .addCase(createCustomer.pending, (state) => {
        ((state.loading = false), (state.customers = []));
      })
      .addCase(createCustomer.fulfilled, (state, action) => {
        ((state.loading = false), (state.customers = action.payload));
      })
      .addCase(createCustomer.rejected, (state, action) => {
        ((state.loading = false), (state.error = action.payload));
      })

      .addCase(updateCustomer.pending, (state)=>{
        state.loading= true;
      })
      .addCase(updateCustomer.fulfilled,(state,action)=>{
        state.loading = false;
        const index = state.customers.findIndex(
            (customer) => customer.id === action.payload.id
        );
        if (index !== -1){
            state.customers[index] = action.payload;
        }
        if(
            state.selectedCustomer && state.selectedCustomer.id === action.payload.id
        ){
            state.selectedCustomer = action.payload
        }
      })
      .addCase(updateCustomer.rejected,(state,action)=>{
        state.loading = false;
        state.error=action.payload;
      })

      .addCase(deleteCustomer.pending,(state)=>{
        state.loading = true;
      })
      .addCase(deleteCustomer.fulfilled,(state,action)=>{
        state.loading=false;
        state.customers=state.customers.filter(
            (customer)=> customer.id !== action.payload
        );
        if(
            state.selectedCustomer && state.selectedCustomer.i === action.payload
        ){
            state.selectedCustomer=null;
        }
      })
      .addCase(deleteCustomer.rejected,(state,action)=>{
        state.loading=false;
        state.error= action.payload;

      })
      .addCase(getCustomerById.pending,(state)=>{
        state.loading = true;
      })
      .addCase(getCustomerById.fulfilled,(state,action)=>{
        state.loading = false;
        state.selectedCustomer = action.payload;
      })

      .addCase(getCustomerById.pending,(state)=>{
        state.loading= true;
      })
      .addCase(getCustomerById.fulfilled,(state,action)=>{
        state.loading=false;
        state.selectedCustomer= action.payload;
      })
      .addCase(getCustomerById.rejected, (state,action)=>{
        state.loading = false;
        state.error= action.payload;
      })

      .addCase(getAllCustomer.pending,(state)=>{
        state.loading=true;
      })
      .addCase(getAllCustomer.fulfilled,(state,action)=>{
        state.loading=false;
        state.customers= action.payload;
      })
      .addCase(getAllCustomer.rejected,(state,action)=>{
        state.loading= false;
        state.error = action.payload;
      })

  },
});

export default customerSlice.reducer;
